package org.courses.textRedactor.service;

import org.courses.entities.Char;
import org.courses.entities.Sentence;
import org.courses.entities.Token;
import org.courses.textRedactor.interf.SplittingStringOnTokens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitStringOnTokensService implements SplittingStringOnTokens {

    @Override
    public List<Sentence> splitStringOnTokens(List<String> sentences) {
        if (sentences == null || sentences.isEmpty()) {
            throw new IllegalArgumentException("List is empty or null");
        }
        List<Sentence> sentenceList = new ArrayList<>();
        for (String sentence : sentences
        ) {
            String[] split = sentence.split("\\b");
            List<String> stringList = Arrays.asList(split);
            ArrayList<Char> chars = new ArrayList<>();
            stringList.forEach(string -> {
                Arrays.stream(string.split("")).forEach(f -> chars.add(new Char(f)));
            });
            List<Token> arrayList = new ArrayList() {{
                add((new Token(chars)));
            }};
            sentenceList.add(new Sentence(arrayList));
        }
        return sentenceList;
    }
}
