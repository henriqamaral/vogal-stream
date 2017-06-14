package br.com.henrique.vogal.stream;

import br.com.henrique.vogal.stream.Stream;

/**
 * CharacterStream
 */
public class CharacterStream implements Stream {

    private final String input;
    private final char[] chars;
    private int currentIndex;

    public CharacterStream(String input) {
        if (input == null) {
            throw new IllegalArgumentException("String nao pode ser nula");
        }
        this.input = input;
        this.chars = this.input.toCharArray();
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