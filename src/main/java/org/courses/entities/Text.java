package org.courses.entities;

import java.util.ArrayList;
import java.util.List;

public class Text {
    private List<Sentence> list = new ArrayList<>();

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

        return list.toString();
    }
}
