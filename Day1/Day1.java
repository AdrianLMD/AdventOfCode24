package Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day1 {

    public static ArrayList<String> leftList = new ArrayList<String>();
    public static ArrayList<String> rightList = new ArrayList<String>();

    public static void main(String[] args) {

        String filePath = "Day1Table.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                manageLists(line);
            }
            if (rightList.size() > 0) {
                System.out.println(rightList.get(rightList.size() - 1));
                // System.out.println(sortList(rightList));
            }

        } catch (IOException e) {
            System.err.println("Fehler beim Lesen der Datei: " + e.getMessage());
        }

        System.out.println(diff(sortList(leftList), sortList(rightList)));
        System.out.println(Integer.valueOf("41255"));

    }

    public static int diff(int[] left, int[] right) {
        int difference = 0;
        for (int i = 0; i < left.length; i++) {
            if (left[i] > right[i]) {
                difference += left[i] - right[i];
            } else {
                difference += right[i] - left[i];
            }
        }

        return difference;
    }

    public static int[] sortList(ArrayList<String> list) {
        int[] sortedList = new int[list.size()];
        for (int j = 0; j < list.size(); j++) {
            for (int i = 0; i < list.size() - 1; i++) {
                if (Integer.valueOf(list.get(i)) > Integer.valueOf(list.get(i + 1))) {
                    sortedList[i] = Integer.valueOf(list.get(i));
                } else {
                    sortedList[i] = Integer.valueOf(list.get(i + 1));
                }
            }
        }

        return sortedList;

    }

    public static void manageLists(String line) {
        // System.out.println("test before if");
        for (int i = 0; i < line.length(); i++) {
            // System.out.println(line.substring(i, i));
            if (line.substring(i, i + 1).equals("#")) {
                appendLeft(line.substring(0, i));
                // System.out.println("test");
                appendRight(line.substring(i + 1, line.length()));
                break;
            }

        }
    }

    public static void appendLeft(String element) {
        leftList.add(element);
    }

    public static void appendRight(String element) {
        rightList.add(element);
    }

}