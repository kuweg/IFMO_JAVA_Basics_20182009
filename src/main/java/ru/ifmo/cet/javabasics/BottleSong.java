package ru.ifmo.cet.javabasics;

import java.util.HashMap;

/**
 * Нужно реализовать констурктор и метод, возвращающий слова песни про бутылки на стене.
 * <p>
 * Слова следующие:
 * <p>
 * 99 bottles of beer on the wall, 99 bottles of beer
 * Take one down, pass it around, 98 bottles of beer
 * 98 bottles of beer on the wall, 98 bottles of beer
 * Take one down, pass it around, 97 bottles of beer
 * 97 bottles of beer on the wall, 97 bottles of beer
 * Take one down, pass it around, 96 bottles of beer
 * 96 bottles of beer on the wall, 96 bottles of beer
 * Take one down, pass it around, 95 bottles of beer
 * 95 bottles of beer on the wall, 95 bottles of beer
 * ...
 * <p>
 * 3 bottles of beer on the wall, 3 bottles of beer
 * Take one down, pass it around, 2 bottles of beer
 * 2 bottles of beer on the wall, 2 bottles of beer
 * Take one down, pass it around, 1 bottles of beer
 * 1 bottle of beer on the wall, 1 bottle of beer
 * Take one down, pass it around, no more bottles of beer on the wall
 * No more bottles of beer on the wall, no more bottles of beer
 * Go to the store and buy some more, 99 bottles of beer on the wall
 * <p>
 * Дело усложняется тем, что текст песни переменный:
 * За раз может быть взято несколько бутылок.
 * Значение передается в качестве параметра конструктора
 * Нужно ограничить возможность взятия бутылок натуральным число не более 99 бутылок за раз.
 */
public class BottleSong {

    private int bottleTakenAtOnce;
    private HashMap<Integer, String> digit = new HashMap<>();

    public BottleSong(int bottleTakenAtOnce) {
        this.bottleTakenAtOnce = bottleTakenAtOnce;

        digit.put(1, "one");
        digit.put(2, "two");
        digit.put(3, "three");
        digit.put(4, "four");
        digit.put(5, "five");
        digit.put(6, "six");
        digit.put(7, "seven");
        digit.put(8, "eight");
        digit.put(9, "nine");
        digit.put(10, "ten");
        digit.put(11, "eleven");
        digit.put(12, "twelve");
        digit.put(13, "thirteen");
        digit.put(14, "fourteen");
        digit.put(15, "fifteen");
        digit.put(16, "sixteen");
        digit.put(17, "seventeen");
        digit.put(18, "eighteen");
        digit.put(19, "nineteen");
        digit.put(20, "twenty");
        digit.put(30, "thirty");
        digit.put(40, "forty");
        digit.put(50, "fifty");
        digit.put(60, "sixty");
        digit.put(70, "seventy");
        digit.put(80, "eighty");
        digit.put(90, "ninety");
    }


    public String getBottleSongLyrics() {
        if (bottleTakenAtOnce > 99 || bottleTakenAtOnce < 1) {

            throw new IllegalArgumentException();

        }

        StringBuffer output = new StringBuffer();


        for (int remain = 99; remain > 0; remain -= bottleTakenAtOnce) {
            output.append(remain);
            output.append(" bottle");
            output.append(remain != 1 ? "s" : "");
            output.append(" of beer on the wall, ");
            output.append(remain);
            output.append(" bottle");
            output.append(remain != 1 ? "s" : "");
            output.append(" of beer.\n");

            output.append("Take ");
            if (remain - bottleTakenAtOnce < 0) {
                bottleTakenAtOnce = remain;
                output.append(digitToString(bottleTakenAtOnce));
                output.append(" down and pass around, no more bottles of beer on the wall.\n");
                break;
            } else {
                output.append(digitToString(bottleTakenAtOnce));
                output.append(" down and pass around, ");
                if (remain - bottleTakenAtOnce == 0) {
                    output.append("no more bottles of beer on the wall.\n");
                    break;
                }
                output.append(remain - bottleTakenAtOnce);
                output.append(" bottle");
                output.append(remain - bottleTakenAtOnce != 1 ? "s" : "");
                output.append(" of beer on the wall.\n");
            }
        }
        output.append("No more bottles of beer on the wall, no more bottles of beer.\n");
        output.append("Go to the store and buy some more, 99 bottles of beer on the wall.\n");

        return output.toString();
    }

    private String digitToString(int number) {
        if (number >= 20 && number % 10 != 0) {
            return digit.get((number / 10) * 10) + " " + digit.get(number % 10);
        } else {
            return digit.get(number);
        }
    }


}
