package com.google.firebase.quickstart.api;

/**
 * Created by ivanm on 12/19/2017.
 */

import java.io.Serializable;


public class DeviceRegistrationId implements Serializable {

    private static final long serialVersionUID = -9121175157711511973L;

    private String hwid;

    private String applicationId;

    public DeviceRegistrationId() {
    }

    public DeviceRegistrationId(String hwid, String applicationId) {
        this.hwid = hwid;
        this.applicationId = applicationId;
    }

    /**
     * Hardware device id. Unique string to identify the device (Please note
     * that accessing UDID on iOS is deprecated and not allowed, one of the
     * alternative ways now is to use MAC address)
     */
    public String getHwid() {
        return hwid;
    }

    public void setHwid(String hwid) {
        this.hwid = hwid;
    }

    /** Push service application ID where you send the message to */
    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((applicationId == null) ? 0 : applicationId.hashCode());
        result = prime * result + ((hwid == null) ? 0 : hwid.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DeviceRegistrationId other = (DeviceRegistrationId) obj;
        if (applicationId == null) {
            if (other.applicationId != null)
                return false;
        } else if (!applicationId.equals(other.applicationId))
            return false;
        if (hwid == null) {
            if (other.hwid != null)
                return false;
        } else if (!hwid.equals(other.hwid))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("DeviceRegistrationId [hwid=");
        builder.append(hwid);
        builder.append(", applicationId=");
        builder.append(applicationId);
        builder.append("]");
        return builder.toString();
    }

}
