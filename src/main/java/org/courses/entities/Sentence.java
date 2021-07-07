package org.courses.entities;

import java.util.List;

public class Sentence {
    private List<Token> list;

    public Sentence(List<Token> list) {
        this.list = list;
    }

    public List<Token> getList() {
        return list;
    }

    public void setList(List<Token> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        list.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }
}
