package com.vladislavdunin.educationalproject.entity;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private Map<String, AppStatusCode> response = new HashMap<>();

    public Result(String message, AppStatusCode appStatusCode) {
        this.response.put(message, appStatusCode);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, AppStatusCode> el : response.entrySet()) {
            builder.append("{message: ");
            builder.append(el.getKey());
            builder.append(";");
            builder.append("statusCode: ");
            builder.append(el.getValue());
            builder.append("}");
        }

        return builder.toString();
    }
}
