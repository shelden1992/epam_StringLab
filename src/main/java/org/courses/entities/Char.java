package org.courses.entities;

public class Char {
    private String chars;

    public Char(String chars) {
        this.chars = chars;
    }

    @Override
    public String toString() {
        return chars;
    }

    public String getChars() {
        return chars;
    }

    public void setChars(String chars) {
        this.chars = chars;
    }
}
