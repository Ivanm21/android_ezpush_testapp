package com.google.firebase.quickstart.api;

/**
 * Created by ivanm on 12/19/2017.
 */

import java.util.Objects;

public class Tag {

    public static final String DATE = "date";
    public static final String STRING = "string";
    public static final String NUMBER = "number";
    public static final String BOOLEAN = "boolean";

    private String key;
    private String value;
    private String type;

    public Tag(String key, String value, String type) {
        this.key = key;
        this.value = value;
        this.type = type;
    }

    public Tag(String key, String value) {
        this(key, value, STRING);
    }

    public Tag() {
        // do nothing
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Tag tag = (Tag) o;
        return Objects.equals(key, tag.key) &&
                Objects.equals(value, tag.value) &&
                Objects.equals(type, tag.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value, type);
    }

    @Override
    public String toString() {
        return "Tag [key=" + key + ", type=" + type + ", value=" + value + "]";
    }

}

