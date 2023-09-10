package src.unionfind;

public class WeightedQuickUnionFind extends QuickUnionFind {

    protected int[] size;

    public WeightedQuickUnionFind(int N) {
        super(N);
        size = new int[N];
        for (int i = 0; i < N; i++) {
            size[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {

        int rootOfP = rootOf(p);
        int rootOfQ = rootOf(q);

        if (rootOfP == rootOfQ) {
            return;
        }

        if (size[rootOfP] < size[rootOfQ]) {
            parent[rootOfP] = rootOfQ;
            size[rootOfP] += size[rootOfQ];
        } else {
            parent[rootOfQ] = rootOfP;
            size[rootOfQ] += size[rootOfP];
        }

    }
}
