package org.courses;

import org.courses.entities.Sentence;
import org.courses.parsers.ParserTextFromFile;
import org.courses.textRedactor.TextRedactor;

import java.util.List;


public class Main {

    public static void main(String[] args) {
        String textFromFile1 = new ParserTextFromFile().parseTextFromFile();
        List<Sentence> sentenceList = new TextRedactor().swapFirstAndLastWordInText(textFromFile1);
        System.out.println(sentenceList);
    }
}

