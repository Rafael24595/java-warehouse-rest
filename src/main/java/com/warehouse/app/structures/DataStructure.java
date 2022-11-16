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

    private Integer getInteger(String key, boolean exception) throws IllegalArgumentException{
        try {
            Double doubleValue = getDouble(key, exception);
            return doubleValue == null ? null : doubleValue.intValue();
        }catch (IllegalArgumentException e){
            if(exception)
                throw new IllegalArgumentException("");
            return Integer.valueOf(0);
        }
    }

    public Integer getIntegerHard(String key) throws IllegalArgumentException{
        return getInteger(key, true);
    }
    public Integer getIntegerSoft(String key) throws IllegalArgumentException{
        return getInteger(key, false);
    }

    private Double getDouble(String key, boolean exception) throws IllegalArgumentException{
        try {
            String stringValue = getStringSoft(key);
            return stringValue == null ? null : Double.valueOf(stringValue);
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

    private Long getLong(String key, boolean exception) throws IllegalArgumentException{
        try {
            Double doubleValue = getDouble(key, exception);
            return doubleValue == null ? null : doubleValue.longValue();
        }catch (IllegalArgumentException e){
            if(exception)
                throw new IllegalArgumentException("");
            return Long.valueOf(0);
        }
    }

    public Long getLongHard(String key) throws IllegalArgumentException{
        return  getLong(key, true);
    }

    public Long getLongSoft(String key) {
        return  getLong(key, false);
    }

    private Boolean getBoolean(String key, boolean exception) throws IllegalArgumentException{
        V value = get(key);

        if(value == null)
            return null;

        if(!exception || (exception && value instanceof Boolean)){
            String stringValue = getStringSoft(key);
            return Boolean.valueOf(stringValue);
        }

        throw new IllegalArgumentException("");
    }

    public Boolean getBooleanHard(String key) throws IllegalArgumentException{
        return getBoolean(key, true);
    }

    public Boolean getBooleanSoft(String key) {
        return getBoolean(key, false);
    }

}
