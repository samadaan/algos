class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ans.add(new ArrayList<>());
        }
        ans.get(0).add(1);
        if (numRows == 1)
            return ans;
        for (int i = 1; i < numRows; i++) {
            for (int j = 0; j < i + 1; j++) {
                int x = j;
                int y = j - 1;
                List<Integer> prevRow = ans.get(i - 1);
                List<Integer> currRow = ans.get(i);
                int val = 0;
                if (x >= 0 && x < prevRow.size()) {
                    val += prevRow.get(x);
                }
                if (y >= 0 && y < prevRow.size()) {
                    val += prevRow.get(y);
                }
                currRow.add(val);
            }
        }
        return ans;
    }
}