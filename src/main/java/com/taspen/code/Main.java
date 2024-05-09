package com.taspen.code;

import java.util.*;

public class Main {
    public static String getSortedGroupedCharacter(String[] words){
        Map<Character, Integer> countChar = new HashMap<>();
        StringBuilder fullWords = new StringBuilder();
        for(String str : words){
            fullWords.append(str);
        }

        for(char ch : fullWords.toString().toCharArray()){
            countChar.put(ch, countChar.getOrDefault(ch, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> entries = getEntries(countChar);

        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : entries) {
            char letter = entry.getKey();
            result.append(letter);
        }

        return result.toString();
    }

    private static List<Map.Entry<Character, Integer>> getEntries(Map<Character, Integer> countChar) {
        List<Map.Entry<Character, Integer>> entries = new ArrayList<>(countChar.entrySet());

        entries.sort((preEntry, postEntry) -> {
            int valueCompare = Integer.compare(postEntry.getValue(), preEntry.getValue());
            if(valueCompare != 0){
                return valueCompare;
            }

            if (Character.isUpperCase(preEntry.getKey()) && Character.isLowerCase(postEntry.getKey())){
                return -1;
            } else if(Character.isLowerCase(preEntry.getKey()) && Character.isUpperCase(postEntry.getKey())){
                return 1;
            } else {
                return Character.compare(preEntry.getKey(), postEntry.getKey());
            }
        });
        return entries;
    }

    public static void main(String[] args) {

        System.out.println("Input : " + "[\"Abc\", \"bCd\"]");
        System.out.println("Output: " + getSortedGroupedCharacter(new String[]{"Abc", "bCd"}) + "\n");

        System.out.println("Input : " + "[\"Oke\", \"One\"]");
        System.out.println("Output: " + getSortedGroupedCharacter(new String[]{"Oke", "One"}) + "\n");

        System.out.println("Input : " + "[\"Pendanaan\", \"Terproteksi\", \"Untuk\", \"Dampak\"]");
        System.out.println("Output: " + getSortedGroupedCharacter(new String[]{"Pendanaan", "Terproteksi", "Untuk", "Dampak", "Berarti"}) + "\n");

    }
}
