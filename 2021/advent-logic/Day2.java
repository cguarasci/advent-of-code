/*
 * Advent of Code 2021
 * Day 2: Dive!
 * Casey Guarasci
 */

import java.io.*;
import java.util.*;

public class Day2 {
	public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input-files/Day2_Input.txt"));
        int max=1000, value=0, horizontal=0, depth=0, ptTwoAnswer=0, aim=0;
        var ptOneAnswer=0;
        String direction;

		for (int i=0; i<max; i++) {
            in.useDelimiter(" ");
			direction=in.next();
            in.skip(" ");
            in.useDelimiter("\n");
            value=in.nextInt();
            if(i!=(max-1)) {
                in.skip("\n");
            }
            
            if (direction.contentEquals("forward")) {
                horizontal+=value;
                ptTwoAnswer+=(aim*value);
            }
            else if (direction.contentEquals("down")) {
                depth+=value;
                aim+=value;
            }
            else {
                depth-=value;
                aim-=value;
            }
		}
		
		in.close();

        ptOneAnswer=horizontal*depth;
        ptTwoAnswer=horizontal*ptTwoAnswer;

        System.out.println("Part One Answer: " + ptOneAnswer + "\nPart Two Answer: " + ptTwoAnswer);
    }
}