package com.vladislavdunin.educationalproject.constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Constants {
    private static final String[] ENG_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase().split("");
    private static final String[] RUS_ALPHABET = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ".toLowerCase().split("");
    private static final String[] NUMBERS = "1234567890".split("");
    private static final String[] SPECIAL_CHARS = "@$#&* {}[],.=-()+;'/°".split("");

    public static final List<String> ALL_SYMBOLS = new ArrayList<>();

    static {
        Collections.addAll(ALL_SYMBOLS, ENG_ALPHABET);
        Collections.addAll(ALL_SYMBOLS, RUS_ALPHABET);
        Collections.addAll(ALL_SYMBOLS, NUMBERS);
        Collections.addAll(ALL_SYMBOLS, SPECIAL_CHARS);
    }
}
