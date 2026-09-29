class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] minors = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                
                if (board[i][j] == '.') continue;
                
                int idx = board[i][j] - '1';
                int bitMask = 1 << idx;
                int min = (i / 3) * 3 + (j / 3);

                if (
                    (rows[i] & bitMask) > 0 ||
                    (cols[j] & bitMask) > 0 ||
                    (minors[min] & bitMask) > 0
                    )
                return false;

                rows[i] = rows[i] | bitMask;
                cols[j] = cols[j] | bitMask;
                minors[min] = minors[min] | bitMask;

            }
        }

        return true;

    }
}
