package org.courses;

import org.courses.entities.Sentence;
import org.courses.parsers.ParserTextFromFile;
import org.courses.textRedactor.TextRedactor;

import java.util.List;


public class Main {

    public static void main(String[] args) {
        TextRedactor textRedactor = new TextRedactor();
        String textFromFile = new ParserTextFromFile().parseTextFromFile();
        String textFromFileToLowerCaseAndDeleteDoubleSpace = textRedactor.replaceDoubleSpaceAndTab(textFromFile.toLowerCase());
        List<String> sentenceList = textRedactor.splitTextOnSentence(textFromFileToLowerCaseAndDeleteDoubleSpace);
        List<Sentence> splitSentenceList = textRedactor.splitStringOnTokens(sentenceList);
        List<Sentence> swapSentenceList = textRedactor.swapFirstAndLastWord(splitSentenceList);
        List<Sentence> upperCaseSentenceList = textRedactor.toUpperCaseFirstChar(swapSentenceList);
        System.out.println(upperCaseSentenceList);
    }
}

