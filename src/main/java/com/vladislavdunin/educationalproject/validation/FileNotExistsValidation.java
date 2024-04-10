package com.vladislavdunin.educationalproject.validation;

import java.nio.file.Files;
import java.nio.file.Path;

public class FileNotExistsValidation {
    public static boolean validate(Path path) {
        if (Files.notExists(path)) {
            return false;
        }

        return true;
    }
}
