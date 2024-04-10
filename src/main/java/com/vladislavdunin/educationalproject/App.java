package com.vladislavdunin.educationalproject;

import com.vladislavdunin.educationalproject.controllers.MainController;
import com.vladislavdunin.educationalproject.entity.Result;
import com.vladislavdunin.educationalproject.exceptions.ApplicationValidateException;
import com.vladislavdunin.educationalproject.validation.UserInputValidation;
import com.vladislavdunin.educationalproject.view.ConsoleUserInterface;

import java.util.Arrays;

public class App {
    private ConsoleUserInterface consoleUserInterface;
    private MainController mainController;
    private UserInputValidation userInputValidation;

    public App() {
        this.consoleUserInterface = new ConsoleUserInterface();
        this.mainController = new MainController();
        this.userInputValidation = new UserInputValidation();
    }

    public Result run() {
        String[] parameters = consoleUserInterface.sessionStart();
        //split action(mode) and other parameters
        //call to controller with parameters and mode
        if (userInputValidation.validateArguments(parameters, parameters[0].equals("3") || parameters[0].equals("4"))) {
            return mainController.doAction(
                    parameters[0],
                    Arrays.copyOfRange(parameters, 1, parameters.length)
            );
        }

        throw new ApplicationValidateException("Please enter valid arguments!");
    }
}
