import java.util.*;

class Solution {
    class DSU {
        int[] parent;
        public DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        public int find(int i) {
            if (parent[i] == i) return i;
            return parent[i] = find(parent[i]);
        }
        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) parent[rootI] = rootJ;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DSU dsu = new DSU(accounts.size());
        Map<String, Integer> emailToAcc = new HashMap<>();

        // 1. Build the DSU by mapping emails to account IDs
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (!emailToAcc.containsKey(email)) {
                    emailToAcc.put(email, i);
                } else {
                    // If we've seen this email before, merge current account with previous owner
                    dsu.union(i, emailToAcc.get(email));
                }
            }
        }

        // 2. Group emails by their root parent (representative account ID)
        Map<Integer, List<String>> merged = new HashMap<>();
        for (String email : emailToAcc.keySet()) {
            int root = dsu.find(emailToAcc.get(email));
            merged.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        // 3. Format the final result
        List<List<String>> result = new ArrayList<>();
        for (int root : merged.keySet()) {
            List<String> emails = merged.get(root);
            Collections.sort(emails);
            // Get the name from the original account list using the root ID
            emails.add(0, accounts.get(root).get(0));
            result.add(emails);
        }

        return result;
    }
}