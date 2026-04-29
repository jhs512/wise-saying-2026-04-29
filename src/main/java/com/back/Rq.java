package com.back;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Rq {
    private final String actionName;
    private Map<String, String> params;

    public Rq(String cmd) {
        String[] cmdBits = cmd.split("\\?");

        actionName = cmdBits[0];

        String queryString = cmdBits.length == 1 ? "" : cmdBits[1].trim();

        if (queryString.isBlank()) {
            params = Map.of();
            return;
        }

        params = Arrays.stream(
                        queryString.split("&")
                )
                .map(paramStr -> paramStr.split("=", 2))
                .filter(paramStrBits -> paramStrBits.length == 2 && !paramStrBits[0].isBlank() && !paramStrBits[1].isBlank())
                .collect(Collectors.toMap(paramStr -> paramStr[0], paramStr -> paramStr[1]));
    }

    public String getActionName() {
        return actionName;
    }

    public int getParamAsInt(String name, int defaultValue) {
        String value = getParam(name, "");

        if (value.isBlank()) return defaultValue;

        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    private String getParam(String name, String defaultValue) {
        return params.getOrDefault(name, defaultValue);
    }
}
