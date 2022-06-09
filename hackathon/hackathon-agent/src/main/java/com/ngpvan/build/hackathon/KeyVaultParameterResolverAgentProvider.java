package com.ngpvan.build.hackathon;

import com.ngpvan.build.hackathon.KeyVaultParameterResolver;
import jetbrains.buildServer.agent.parameters.ParameterResolverAgentProvider;
import jetbrains.buildServer.parameters.ContextVariables;
import jetbrains.buildServer.parameters.ParameterResolver;

public class KeyVaultParameterResolverAgentProvider implements ParameterResolverAgentProvider {
    @Override
    public ParameterResolver getParameterResolver(ContextVariables contextVariables) {
        return new KeyVaultParameterResolver();
    }
}
