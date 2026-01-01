class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> wordSet=new HashSet<>(wordList);
        if(!wordSet.contains(endWord)){
            return 0;
        }
        int ans=0;
        Queue<String> queue=new LinkedList<>();
        Set<String> visited=new HashSet<>();
        queue.add(beginWord);
        visited.add(beginWord);
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size-- >0){
                String word=queue.remove();
                if(endWord.equals(word)){
                    return ans+1;
                }
                for(String adj:wordList){
                    if(!visited.contains(adj) && oneCharDiff(adj, word)){
                        queue.add(adj);
                        visited.add(adj);
                    }
                }

            }
            ans++;
        }
        return 0;

        
    }

    private boolean oneCharDiff(String a, String b){
        int count=0;
        int len=a.length();
        for(int i=0;i<len;i++){
            if(a.charAt(i)!=b.charAt(i)){
                count++;
            }
            if(count>1)return false;
        }
        return count==1;
    }
}