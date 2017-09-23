package com.wind.utils.validation;

import com.wind.utils.validation.annotation.NotNull;

public class User {

    @NotNull
    private Long id;
    @NotNull
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
