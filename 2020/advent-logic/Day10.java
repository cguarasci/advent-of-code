/*
 * Advent of Code 2020
 * Day 10: Adapter Array
 * Casey Guarasci
 */

import java.util.*;
import java.io.*;

public class Day10 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner (new File ("input-files/Day10_Input.txt"));
		int max=98, i=0, adapters[] = new int[max], oneJoltDiff=0, threeJoltDiff=0, ptOneAnswer;
		
		adapters[i++]=0;
		
		while(in.hasNext()) {
			adapters[i++]=in.nextInt();
		}
		
		in.close();
		
		Arrays.sort(adapters);
		
		for(i=1; i<max; i++) {
			int difference=adapters[i]-adapters[i-1];
			if (difference==1) {
				oneJoltDiff++;
			}
			else if (difference==3) {
				threeJoltDiff++;
			}
		}
		
		threeJoltDiff++;
		
		ptOneAnswer=oneJoltDiff*threeJoltDiff;
		
		System.out.println("Part One Answer: " + ptOneAnswer);
	}
}