package com.vladislavdunin.educationalproject;


import com.vladislavdunin.educationalproject.entity.Result;

public class Runner {
    public static void main(String[] args) {
        App app = new App();

        Result result = app.run();
        System.out.println(result);
    }
}