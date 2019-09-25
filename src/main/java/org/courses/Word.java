package org.courses;

import java.util.StringJoiner;

public class Word {
    private String value;

    public String getValue() {
        return value;
    }

    public void setWord(String word) {
        this.value = word;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public Word(String word) {
        this.value = word;
    }
}
