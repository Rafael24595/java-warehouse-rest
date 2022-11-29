package com.warehouse.app.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class DataMapTest {

    public static final String K_String = "String";
    public static final String K_Integer = "Integer";
    public static final String K_integer = "integer";
    public static final String K_Long = "Long";
    public static final String K_long = "long";
    public static final String K_Double = "Double";
    public static final String K_double = "double";
    public static final String K_Boolean = "Boolean";
    public static final String K_boolean = "boolean";

    public static final String K_Map = "map";
    public static final String K_NotFound = "NotFound";

    public static DataMap structure;

    @BeforeAll
    public static void fillDataStructure(){
        structure = new DataMap();
        structure.put(K_String, "char_string");
        structure.put(K_Integer, Integer.valueOf(1));
        structure.put(K_integer, 2);
        structure.put(K_Long, Long.valueOf(3));
        structure.put(K_long, (long) 4);
        structure.put(K_Double, Double.valueOf(5.5));
        structure.put(K_double, 6.6);
        structure.put(K_Boolean, Boolean.valueOf(true));
        structure.put(K_boolean, true);

        Map<String, Object> map = new LinkedHashMap<>();
        map.put(K_String, "sub_char_string");

        structure.put(K_Map, map);
    }

    @Test
    public void getStructureTest() {
        Map map = structure.getStructureSoft(K_Map);

        assertInstanceOf(DataMap.class, map);
        assertEquals("sub_char_string", ((DataMap) map).getStringSoft(K_String));
    }

    @Test
    public void getStringSoftTest(){
        assertEquals("char_string", structure.getStringSoft(K_String));
        assertEquals("1", structure.getStringSoft(K_Integer));
        assertEquals("2", structure.getStringSoft(K_integer));
        assertEquals("3", structure.getStringSoft(K_Long));
        assertEquals("4", structure.getStringSoft(K_long));
        assertEquals("5.5", structure.getStringSoft(K_Double));
        assertEquals("6.6", structure.getStringSoft(K_double));
        assertEquals("true", structure.getStringSoft(K_Boolean));
        assertEquals("true", structure.getStringSoft(K_boolean));
    }

    @Test
    public void getStringHardTest(){
        assertDoesNotThrow(()-> structure.getStringHard(K_String));
        assertThrowsExactly(IllegalArgumentException.class, ()-> structure.getStringHard(K_Integer));
        assertThrowsExactly(IllegalArgumentException.class, ()-> structure.getStringHard(K_integer));
        assertThrowsExactly(IllegalArgumentException.class, ()-> structure.getStringHard(K_Long));
        assertThrowsExactly(IllegalArgumentException.class, ()-> structure.getStringHard(K_long));
        assertThrowsExactly(IllegalArgumentException.class, ()-> structure.getStringHard(K_Double));
        assertThrowsExactly(IllegalArgumentException.class, ()-> structure.getStringHard(K_double));
        assertThrowsExactly(IllegalArgumentException.class, ()-> structure.getStringHard(K_Boolean));
        assertThrowsExactly(IllegalArgumentException.class, ()-> structure.getStringHard(K_boolean));

        assertDoesNotThrow(()-> structure.getStringHard(K_NotFound));
    }

    @Test
    public void getIntegerSoftTest(){
        assertEquals(0, structure.getIntegerSoft(K_String));
        assertEquals(1, structure.getIntegerSoft(K_Integer));
        assertEquals(2, structure.getIntegerSoft(K_integer));
        assertEquals(3, structure.getIntegerSoft(K_Long));
        assertEquals(4, structure.getIntegerSoft(K_long));
        assertEquals(5, structure.getIntegerSoft(K_Double));
        assertEquals(6, structure.getIntegerSoft(K_double));
        assertEquals(0, structure.getIntegerSoft(K_Boolean));
        assertEquals(0, structure.getIntegerSoft(K_boolean));
    }

    @Test
    public void getIntegerHardTest(){
        assertThrowsExactly(IllegalArgumentException.class, ()-> structure.getIntegerHard(K_String));
        assertDoesNotThrow(()-> structure.getIntegerHard(K_Integer));
        assertDoesNotThrow(()-> structure.getIntegerHard(K_integer));
        assertDoesNotThrow(()-> structure.getIntegerHard(K_Long));
        assertDoesNotThrow(()-> structure.getIntegerHard(K_long));
        assertDoesNotThrow(()-> structure.getIntegerHard(K_Double));
        assertDoesNotThrow(()-> structure.getIntegerHard(K_double));
        assertThrowsExactly(IllegalArgumentException.class, ()-> structure.getIntegerHard(K_Boolean));
        assertThrowsExactly(IllegalArgumentException.class, ()-> structure.getIntegerHard(K_boolean));
    }

    @Test
    public void getLongSoftTest(){
        assertEquals(0, structure.getLongSoft(K_String));
        assertEquals(1, structure.getLongSoft(K_Integer));
        assertEquals(2, structure.getLongSoft(K_integer));
        assertEquals(3, structure.getLongSoft(K_Long));
        assertEquals(4, structure.getLongSoft(K_long));
        assertEquals(5, structure.getLongSoft(K_Double));
        assertEquals(6, structure.getLongSoft(K_double));
        assertEquals(0, structure.getLongSoft(K_Boolean));
        assertEquals(0, structure.getLongSoft(K_boolean));
    }

    @Test
    public void getLongHardTest(){
        assertThrowsExactly(IllegalArgumentException.class, ()-> structure.getLongHard(K_String));
        assertDoesNotThrow(()-> structure.getLongHard(K_Integer));
        assertDoesNotThrow(()-> structure.getLongHard(K_integer));
        assertDoesNotThrow(()-> structure.getLongHard(K_Long));
        assertDoesNotThrow(()-> structure.getLongHard(K_long));
        assertDoesNotThrow(()-> structure.getLongHard(K_Double));
        assertDoesNotThrow(()-> structure.getLongHard(K_double));
        assertThrowsExactly(IllegalArgumentException.class, ()-> structure.getLongHard(K_Boolean));
        assertThrowsExactly(IllegalArgumentException.class, ()-> structure.getLongHard(K_boolean));

        assertDoesNotThrow(()-> structure.getLongHard(K_NotFound));
    }

    @Test
    public void getDoubleSoftTest(){
        assertEquals(0.0, structure.getDoubleSoft(K_String));
        assertEquals(1.0, structure.getDoubleSoft(K_Integer));
        assertEquals(2.0, structure.getDoubleSoft(K_integer));
        assertEquals(3.0, structure.getDoubleSoft(K_Long));
        assertEquals(4.0, structure.getDoubleSoft(K_long));
        assertEquals(5.5, structure.getDoubleSoft(K_Double));
        assertEquals(6.6, structure.getDoubleSoft(K_double));
        assertEquals(0.0, structure.getDoubleSoft(K_Boolean));
        assertEquals(0.0, structure.getDoubleSoft(K_boolean));
    }

    @Test
    public void getDoubleHardTest(){
        assertThrowsExactly(IllegalArgumentException.class, ()-> structure.getDoubleHard(K_String));
        assertDoesNotThrow(()-> structure.getDoubleHard(K_Integer));
        assertDoesNotThrow(()-> structure.getDoubleHard(K_integer));
        assertDoesNotThrow(()-> structure.getDoubleHard(K_Long));
        assertDoesNotThrow(()-> structure.getDoubleHard(K_long));
        assertDoesNotThrow(()-> structure.getDoubleHard(K_Double));
        assertDoesNotThrow(()-> structure.getDoubleHard(K_double));
        assertThrowsExactly(IllegalArgumentException.class, ()-> structure.getDoubleHard(K_Boolean));
        assertThrowsExactly(IllegalArgumentException.class, ()-> structure.getDoubleHard(K_boolean));

        assertDoesNotThrow(()-> structure.getDoubleHard(K_NotFound));
    }

    @Test
    public void getBooleanSoftTest(){
        assertEquals(false, structure.getBooleanSoft(K_String));
        assertEquals(false, structure.getBooleanSoft(K_Integer));
        assertEquals(false, structure.getBooleanSoft(K_integer));
        assertEquals(false, structure.getBooleanSoft(K_Long));
        assertEquals(false, structure.getBooleanSoft(K_long));
        assertEquals(false, structure.getBooleanSoft(K_Double));
        assertEquals(false, structure.getBooleanSoft(K_double));
        assertEquals(true, structure.getBooleanSoft(K_Boolean));
        assertEquals(true, structure.getBooleanSoft(K_boolean));
    }

    @Test
    public void getBooleanHardTest(){
        assertThrowsExactly(IllegalArgumentException.class, ()-> structure.getBooleanHard(K_String));
        assertThrowsExactly(IllegalArgumentException.class, ()-> structure.getBooleanHard(K_Integer));
        assertThrowsExactly(IllegalArgumentException.class, ()-> structure.getBooleanHard(K_integer));
        assertThrowsExactly(IllegalArgumentException.class, ()-> structure.getBooleanHard(K_Long));
        assertThrowsExactly(IllegalArgumentException.class, ()-> structure.getBooleanHard(K_long));
        assertThrowsExactly(IllegalArgumentException.class, ()-> structure.getBooleanHard(K_Double));
        assertThrowsExactly(IllegalArgumentException.class, ()-> structure.getBooleanHard(K_double));
        assertDoesNotThrow(()-> structure.getBooleanHard(K_Boolean));
        assertDoesNotThrow(()-> structure.getBooleanHard(K_boolean));

        assertDoesNotThrow(()-> structure.getBooleanHard(K_NotFound));
    }

    @Test
    public void getNullTest() {
        assertEquals(null, structure.getStringHard(K_NotFound));
        assertEquals(null, structure.getStringSoft(K_NotFound));
        assertEquals(null, structure.getIntegerHard(K_NotFound));
        assertEquals(null, structure.getIntegerSoft(K_NotFound));
        assertEquals(null, structure.getLongHard(K_NotFound));
        assertEquals(null, structure.getLongSoft(K_NotFound));
        assertEquals(null, structure.getDoubleHard(K_NotFound));
        assertEquals(null, structure.getDoubleSoft(K_NotFound));
        assertEquals(null, structure.getBooleanHard(K_NotFound));
        assertEquals(null, structure.getBooleanSoft(K_NotFound));
    }

    @Test
    public void getNotNullTest() {
        assertEquals("", structure.getStringHardNotNull(K_NotFound));
        assertEquals("", structure.getStringSoftNotNull(K_NotFound));
        assertEquals(0, structure.getIntegerHardNotNull(K_NotFound));
        assertEquals(0, structure.getIntegerSoftNotNull(K_NotFound));
        assertEquals(0, structure.getLongHardNotNull(K_NotFound));
        assertEquals(0, structure.getLongSoftNotNull(K_NotFound));
        assertEquals(0, structure.getDoubleHardNotNull(K_NotFound));
        assertEquals(0, structure.getDoubleSoftNotNull(K_NotFound));
        assertEquals(false, structure.getBooleanHardNotNull(K_NotFound));
        assertEquals(false, structure.getBooleanSoftNotNull(K_NotFound));
    }

}
