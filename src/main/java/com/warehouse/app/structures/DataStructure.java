package com.warehouse.app.structures;

import com.warehouse.app.tools.MessageBuilder;

import java.io.Serializable;
import java.util.*;

public class DataStructure<V> extends HashMap<String,V> implements Map<String,V>, Cloneable, Serializable {

    private DataStructure<Object> getStructure(String key, boolean exception) {
        V value = get(key);

        if(value instanceof DataStructure)
            return (DataStructure) value;

        if(exception && !(value instanceof Map)){
            String message = MessageBuilder.build(ExceptionMessages.STRUCTURE.INVALID_TYPE_ARGUMENT, key, "DataStructure");
            throw new IllegalArgumentException(message);
        }

        return parseMap(key);
    }

    private DataStructure<Object> parseMap(String key) {
        V value = get(key);
        DataStructure<Object> parsedValue = new DataStructure<>();

        if(value instanceof Map) {
            Map<String, Object> typedValue = (Map<String, Object>) value;
            Set<String> genericKeys = typedValue.keySet();

            for(String genericKey : genericKeys){
                Object genericValue = typedValue.get(genericKey);
                parsedValue.put(genericKey, genericValue);
            }

            put(key, (V) parsedValue);

            return (DataStructure<Object>) get(key);
        }

        return null;
    }

    public DataStructure getStructureHard(String key) {
        return getStructure(key, true);
    }

    public DataStructure getStructureSoft(String key) {
        return getStructure(key, false);
    }

    private String getString(String key, boolean exception, boolean nullable) throws IllegalArgumentException{
        V value = get(key);

        if(value == null)
            return nullable ? null : "";

        if(!exception || (exception && value instanceof String))
            return String.valueOf(value);
        String message = MessageBuilder.build(ExceptionMessages.STRUCTURE.INVALID_TYPE_ARGUMENT, key, "String");
        throw new IllegalArgumentException(message);
    }

    public String getStringHardNotNull(String key) throws IllegalArgumentException {
        return getString(key, true, false);
    }

    public String getStringHard(String key) throws IllegalArgumentException {
        return getString(key, true, true);
    }

    public String getStringSoftNotNull(String key){
        return getString(key, false, false);
    }

    public String getStringSoft(String key){
        return getString(key, false, true);
    }

    private Integer getInteger(String key, boolean exception, boolean nullable) throws IllegalArgumentException{
        try {
            Double doubleValue = getDouble(key, exception, true);
            if(!nullable && doubleValue == null)
                return 0;
            return doubleValue == null ? null : doubleValue.intValue();
        }catch (IllegalArgumentException e){
            if(!exception)
                return Integer.valueOf(0);
            String message = MessageBuilder.build(ExceptionMessages.STRUCTURE.INVALID_TYPE_ARGUMENT, key, "Integer");
            throw new IllegalArgumentException(message);
        }
    }

    public Integer getIntegerHardNotNull(String key) throws IllegalArgumentException{
        return getInteger(key, true, false);
    }

    public Integer getIntegerHard(String key) throws IllegalArgumentException{
        return getInteger(key, true, true);
    }

    public Integer getIntegerSoftNotNull(String key) throws IllegalArgumentException{
        return getInteger(key, false, false);
    }

    public Integer getIntegerSoft(String key) throws IllegalArgumentException{
        return getInteger(key, false, true);
    }

    private Double getDouble(String key, boolean exception, boolean nullable) throws IllegalArgumentException{
        try {
            String stringValue = getStringSoft(key);
            if(!nullable && stringValue == null)
                return 0D;
            return stringValue == null ? null : Double.valueOf(stringValue);
        }catch (NumberFormatException e){
            if(!exception)
                return Double.valueOf(0);
            String message = MessageBuilder.build(ExceptionMessages.STRUCTURE.INVALID_TYPE_ARGUMENT, key, "Double");
            throw new IllegalArgumentException(message);
        }
    }

    public Double getDoubleHardNotNull(String key) throws IllegalArgumentException {
        return getDouble(key, true, false);
    }

    public Double getDoubleHard(String key) throws IllegalArgumentException {
        return getDouble(key, true, true);
    }

    public Double getDoubleSoftNotNull(String key) {
        return getDouble(key, false, false);
    }

    public Double getDoubleSoft(String key) {
        return getDouble(key, false, true);
    }

    private Long getLong(String key, boolean exception, boolean nullable) throws IllegalArgumentException{
        try {
            Double doubleValue = getDouble(key, exception, true);
            if(!nullable && doubleValue == null)
                return 0L;
            return doubleValue == null ? null : doubleValue.longValue();
        }catch (IllegalArgumentException e){
            if(!exception)
                return Long.valueOf(0);
            String message = MessageBuilder.build(ExceptionMessages.STRUCTURE.INVALID_TYPE_ARGUMENT, key, "Long");
            throw new IllegalArgumentException(message);
        }
    }

    public Long getLongHardNotNull(String key) throws IllegalArgumentException{
        return  getLong(key, true, false);
    }

    public Long getLongHard(String key) throws IllegalArgumentException{
        return  getLong(key, true, true);
    }

    public Long getLongSoftNotNull(String key) {
        return  getLong(key, false, false);
    }

    public Long getLongSoft(String key) {
        return  getLong(key, false, true);
    }

    private Boolean getBoolean(String key, boolean exception, boolean nullable) throws IllegalArgumentException{
        V value = get(key);

        if(value == null)
            return nullable ? null : false;

        if(!exception || (exception && value instanceof Boolean)){
            String stringValue = getStringSoft(key);
            return Boolean.valueOf(stringValue);
        }

        String message = MessageBuilder.build(ExceptionMessages.STRUCTURE.INVALID_TYPE_ARGUMENT, key, "Boolean");
        throw new IllegalArgumentException(message);
    }

    public Boolean getBooleanHardNotNull(String key) throws IllegalArgumentException{
        return getBoolean(key, true, false);
    }

    public Boolean getBooleanHard(String key) throws IllegalArgumentException{
        return getBoolean(key, true, true);
    }

    public Boolean getBooleanSoftNotNull(String key) {
        return getBoolean(key, false, false);
    }

    public Boolean getBooleanSoft(String key) {
        return getBoolean(key, false, true);
    }

}
