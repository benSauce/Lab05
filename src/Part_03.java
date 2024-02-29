import java.io.*;
import java.util.*;



/* Steps
 * Read Text File
 * Parse words
 * Check if word has been inserted into map before
 * If not, insert word and set value to 1
 * If has, retrieve value and increment by 1
 * Print out vowel and count for each vowel present
 */
public class     Part_03 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Source file is: lincoln.txt");
        File file = new File("src/lincoln.txt");
        if (file.exists()) {
            System.out.println("Words and counts");
            createMap(file);
        } else {
            System.out.println("File lincoln.txt does not exist");
        }
    }

    public static int createMap(File file) throws Exception {
        // Create a TreeMap to hold words as key and count as value
        Map<String, Integer> map = new TreeMap<>();
        //assign file to scanner
        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            //Take input and retrieve word
            String word = input.next();
            //make lower case
            word = word.toLowerCase();
            //remove punctuations
            String cleanedWord = word.replaceAll("[^\\sa-zA-Z0-9]", "");
            //If word hasn't been added, add and set value 1
            if (!map.containsKey(cleanedWord)) {
                map.put(cleanedWord, 1);
                //else get kay value and increment if does contain
            } else {
                int value = map.get(cleanedWord);
                value++;
                map.put(cleanedWord, value);
            }
        }
        //Print out vowel and count
        map.forEach((k,v) -> System.out.println(( k + " : " + v)));
        return 0;
    }
}
