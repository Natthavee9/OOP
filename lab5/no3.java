import java.util.*;


class SortMergeList {
      public ArrayList<Integer> intersect(ArrayList<Integer> list1, ArrayList<Integer> list2) {
            ArrayList<Integer> result = new ArrayList<>();
            int i = 0;
            int j = 0;

            while (i < list1.size() && j < list2.size()) {
                  int val1 = list1.get(i);
                  int val2 = list2.get(j);

                  if (val1 == val2) {
                        result.add(val1);
                        i++;
                        j++;
                  } else if (val1 < val2) {
                        i++;
                  } else {
                        j++;
                  }
            }
            return result;
      }  
}

public class no3 {
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            ArrayList<Integer> list1 = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();

            input_ArrayList(list1, sc);

            input_ArrayList(list1, sc);

            SortMergeList sorter = new SortMergeList();
            ArrayList<Integer> intersection = sorter.intersect(list1, list2);

            for (int num : intersection) {
                  System.out.print(num + " ");
            }
            System.out.println();

            sc.close();
      }
      
      public static void input_ArrayList(ArrayList<Integer> a, Scanner sc) {
            while (sc.hasNextInt()) {
                  int num = sc.nextInt();
                  if (num == 0)
                        break;
                  a.add(num);
            }
      }
}