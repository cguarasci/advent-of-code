/*
 * Advent of Code 2020
 * Day 1: Report Repair
 * Casey Guarasci
 */

import java.io.*;
import java.util.*;

public class Day1 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("input-files/Day1_Input.txt"));
		int array[], max=200, ptOneAnswer=0, ptTwoAnswer=0;
		array=new int[max];
		
		for (int i=0; i<max; i++) {
			array[i]=in.nextInt();
		}
		
		in.close();
		
		Arrays.sort(array);
		
		for (int i=0; i<max; i++) {
			for (int j=i+1; j<max; j++) {
				if (array[i]+array[j]==2020) {
					ptOneAnswer=array[i]*array[j];
				}

				for (int k=j+1; k<max; k++) {
					if ((array[i]+array[j]+array[k])==2020) {
						ptTwoAnswer=array[i]*array[j]*array[k];
					}
				}
			}
		}

		System.out.print("Part One Answer: " + ptOneAnswer + "\nPart Two Answer: " + ptTwoAnswer);
	}
}