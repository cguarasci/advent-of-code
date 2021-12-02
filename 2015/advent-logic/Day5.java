/*
 * Advent of Code 2015
 * Day 5: Doesn't He Have Intern-Elves For This?
 * Casey Guarasci
 */

import java.io.*;
import java.util.*;

public class Day5 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input-files/Day5_Input.txt"));
        int vowels=0, max=1000, ptOneAnswer=0, ptTwoAnswer=0;
        boolean repeats=false, contains=false, pairs=false, sandwich=false;
        String string;

        for (int i=0; i<max; i++) {
            string=in.nextLine();

            for (int j=0; j<16; j++) {
                //Count vowels
                if (string.charAt(j)=='a' || string.charAt(j)=='e' || string.charAt(j)=='i' || string.charAt(j)=='o' || string.charAt(j)=='u') {
                    vowels++;
                }
                //Check for repeating letters
                if (j>0) {
                    if (string.charAt(j)==string.charAt(j-1)) {
                        repeats=true;
                    }
                }
                //Check for set of strings
                if (string.contains("ab") || string.contains("cd") || string.contains("pq") || string.contains("xy")) {
                    contains=true;
                }
                //Check for pairs
                if (j>=3) {
                    if (string.substring(0, j-1).contains(string.substring(j-1, j+1))) {
                        pairs=true;
                    }
                }
                //Check for letter sandwich
                if (j>=2) {
                    if (string.charAt(j)==string.charAt(j-2)) {
                        sandwich=true;
                    }
                }
            }

            if ((vowels>=3) && (repeats==true) && (contains==false)) {
                ptOneAnswer++;
            }

            if ((pairs==true) && (sandwich==true)) {
                ptTwoAnswer++;
            }

            //Reset values
            vowels=0;
            repeats=false;
            contains=false;
            pairs=false;
            sandwich=false;
        }
        
        in.close();

        System.out.println("Part One Answer: " + ptOneAnswer + "\nPart Two Answer: " + ptTwoAnswer);
    }
}