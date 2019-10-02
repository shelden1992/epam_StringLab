package org.courses.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
//        Stream.of(a, b)
//                .flatMap(Stream::of)
//
//        List<List<String>> collect = Stream.of(stringList).flatMap(Stream::of).collect(Collectors.toList());

        return String.valueOf(stringList);
    }
}
