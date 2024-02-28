import java.io.*;
import java.util.*;


public class Part_02 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Source file is: lincoln.txt");
        File file = new File("/home/bsauce/IdeaProjects/Lab05/src/lincoln.txt");
        if (file.exists()) {
            System.out.println("Non duplicate words in ascending order:");
            createSet(file);
        }
        else {
            System.out.println("File lincoln.txt does not exist");
        }
    }

    public static int createSet(File file) throws Exception {
        // Vowel keywords
        String text = "Good morning. Have a good class. " +
                "Have a good visit. Have fun!";
        // Create a TreeMap to hold words as key and count as value
        Map<String, Integer> vowelMap = new TreeMap<>();
        // Create a hash set
        String strText = "";
        //Set<String> set = new HashSet<>();
        //Read file in
        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            //Take input make string
            String word = input.next();
            //Remove punctuation
            word = word.replaceAll("[^\\sa-zA-Z0-9]", "");

            //add string to set
            strText += word;
        }


        String[] words = strText.split("[\\s+\\p{P}]");
        for (String word : words) {
            String key = word.toLowerCase();
            if (!key.isEmpty()) {
                if (!vowelMap.containsKey(key)) {
                    vowelMap.put(key, 1);
                } else {
                    int value = vowelMap.get(key);
                    value++;
                    vowelMap.put(key, value);
                }
            }
        }


        return 0;
    }
}
