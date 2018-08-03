package br.com.henrique.vogal.stream;

import java.util.Optional;

public class CharacterStream implements Stream {

  private final char[] chars;
  private int currentIndex;

  public CharacterStream(final String input) {
    chars =
        Optional.ofNullable(input)
            .map(s -> input.toCharArray())
            .orElseThrow(() -> new IllegalArgumentException("String nao pode ser nula"));
  }

  @Override
  public char getNext() {
    if (!hasNext()) {
      throw new RuntimeException("Nenhum valor encontrado");
    }
    return this.chars[currentIndex++];
  }

  @Override
  public boolean hasNext() {
    return this.currentIndex < chars.length;
  }
}
