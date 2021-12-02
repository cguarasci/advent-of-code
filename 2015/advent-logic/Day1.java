/*
 * Advent of Code 2015
 * Day 1: Not Quite Lisp
 * Casey Guarasci
 */

import java.io.*;
import java.util.*;

public class Day1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input-files/Day1_Input.txt"));
        int ptOneAnswer=0, ptTwoAnswer=0, count=0;
        char parens[]=in.nextLine().toCharArray();

        for (int i=0; i<parens.length; i++) {
            if (parens[i]=='(') {
                ptOneAnswer++;
            }
            else {
                ptOneAnswer--;
            }

            if (ptOneAnswer<0 && count==0) {
                ptTwoAnswer=(i+1);
                count++;
            }
        }
        
        in.close();

        System.out.println("Part One Answer: " + ptOneAnswer + "\nPart Two Answer: " + ptTwoAnswer);
    }
}