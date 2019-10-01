package org.courses.textRedactor;

import org.courses.entities.Sentence;
import org.courses.entities.Token;
import org.courses.textRedactor.interf.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TextRedactor implements DoingToUpperCase, ReplacingDoubleSpaceAndTab, SplittingTextOnSentence, SplittingSentencesOnTokens, SwappingFirstAndLastWord {

    @Override
    public String replaceDoubleSpaceAndTab(String text) {
        return text.replace("  ", " ").replace("\t", " ");
    }

    @Override
    public List<String> splitTextOnSentence(String text) {
        String[] split = text.split("(?<=[.?!])\\s+");
        return Arrays.asList(split);
    }

    @Override
    public void toUpperCaseFirstChar(List<Sentence> sentences) {
        for (Sentence sentence : sentences
        ) {
            List<Token> tokens = sentence.getList();
            tokens.forEach(token -> {
                List<String> stringList = token.getStringList();
                char[] chars = stringList.get(0).toCharArray();
                chars[0] = Character.toUpperCase(chars[0]);
                stringList.set(0, String.valueOf(chars));
            });
        }
    }

    @Override
    public List<Sentence> splitSentencesOnTokens(List<String> sentences) {
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
    public void swapFirstAndLastWord(List<Sentence> sentences) {
        for (Sentence sentence : sentences
        ) {
            sentence.getList().forEach(token -> Collections.swap(token.getStringList(), 0, token.getStringList().size() - 2));
        }
    }
}
