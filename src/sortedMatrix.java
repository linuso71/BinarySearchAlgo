import java.util.Arrays;

public class sortedMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(Arrays.toString(searchmatrix(arr,3)));
    }

    static  int[] binarySearch(int[][] arr,int row,int cstart,int cend,int target){

        while(cstart <= cend){
            int cmid = cstart + (cend - cstart)/2;
            if(arr[row][cmid] < target){
                cstart = cmid+1;
            }
            else if(arr[row][cmid] > target){
                cend = cmid-1;
            }
            else{
                return new int[]{row,cmid};
            }
        }
        return new int[]{-1,-1};
    }
    static int[] searchmatrix(int[][] arr,int target){
        int rows = arr.length;
        int cols = arr[0].length;
        if (cols == 0){
            return new int[]{-1,-1};
        }
        if (rows == 1 ){
            return binarySearch(arr,0,0,cols-1,target);
        }
        int rstart = 0;
        int rend = rows - 1;
        int cmid = cols/2;

        // loop to eliminate 2 rows
        while (rstart < (rend-1)){
            int rmid = rstart + (rend - rstart)/2;
            if (arr[rmid][cmid] > target){
                rend = rmid;
            }
            else if (arr[rmid][cmid] < target) {
                rstart = rmid;
            }
            else{
                return new int[]{rmid,cmid};
            }
        }

        // searching middle col
        if(arr[rstart][cmid] == target){
            return new int[]{rstart,cmid};
        }
        if (arr[rstart+1][cmid] == target){
            return new int[] {rstart+1,cmid};
        }

        // searching other cols
        if (target <= arr[rstart][cmid-1]){
            return binarySearch(arr,rstart,0,cmid-1,target);
        }
        if (target >= arr[rstart][cmid+1] && target <= arr[rstart][cols - 1]){
            return binarySearch(arr,rstart,cmid+1,cols-1,target);
        }
        if (target <= arr[rstart+1][cmid-1]) {
            return binarySearch(arr,rstart+1,0,cmid-1,target);
        }

        else{
            return binarySearch(arr,rstart+1,cmid+1,cols-1,target);
        }
    }
}