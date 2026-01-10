class Solution {
    class DSU{
        Map<Integer, Integer> parent;
        Map<Integer, Integer> rank;
        int numComponents;
        public DSU(){
            this.numComponents=0;
            parent=new HashMap<>();
            rank=new HashMap<>();
        }
        private int find(int x){
            if(parent.get(x)==null){
                parent.put(x, x);
                numComponents++;
            }
            if(parent.get(x)==x)return x;
            parent.put(x, find(parent.get(x)));
            return parent.get(x);
        }

        private boolean union(int x, int y){
            int parx=find(x);
            int pary=find(y);
            if(parx==pary){
                return false;
            }
            if(rank.get(parx)==null){
                rank.put(parx,1);
            }
            if(rank.get(pary)==null){
                rank.put(pary, 1);
            }
            if(rank.get(parx)==rank.get(pary)){
                parent.put(parx, pary);
                rank.put(pary, rank.get(pary)+1);
            }else if(rank.get(parx) > rank.get(pary)){
                 parent.put(pary, parx);
            }else{
                parent.put(parx, pary);
            }
            numComponents--;
            return true;
        }
    }
    public int removeStones(int[][] stones) {
        DSU dsu=new DSU();
        for(int[] stone: stones){
            dsu.union(stone[0], 100000+stone[1]);
        }        
        return stones.length-dsu.numComponents;
    }
}