package org.courses.textRedactor.service;

import org.courses.textRedactor.interf.SplittingTextOnSentence;

import java.util.Arrays;
import java.util.List;

public class SplitTextOnSentenceService implements SplittingTextOnSentence {
    private static final String END_SENTENCE_REGEX = "(?<=[.?!])\\s+";


    @Override
    public List<String> splitTextOnSentence(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text not valid");
        }
        String[] split = text.split(END_SENTENCE_REGEX);
        return Arrays.asList(split);
    }
}
