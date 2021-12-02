/*
 * Advent of Code 2020
 * Day 7: Handy Haversacks
 * Casey Guarasci
 */

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class Day7 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input-files/Day7_Input.txt"));
        List<Bag> allBags = new ArrayList<>();

        while (in.hasNextLine()) {
            allBags.add(new Bag(in.nextLine()));
        }

        Set<String> names = new HashSet<>();
        names.add("shiny gold");
        int numOfNames = 0;
        while(names.size() != numOfNames) {
            numOfNames = names.size();
            Set<String> newNames = new HashSet<>();
            for(String name : names) {
                newNames.addAll(getAllBagsThatContains(allBags, name));
            }
            names.addAll(newNames);
        }

        System.out.println("Part One Answer: " + numOfNames);

        for (Bag b : allBags) {
            if (b.name.equals("shiny gold")) {
                System.out.print("Part Two Answer: " + b.containsNumberOfBags(allBags));
                break;
            }
        }

        in.close();
    }

    public static class Bag {
        private String name;
        private Map<String, Integer> contains = new HashMap<>();

        public Bag(String rule) {
            String[] sArr = rule.split(" bags contain ");
            name = sArr[0];
            rule = sArr[1];

            Pattern p = Pattern.compile("(\\d+) (\\w+ \\w+)");

            for (String s : rule.split(",")) {
                s = s.replaceAll("bags*\\.*", "").trim();
                Matcher m = p.matcher(s);
                if (m.find()) {
                    int num = Integer.parseInt(m.group(1));
                    String name = m.group(2);
                    contains.put(name, num);
                }
            }
        }

        public boolean containsBag(String name) {
            return contains.containsKey(name);
        }

        private Bag findBag(List<Bag> allBags, String name) {
            for (Bag b : allBags) {
                if (b.name.equals(name)) {
                    return b;
                }
            }
            return null;
        }

        public long containsNumberOfBags(List<Bag> allBags) {
            long numOfBags = 1;
            for(Map.Entry<String, Integer> bag : contains.entrySet()) {
                Bag foundBag = findBag(allBags, bag.getKey());
                numOfBags += bag.getValue() * foundBag.containsNumberOfBags(allBags);
            }
            return numOfBags;
        }
    }

    public static List<String> getAllBagsThatContains(List<Bag> currentBags, String name) {
        List<String> names = new ArrayList<>();
        for(Bag b : currentBags) {
            if(b.containsBag(name)) {
                names.add(b.name);
            }
        }
        return names;
    }
}