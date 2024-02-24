public class OrderAgnosticBS {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,9,10,54,99};
        int[] arr2 = {99,54,32,26,19,12,9,7,3,1};
        int target = 19;
        System.out.println(binarySearch(arr2,target));
    }
    static int binarySearch(int[] arr,int target) {
        int start = 0;
        int end = arr.length - 1;

        // cheking if arr is asc or in desc
        boolean isAsc = arr[end] > arr[start];
        //System.out.println(isAsc);
        while (start <= end) {
            int mid = start + (end - start) / 2;// TO resolve the problem of limit storing in integer

            if (target == arr[mid]){
                return mid;
            }

            else if (isAsc){
                if (target < arr[mid]) {
                    end = mid - 1;
                    //System.out.println(end);
                } else {
                    start = mid + 1;
                    //System.out.println(start);
                }
            }
            else{
                if (target < arr[mid]) {
                    start = mid + 1;

//                System.out.println(end);
                } else{
                    end = mid - 1;
//                System.out.println(start);
                }
            }

        }
        return -1;
    }
}
