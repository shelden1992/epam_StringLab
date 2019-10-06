package org.courses.textRedactor.service;

import org.courses.entities.Sentence;
import org.courses.entities.Token;
import org.courses.textRedactor.interf.DoingToUpperCase;

import java.util.ArrayList;
import java.util.List;

public class DoingToUpperCaseService implements DoingToUpperCase {
    private static void toUpCaseFirstChar(Token token) {
        token.getCharList().stream()
                .findFirst()
                .ifPresent(charObj -> charObj.setChars(charObj.getChars().toUpperCase()));

    }

    private static void toUpCaseFirstChar(Sentence sentence) {
        sentence.getList().forEach(DoingToUpperCaseService::toUpCaseFirstChar);
    }


    @Override
    public List<Sentence> toUpperCaseFirstChar(List<Sentence> sentences) {
        List<Sentence> sentenceList = new ArrayList<>(sentences);
        if (sentences == null || sentences.isEmpty()) {
            throw new IllegalArgumentException("List is empty or null");
        }
        sentenceList.forEach(DoingToUpperCaseService::toUpCaseFirstChar);
        return sentenceList;
    }
}
