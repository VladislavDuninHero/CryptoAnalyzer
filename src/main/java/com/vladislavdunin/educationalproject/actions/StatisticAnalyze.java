package com.vladislavdunin.educationalproject.actions;

import com.vladislavdunin.educationalproject.dataDispatchers.FileDispatcher;
import com.vladislavdunin.educationalproject.entity.Result;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class StatisticAnalyze implements Action {
    private FileDispatcher dispatcher = new FileDispatcher();
    private Map<Character, Integer> referenceFileStatistic = new HashMap<>();
    private Map<Character, Integer> encodedFileStatistic = new HashMap<>();
    private StringBuilder builder = new StringBuilder();

    @Override
    public Result execute(String[] parameters) {
        //transform to path format
        Path inputFile = Path.of(parameters[0]).toAbsolutePath();
        Path outputFile = Path.of(parameters[1]).toAbsolutePath();
        Path fileReference = Path.of(parameters[2]).toAbsolutePath();

        //get data from encoded file
        String data = dispatcher.getInputData(inputFile);

        //get data from reference file
        String fileReferenceData = dispatcher.getInputData(fileReference);

        //analyze reference file and get statistic
        fileAnalyzer(referenceFileStatistic, fileReferenceData);

        //init statistic analyze and decode encoded file
        String statisticAnalyzeResult = toStatisticAnalyze(data);

        //write result file
        Result result = dispatcher.setData(outputFile, statisticAnalyzeResult);

        return result;
    }

    private void fileAnalyzer(Map<Character, Integer> statistic, String data) {
        for (int i = 0; i < data.length(); i++) {
            if (statistic.containsKey(data.charAt(i))) {
                int newValue = statistic.get(data.charAt(i)) + 1;
                statistic.put(data.charAt(i), newValue);
                continue;
            }

            statistic.put(data.charAt(i), 1);
        }
    }

    private String toStatisticAnalyze(String encodedFile) {
        char[] encodedFileArr = encodedFile.toCharArray();
        Map<Character, Character> charMap = new HashMap<>();

        fileAnalyzer(encodedFileStatistic, encodedFile);

        for (Map.Entry<Character, Integer> encodedFileEntry : encodedFileStatistic.entrySet()) {
            for (Map.Entry<Character, Integer> referenceFileEntry : referenceFileStatistic.entrySet()) {
                if (Objects.equals(encodedFileEntry.getValue(), referenceFileEntry.getValue())) {
                    charMap.put(encodedFileEntry.getKey(), referenceFileEntry.getKey());
                    break;
                }
            }
        }

        for (int i = 0; i < encodedFileArr.length; i++) {
            for (Map.Entry<Character, Character> charEntry : charMap.entrySet()) {
                if (encodedFileArr[i] == charEntry.getKey()) {
                    encodedFileArr[i] = charEntry.getValue();
                    break;
                }
            }
        }

        for (int i = 0; i < encodedFileArr.length; i++) {
            builder.append(encodedFileArr[i]);
        }

        return builder.toString();
    }

}
