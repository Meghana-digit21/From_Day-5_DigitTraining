
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class PerformanceComparison {
    public static void main(String[] args) {
        int dataSize = 1000000;
        HashSet<Integer> hashSet = new HashSet<>();
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        System.out.println("Performance Comparison for Adding Elements:");
        measurePerformance(hashSet, dataSize, "HashSet");
        measurePerformance(linkedHashSet, dataSize, "LinkedHashSet");
        measurePerformance(treeSet, dataSize, "TreeSet");

        System.out.println("\nPerformance Comparison for Removing Elements:");
        measureRemovePerformance(hashSet, dataSize, "HashSet");
        measureRemovePerformance(linkedHashSet, dataSize, "LinkedHashSet");
        measureRemovePerformance(treeSet, dataSize, "TreeSet");

        System.out.println("\nPerformance Comparison for Contains Operation:");
        measureContainsPerformance(hashSet, dataSize, "HashSet");
        measureContainsPerformance(linkedHashSet, dataSize, "LinkedHashSet");
        measureContainsPerformance(treeSet, dataSize, "TreeSet");
    }

    private static void measurePerformance(java.util.Set<Integer> set, int dataSize, String setName) {
        long startTime = System.nanoTime();
        for (int i = 0; i < dataSize; i++) {
            set.add(i);
        }
        long endTime = System.nanoTime();
        System.out.println(setName + " add: " + (endTime - startTime) / 1e6 + " ms");
    }

    private static void measureRemovePerformance(java.util.Set<Integer> set, int dataSize, String setName) {
        for (int i = 0; i < dataSize; i++) {
            set.add(i);
        }
        long startTime = System.nanoTime();
        for (int i = 0; i < dataSize; i++) {
            set.remove(i);
        }
        long endTime = System.nanoTime();
        System.out.println(setName + " remove: " + (endTime - startTime) / 1e6 + " ms");
    }

    private static void measureContainsPerformance(java.util.Set<Integer> set, int dataSize, String setName) {
        // Refill the set for fair comparison
        for (int i = 0; i < dataSize; i++) {
            set.add(i);
        }
        long startTime = System.nanoTime();
        for (int i = 0; i < dataSize; i++) {
            set.contains(i);
        }
        long endTime = System.nanoTime();
        System.out.println(setName + " contains: " + (endTime - startTime) / 1e6 + " ms");
    }
}
