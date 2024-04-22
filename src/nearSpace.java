public class nearSpace {

    public static void main(String[] args) {

    }


    public int solution(String[][] board, int h, int w) {
        int boardLength = board.length;
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};
        int count = 0;
        for (int nearSpace = 0; nearSpace < 4; nearSpace++) {
            int h_check = h + dh[nearSpace];
            int w_check = w + dw[nearSpace];

            if (h_check >= 0 && h_check < boardLength
                && w_check >= 0 && w_check < boardLength) {
                if (board[h][w].equals(board[h_check][w_check])) {
                    count++;
                }
            }
        }

        return count;
    }
}
