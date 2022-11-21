package com.warehouse.app.tools;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageBuilderTest {

    private static String TEST_MESSAGE = "This is a test message. Replace char-sequences: ";

    @Test
    public void getAUXTest() {
        String aux1 = MessageBuilder.aux(1);

        assertEquals(aux1, MessageBuilder.aux() + "1");
    }

    @Test
    public void buildSimpleTest() {
        String stringReplace = "String";
        Integer integerReplace = 1;
        int intReplace = 2;
        boolean booleanReplace = true;

        String messageString = MessageBuilder.build(TEST_MESSAGE + MessageBuilder.aux(), stringReplace);
        String messageInteger = MessageBuilder.build(TEST_MESSAGE + MessageBuilder.aux(), integerReplace);
        String messageInt = MessageBuilder.build(TEST_MESSAGE + MessageBuilder.aux(), intReplace);
        String messageBoolean = MessageBuilder.build(TEST_MESSAGE + MessageBuilder.aux(), booleanReplace);

        assertEquals(messageString, TEST_MESSAGE + stringReplace);
        assertEquals(messageInteger, TEST_MESSAGE + integerReplace);
        assertEquals(messageInt, TEST_MESSAGE + intReplace);
        assertEquals(messageBoolean, TEST_MESSAGE + booleanReplace);
    }

    @Test
    public void buildTest() {
        String stringReplace = "String";
        Integer integerReplace = 1;
        int intReplace = 2;
        boolean booleanReplace = true;

        String messageTemplate = TEST_MESSAGE + MessageBuilder.aux(1) + "" + MessageBuilder.aux(2) + "" + MessageBuilder.aux(3) + "" + MessageBuilder.aux(4);
        String messageResult = TEST_MESSAGE + stringReplace + "" + integerReplace + "" + intReplace + "" + booleanReplace;
        String messageTest = MessageBuilder.build(messageTemplate, stringReplace, integerReplace, intReplace, booleanReplace);

        assertEquals(messageResult, messageTest);
    }

}
