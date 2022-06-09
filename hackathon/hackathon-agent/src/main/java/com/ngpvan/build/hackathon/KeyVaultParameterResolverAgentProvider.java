package com.ngpvan.build.hackathon;

import com.ngpvan.build.hackathon.common.KeyVaultParameterResolver;
import jetbrains.buildServer.parameters.ContextVariables;
import jetbrains.buildServer.parameters.ParameterResolver;
import jetbrains.buildServer.agent.parameters.ParameterResolverAgentProvider;

public class KeyVaultParameterResolverAgentProvider implements ParameterResolverAgentProvider {
    @Override
    public ParameterResolver getParameterResolver(ContextVariables contextVariables) {
        return new KeyVaultParameterResolver();
    }
}
