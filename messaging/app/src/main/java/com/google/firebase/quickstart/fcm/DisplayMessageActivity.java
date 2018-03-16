package com.google.firebase.quickstart.fcm;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        Bundle payload = intent.getExtras();

        TableLayout table = findViewById(R.id.data_table);

        for (String key: payload.keySet()) {

            TableRow row = new TableRow(this);

            TextView p_key = new TextView(this);
            p_key.setText(key);
            p_key.setTextColor(Color.BLACK);

            TextView p_value = new TextView(this);
            p_value.setText(payload.getString(key));
            p_value.setTextIsSelectable(true);


            row.addView(p_key);
            row.addView(p_value);

            table.addView(row);
        }



    }


}
