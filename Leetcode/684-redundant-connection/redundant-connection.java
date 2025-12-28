class Solution {
    class UnionFind{
        int[] parent;
        int[] rank;

        public UnionFind(int n){
            this.parent=new int[n];
            this.rank=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
                rank[i]=1;
            }
        }

        public int find(int x){
            if(x==parent[x]){
                return x;
            }
            return parent[x]=find(parent[x]);
        }
        public boolean isRedundantByUnion(int x, int y){
            int rootX=find(x);
            int rootY=find(y);
            if(rootX==rootY)return true;
            if(rank[rootX]>rank[rootY]){
                parent[rootY]=rootX;
            }else if(rank[rootY]>rank[rootX]){
                parent[rootX]=rootY;
            }else{
                parent[rootY]=rootX;
                rank[rootX]++;
            }
            return false;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {

        UnionFind uf=new UnionFind(edges.length+1);

        for(int[] edge:edges){
            if(uf.isRedundantByUnion(edge[0], edge[1])){
                return edge;
            }
        }
        return new int[2];
        
    }
}