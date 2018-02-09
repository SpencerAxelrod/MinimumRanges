import java.util.*;
import java.lang.*;
class MinimumRange {
  public static void main(String args[]) {
    ArrayList<List<Integer>> r = new ArrayList<List<Integer>>();
    r.add(Arrays.asList(1, 3));
    r.add(Arrays.asList(3, 4));
    r.add(Arrays.asList(5, 6));
    System.out.println(findMinimumRanges(r));
  }
  
  public static ArrayList<List<Integer>> findMinimumRanges(ArrayList<List<Integer>> ranges) {
    ArrayList<List<Integer>> minRanges = new ArrayList<List<Integer>>();
    while (ranges.size() > 0) {
      boolean merged = false;
      List<Integer> current = ranges.remove(0);
      for (int i=0; i < ranges.size(); i++) {
        if (ranges.get(i).get(0) <= current.get(0) && current.get(0) <= ranges.get(i).get(1)) {
          ranges.get(i).set(1, Math.max(current.get(1), ranges.get(i).get(1)));
          merged = true;
          break;
        }
        if (ranges.get(i).get(0) <= current.get(1) && current.get(1) <= ranges.get(i).get(1)) {
          ranges.get(i).set(0, Math.min(current.get(0), ranges.get(i).get(0)));
          merged = true;
          break;
        }
        if (ranges.get(i).get(0) > current.get(0) && current.get(1) > ranges.get(i).get(1)) {
          ranges.get(i).set(0, current.get(0));
          ranges.get(i).set(1, current.get(1));
          merged = true;
          break;
        }
      }
      if (!merged) {
        minRanges.add(current);
      }
      merged = false;
    }
    return minRanges;
  }
}
        
