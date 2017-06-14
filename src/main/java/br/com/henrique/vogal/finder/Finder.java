package br.com.henrique.vogal.finder;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.henrique.exception.NoValueFoundException;
import br.com.henrique.vogal.stream.Stream;

/**
 * Finder
 */
public class Finder {

    private static final String VOGAL_REGEX = "(?i)[aáàãâÁÀÃÂeéêÉÊiíÍoóõôÓÕÔuúÚ]";

    public static char firstChar(Stream input) {
        if (input == null) {
            throw new IllegalArgumentException("Input nulo");
        }

        List<Character> chars = new ArrayList<>();
        //preenche a lista
        while (input.hasNext()) {
            chars.add(input.getNext());
        }
        List<Character> consoantes = chars.stream()
            .filter(c -> !isVogal(c)).collect(Collectors.toList());
        //não possuiu consoante
        if(consoantes == null || consoantes.isEmpty()) {
            return ' ';
        }
        try {
            for(Character c : consoantes) {
            //pega a posicao da consoante
            int consoanteIndex = chars.indexOf(c);
            if(consoanteIndex > 0 && consoanteIndex < chars.size() - 1) {
                if(isVogal(chars.get(consoanteIndex - 1)) && isVogal(chars.get(consoanteIndex + 1))) {
                    
                    //comeca a pesquisar na lista a partir do indice da consoante
                    Character vogal = chars.subList(consoanteIndex + 1, chars.size()).stream().filter(c1 -> {
                        if(isVogal(c1) && chars.stream().filter(cc -> cc.equals(c1)).count() == 1) {
                            return true;
                        }
                        return false;
                    }).findFirst().orElseThrow(NoValueFoundException::new);
                    if(vogal != null) {
                        return vogal;
                    }
                }
            }
        }
        } catch (NoValueFoundException e) {
            return ' ';
        }
        
        /*
        //pega a posicao da consoante
        int consoanteIndex = chars.indexOf(consoante);
        //comeca a pesquisar na lista a partir do indice da consoante
        Character vogal = chars.subList(consoanteIndex, chars.size()).stream().filter(c -> {
            if(isVogal(c) && chars.stream().filter(cc -> cc.equals(c)).count() == 1) {
                return true;
            }
            return false;
        }).findFirst().orElseThrow(NoValueFoundException::new);
        */
        return ' ';
    } 


    private static boolean isVogal(char c) {
        String vogal = String.valueOf(c);
        return vogal.matches(VOGAL_REGEX);
    } 
  
}