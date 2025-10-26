package Week9.Homework;

public class SortResults {
    private final String algorithm;
    private final boolean sorted;
    private final int swaps;
    private final long comparisons;

    public SortResults(String algorithm, boolean sorted, int swaps, long comparisons) {
        this.algorithm = algorithm;
        this.sorted = sorted;
        this.comparisons = comparisons;
        this.swaps = swaps;
    }

    public String toString() {
        return String.format("%-20s %8b %12d %12d",
                algorithm, sorted, swaps, comparisons);
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public boolean isSorted() {
        return sorted;
    }

    public long getComparisons() {
        return comparisons;
    }

    public int getSwaps() {
        return swaps;
    }
}
