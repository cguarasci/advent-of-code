/*
 * Advent of Code 2015
 * Day 2: I Was Told There Would Be No Math
 * Casey Guarasci
 */

import java.io.*;
import java.util.*;

public class Day2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input-files/Day2_Input.txt"));
        int length, width, height, max=1000, ptOneAnswer=0, ptTwoAnswer=0;

        for (int i=0; i<max; i++) {
            in.useDelimiter("x");
			length=in.nextInt();
            in.skip("x");
            in.useDelimiter("x");
            width=in.nextInt();
            in.skip("x");
            in.useDelimiter("\n");
            height=in.nextInt();
            if(i!=(max-1)) {
                in.skip("\n");
            }

            ptOneAnswer += ((2*length*width) + (2*width*height) + (2*height*length));
            ptOneAnswer += ((length*width*height) / Math.max(Math.max(length, width), height));

            ptTwoAnswer += ((2*length) + (2*width) + (2*height)) - (2*Math.max(Math.max(length, width), height));
            ptTwoAnswer += (length*width*height);
        }
        
        in.close();

        System.out.println("Part One Answer: " + ptOneAnswer + "\nPart Two Answer: " + ptTwoAnswer);
    }
}