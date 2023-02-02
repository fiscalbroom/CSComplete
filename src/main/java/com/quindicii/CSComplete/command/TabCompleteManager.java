package com.quindicii.CSComplete.command;

import java.util.ArrayList;
import java.util.List;

class TabCompleteManager {
    static List<String> adopt(String last, List<String> variants) {
        List<String> variantsList = new ArrayList<>(variants);
        for (String variant : variantsList) if (!variant.startsWith(last)) variants.remove(variant);
        return variants;
    }
}
