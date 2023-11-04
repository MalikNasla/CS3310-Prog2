/************************************/
/* Malik Nasla                      */
/* Bronco ID: 016190707             */
/* CS 3310, Fall 2023               */
/* Programming Assignment 2         */
/* Anagram Finder                   */
/************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Arrays;

public class Source{
    public static void main(String[] args) throws FileNotFoundException{
        String fname;
        Map<String, String> map = new HashMap<>();

        Scanner scnr = new Scanner(System.in);

        // Ask for File Name
        System.out.print("Enter File Name: ");
        fname = scnr.next();
        // Store File Name
        Scanner file = new Scanner(new File(fname));

        // Keep looping while the file still has contents in it
        while (file.hasNextLine())
        {
            // Store string into line, convert it to lowercase, sort it by char, and put it into the map
            String line = file.nextLine();
            char[] arr = line.toLowerCase().toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            map.put(line.toLowerCase(), sorted);
        }
        
        // Call equalVal to find anagrams
        equalVal(map);
    }

    /************************************/
    /* Method: equalVal                 */
    /* Purpose: Find and Print Anagrams */
    /*          found in the text file. */
    /* Parameters:                      */
    /* map: the map where all the keys  */
    /*      (words) and values          */
    /*      (sorted by char words) were */
    /*      stored.                     */
    /************************************/
    public static void equalVal(Map<String, String> map) {
        Map<String, Set<String>> map2 = new HashMap<>();

        // Finds all the anagrams
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String value = entry.getValue();
            map2.computeIfAbsent(value, k -> new HashSet<>()).add(entry.getKey());
        }

        // Prints the Anagrams
        for (Map.Entry<String, Set<String>> entry : map2.entrySet()) {
            if (entry.getValue().size() > 1) {
                System.out.println("Anagrmas: " + entry.getValue() + ", Value: " + entry.getKey());
            }
        }
    }
}
