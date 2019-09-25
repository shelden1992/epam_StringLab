package org.courses;

import java.util.StringJoiner;

public class Word {
    private String value;

    public Word(String word) {
        this.value = word;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setWord(String word) {
        this.value = word;
    }

    @Override
    public String toString() {
        return value;
    }
}
