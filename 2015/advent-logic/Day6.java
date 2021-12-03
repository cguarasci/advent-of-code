/*
 * Advent of Code 2015
 * Day 6: Probably a Fire Hazard
 * Casey Guarasci
 */

import java.io.*;
import java.util.*;

public class Day6 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input-files/Day6_Input.txt"));
        int inputMax=300, gridMax=1000, ptOneAnswer=0, ptTwoAnswer=0, x1, x2, y1, y2, gridPtTwo[][] = new int [gridMax][gridMax];
        boolean gridPtOne[][] = new boolean [gridMax][gridMax];
        String instruction;

        for (int row=0; row<gridMax; row++) {
            for (int col=0; col<gridMax; col++) {
                gridPtTwo[row][col]=0;
            }
        }

        for (int i=0; i<inputMax; i++) {
            in.useDelimiter(" ");
            instruction=in.next();
            if (instruction.equals("turn")) {
                instruction=in.next();
            }
            in.skip(" ");
            in.useDelimiter(",");
            x1=Integer.valueOf(in.next());
            in.skip(",");
            in.useDelimiter(" ");
            y1=Integer.valueOf(in.next());
            in.skip(" through ");
            in.useDelimiter(",");
            x2=Integer.valueOf(in.next());
            in.skip(",");
            in.useDelimiter("\n");
            y2=Integer.valueOf(in.next());
            if(i!=(inputMax-1)) {
                in.skip("\n");
            }
            
            for (int row=x1; row<=x2; row++) {
                for (int col=y1; col<=y2; col++) {
                    if (instruction.equals("on")) {
                        gridPtOne[row][col] = true;
                        gridPtTwo[row][col]++;
                    }
                    if (instruction.equals("off")) {
                        gridPtOne[row][col] = false;
                        if(gridPtTwo[row][col]>=1) {
                            gridPtTwo[row][col]--;
                        }
                    }
                    if (instruction.equals("toggle")) {
                        gridPtOne[row][col] = !gridPtOne[row][col];
                        gridPtTwo[row][col]+=2;
                    }
                }
            }
        }
        
        in.close();

        for (int row=0; row<gridMax; row++) {
            for (int col=0; col<gridMax; col++) {
                if (gridPtOne[row][col]) {
                    ptOneAnswer++;
                }
                ptTwoAnswer+=gridPtTwo[row][col];
            }
        }

        System.out.println("Part One Answer: " + ptOneAnswer + "\nPart Two Answer: " + ptTwoAnswer);
    }
}