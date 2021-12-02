/*
 * Advent of Code 2015
 * Day 3: Perfectly Spherical Houses in a Vacuum
 * Casey Guarasci
 */

import java.io.*;
import java.util.*;

public class Day3 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("/Users/caseyguarasci/Documents/GitHub/advent-of-code/2015/input-files/Day3_Input.txt"));
        int x=200, y=200, xS=200, yS=200, xRS=200, yRS=200, ptOneAnswer=0, ptTwoAnswer=0, size=1000, coordsOne[][]= new int[size][size], coordsTwo[][]= new int[size][size];
        char input[]=in.nextLine().toCharArray();
        coordsOne[x][y]=1;
        coordsTwo[x][y]=1;

        in.close();

        for (int i=0; i<input.length; i++) {
            if (input[i]=='^') { y++; }
            else if (input[i]=='v') { y--; }
            else if (input[i]=='>') { x++; }
            else if (input[i]=='<') { x--; }
            coordsOne[x][y]=1;

            if ((i%2)==0) {
                if (input[i]=='^') { yS++; }
                else if (input[i]=='v') { yS--; }
                else if (input[i]=='>') { xS++; }
                else if (input[i]=='<') { xS--; }

                coordsTwo[xS][yS]=1;
            }
            else {
                if (input[i]=='^') { yRS++; }
                else if (input[i]=='v') { yRS--; }
                else if (input[i]=='>') { xRS++; }
                else if (input[i]=='<') { xRS--; }

                coordsTwo[xRS][yRS]=1;
             }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (coordsOne[i][j]==1) {
                    ptOneAnswer++;
                }
                if (coordsTwo[i][j]==1) {
                    ptTwoAnswer++;
                }
            }
        }

        System.out.println("Part One Answer: " + ptOneAnswer + "\nPart Two Answer: " + ptTwoAnswer);
    }
}