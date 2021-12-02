/*
 * Advent of Code 2020
 * Day 5: Binary Boarding
 * Casey Guarasci
 */

import java.util.*;
import java.io.*;

public class Day5 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File ("input-files/Day5_Input.txt"));
		int max=940, answer=0;
		BoardingPass[] boardingPasses = new BoardingPass[max];
		
		for (int i=0; i<max; i++) {
			boardingPasses[i] = new BoardingPass(in.nextLine());
		}
		
		Arrays.sort(boardingPasses);
		
		for (int i=boardingPasses[max-1].seatID; i<=boardingPasses[0].seatID; i++) {
			answer+=i;
		}
		
		for (int i=0; i<max; i++) {
			answer-=boardingPasses[i].seatID;
		}
		
		System.out.println("Part One Answer: " + boardingPasses[0].seatID + "\nPart Two Answer: " + answer);
		
		in.close();
	}
	
	public static class BoardingPass implements Comparable<BoardingPass>{
    	int row, col, seatID;
        
        BoardingPass (String pass) {
        	int row=0, col=0, low=0, high=127;
        	
        	for (int i=0; i<10; i++) {
        		if (pass.charAt(i)=='F' || pass.charAt(i)=='L') {
        			high=high - ((high-low)/2)-1;
        		}
        		else {
        			low=low+((high-low)/2)+1;
        		}
        		if (i==6) {
        			row=low;
        			low=0;
        			high=7;
        		}
        	}
        	
        	col = high;
        	
        	this.row = row;
        	this.col = col;
        	this.seatID = (row * 8) + col;
        }
        
        public int compareTo(BoardingPass e) {
            return Long.compare(e.seatID, seatID);
        }
    }
}
