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


public class Part_02 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Source file is: lincoln.txt");
        File file = new File("/home/bsauce/IdeaProjects/Lab05/src/lincoln.txt");
        if (file.exists()) {
            System.out.println("Vowels and counts:");
            createMap(file);
        }
        else {
            System.out.println("File lincoln.txt does not exist");
        }
    }

    public static int createMap(File file) throws Exception {
        // Vowel keywords
        String[] vowelArray = {"a", "e", "i", "o", "u"};
        //Create set from vowelSet
        Set<String> vowelSet = new HashSet<>(Arrays.asList(vowelArray));
        int count = 0;
        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            String word = input.next();
            if (vowelSet.contains(word))
                count++;
        }
        return count;
    }
}
