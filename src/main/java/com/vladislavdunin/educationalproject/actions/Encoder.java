package com.vladislavdunin.educationalproject.actions;

import com.vladislavdunin.educationalproject.constants.Constants;
import com.vladislavdunin.educationalproject.dataDispatchers.FileDispatcher;
import com.vladislavdunin.educationalproject.entity.Result;

import java.nio.file.Path;

public class Encoder implements Action {
    private FileDispatcher dispatcher = new FileDispatcher();

    @Override
    public Result execute(String[] parameters) {
        Path inputFile = Path.of(parameters[0]);
        Path outputFile = Path.of(parameters[1]);
        int key = Integer.parseInt(parameters[2]);

        String inputData = dispatcher.getInputData(inputFile);

        String encodedString = toEncoded(inputData, key);

        Result result = dispatcher.setData(outputFile, encodedString);

        return result;
    }

    private String toEncoded(String data, int key) {
        char[] arrayOfData = data.toCharArray();
        StringBuilder builder = new StringBuilder();
        int sizeOfAllSymbols = Constants.ALL_SYMBOLS.size();

        for (int i = 0; i < arrayOfData.length; i++) {
            for (int j = 0; j < sizeOfAllSymbols; j++) {
                if (Constants.ALL_SYMBOLS.get(j).equals(Character.toString(arrayOfData[i]))) {
                    if ((j + key) >= sizeOfAllSymbols) {
                        builder.append(Constants.ALL_SYMBOLS.get(j - sizeOfAllSymbols + key));
                        break;
                    }
                    builder.append(Constants.ALL_SYMBOLS.get(j + key));
                }
            }
        }

        return builder.toString();
    }
}
