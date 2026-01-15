class Solution {
    Set<String> words;
    Map<String, Boolean> map;

    public boolean wordBreak(String s, List<String> wordDict) {
        words = new HashSet<>(wordDict);
        map = new HashMap<>();
        return rec(s);

    }

    boolean rec(String s) {
        if (s.length() == 0)
            return true;

        if (map.containsKey(s))
            return map.get(s);

        if (words.contains(s))
            return true;

        for (int i = 1; i <= s.length(); i++) {

            if (words.contains(s.substring(0, i)) && rec(s.substring(i))) {
                map.put(s, true);
                return true;
            }

        }
        map.put(s, false);
        return false;
    }
}