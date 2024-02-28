
package Lab_05;

import java.io.*;
import java.util.*;


public class Part_01 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Source file is: lincoln.txt");
        File file = new File("/home/bsauce/IdeaProjects/TextbookPrac/src/Lab_05/lincoln.txt");
        if (file.exists()) {
            System.out.println("The number of keywords in lincoln.txt is " + createSet(file));
        }
        else {
            System.out.println("File lincoln.txt does not exist");
        }
    }

    public static int createSet(File file) throws Exception {
        //Create set
        Set<String> set = new HashSet<>();

    }
}
