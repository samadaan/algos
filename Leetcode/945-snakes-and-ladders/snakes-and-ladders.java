class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.print(board[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // return -1;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.add(1);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int num = queue.poll();
                if (set.contains(num)) {
                    continue;
                }
                set.add(num);
                if (num == n * n) {
                    return count;
                }
                for (int i = num + 1; i <=Math.min(num + 6, n * n); i++) {
                    int xCord = findX(i, n);
                    int yCord = findY(i, n);
                    // System.out
                    //         .println("i " + i + " xCord " + xCord + " yCord " + yCord + " val " + board[xCord][yCord]);
                    if (board[xCord][yCord] != -1) {
                        queue.add(board[xCord][yCord]);
                    } else {
                        queue.add(i);
                    }
                }
            }
            count++;
        }
        return -1;
    }

    private int findX(int num, int n) {
        int fromEnd = num / n;
        if (num % n == 0)
            fromEnd--;
        return n - fromEnd - 1;
    }

    private int findY(int num, int n) {
        int div = num / n;

        int rem = num % n;
        if(rem==0)div--;
        if (div % 2 == 0) {
            if (rem == 0) {
                return n - 1;
            }
            return rem - 1;
        }
        if (rem == 0) {
            return rem;
        }
        return n - rem;
    }

}