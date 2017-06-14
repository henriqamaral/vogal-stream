package br.com.henrique.vogal;

import java.io.Console;

import br.com.henrique.exception.NoValueFoundException;
import br.com.henrique.vogal.finder.Finder;
import br.com.henrique.vogal.stream.CharacterStream;
import br.com.henrique.vogal.stream.Stream;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Console c = System.console();
        if (c == null) {
            System.err.println("No console.");
            System.exit(1);
        }

        String input = c.readLine("Digite o input: ");
        try {
            Stream s = new CharacterStream(input);
            System.out.println("Output: " + Finder.firstChar(s));
        } catch (NoValueFoundException e) {
            System.out.println("Output: ");
        }
        
    }
}