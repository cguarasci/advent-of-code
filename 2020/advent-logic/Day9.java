/*
 * Advent of Code 2020
 * Day 9: Encoding Error
 * Casey Guarasci
 */

import java.util.*;
import java.io.*;
import java.text.*;

public class Day9 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner (new File ("input-files/Day9_Input.txt"));
		DecimalFormat df = new DecimalFormat("#");
		int max=1000, range=25, i=0, fineCheck=0;
		double sum=0, numbers[] = new double[max], ptOneAnswer=0, ptTwoAnswer=0;
		
		while(in.hasNext()) {
			numbers[i++]=in.nextDouble();
		}
		
		for (i=range; i<max; i++) {
			fineCheck=0;
			
			for (int j=i-range; j<i; j++) {
				for (int k=j+1; k<i; k++) {
					sum=numbers[j]+numbers[k];
					if(sum==numbers[i]) {
						fineCheck=1;
					}
				}
			}
			
			ptOneAnswer=numbers[i];
			
			if(fineCheck==0) {
				System.out.println("Part One Answer: " + df.format(ptOneAnswer));
				break;
			}
		}
		
		for (i=0; fineCheck==0; i++) {
			sum=numbers[i];
			double lowest=numbers[i];
			double highest=numbers[i];
			
			for (int j=i+1; sum<ptOneAnswer; j++) {
				sum+=numbers[j];
				
				if(numbers[j]<lowest) {
					lowest=numbers[j];
				}
				
				if (numbers[j]>highest) {
					highest=numbers[j];
				}
				
				if (sum==ptOneAnswer) {
					ptTwoAnswer=lowest+highest;
					System.out.println("Part Two Answer: " + df.format(ptTwoAnswer));
					fineCheck=1;
					break;
				}
			}
		}
		
		in.close();
	}
}
