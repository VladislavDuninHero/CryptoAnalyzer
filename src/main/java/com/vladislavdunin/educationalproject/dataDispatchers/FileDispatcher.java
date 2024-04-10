package com.vladislavdunin.educationalproject.dataDispatchers;

import com.vladislavdunin.educationalproject.entity.AppStatusCode;
import com.vladislavdunin.educationalproject.entity.Result;
import com.vladislavdunin.educationalproject.exceptions.ApplicationValidateException;
import com.vladislavdunin.educationalproject.validation.FileNotExistsValidation;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;


public class FileDispatcher {
    public String getInputData(Path in) {
        //create absolute path to file
        Path fileForEncode = in.toAbsolutePath();
        //result builder
        StringBuilder builder = new StringBuilder();
        //validate file
        if (FileNotExistsValidation.validate(fileForEncode)) {
            //create stream for file
            try (
                    Reader reader = Files.newBufferedReader(fileForEncode, StandardCharsets.UTF_8)
            ) {
                while (reader.ready()) {
                    builder.append((char)reader.read());
                }
            } catch (IOException err) {
                err.printStackTrace();
            }
        } else {
            throw new ApplicationValidateException("File not found!");
        }

        return builder.toString().toLowerCase();
    }

    public Result setData(Path path, String data) {
        if (!FileNotExistsValidation.validate(path)) {
            try {
                Files.createFile(path);
            } catch (IOException err) {
                err.printStackTrace();
            }
        }

        try(Writer out = Files.newBufferedWriter(path)) {
            out.append(data);

            return new Result("Success", AppStatusCode.OK);
        } catch (IOException err) {
            err.printStackTrace();
            return new Result("Failed", AppStatusCode.ERROR);
        }
    }

}
