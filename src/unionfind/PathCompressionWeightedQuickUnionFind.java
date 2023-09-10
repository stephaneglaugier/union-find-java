package src.unionfind;

public class PathCompressionWeightedQuickUnionFind extends WeightedQuickUnionFind {

    public PathCompressionWeightedQuickUnionFind(int N) {
        super(N);
    }

    @Override
    protected int rootOf(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
}
