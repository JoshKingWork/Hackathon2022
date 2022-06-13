package com.ngpvan.build.hackathon;

import jetbrains.buildServer.log.Loggers;

import com.azure.identity.EnvironmentCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;

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
        if (ParameterKeyValidator.isValid(key)) {

            Loggers.AGENT.info("KeyVaultParameterResolver: Valid vault secret");

            ParameterKey vaultSecret = new ParameterKey(key);

            String vaultUrl = String.format("https://%s.vault.azure.net", vaultSecret.getVault());

            Loggers.AGENT.info("KeyVaultParameterResolver: Vault URL: " + vaultUrl);

            Loggers.AGENT.info("KeyVaultParameterResolver: Client ID: " + System.getenv("AZURE_CLIENT_ID"));

            SecretClient secretClient = new SecretClientBuilder()
                    .credential(new EnvironmentCredentialBuilder().build())
                    .vaultUrl(vaultUrl)
                    .buildClient();

            Loggers.AGENT.info("KeyVaultParameterResolver: Fetching secret: " + vaultSecret.getSecretName());

            KeyVaultSecret secret = secretClient.getSecret(vaultSecret.getSecretName());

            Loggers.AGENT.info("KeyVaultParameterResolver: Secret fetched");

            result = new ProcessingResultImpl(secret.getValue(), true, true);
        } else {
            result = new ProcessingResultImpl(value, false, true);
        }
        return result;
    }
}
