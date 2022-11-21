package com.warehouse.app.tools;

public class MessageBuilder {

    private static String AUX_VALUE = "&var";

    public static String aux() {
        return AUX_VALUE;
    }

    public static String aux(Integer position) {
        StringBuilder sb = new StringBuilder();
        sb.append(AUX_VALUE);
        sb.append(position);

        return sb.toString();
    }

    public static String build(String base, Object ...args) {
        for (Integer i = 0; i < args.length; i++) {
            String key = (args.length > 1) ? AUX_VALUE + (i + 1) : AUX_VALUE;
            String value = args[i].toString();
            base = base.replace(key, value);
        }

        return base;
    }

}
