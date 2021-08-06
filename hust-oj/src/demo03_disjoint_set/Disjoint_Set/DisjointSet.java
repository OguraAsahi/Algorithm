package demo03_disjoint_set.Disjoint_Set;

public class DisjointSet {
    private int[] parent;
    private int[] rank; // size of component for roots
    private int count; // number of components

    public DisjointSet(int N) {
        count = N; // 初始时有N个组件
        parent = new int[N];
        rank = new int[N];
        for(int i = 0; i < N; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }
    public int count() {
        return count;
    }
    public boolean isconnected(int p, int q) {
        return find(p) == find(q);
    }
    private int find(int p) {
        while(p != parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
            //rank[qRoot] += rank[pRoot];
        } else if(rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
            //rank[pRoot] += rank[qRoot];
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
        // count--; // 执行一次union，才需要减一次
    }
}
