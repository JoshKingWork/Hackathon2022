package com.ngpvan.build.hackathon;

import jetbrains.buildServer.log.Loggers;
public class AppServer {
    KeyVaultParameterResolverServerProvider provider;

    public AppServer() {
        this.provider = new KeyVaultParameterResolverServerProvider();
        Loggers.SERVER.info("KeyVaultParameterResolverAgentProvider is loaded in server");
    }

}