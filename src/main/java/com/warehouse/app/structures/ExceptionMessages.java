package com.warehouse.app.structures;

import com.warehouse.app.tools.MessageBuilder;

public class ExceptionMessages {

    public class STRUCTURE {
        public static String INVALID_TYPE_ARGUMENT = "Argument \"" + MessageBuilder.aux(1) + "\" has been found, but it's format does not match with " + MessageBuilder.aux(2) + " type";
        public static String INVALID_SITUATION_FK = "Invalid foreign key reference. Expected \" " + MessageBuilder.aux(1) + "\" but got \"" + MessageBuilder.aux(2) + "\"";
    }

    public class REQUEST {
        public static String BAD_JSON_FORMAT = "Bean instantiation failed, bad JSON data format: " + MessageBuilder.aux();
    }

    public class REPOSITORY {
        public static String NOT_FOUND_ID = "Element \"" + MessageBuilder.aux(1) + "\" with id \"" + MessageBuilder.aux(2) + "\" was not found";
    }

}
