package ru.ifmo.cet.javabasics;

import java.io.IOException;
import java.nio.charset.Charset;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.Files.readAllLines;

import static java.nio.file.Files.readAllLines;


public class WarAndPeaceExercise {

    public static HashMap<String, Integer> message = new HashMap<>();
    final static Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
    final static Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");
    final  static Charset charset = Charset.forName("windows-1251");
    static String result ="";

    public static String warAndPeace() throws IOException {
        List<String> strings = readAllLines(tome12Path, charset);
        strings.addAll(readAllLines(tome34Path, charset));
        String buffer = strings.toString();
        buffer = buffer.replaceAll("[^a-zA-Zа-яА-Я]", " ").toLowerCase();
        Stream.of(buffer.split(" ")).map(String::toString).filter(word -> word.length() >= 4).
                forEach(word -> message.put(word, message.getOrDefault(word, 0) + 1));
        // TODO map lowercased words to its amount in text and concatenate its entries.
        // TODO Iff word "котик" occurred in text 23 times then its entry would be "котик - 23\n".
        // TODO Entries in final String should be also sorted by amount and then in alphabetical order iff needed.
        // TODO Also omit any word with lengths less than 4 and frequency less than 10
        List<Map.Entry<String, Integer>> entrym = new ArrayList<>(message.entrySet());
        entrym.sort(Map.Entry.comparingByKey());
        entrym.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

        /* return entrym.stream().filter(entrance -> (entrance.getValue() >=10)).
         message(entrance -> entrance.getKey() + " " + entrance.getValue()); */


        result = entrym.stream().filter(entrance -> (entrance.getValue() >= 10)).
                map(entrance -> entrance.getKey() + " - " + entrance.getValue())
                .collect(Collectors.joining("\n"));
        // throw new UnsupportedOperationException();
        return result.trim();
    }

}