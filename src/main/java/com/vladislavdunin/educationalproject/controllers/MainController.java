package com.vladislavdunin.educationalproject.controllers;

import com.vladislavdunin.educationalproject.actions.*;
import com.vladislavdunin.educationalproject.entity.Result;
import com.vladislavdunin.educationalproject.exceptions.ApplicationValidateException;

public class MainController {
    public Result doAction(String actionName, String[] parameters) {

        Action action = switch(actionName) {
            case "1" -> new Encoder();
            case "2" -> new Decoder();
            case "3" -> new BruteForce();
            case "4" -> new StatisticAnalyze();
            default -> throw new ApplicationValidateException("Action not found");
        };
        Result result = action.execute(parameters);

        return result;
    }
}
