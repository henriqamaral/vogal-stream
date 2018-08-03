package br.com.henrique.vogal;

import java.io.Console;

import br.com.henrique.vogal.finder.Finder;
import br.com.henrique.vogal.stream.CharacterStream;
import br.com.henrique.vogal.stream.Stream;

public class Main {

  public static void main(String[] args) {
    Console c = System.console();
    if (c == null) {
      System.err.println("No console.");
      System.exit(1);
    }

    final String input = c.readLine("Input: ");
    try {
      final Stream s = new CharacterStream(input);
      final Character foundC = Finder.firstChar(s);
      if (foundC != ' ') {
        System.out.println("Output: " + foundC);
      } else {
        System.out.println("Output: Caracter  não encontrado");
      }
    } catch (IllegalArgumentException e) {
      System.out.println("Output: Caracter  não encontrado");
    }
  }
}
