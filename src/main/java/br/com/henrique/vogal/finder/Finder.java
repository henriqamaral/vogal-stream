package br.com.henrique.vogal.finder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.henrique.vogal.stream.Stream;
import java.util.stream.IntStream;

public class Finder {

  private static final String VOWEL_REGEX = "(?i)[aáàãâÁÀÃÂeéêÉÊiíÍoóõôÓÕÔuúÚ]";

  public static char firstChar(final Stream input) {

    final List<Character> chars =
        Optional.ofNullable(input)
            .map(Finder::mountCharsList)
            .orElseThrow(() -> new IllegalArgumentException("Input nulo"));

    final int charIndex =
        IntStream.range(0, chars.size())
            .filter(index -> filterUniqueVowels(chars.get(index), chars))
            .filter(index -> index > 2 && isVowel(chars.get(index - 2)) &&  !isVowel(chars.get(index - 1)))
            .map(index -> chars.get(index))
            .findFirst()
            .orElse(' ');

    return (char) charIndex;
  }

  private static boolean isVowel(char c) {
    String vowel = String.valueOf(c);
    return vowel.matches(VOWEL_REGEX);
  }

  private static List<Character> mountCharsList(final Stream input) {
    final List<Character> chars = new ArrayList<>();
    while (input.hasNext()) {
      chars.add(input.getNext());
    }
    return chars;
  }

  private static boolean filterUniqueVowels(final Character vowel, final List<Character> chars) {
    return chars.stream().filter(v -> isVowel(v) && v.equals(vowel)).count() == 1;
  }
}
