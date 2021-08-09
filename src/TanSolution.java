import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TanSolution {

    public static void main(String[] args) {
        /*
        Strategy:
          Index through the list
          At each index, count the number of ints that are of lesser index and lesser value. *subCount*
          Then subCount(i) += subCount at each index of lesser index and value
          Add this count to the ArrayList

        */

        //int[] myList = {1, 7, 3, 5, 2, 8, 10, 24, -1, -5, 4};
        //List<Integer> myList = new ArrayList<>(Arrays.asList(3,2,4,5,4));
        int[] myList = {-1,-2,-3,1,2};

        ArrayList<Integer> subArray = new ArrayList<Integer>();
        int result = 1;
        int index = 1;
        subArray.add(1);

        while(index < myList.length) {
            int subCount = 1;
            for (int i = index-1; i >= 0; i--) {
                if (myList[i] < myList[index]) {
                    subCount += subArray.get(i);
                }
            }
            subArray.add(subCount);
            result += subCount;
            index += 1;
        }
        for(int item:subArray){
            System.out.println(item);
        }
        System.out.println("Total = " + result);
    }
}
