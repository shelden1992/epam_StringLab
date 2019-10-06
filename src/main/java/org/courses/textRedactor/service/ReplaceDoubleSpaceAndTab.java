package org.courses.textRedactor.service;

import org.courses.textRedactor.interf.ReplacingDoubleSpaceAndTab;

public class ReplaceDoubleSpaceAndTab implements ReplacingDoubleSpaceAndTab {

    @Override
    public String replaceDoubleSpaceAndTab(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text not valid");
        }
        return text.replaceAll(" {2}", " ").replaceAll("\t", "");
    }
}
