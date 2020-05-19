package sorts;

import java.util.ArrayList;
import java.util.Scanner;

public class InsertSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> objects = new ArrayList<>();
        while (!scanner.hasNext("end")) {
            objects.add(scanner.nextInt());
        }

        System.out.println("Before sort:\n");

        for (int i = 0; i < objects.size(); i++) {
            System.out.print(objects.get(i) + " ");
        }
        System.out.println("\nafter sort:\n");
        Integer[] objects1 = objects.toArray(new Integer[objects.size()]);
        Integer[] ints = insertSort(objects1);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.println("\n");
    }

    public static Integer[]  insertSort(Integer[] a) {
        if (a == null || a.length == 0) {
            return a;
        }

        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            int insertData = a[i];
            while (j >= 0 && a[j] > insertData) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = insertData;
        }

        return a;



    }
}


