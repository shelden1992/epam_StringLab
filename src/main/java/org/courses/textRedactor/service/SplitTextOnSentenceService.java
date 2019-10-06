package org.courses.textRedactor.service;

import org.courses.textRedactor.interf.SplittingTextOnSentence;

import java.util.Arrays;
import java.util.List;

public class SplitTextOnSentenceService implements SplittingTextOnSentence {


    @Override
    public List<String> splitTextOnSentence(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text not valid");
        }
        String[] split = text.split("(?<=[.?!])\\s+");
        return Arrays.asList(split);
    }
}
