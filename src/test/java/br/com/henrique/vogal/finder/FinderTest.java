package br.com.henrique.vogal.finder;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import br.com.henrique.vogal.stream.CharacterStream;
import br.com.henrique.vogal.stream.Stream;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Finder
 */
@RunWith(Parameterized.class)
public class FinderTest {

    @Parameterized.Parameters(name = "input:{0} - output:{1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new CharacterStream("aAbBABacafe"), 'e'},
                {new CharacterStream("cafe"), 'e'},
                {new CharacterStream("coco"), ' '},
                {new CharacterStream("dddd"), ' '},
                {new CharacterStream("casa"), ' '},
                {new CharacterStream("humilde"), 'i'}
        });
    }

    private final Stream input;

    private final char expected;

    public FinderTest(Stream input, char expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void tryToFindVowelOnStream() {
        char actual = Finder.firstChar(input);
        assertThat(actual, is(equalTo(expected)));
    }
  
}