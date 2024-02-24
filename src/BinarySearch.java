public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,9,10,54,99};
        int target = 7;
        int ans = binarySearch(arr,target);
        System.out.println(ans);
    }
    static int binarySearch(int[] arr,int target){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start + (end - start)/2;// TO resolve the problem of limit storing in integer
            if (target < arr[mid]){
                end = mid -1;
//                System.out.println(end);
            }
            else if (target > arr[mid]){
                start = mid +1;
//                System.out.println(start);
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}
