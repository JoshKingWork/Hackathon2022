package com.ngpvan.build.hackathon;

import org.jetbrains.annotations.NotNull;
import org.springframework.util.StringUtils;

public class ParameterKeyValidator {

    public static boolean isValid(@NotNull String key) {
        boolean resolvable = true;
        if (!key.startsWith("azkeyvault")) {
            resolvable = false;
        }

        if (StringUtils.countOccurrencesOf(key, ".") < 2) {
            resolvable = false;
        }

        return resolvable;
    }

}
