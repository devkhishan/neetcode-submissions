class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int t=0, b=matrix.length-1,l=0, r=matrix[0].length-1;

        while (t<=b) {
            int v_mid = t + (b-t)/2;
            if (target < matrix[v_mid][l]) b = v_mid-1;
            else if (target > matrix[v_mid][r]) t = v_mid+1;
            else {
                while (l<=r) {
                    int h_mid = l + (r-l)/2;
                    if (matrix[v_mid][h_mid] < target) l = h_mid+1;
                    else if (matrix[v_mid][h_mid] > target) r = h_mid-1;
                    else return true;
                }
                return false;
            }
        }
        return false;
    }
}
