package Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day1 {

    public static ArrayList<Integer> leftList = new ArrayList<Integer>();
    public static ArrayList<Integer> rightList = new ArrayList<Integer>();

    public static void main(String[] args) {

        String filePath = "Day1/Day1Table.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                manageLists(line);
            }

        } catch (IOException e) {
            System.err.println("Fehler beim Lesen der Datei: " + e.getMessage());
        }
        leftList.sort(Integer::compare);
        rightList.sort(Integer::compare);
        System.out.println(diffList(leftList, rightList));

    }

    public static int diffList(ArrayList<Integer> left, ArrayList<Integer> right) {

        int difference = 0;
        for (int i = 0; i < left.size(); i++) {
            difference += Math.abs(left.get(i) - right.get(i));
        }
        return difference;
    }

    public static void manageLists(String line) {
        for (int i = 0; i < line.length(); i++) {
            // if # gets detected, splits String and puts int value in ArrayList
            if (line.substring(i, i + 1).equals("#")) {
                leftList.add(Integer.valueOf(line.substring(0, i)));
                rightList.add(Integer.valueOf(line.substring(i + 1, line.length())));
                break;
            }

        }
    }

}