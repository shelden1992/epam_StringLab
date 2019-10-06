package org.courses.textRedactor;

import org.courses.entities.Sentence;
import org.courses.parsers.ParserTextFromFile;
import org.courses.textRedactor.service.*;

import java.util.List;

public class TextRedactor {
    public List<Sentence> swapFirstAndLastWordInText() {
        String textFromFile = new ParserTextFromFile().parseTextFromFile();
        String textFromFileToLowerCaseAndDeleteDoubleSpace = new ReplaceDoubleSpaceAndTab().replaceDoubleSpaceAndTab(textFromFile.toLowerCase());
        List<String> sentenceList = new SplitTextOnSentenceService().splitTextOnSentence(textFromFileToLowerCaseAndDeleteDoubleSpace);
        List<Sentence> splitSentenceList = new SplitStringOnTokensService().splitStringOnTokens(sentenceList);
        List<Sentence> swapSentenceList = new SwappingFirstAndLastWordService().swapFirstAndLastWord(splitSentenceList);
        List<Sentence> upperCaseSentenceList = new DoingToUpperCaseService().toUpperCaseFirstChar(swapSentenceList);
        return upperCaseSentenceList;
    }


}
