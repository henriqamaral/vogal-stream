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

@RunWith(Parameterized.class)
public class FinderTest {

  @Parameterized.Parameters(name = "input:{0} - output:{1}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {new CharacterStream("aAbBABacafe"), 'e'},
          {new CharacterStream("cafe"), 'e'},
          {new CharacterStream("coco"), ' '},
          {new CharacterStream("dddd"), ' '},
          {new CharacterStream("casa"), ' '},
          {new CharacterStream("aAbBABacafeTE"), 'e'},
          {new CharacterStream("a"), ' '},
          {new CharacterStream("c"), ' '},
          {new CharacterStream("ac"), ' '},
          {new CharacterStream("xafeAbBABcfIeKI"), ' '},
          {new CharacterStream("aAbBABacafesi"), 'e'},
          {new CharacterStream("aAbBABacafesa"), 'e'},
          {new CharacterStream("afeaAbBABacafIe"), 'I'},
          {new CharacterStream("ifAgahA"), 'a'},
          {new CharacterStream("ifagAha"), 'A'},
          {new CharacterStream(""), ' '},
          {new CharacterStream(" "), ' '},
          {new CharacterStream("afe)aAb!BA&Ba(cafIe"), 'I'},
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

  @Test(expected = IllegalArgumentException.class)
  public void give_null_stream_should_throw_illegal_exception() {
    Finder.firstChar(null);
  }
}
