package org.courses.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
//        StringBuilder stringBuilder = new StringBuilder();
//        for (Sentence sentence : list
//                ) {
//            stringBuilder.append(sentence);
//
//        }
//        list.forEach(f -> stringBuilder.append(f.getList()));


        for (Sentence sentence : list
        ) {
            List<List<Sentence>> collect = Stream.of(list).flatMap(Stream::of).collect(Collectors.toList());

        }
        return list.toString();

    }
}
