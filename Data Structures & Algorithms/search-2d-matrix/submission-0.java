class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix[0].length;
        int i = 0;
        int j = len * matrix.length - 1;

        while (i <= j) {
            int mid = (i + j) / 2;
            int row = mid / len;
            int col = mid % len;

            int num = matrix[row][col];

            if (num == target) return true;
            else if (num < target) i = mid + 1;
            else j = mid - 1;
        }

        return false;
    }
}
