package org.courses.textRedactor;

import org.courses.entities.Sentence;
import org.courses.entities.Token;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TextRedactorTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    TextRedactor redactor;
    List<String> sentenceStringList;
    List<Sentence> sentenceList;
    List<Sentence> swapSentenceList;
    List<Sentence> sentenceListInLowerCase;

    @Before
    public void setUp() {
        redactor = new TextRedactor();
        sentenceStringList = new ArrayList<String>() {{
            addAll(Arrays.asList("First sentence!", "Second sentence?", "Third sentence."));
        }};
        sentenceList = Collections.singletonList(new Sentence(Collections.singletonList(new Token(new ArrayList<String>() {{
            addAll(Arrays.asList("First", " ", "sentence", "!"));

        }}))));
        swapSentenceList = Collections.singletonList(new Sentence(Collections.singletonList(new Token(new ArrayList<String>() {{
            addAll(Arrays.asList("sentence", " ", "First", "!"));
        }}))));
        sentenceListInLowerCase = Collections.singletonList(new Sentence(Collections.singletonList(new Token(new ArrayList<String>() {{
            addAll(Arrays.asList("first", " ", "sentence", "!"));

        }}))));

    }

    @Test
    public void shouldReturnStringWithReplaceDoubleSpaceAndTabWhenPassStringNotNullOrNotEmpty() {
        String doubleSpace = "  \t".replaceAll(" {2}", " ");
        String result = redactor.replaceDoubleSpaceAndTab(doubleSpace);
        assertEquals(" ", result);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenPassNullInReplaceDoubleSpaceAndTabMethod() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Text not valid");
        redactor.replaceDoubleSpaceAndTab(null);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenPassEmptyStringInReplaceDoubleSpaceAndTabMethod() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Text not valid");
        redactor.replaceDoubleSpaceAndTab("");
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenPassNullInSplitTextOnSentenceMethod() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Text not valid");
        redactor.splitTextOnSentence(null);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenPassEmptyStringInSplitTextOnSentenceMethod() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Text not valid");
        redactor.splitTextOnSentence("");
    }

    @Test
    public void shouldReturnListOfSentenceWhenPassValidString() {
        String sentenceOneString = "First sentence! Second sentence? Third sentence.";
        List<String> result = redactor.splitTextOnSentence(sentenceOneString);
        assertEquals(sentenceStringList, result);
    }

    @Test
    public void shouldReturnListOfSentenceWhereFirstCharInUpperCaseWhenPassValidSentenceList() {
        List<Sentence> result = redactor.toUpperCaseFirstChar(sentenceListInLowerCase);
        Sentence sentence = result.get(0);
        Token token = sentence.getList().get(0);
        List<String> stringList = token.getStringList();
        assertThat(stringList, is(equalTo(Arrays.asList("First", " ", "sentence", "!"))));
    }

    @Test
    public void shouldReturnListOfTokensWhenPassValidListString() {
        List<Sentence> result = redactor.splitStringOnTokens(sentenceStringList);
        Sentence sentence = result.get(0);
        Token token = sentence.getList().get(0);
        List<String> stringList = token.getStringList();
        assertThat(stringList, is(equalTo(Arrays.asList("First", " ", "sentence", "!"))));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenPassEmptyListOfStringInSplitStringOnTokensMethod() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("List is empty or null");
        redactor.splitStringOnTokens(new ArrayList<String>());
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenNullOfStringInSplitStringOnTokensMethod() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("List is empty or null");
        redactor.splitStringOnTokens(null);
    }

    @Test
    public void shouldReturnListOfSwapFirstAndLastWordWhenPassValidListSentence() {
        List<Sentence> sentenceList = redactor.swapFirstAndLastWord(this.sentenceList);
        Sentence sentence = sentenceList.get(0);
        Token token = sentence.getList().get(0);
        List<String> stringList = token.getStringList();
        assertThat(stringList, is(equalTo(Arrays.asList("sentence", " ", "First", "!"))));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenPassEmptyListOfSentenceInSwapFirstAndLastWordMethod() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("List is empty or null");
        redactor.swapFirstAndLastWord(new ArrayList<Sentence>());
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenNullOfSentenceInSwapFirstAndLastWordMethod() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("List is empty or null");
        redactor.swapFirstAndLastWord(null);
    }

}