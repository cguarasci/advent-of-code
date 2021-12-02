/*
 * Advent of Code 2021
 * Day 1: Sonar Sweep
 * Casey Guarasci
 */

import java.io.*;
import java.util.*;

public class Day1 {
	public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input-files/Day1_Input.txt"));
        int array[], max=2000, ptOneAnswer=0, ptTwoAnswer=0;
		array=new int[max];
		array[0]=in.nextInt();

		for (int i=1; i<max; i++) {
			array[i]=in.nextInt();

            if (array[i]>array[i-1]) {
                ptOneAnswer++;
            }

            if (i>=3) {
                if ((array[i-1]+array[i-2]+array[i-3])<(array[i]+array[i-1]+array[i-2])) {
                    ptTwoAnswer++;
                }
            }
		}
		
		in.close();

        System.out.println("Part One Answer: " + ptOneAnswer + "\nPart Two Answer: " + ptTwoAnswer);
    }
}
