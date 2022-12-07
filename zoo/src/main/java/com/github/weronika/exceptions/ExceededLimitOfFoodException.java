package com.github.weronika.exceptions;

public class ExceededLimitOfFoodException extends Exception{
    public ExceededLimitOfFoodException(String errorMessage) {
        super(errorMessage);
    }
}
