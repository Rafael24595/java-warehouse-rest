package com.warehouse.app.structures;

import com.warehouse.app.structures.DataStructure;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DataStructureTest {

    public static final String K_String = "String";
    public static final String K_Long = "Long";
    public static final String K_long = "long";
    public static final String K_Double = "Double";
    public static final String K_double = "double";
    public static final String K_Boolean = "Boolean";
    public static final String K_boolean = "boolean";

    public static final String K_NotFound = "NotFound";

    public static DataStructure structure;

    @BeforeAll
    public static void fillDataStructure(){
        structure = new DataStructure();
        structure.put(K_String, "char_string");
        structure.put(K_Long, Long.valueOf(1));
        structure.put(K_long, (long) 2);
        structure.put(K_Double, Double.valueOf(3.3));
        structure.put(K_double, 4.4);
        structure.put(K_Boolean, Boolean.valueOf(true));
        structure.put(K_boolean, true);
    }

    @Test
    public void getStringSoftTest(){
        assertEquals("char_string", structure.getStringSoft(K_String));
        assertEquals("1", structure.getStringSoft(K_Long));
        assertEquals("2", structure.getStringSoft(K_long));
        assertEquals("3.3", structure.getStringSoft(K_Double));
        assertEquals("4.4", structure.getStringSoft(K_double));
        assertEquals("true", structure.getStringSoft(K_Boolean));
        assertEquals("true", structure.getStringSoft(K_boolean));

        assertEquals(null, structure.getStringSoft(K_NotFound));
    }

    @Test
    public void getStringHardTest(){
        assertDoesNotThrow(()-> structure.getStringHard(K_String));
        assertThrowsExactly(IllegalArgumentException.class, ()-> structure.getStringHard(K_Long));
        assertThrowsExactly(IllegalArgumentException.class, ()->structure.getStringHard(K_long));
        assertThrowsExactly(IllegalArgumentException.class, ()->structure.getStringHard(K_Double));
        assertThrowsExactly(IllegalArgumentException.class, ()->structure.getStringHard(K_double));
        assertThrowsExactly(IllegalArgumentException.class, ()->structure.getStringHard(K_Boolean));
        assertThrowsExactly(IllegalArgumentException.class, ()->structure.getStringHard(K_boolean));

        assertDoesNotThrow(()-> structure.getStringHard(K_NotFound));
    }

}
