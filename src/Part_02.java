/*
 * CS 2013
 * Lab 5 - Sets and Maps
 * Benjamin Saucedo
 * Use a text file as input. Read the text file.
 * Display the number of each vowel (a, e, i, o, u)  in the file.
 */

import java.io.*;
import java.util.*;

public class Part_02 {
    public static void main(String[] args) throws Exception {
        //Assign source file
        System.out.println("Source file is: lincoln.txt");
        File file = new File("src/lincoln.txt");
        if (file.exists()) {
            System.out.println("Vowels and counts:");
            createMap(file);
        } else {
            System.out.println("File lincoln.txt does not exist");
        }
    }

    /*
     * createMap
     * description: Takes input from text file. Parse through each character. Check if char is vowel.
     * If vowel, add to map as the key and track number as value.
     * parameters: File
     * returns: 0, but prints map
     */
    public static int createMap(File file) throws Exception {
        // Vowel keywords
        String[] vowelArray = {"a", "e", "i", "o", "u"};
        //Create set from vowelArray
        Set<String> vowelSet = new HashSet<>(Arrays.asList(vowelArray));
        // Create a TreeMap to hold words as key and count as value
        Map<String, Integer> map = new TreeMap<>();
        //assign file to scanner
        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            //Take input and retrieve word
            String word = input.next();
            //Parse word by letter
            for (int i = 0; i < word.length(); i++) {
                //Assign individual char to key
                String key = String.valueOf(word.charAt(i));
                //Check if key is in vowelSet
                if (vowelSet.contains(key)) {
                    //If yes, check if map contains key, add if doesn't
                    if (!map.containsKey(key)) {
                        map.put(key, 1);
                    //else get kay value and increment if does contain
                    } else {
                        int value = map.get(key);
                        value++;
                        map.put(key, value);
                    }
                }
            }
        }
        //Print out vowel and count
        System.out.println(map);
        return 0;
    }
}