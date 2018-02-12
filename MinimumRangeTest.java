import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumRangeTest {

    @Test
    public void testNoMerges() {
        ArrayList<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(1, 2));
        input.add(Arrays.asList(3, 4));
        input.add(Arrays.asList(5, 6));

        ArrayList<List<Integer>> r = new ArrayList<>();
        r.add(Arrays.asList(1, 2));
        r.add(Arrays.asList(3, 4));
        r.add(Arrays.asList(5, 6));

        assertEquals(r, MinimumRange.findMinimumRanges(input));
    }

    @Test
    public void testDuplicates() {
        ArrayList<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(1, 1));
        input.add(Arrays.asList(2, 2));
        input.add(Arrays.asList(1, 1));
        input.add(Arrays.asList(2, 2));
        input.add(Arrays.asList(2, 2));
        input.add(Arrays.asList(2, 2));

        ArrayList<List<Integer>> r = new ArrayList<>();
        r.add(Arrays.asList(1, 1));
        r.add(Arrays.asList(2, 2));

        assertEquals(r, MinimumRange.findMinimumRanges(input));
    }

    @Test
    public void testDuplicatesMerged() {
        ArrayList<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(1, 4));
        input.add(Arrays.asList(3, 7));
        input.add(Arrays.asList(1, 7));
        input.add(Arrays.asList(99, 99));

        ArrayList<List<Integer>> r = new ArrayList<>();
        r.add(Arrays.asList(1, 7));
        r.add(Arrays.asList(99, 99));

        assertEquals(r, MinimumRange.findMinimumRanges(input));
    }

    @Test
    public void testSingleMergeFirst() {
        ArrayList<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(1, 3));
        input.add(Arrays.asList(3, 4));
        input.add(Arrays.asList(5, 6));

        ArrayList<List<Integer>> r = new ArrayList<>();
        r.add(Arrays.asList(1, 4));
        r.add(Arrays.asList(5, 6));

        assertEquals(r, MinimumRange.findMinimumRanges(input));
    }

    @Test
    public void testSingleMergeLast() {
        ArrayList<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(1, 2));
        input.add(Arrays.asList(3, 4));
        input.add(Arrays.asList(4, 6));

        ArrayList<List<Integer>> r = new ArrayList<>();
        r.add(Arrays.asList(1, 2));
        r.add(Arrays.asList(3, 6));

        assertEquals(r, MinimumRange.findMinimumRanges(input));
    }

    @Test
    public void testFullMerge() {
        ArrayList<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(99, 888));
        input.add(Arrays.asList(444, 555));
        input.add(Arrays.asList(101, 101));

        ArrayList<List<Integer>> r = new ArrayList<>();
        r.add(Arrays.asList(99, 888));

        assertEquals(r, MinimumRange.findMinimumRanges(input));
    }
}