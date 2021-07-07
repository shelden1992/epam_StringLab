package org.courses.entities;

import java.util.List;

public class Token {
    private List<Char> charList;

    public Token(List<Char> stringList) {
        this.charList = stringList;
    }


    public List<Char> getCharList() {
        return charList;
    }

    public void setCharList(List<Char> stringList) {
        this.charList = stringList;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        charList.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }
}
