package com.warehouse.app.structures;

import java.io.Serializable;
import java.util.*;

public class DataStructure<K,V> extends HashMap<String,V> implements Map<String,V>, Cloneable, Serializable {

    private String getString(String key, boolean exception) throws IllegalArgumentException{
        V value = get(key);

        if(value == null)
            return null;

        if(!exception || (exception && value instanceof String))
            return String.valueOf(value);
        throw new IllegalArgumentException("");
    }

    public String getStringHard(String key) throws IllegalArgumentException {
        return getString(key, true);
    }

    public String getStringSoft(String key){
        return getString(key, false);
    }

    private Double getDouble(String key, boolean exception) throws IllegalArgumentException{
        try {
            String stringValue = getStringSoft(key);
            return Double.valueOf(stringValue);
        }catch (NumberFormatException e){
            if(exception)
                throw new IllegalArgumentException("");
            return Double.valueOf(0);
        }
    }

    public Double getDoubleHard(String key) throws IllegalArgumentException {
        return getDouble(key, true);
    }

    public Double getDoubleSoft(String key) {
        return getDouble(key, false);
    }

    public Long getLong(String key, boolean exception) throws IllegalArgumentException{
        try {
            String stringValue = getStringSoft(key);
            return Long.valueOf(stringValue);
        }catch (NumberFormatException e){
            if(exception)
                throw new IllegalArgumentException("");
            return Long.valueOf(0);
        }
    }

    private Long getLongHard(String key) throws IllegalArgumentException{
        return  getLong(key, true);
    }

    public Long getLongSoft(String key) {
        return  getLong(key, false);
    }

    private Boolean getBoolean(String key, boolean exception) throws IllegalArgumentException{
        try {
            String stringValue = getStringSoft(key);
            return Boolean.valueOf(stringValue);
        }catch (NumberFormatException e){
            if(exception)
                throw new IllegalArgumentException("");
            return Boolean.valueOf(false);
        }
    }

    public Boolean getBooleanHard(String key, boolean exception) throws IllegalArgumentException{
        return getBoolean(key, true);
    }

    public Boolean getBooleanSoft(String key, boolean exception) {
        return getBoolean(key, false);
    }

}
