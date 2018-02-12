import java.util.*;
import java.lang.*;
class MinimumRange {

  public static ArrayList<List<Integer>> findMinimumRanges(ArrayList<List<Integer>> ranges) {
    ArrayList<List<Integer>> minRanges = new ArrayList<>();

    while (ranges.size() > 0) {
      boolean merged = false;
      List<Integer> current = ranges.remove(0);

      for (List<Integer> range : ranges) {
        if (range.get(0) <= current.get(0) && current.get(0) <= range.get(1)) {
          range.set(1, Math.max(current.get(1), range.get(1)));
          merged = true;
          break;
        }
        if (range.get(0) <= current.get(1) && current.get(1) <= range.get(1)) {
          range.set(0, Math.min(current.get(0), range.get(0)));
          merged = true;
          break;
        }
        if (range.get(0) > current.get(0) && current.get(1) > range.get(1)) {
          range.set(0, current.get(0));
          range.set(1, current.get(1));
          merged = true;
          break;
        }
      }
      if (!merged) {
        minRanges.add(current);
      }
    }
    return minRanges;
  }
}
        
