package ru.ifmo.cet.javabasics;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.nio.file.Files.readAllLines;


public class WarAndPeaceExercise {
    public static Map<String, Integer> message = new HashMap<>();

    public static String warAndPeace() throws IOException {
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");
        final Charset charset = Charset.forName("windows-1251");
        String buffer;
        String result = "";
        List<String> strings = readAllLines(tome12Path, charset);
        strings.addAll(readAllLines(tome34Path, charset));
        StringBuilder listString = new StringBuilder();
        for (String s : strings) {
            listString.append(s);
            listString.append("\t");

        }

        buffer = listString.toString();
        String[] buffer2 = buffer.split(" ");
        // TODO map lowercased words to its amount in text and concatenate its entries.
        // TODO Entries in final String should be also sorted by amount and then in alphabetical order if needed.
        // TODO Also omit any word with lengths less than 4 and frequency less than 10
        // TODO If word "котик" occurred in text 23 times then its entry would be "котик - 23\n".
        for (String res : buffer2) {

            res = res.replaceAll("[^а-яА-Яa-zA-Z]", " ");

            for (String words : res.split(" ")) {
                if (words.length() >= 4) {

                    words = words.toLowerCase();

                    if ((message.containsKey(words))) {
                        message.put(words, message.get(words) + 1);
                    } else {
                        message.put(words, 1);

                    }
                }
            }
        }




        List<Map.Entry<String, Integer>> entrym = new ArrayList<>(message.entrySet());
        entrym.sort(Map.Entry.comparingByKey());
        entrym.sort(Map.Entry.<String, Integer>comparingByValue().reversed());


        for (Map.Entry entry : entrym) {
            String key = (String) entry.getKey();
            Integer value = (Integer) entry.getValue();
            if (value >= 10) {

                result += key + " - " + value + "\n";
            }

        }

        return result.trim();

    }
}