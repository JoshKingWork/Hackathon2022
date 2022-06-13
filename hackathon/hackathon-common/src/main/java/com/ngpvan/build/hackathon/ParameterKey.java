package com.ngpvan.build.hackathon;

public class ParameterKey {

    private String vault;
    private String secretName;

    public ParameterKey(String key) {
        String[] parts = key.split("\\.");
        if (parts.length < 3) {
            throw new IllegalArgumentException("Invalid Parameter Key");
        }
        this.vault = parts[1];
        this.secretName = parts[2];
    }

    public String getSecretName() {
        return secretName;
    }

    public String getVault() {
        return vault;
    }

}
