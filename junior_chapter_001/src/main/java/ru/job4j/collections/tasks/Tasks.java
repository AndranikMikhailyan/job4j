package ru.job4j.collections.tasks;

import java.util.*;

public class Tasks {

    public boolean containSameChar(String firstWord, String secondWord) {
        boolean result = false;
        HashMap<Character, String> first = convert(firstWord);
        HashMap<Character, String> second = convert(secondWord);
        if (first.toString().equals(second.toString())) {
            result = true;
        }
        return result;
    }

    public ArrayList<Character> duplicatesChars(String word) {
        ArrayList<Character> result = new ArrayList<>();
        HashMap<Character, String> wordMap = convert(word);
        wordMap.forEach((character, string) -> {
            if (string.length() > 1) {
                result.add(character);
            }
        });
        Collections.sort(result);
        return result;
    }

    private HashMap<Character, String> convert(String word) {
        String wrd = word.toLowerCase();
        HashMap<Character, String> result = new HashMap<>();
        char[] chars = wrd.toCharArray();
        for (char aChar : chars) {
            result.computeIfPresent(aChar, (character, string) -> string = string + aChar);
            result.putIfAbsent(aChar, String.valueOf(aChar));
        }
        return result;
    }
}
