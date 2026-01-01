class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        
        beginSet.add(beginWord);
        endSet.add(endWord);
        
        int level = 1;

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // Always expand the smaller set to optimize performance
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextSet = new HashSet<>();
            for (String word : beginSet) {
                char[] chars = word.toCharArray();
                
                for (int i = 0; i < chars.length; i++) {
                    char old = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String target = String.valueOf(chars);

                        // If the frontiers meet, we found the shortest path
                        if (endSet.contains(target)) {
                            return level + 1;
                        }

                        if (wordSet.contains(target)) {
                            nextSet.add(target);
                            wordSet.remove(target); // Mark as visited
                        }
                    }
                    chars[i] = old;
                }
            }
            beginSet = nextSet;
            level++;
        }
        
        return 0;
    }
}