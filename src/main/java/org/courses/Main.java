package org.courses;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final int MINIMAL_SENTENCES_LENGHT = 4;
    private static Path pathRead = Paths.get("/Users/macuser/Desktop/projects/epamEducation/epam_StringLaboratory/src/main/resources/BookForProgramming");
    private static String replacePoint = "";
    private static String punctuaitionAfterFirsWord = "";

    public static void main(String[] args) {
        parseTextToStringAndSwapWord();
    }


    private static Word[] replaceWordAndAddPointToAndWord(Word[] words) {
        Word[] wordsLocalCopy = words;
        Word firstWord = (DeleteAndSavePunctuationAfterFirstWord(wordsLocalCopy[0]));
        Word firstCopyWord = firstWord;
        Word lastWord = wordsLocalCopy[words.length - 1];
        wordsLocalCopy[0] = toUpperCaseFirstWordAndAddPunction(lastWord);
        wordsLocalCopy[words.length - 1] = toLowerCaseLastWordAndAddPunction(firstCopyWord);
        return wordsLocalCopy;

    }

    private static Word toUpperCaseFirstWordAndAddPunction(Word word) {
        String value = word.getValue();
        return new Word(String.valueOf(value.charAt(0)).toUpperCase() + value.substring(1) + punctuaitionAfterFirsWord);
    }

    private static Word toLowerCaseLastWordAndAddPunction(Word word) {
        String value = word.getValue();
        return new Word(value.toLowerCase() + replacePoint);
    }

    private static Word[] createWordAndDeletePointInEndWord(String[] strings) {
        Word[] words = new Word[strings.length];

        for (int i = 0; i < strings.length; i++) {
            if (i == strings.length - 1) {

                words[i] = new Word(DeleteAndSavePunctuationAfterLastWord(strings[i]));
            } else {
                words[i] = new Word(strings[i]);
            }
        }
        return words;
    }

    private static String replaceDoubleSpaceAndTab(String str) {
        return str.replace("  ", " ").replace("\t", " ");

    }

    private static List<Sentence> parseTextToStringAndSwapWord() {
        Text textBook = new Text();
        List<Sentence> sentenceList = textBook.getSentenceList();
        try {
            String text = new String(Files.readAllBytes(pathRead), StandardCharsets.UTF_8);
            Arrays.stream(text.split("(?<=[.?!])\\s+")).filter(f -> f.length() > MINIMAL_SENTENCES_LENGHT)
                    .forEach(f -> {
                        sentenceList.add(
                                new Sentence(Arrays.asList(replaceWordAndAddPointToAndWord(createWordAndDeletePointInEndWord(replaceDoubleSpaceAndTab(f).split("\\s")))))
                        );
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(textBook.toString());
        return sentenceList;
    }

    private static String DeleteAndSavePunctuationAfterLastWord(String string) {
        Pattern somePunction = Pattern.compile("\\p{Punct}");
        Matcher matcher = somePunction.matcher(string);
        String punct = "";
        if (matcher.find()) {
            punct = matcher.group();
        }
        replacePoint = punct;
        return string.replace(punct, "");


    }

    private static Word DeleteAndSavePunctuationAfterFirstWord(Word word) {
        String wordValue = word.getValue();
        Pattern somePunction = Pattern.compile("\\p{Punct}");
        Matcher matcher = somePunction.matcher(wordValue);
        String punct = "";
        if (matcher.find()) {
            punct = matcher.group();
        }
        punctuaitionAfterFirsWord = punct;
        return new Word(wordValue.replace(punct, ""));
    }

}