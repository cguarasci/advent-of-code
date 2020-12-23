/*
 * Advent of Code 2020
 * Day 4: Passport Processing
 * Casey Guarasci
 */

import java.util.*;
import java.io.*;

public class Day4 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("input-files/Day4_Input.txt"));
		int i=0, j=0, tempInt, flag=0, ptOneAnswer=0, ptTwoAnswer=0, max=957;
		String passports[] = new String[max], passport[] = new String[50];
		
		in.useDelimiter("\n\n");
		
		while(in.hasNext()) {
			passports[i]=in.next();
			i++;
		}
		
		for (i=0; passports[i]!=null; i++) {
			if (passports[i].contains("byr") && passports[i].contains("iyr") && passports[i].contains("eyr") && passports[i].contains("hgt") && passports[i].contains("hcl") && passports[i].contains("ecl") && passports[i].contains("pid")) {
				ptOneAnswer++;
				
				passport = passports[i].split("[: \n]+");
				
				for (j=0; j<passport.length; j+=2) {
					if(passport[j].contains("byr")) {
						if(passport[j+1].length()<4 || passport[j+1].length()>4) {
							flag++;
						}
						
						tempInt=Integer.parseInt(passport[j+1]);
						
						if(tempInt<1920 || tempInt>2002) {
							flag++;
						}
					}
					else if(passport[j].contains("iyr")) {
						if(passport[j+1].length()<4) {
							flag++;
						}
						
						tempInt=Integer.parseInt(passport[j+1]);
						
						if(tempInt<2010 || tempInt>2020) {
							flag++;
						}
					}
					else if(passport[j].contains("eyr")) {
						if(passport[j+1].length()<4) {
							flag++;
						}
						
						tempInt=Integer.parseInt(passport[j+1]);
						
						if(tempInt<2020 || tempInt>2030) {
							flag++;
						}
					}
					else if(passport[j].contains("hgt")) {
						if(passport[j+1].contains("cm")) {
							tempInt=Integer.parseInt(passport[j+1].substring(0, passport[j+1].length() - 2));
							
							if (tempInt<150 || tempInt>193) {
								flag++;
							}
						}
						else if(passport[j+1].contains("in")) {
							tempInt=Integer.parseInt(passport[j+1].substring(0, passport[j+1].length() - 2));
							
							if (tempInt<59 || tempInt>76) {
								flag++;
							}
						}
						else {
							flag++;
						}
					}
					else if(passport[j].contains("hcl")) {
						if (passport[j+1].charAt(0)!=35) {
							flag++;
						}
						if (passport[j+1].length()==7) {
							for (int k=1; k<7; k++) {
								if (passport[j+1].charAt(k)>=48 && passport[j+1].charAt(k)<=57) {
								}
								else if (passport[j+1].charAt(k)>=97 && passport[j+1].charAt(k)<=122) {
								}
								else {
									flag++;
								}
							}
						}
						else {
							flag++;
						}
					}
					else if(passport[j].contains("ecl")) {
						if(passport[j+1].contains("amb") || passport[j+1].contains("blu") || passport[j+1].contains("brn") || passport[j+1].contains("gry") || passport[j+1].contains("grn") || passport[j+1].contains("hzl") || passport[j+1].contains("oth")) {
						}
						else {
							flag++;
						}
					}
					else if(passport[j].contains("pid")) {
						if (passport[j+1].length()==9) {
							for (int k=0; k<9; k++) {
								if (passport[j+1].charAt(k)<48 || passport[j+1].charAt(k)>57) {
									flag++;
								}
							}
						}
						else {
							flag++;
						}
					}
				}
				
				if(flag==0) {
					ptTwoAnswer++;
				}
				else {
					flag=0;
				}
			}
		}
		
		System.out.print("Part One Answer: " + ptOneAnswer + "\nPart Two Answer: " + ptTwoAnswer);
		
		in.close();
	}
}