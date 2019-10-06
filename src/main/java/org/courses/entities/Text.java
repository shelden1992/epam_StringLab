package org.courses.entities;

import java.util.List;

public class Text {
    private List<Sentence> list;

    public Text(List<Sentence> list) {
        this.list = list;
    }

    public List<Sentence> getList() {
        return list;
    }

    public void setList(List<Sentence> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        list.forEach(stringBuilder::append);

        return stringBuilder.toString();
    }
}
