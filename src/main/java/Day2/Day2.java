package Day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day2 {
    public static void main(String[] args) {

        String filePath = "./inputs/Day2Table.txt";
        int safeCounter = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (isSafe(arr2List(splitString(line)))) {
                    safeCounter++;
                }
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Lesen der Datei: " + e.getMessage());
        }
        System.out.println(safeCounter);
    }

    public static Boolean decrease(ArrayList<Integer> line) {
        for (int i = 0; i < line.size() - 1; i++) {
            if (line.get(i) > line.get(i + 1)) {
                return false;
            } else if (line.get(i) == line.get(i + 1)) {
                return false;
            } else if (Math.abs(line.get(i) - line.get(i + 1)) > 3) {
                return false;
            }
        }
        return true;
    }

    public static Boolean increase(ArrayList<Integer> line) {
        for (int i = 0; i < line.size() - 1; i++) {
            if (line.get(i) < line.get(i + 1)) {
                return false;
            } else if (line.get(i) == line.get(i + 1)) {
                return false;
            } else if (Math.abs(line.get(i) - line.get(i + 1)) > 3) {
                return false;
            }
        }
        return true;
    }

    public static ArrayList<Integer> arr2List(String[] arr) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (String s : arr) {
            list.add(Integer.valueOf(s));
        }
        // System.out.println(list);
        return list;
    }

    public static Boolean isSafe(ArrayList<Integer> list) {
        if (increase(list) || decrease(list)) {
            return true;
        } else {
            return false;
        }
    }

    public static String[] splitString(String line) {
        String[] result = line.split(" ");
        return result;
    }
}