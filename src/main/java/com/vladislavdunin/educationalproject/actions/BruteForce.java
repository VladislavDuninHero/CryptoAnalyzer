package com.vladislavdunin.educationalproject.actions;

import com.vladislavdunin.educationalproject.constants.Constants;
import com.vladislavdunin.educationalproject.dataDispatchers.FileDispatcher;
import com.vladislavdunin.educationalproject.entity.Result;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BruteForce implements Action {
    private FileDispatcher dispatcher = new FileDispatcher();
    private boolean isSuccessBruteForce = false;
    private Map<String, Boolean> statistic = new HashMap<>();
    private String bruteForceDecode = "";
    private boolean bruteForceIsStatisticPercentSuccess = false;
    private int keyForDecode = 0;
    @Override
    public Result execute(String[] parameters) {
        Path encryptedFile = Path.of(parameters[0]).toAbsolutePath();
        Path outputFile = Path.of(parameters[1]).toAbsolutePath();
        Path referencesFile = Path.of(parameters[2]).toAbsolutePath();

        String data = dispatcher.getInputData(encryptedFile);
        String referencesData = dispatcher.getInputData(referencesFile);

        String decrypted = toBruteForce(data, referencesData);

        Result result = dispatcher.setData(outputFile, decrypted);

        return result;
    }

    private String toBruteForce(String data, String references) {
        char[] dataArray = data.toCharArray();
        String[] referencesArray = references.split("\r\n");
        List<String> alphabet = Constants.ALL_SYMBOLS;

        int key = 0;

        while (key != alphabet.size()) {
            if (isSuccessBruteForce) {
                break;
            }

            String decode = bruteForceDecoder(dataArray, alphabet, key);
            String[] arr = decode.split("[ ,.]");

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < referencesArray.length; j++) {
                    if (arr[i].equals(referencesArray[j])) {
                        statistic.put(arr[i], true);
                        isSuccessBruteForce = Boolean.TRUE;
                        break;
                    }
                    statistic.put(arr[i], false);
                }
            }



            key++;
        }

        analyzeStatistic(statistic);

        return bruteForceDecode;
    }

    private String bruteForceDecoder(char[] dataArray, List<String> alphabet, int key) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < dataArray.length; i++) {
            for (int j = 0; j < alphabet.size(); j++) {
                if (alphabet.get(j).equals(Character.toString(dataArray[i]))) {
                    if ((j - key) < 0) {
                        builder.append(alphabet.get(alphabet.size() + (j - key)));
                        break;
                    }

                    builder.append(alphabet.get(j - key));
                }
            }
        }

        this.bruteForceDecode = builder.toString();
        this.keyForDecode = key;

        return builder.toString();
    }

    private void analyzeStatistic(Map<String, Boolean> statistic) {
        int countOfElements = 0;
        for (Map.Entry<String, Boolean> el : statistic.entrySet()) {
            if (Boolean.TRUE.equals(el.getValue())) {
                countOfElements++;
            }
        }

        if (countOfElements >= 1) {
            bruteForceIsStatisticPercentSuccess = true;
            System.out.println("key for decode: " + keyForDecode);
        }
    }
}
