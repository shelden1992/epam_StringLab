package org.courses.textRedactor.interf;

import org.courses.entities.Sentence;

import java.util.List;

public interface DoingToUpperCase {
    List<Sentence> toUpperCaseFirstChar(List<Sentence> sentences);
}
