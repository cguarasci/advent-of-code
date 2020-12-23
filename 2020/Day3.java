/*
 * Advent of Code 2020
 * Day 3: Toboggan Trajectory
 * Casey Guarasci
 */

import java.util.*;
import java.io.*;

public class Day3 {
	static int rowTotal=323, colTotal=31, rightIncrements[]={1, 3, 5, 7, 1}, downIncrements[]={1, 1, 1, 1, 2};
	static char map[][] = new char[rowTotal][colTotal];

	public static void main(String[] args) throws FileNotFoundException {
		long ptOneAnswer=0, ptTwoAnswer=1;
		
		readFile();
		
		ptOneAnswer=countTrees(rightIncrements[1], downIncrements[1]);

		for (int i=0; i<rightIncrements.length; i++) {
			ptTwoAnswer*=countTrees(rightIncrements[i], downIncrements[i]);
		}
		
		System.out.print("Part One Answer: " + ptOneAnswer + "\nPart Two Answer: " + ptTwoAnswer);
	}
	
	public static void readFile() throws FileNotFoundException {
		Scanner in = new Scanner(new File ("input-files/Day3_Input.txt"));
		
		for (int row=0; row<rowTotal; row++) {
            map[row]=in.nextLine().toCharArray();
		}
		
		in.close();
	}
	
	public static long countTrees(int right, int down) {
		long treeCount=0;
		int row=0, col=0;
		
		for (row=0; row<rowTotal; row+=down) {
			if(map[row][col]=='#') {
				treeCount++;
			}
			
			col=(col+right)%31;
		}
		
		return treeCount;
	}
}