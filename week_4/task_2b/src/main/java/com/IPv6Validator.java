package com;

import java.util.regex.Pattern;

public class IPv6Validator {

    private static final String IPV6_REGEX = "^([0-9a-fA-F]{4}:){7}[0-9a-fA-F]{4}$";

    public static boolean isValidIPv6(String ip) {
        // Создаем шаблон на основе регулярного выражения
        Pattern pattern = Pattern.compile(IPV6_REGEX);
        return pattern.matcher(ip).matches();
    }
}
