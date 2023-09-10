package src.unionfind;

public class QuickUnionFind implements IUnionFind {

    protected int[] parent;

    public QuickUnionFind(int N) {
        parent = new int[N];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return parent[p] == parent[q];
    }

    @Override
    public void union(int p, int q) {
        parent[rootOf(p)] = rootOf(q);
    }

    protected int rootOf(int p) {
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }
}
