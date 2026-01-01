class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] state = new int[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int room = queue.poll();
            if (state[room] == 1) {
                continue;
            }
            state[room] = 1;
            for (Integer adjKey : rooms.get(room)) {
                queue.offer(adjKey);
            }
        }
        for (int i = 0; i < state.length; i++) {
            if (state[i] == 0)
                return false;
        }
        return true;

    }

}