package com.ngpvan.build.hackathon;

import jetbrains.buildServer.parameters.ParameterResolver;
import jetbrains.buildServer.parameters.ParametersProvider;
import jetbrains.buildServer.parameters.ProcessingResult;
import jetbrains.buildServer.parameters.impl.ProcessingResultImpl;
import org.jetbrains.annotations.NotNull;

public class KeyVaultParameterResolver implements ParameterResolver {
    @NotNull
    @Override
    public ProcessingResult resolve(@NotNull String key, @NotNull String value, @NotNull ParametersProvider parameters) {
        ProcessingResultImpl result;
        if (key.equals("hello")) {
            result = new ProcessingResultImpl("world", true, false);
        } else {
            result = new ProcessingResultImpl(value, false, false);
        }
        return result;
    }
}
