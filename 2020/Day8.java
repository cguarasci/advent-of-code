/*
 * Advent of Code 2020
 * Day 8: Handheld Halting
 * Casey Guarasci
 */

import java.util.*;
import java.io.*;

public class Day8 {
	static int accumulator=0, max=596, index=0, infiniteFlag=0;
	static Instruction[] instructions = new Instruction[max];

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner (new File ("input-files/Day8_Input.txt"));
		
		for (int i=0; in.hasNextLine(); i++) {
			instructions[i]=new Instruction(in.nextLine());
		}
		
		in.close();
		
		check(instructions[index]);
		
		System.out.println("Part One Answer: " + accumulator);
		
		findCorruption();
		
		System.out.print("Part Two Answer: " + accumulator);
	}
	
	public static void check (Instruction instruction) {
		while (instruction.flag==0 && index<max-1) {
			instruction.flag=1;
			
			if (instruction.operation.matches("acc")) {
				accumulator+=instruction.argument;
				check(instructions[++index]);
			}
			else if (instruction.operation.matches("jmp")) {
				index+=instruction.argument;
				check(instructions[index]);
			}
			else if (instruction.operation.matches("nop")) {
				check(instructions[++index]);
			}
			else {
				System.out.println("One of the instructions you have inputted is invalid. Please only enter valid instructions.");
			}
		}
		
	}
	
	public static void findCorruption(){
        for (int i=0; i<max; i++){
        	for (int j=0; j<max; j++) {
    			instructions[j].flag=0;
    		}
            accumulator=0;
            index=0;
            
            if (instructions[i].operation.matches("nop")){
                instructions[i].operation="jmp";
                check(instructions[index]);
                if (instructions[index].flag==0) {
                	break;
                }
                instructions[i].operation="nop";
            }
            else if (instructions[i].operation.matches("jmp")){
            	instructions[i].operation="nop";
            	check(instructions[index]);
                if (instructions[index].flag==0) {
                	break;
                }
                instructions[i].operation="jmp";
            }
        }
    }
	
	public static class Instruction {
		int flag, argument;
		String operation;
		
		Instruction(String line) {
			this.flag=0;
			this.operation=line.substring(0, 3);
			this.argument=Integer.parseInt(line.substring(4));
		}
	}
}