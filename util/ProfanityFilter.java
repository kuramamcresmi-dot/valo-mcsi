package com.kuramamc.valorant.util;

import java.util.Arrays;
import java.util.List;

public class ProfanityFilter {
    // Buraya istediğin kadar küfür ekleyebilirsin
    private static final List<String> BLACKLIST = Arrays.asList(
        "amk", "oc", "siktir", "fuck", "shit", "aq", "awq", "sg", "oe",
    );

    public static boolean containsProfanity(String input) {
        String cleaned = input.toLowerCase().replaceAll("\\s+", "");
        return BLACKLIST.stream().anyMatch(cleaned::contains);
    }
}
