package com.google.firebase.quickstart.httpClient;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;

import java.io.BufferedReader;
import java.io.InputStreamReader;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import static android.app.PendingIntent.getActivity;

import com.google.firebase.quickstart.api.RegisterDeviceRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.*;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpHeaders;
import cz.msebera.android.httpclient.entity.StringEntity;
import android.provider.Settings.Secure;
import android.util.Log;


/**
 * Created by ivanm on 12/18/2017.
 */

public class httpClient {

    private String ServerAddress;
    private String ApiKey;
    private String ApplicationId;
    private Context context ;
    private int Port;


    public httpClient (Context context){
        this.context = context;
        try {
            JSONObject config = loadConfiguration(this.context, "serverprod.json");
            ServerAddress = config.getString("ServerAddress");
            ApiKey = config.getString("ApiKey");
            ApplicationId = config.getString("ApplicationId");
            Port = config.getInt("Port");
        }catch (Exception e)
        {
            e.printStackTrace();
        }


    }

    public void registerDevice(String PushToken,String ApplicationId, String hwid, String language ){

        String url = ServerAddress + "/pt.openapi.push.devreg/registerDevice/1.0";

        AsyncHttpClient client = new AsyncHttpClient(false,80,Port);
        RegisterDeviceRequest req = null;

        if (ApplicationId != null && !ApplicationId.isEmpty() ){
             req = new RegisterDeviceRequest(hwid,ApplicationId);
        }else{
            req = new RegisterDeviceRequest(hwid,this.ApplicationId);
        }

        req.setLanguage(language);
        req.setPushToken(PushToken);
        req.setPlatform(2);

//        HttpHeaders headers = null;
//        headers.setContentType(MediaType.APPLICATION_JSON);
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(req);

        StringEntity entity = null;
        try {
            entity = new StringEntity(json);
            entity.setContentType("application/json");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        client.post(context, url, entity, "application/json", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // Root JSON in response is an dictionary i.e { "data : [ ... ] }
                // Handle resulting parsed JSON response here
                Log.d("EzPush",response.toString());

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                Log.d("Failed: ", ""+statusCode);
                Log.d("Error : ", "" + throwable);
            }
        });
    }

    private JSONObject loadConfiguration(Context context, String confFileName) {
        JSONObject json = null;
        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open(confFileName)));
            StringBuilder config = new StringBuilder();
            String str;
            while ((str = reader.readLine()) != null) {
                config.append(str);
            }
            json = new JSONObject(config.toString());
            return json;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;

    }


}
