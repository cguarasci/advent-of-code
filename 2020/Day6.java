/*
 * Advent of Code 2020
 * Day 6: Custom Customs
 * Casey Guarasci
 */

import java.util.*;
import java.io.*;

public class Day6 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File ("input-files/Day6_Input.txt"));
		int max=2056, i=0, count=0, ptOneAnswer=0, ptTwoAnswer=0;
		String groups[] = new String[max], individuals[]=new String[max];
		
		in.useDelimiter("\n\n");
		
		while(in.hasNext()) {
			groups[i]=in.next();
			i++;
		}
		
		in.close();
		
		for (i=0; groups[i]!=null; i++) {
			individuals=groups[i].split("\n");
			
			for (int k=97; k<=122; k++) {
				if (groups[i].contains(Character.toString(k))) {
					ptOneAnswer++;
				}
				
				for (int j=0; j<individuals.length; j++) {
					if (individuals[j].contains(Character.toString(k))) {
						count++;
						
						if (count==individuals.length) {
							ptTwoAnswer++;
						}
					}
				}
				
				count=0;
			}
		}
		
		System.out.print("Part One Answer: " + ptOneAnswer + " " + "\nPart Two Answer: " + ptTwoAnswer);
	}
}