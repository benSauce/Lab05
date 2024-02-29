import java.io.*;
import java.util.*;

/* Steps
 * Read Text File
 * Display number of times vowerl is present
 *   (a, e, i, o, u)
 *       Read file
 *       parse through each character
 *       if character matches vowel set
 *           add that vowel with count of 1
 *       else if vowel is already in set
 *           add count +1 for that vowel
 * Print out vowel and count for each vowel present
 */


public class     Part_03 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Source file is: lincoln.txt");
        File file = new File("src/lincoln.txt");
        if (file.exists()) {
            System.out.println("Vowels and counts:");
            createMap(file);
        } else {
            System.out.println("File lincoln.txt does not exist");
        }
    }

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