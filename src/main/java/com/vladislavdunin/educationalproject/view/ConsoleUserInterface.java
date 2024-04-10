package com.vladislavdunin.educationalproject.view;

import java.util.Arrays;
import java.util.Scanner;

public class ConsoleUserInterface {
    private String welcomeMessage = "***Hello from CryptoAnalyzer app!***";
    private String mods = "Mods:";
    private String selectConsoleMode = "Select mode: ";
    private String enterMenu = "1: Encode\n" + "2: Decode\n" + "3: BruteForce\n" + "4: Statistic Analyze" ;
    private String runnerMessage = "Enter the parameters(input file, output file, key): ";
    private String alternativeRunnerMessage = "Enter the parameters(encrypted file, file to save the decrypted message): ";
    private String messageForStatisticAnalyze = "Enter name or path to the references file(same text of this author or other texts): ";
    private String fileReference = "";
    public String[] sessionStart() {
        //show entry message and menu
        System.out.printf("%s\n%s\n%s\n%s", welcomeMessage, mods, enterMenu, selectConsoleMode);

        //get mode
        Scanner inputScanner = new Scanner(System.in);
        String selectMode = inputScanner.nextLine();
        //get parameters
        if (Integer.parseInt(selectMode) > 2) {
            System.out.println(alternativeRunnerMessage);
        } else {
            System.out.println(runnerMessage);
        }
        String parameters = inputScanner.nextLine();
        //concat mode + parameters
        String concatParameters;
        //if mode is Statistic analyze then preview extended console ui element for load file reference
        if (Integer.parseInt(selectMode) == 4 || Integer.parseInt(selectMode) == 3) {
            System.out.println(messageForStatisticAnalyze);
            this.fileReference = inputScanner.nextLine();
            concatParameters = selectMode + " " + parameters + " " + this.fileReference;
        } else {
            //or concat default parameters
            concatParameters = selectMode + " " + parameters;
        }
        String[] allParameters = concatParameters.split(" ");

        //return data with parameters out
        return allParameters;
    }
}
