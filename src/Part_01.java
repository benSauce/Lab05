/*
 * CS 2013
 * Lab 5 - Sets and Maps
 * Benjamin Saucedo
 * Use a text file as input. Display Non-duplicate words in ascending order.
 */

import java.io.*;
import java.util.*;


public class Part_01 {
    public static void main(String[] args) throws Exception {
        //Assign source file
        System.out.println("Source file is: lincoln.txt");
        File file = new File("src/lincoln.txt");
        if (file.exists()) {
            System.out.println("Non duplicate words in ascending order:");
            createSet(file);
        }
        else {
            System.out.println("File lincoln.txt does not exist");
        }
    }

    /*
     * createSet
     * description: Takes input from text file. Turns it into string and adds to set
     * parameters: File
     * returns: 0, but prints set
     */
    public static int createSet(File file) throws Exception {
        // Create a hash set
        Set<String> set = new HashSet<>();
        //Read file in
        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            //Take input make string
            String word = input.next();
            //Remove punctuation
            word = word.replaceAll("[^\\sa-zA-Z0-9]", "");

            //add string to set
            set.add(word.toLowerCase());
        }

        //Create treeSet from set
        TreeSet<String> treeSet = new TreeSet<>(set);

        //Set<String> set = new HashSet<>();
        //System.out.println(treeSet);
        treeSet.forEach(e -> System.out.println(e.toUpperCase()));
        return 0;
    }
}
