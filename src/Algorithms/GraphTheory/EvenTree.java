package Algorithms.GraphTheory;//tree / no cycles

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EvenTree {

    public static Map<Integer, ArrayList<Integer>> tree;
    public static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int v = scanner.nextInt();
        int e = scanner.nextInt();

        tree = new HashMap<>();

        for (int i = 1; i <= v; i++) {
            tree.put(i, new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int child = scanner.nextInt();
            int parent = scanner.nextInt();

            tree.get(parent).add(child);
        }

        for (int i = 1; i <= tree.size(); i++) {
            if ((countChild(i) % 2) != 0) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static int countChild(int node) {
        int totalChild = tree.get(node).size();
        for (int child : tree.get(node)) {
            totalChild += countChild(child);
        }
        return totalChild;
    }
}
