package org.courses;

import java.util.*;

public class Sentence {
    private List<Word> wordList = new LinkedList<>();



    public Sentence(List<Word> wordList) {
        this.wordList = wordList;
    }


    public List<Word> getWordList() {
        return wordList;
    }

    public void setWordList(List<Word> wordList) {
        this.wordList = wordList;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        wordList.forEach(f->stringBuilder.append(f).append(" "));
        return stringBuilder.toString();
    }


}
