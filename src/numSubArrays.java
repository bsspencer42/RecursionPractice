public class numSubArrays {
    public static void main(String[] args) {
        int[] myArr = {1,2,3};
        System.out.println("Num Subarrays = " + subArrays(myArr));
    }
    public static int subArrays(int[] myArr){
        if (myArr.length == 1){
            return 1;
        }

        // Print subarrays
        int sumCount = 1;
       for (int i=1;i < myArr.length;i++){
           if (myArr[i] < myArr[0]){
               continue;
           }
           int count = 0;
           int previous = myArr[0];
           for (int y=i;y < myArr.length;y++){
               if (y == i){
               System.out.print(previous);
               System.out.print(" ");
               }
               if (myArr[y] > previous){
                   count++;
                   previous = myArr[y];
                   System.out.print(myArr[y]);
                   System.out.print(" ");
               }
           }
           System.out.println("");
           sumCount+= Math.pow(2,count-1);
           System.out.println("Sumcount=" + sumCount + ", Count=" + count);
       }
       // Get next sub-array to send recursively
       int[] nextArr = new int[myArr.length-1];
       for (int i = 1;i < myArr.length;i++){
           nextArr[i-1] = myArr[i];
       }
       return sumCount + subArrays(nextArr);
    }
}
