package com.example.taskmanager.utils.validation.rules;

public interface IValidationRule {
    boolean isValid(String value);
    String getErrorMessage();
}
