package com.ngpvan.build.hackathon;

public class AppServer {
    KeyVaultParameterResolverServerProvider provider;

    public AppServer() {
        this.provider = new KeyVaultParameterResolverServerProvider();
    }

}