import java.util.Arrays;

public class Binary2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                {10,20,30,40},
                {15,25,35,45},
                {28,29,37,49},
                {33,34,38,50}
        };
        System.out.println(Arrays.toString(search2(arr,50)));
    }
    static int[] search(int[][] arr,int target){
        int r = 0;
        int c = arr.length -1;
        while (r<arr.length && c>=0){
            if (arr[r][c] > target){
                c--;
            }
            else if (arr[r][c] < target) {
                r++;
            }
            else{
                //System.out.println(row + " " + col);
                return new int[]{r,c};
            }
        }
        //System.out.println(result);
        return new int[]{-1,-1};
    }

    static int[] search2(int[][] arr,int target){
        for(int r = 0;r<arr.length;r++){
            for(int c = arr.length-1;c>=0;c--){
                if (arr[r][c] > target){
                    continue;
                }
                else if (arr[r][c] < target){
                    break;
                }
                else{
                    return new int[]{r,c};
                }
            }
        }
        return new int[]{-1,-1};
    }

}
