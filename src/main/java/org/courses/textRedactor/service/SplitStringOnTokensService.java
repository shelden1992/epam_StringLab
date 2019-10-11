package org.courses.textRedactor.service;

import org.courses.entities.Char;
import org.courses.entities.Sentence;
import org.courses.entities.Token;
import org.courses.textRedactor.interf.SplittingStringOnTokens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitStringOnTokensService implements SplittingStringOnTokens {
    private static final String CHAR_REGEX = "\\b";

    @Override
    public List<Sentence> splitStringOnTokens(List<String> sentences) {
        if (sentences == null || sentences.isEmpty()) {
            throw new IllegalArgumentException("List is empty or null");
        }
        List<Sentence> sentenceList = new ArrayList<>();
        sentences.forEach(sentence -> {
            List<Char> chars = new ArrayList<>();
            Arrays.stream(sentence.split(CHAR_REGEX))
                    .forEach(string -> {
                        Arrays.asList(string.split(""))
                                .forEach(f -> chars.add(new Char(f)));
                    });
            sentenceList.add(new Sentence(new ArrayList() {{
                add((new Token(chars)));
            }}));
        });
        return sentenceList;
    }
}
