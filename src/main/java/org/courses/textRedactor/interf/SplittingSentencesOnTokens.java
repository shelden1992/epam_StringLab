package org.courses.textRedactor.interf;

import org.courses.entities.Sentence;

import java.util.List;

public interface SplittingSentencesOnTokens {
    public List<Sentence> splitSentencesOnTokens(List<String> sentences);
}
