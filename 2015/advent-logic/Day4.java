/*
 * Advent of Code 2015
 * Day 4: The Ideal Stocking Stuffer
 * Casey Guarasci
 */

import java.io.*;
import java.security.*;
import java.util.*;

public class Day4 {
    public static void main(String[] args) throws FileNotFoundException, NoSuchAlgorithmException {
        Scanner in = new Scanner(new File("input-files/Day4_Input.txt"));
        int count=0, flag=0, ptOneAnswer=0, ptTwoAnswer=0;
        String key=in.nextLine(), hash=getMD5(key), keyInc;

        in.close();

        while (!hash.substring(0,6).equals("000000")) {
            keyInc = key.concat(String.valueOf(count));
            hash = getMD5(keyInc);
            if (hash.substring(0,5).equals("00000") && flag==0) {
                ptOneAnswer=count;
                flag++;
            }
            count++;
        }

        ptTwoAnswer=count-1;

        System.out.println("Part One Answer: " + ptOneAnswer + "\nPart Two Answer: " + ptTwoAnswer);
    }

    public static String getMD5(String key) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(key.getBytes());
		byte[] digest = md.digest();
		StringBuffer sb = new StringBuffer();
		for (byte e : digest) {
			sb.append(String.format("%02x", e & 0xff));
		}

        return sb.toString();
    }
}