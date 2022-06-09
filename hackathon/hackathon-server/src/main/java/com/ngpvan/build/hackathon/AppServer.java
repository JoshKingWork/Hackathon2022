package com.ngpvan.build.hackathon;

import jetbrains.buildServer.log.Loggers;
public class AppServer {
    private KeyVaultParameterResolverServerProvider provider;

    public AppServer() {
        this.provider = new KeyVaultParameterResolverServerProvider();
        Loggers.SERVER.info("KeyVaultParameterResolverServerProvider is loaded in server");
    }

}