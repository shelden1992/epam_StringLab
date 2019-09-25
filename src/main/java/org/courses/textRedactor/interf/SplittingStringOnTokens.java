package org.courses.textRedactor.interf;

import org.courses.entities.Sentence;

import java.util.List;

public interface SplittingStringOnTokens {
    List<Sentence> splitStringOnTokens(List<String> sentences);
}
