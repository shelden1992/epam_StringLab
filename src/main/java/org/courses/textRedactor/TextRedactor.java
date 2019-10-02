package org.courses.textRedactor;

import org.courses.entities.Sentence;
import org.courses.entities.Token;
import org.courses.textRedactor.interf.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TextRedactor implements DoingToUpperCase, ReplacingDoubleSpaceAndTab, SplittingTextOnSentence, SplittingStringOnTokens, SwappingFirstAndLastWord {

    @Override
    public String replaceDoubleSpaceAndTab(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text not valid");
        }
        return text.replaceAll(" {2}", " ").replaceAll("\t", "");
    }

    @Override
    public List<String> splitTextOnSentence(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text not valid");
        }
        String[] split = text.split("(?<=[.?!])\\s+");
        return Arrays.asList(split);
    }

    @Override
    public List<Sentence> toUpperCaseFirstChar(List<Sentence> sentences) {
        List<Sentence> sentenceList = new ArrayList<>(sentences);
        if (sentences == null || sentences.isEmpty()) {
            throw new IllegalArgumentException("List is empty or null");
        }
        for (Sentence sentence : sentenceList
        ) {
            List<Token> tokens = sentence.getList();
            tokens.forEach(token -> {
                List<String> stringList = token.getStringList();
                char[] chars = stringList.get(0).toCharArray();
                chars[0] = Character.toUpperCase(chars[0]);
                stringList.set(0, String.valueOf(chars));
            });
        }
        return sentenceList;
    }

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
            List<Token> arrayList = new ArrayList() {{
                add((new Token(stringList)));
            }};
            sentenceList.add(new Sentence(arrayList));
        }
        return sentenceList;
    }

    @Override
    public List<Sentence> swapFirstAndLastWord(List<Sentence> sentences) {
        if (sentences == null || sentences.isEmpty()) {
            throw new IllegalArgumentException("List is empty or null");
        }
        List<Sentence> sentenceList = new ArrayList<>(sentences);
        for (Sentence sentence : sentenceList
        ) {
            sentence.getList().forEach(token -> Collections.swap(token.getStringList(), 0, token.getStringList().size() - 2));
        }
        return sentenceList;
    }
}