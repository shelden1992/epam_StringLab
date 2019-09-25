package org.courses;

import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

public class Text {
    private List<Sentence> sentenceList = new LinkedList<>();
    private Sentence sentence;

    public Text(Sentence sentence) {
        this.sentence = sentence;
        sentenceList.add(sentence);
    }

    public Text() {
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        sentenceList.forEach(f -> stringBuilder.append(f).append(" "));
        return stringBuilder.toString();
    }

    public List<Sentence> getSentenceList() {
        return sentenceList;
    }

    public void setSentenceList(List<Sentence> sentenceList) {
        this.sentenceList = sentenceList;
    }
}
