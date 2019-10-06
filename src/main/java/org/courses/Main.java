package org.courses;

import org.courses.entities.Sentence;
import org.courses.textRedactor.TextRedactor;

import java.util.List;


public class Main {

    public static void main(String[] args) {
        List<Sentence> sentenceList = new TextRedactor().swapFirstAndLastWordInText();
        System.out.println(sentenceList);
    }
}

