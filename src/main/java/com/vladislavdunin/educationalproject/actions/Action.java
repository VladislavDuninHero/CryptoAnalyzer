package com.vladislavdunin.educationalproject.actions;

import com.vladislavdunin.educationalproject.entity.Result;

public interface Action {
    Result execute(String[] parameters);
}
