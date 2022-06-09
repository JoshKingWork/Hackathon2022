package com.ngpvan.build.hackathon;

import jetbrains.buildServer.log.Loggers;
public class AppAgent {
    KeyVaultParameterResolverAgentProvider provider;

    public AppAgent() {
        this.provider = new KeyVaultParameterResolverAgentProvider();
        Loggers.AGENT.info("KeyVaultParameterResolverAgentProvider is loaded in agent");
    }
}
