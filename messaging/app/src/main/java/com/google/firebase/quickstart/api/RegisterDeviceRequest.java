package com.google.firebase.quickstart.api;

/**
 * Created by ivanm on 12/19/2017.
 */

import java.util.List;

public class RegisterDeviceRequest {

    private DeviceRegistrationId _id;

    /**
     * Can be either push token for iOS and Android devices, or endpoint URL for Firefox devices
     */
    private String pushToken;

    private String language;

    private int timeZone;

    private int platform;

    private String userIdentity;

    private List<Tag> tags;

    private boolean testDevice;

    /**
     * For firefox webpush only, keys.auth value URL-safe Base64 encoded.
     * Used as similar to password.
     */
    private String auth;

    /**
     * For firefox webpush only, keys.auth value URL-safe Base64 encoded
     */
    private String p256dh;

    public RegisterDeviceRequest() {
    }

    public RegisterDeviceRequest(String hwid, String applicationId) {
        this(new DeviceRegistrationId(hwid, applicationId));
    }

    public RegisterDeviceRequest(DeviceRegistrationId id) {
        this._id = id;
    }

    public DeviceRegistrationId getId() {
        return _id;
    }

    public void setId(DeviceRegistrationId id) {
        this._id = id;
    }

    /** Push token for the device */
    public String getPushToken() {
        return pushToken;
    }

    public void setPushToken(String pushToken) {
        this.pushToken = pushToken;
    }

    /** Language locale of the device (optional) */
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    /** Timezone offset in seconds for the device (optional) */
    public int getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(int timeZone) {
        this.timeZone = timeZone;
    }

    /**
     * Platform code of the device's platform
     */
    public int getPlatform() {
        return platform;
    }

    public void setPlatform(int platform) {
        this.platform = platform;
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getP256dh() {
        return p256dh;
    }

    public void setP256dh(String p256dh) {
        this.p256dh = p256dh;
    }

    public boolean isTestDevice() {
        return testDevice;
    }

    public void setTestDevice(boolean testDevice) {
        this.testDevice = testDevice;
    }

    @Override
    public String toString() {
        return "RegisterDeviceRequest{_id=" + _id +
                ", pushToken='" + pushToken + '\'' +
                ", language='" + language + '\'' +
                ", timeZone=" + timeZone +
                ", platform=" + platform +
                ", tags=" + tags +
                ", auth=" + (auth != null ? "******" : "") +
                ", p256dh=" + p256dh +
                ", userIdentity='" + userIdentity + '\'' +
                ", testDevice='" + testDevice + '\'' +
                '}';
    }

}
