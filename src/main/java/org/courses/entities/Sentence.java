package org.courses.entities;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private List<Token> list = new ArrayList<>();

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
        list.forEach(f -> stringBuilder.append(f.getStringList()));
        return stringBuilder.toString();
    }
}
