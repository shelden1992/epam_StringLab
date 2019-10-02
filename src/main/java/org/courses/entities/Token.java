package org.courses.entities;

import java.util.ArrayList;
import java.util.List;

public class Token {
    private List<String> stringList = new ArrayList<>();

    public Token(List<String> stringList) {
        this.stringList = stringList;
    }


    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    @Override
    public String toString() {

        return String.valueOf(stringList);
    }
}
