package org.courses.textRedactor.service;

import org.courses.entities.Sentence;
import org.courses.textRedactor.interf.SwappingFirstAndLastWord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SwappingFirstAndLastWordService implements SwappingFirstAndLastWord {


    @Override
    public List<Sentence> swapFirstAndLastWord(List<Sentence> sentences) {
        if (sentences == null || sentences.isEmpty()) {
            throw new IllegalArgumentException("List is empty or null");
        }
        List<Sentence> sentenceList = new ArrayList<>(sentences);
        sentenceList.forEach(sentence -> Collections.swap(sentence.getList(), 0, sentence.getList().size() - 1));
        return sentenceList;
    }
}
