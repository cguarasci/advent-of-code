/*
 * Advent of Code 2020
 * Day 2: Password Philosophy
 * Casey Guarasci
 */

import java.util.*;
import java.io.*;

public class Day2 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("input-files/Day2_Input.txt"));
		int max=1000, lowBound, highBound, count=0, ptOneAnswer=0, ptTwoAnswer=0;
		String letter, password;
		
		for (int i=0; i<max; i++) {
			in.useDelimiter("-");
			lowBound = in.nextInt();
			in.skip("-");
			in.useDelimiter(" ");
			highBound = in.nextInt();
			in.useDelimiter(":");
			in.skip(" ");
			letter = in.next();
			in.useDelimiter("\n");
			in.skip(": ");
			password = in.nextLine();
			
			count=0;

			for (int j=0; j<password.length(); j++) {
				if (password.charAt(j)==letter.charAt(0)) {
					count++;
				}
			}

			if (count<=highBound && count>=lowBound) {
				ptOneAnswer++;
			}

			if (password.charAt(lowBound-1) == letter.charAt(0) ^ password.charAt(highBound-1) == letter.charAt(0)) {
				ptTwoAnswer++;
		    }
		}
		
		System.out.print("Part One Answer: " + ptOneAnswer + "\nPart Two Answer: " + ptTwoAnswer);
		
		in.close();
	}
}