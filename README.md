# Union-Find Implementations
This Git repository contains different implementations of the Union-Find data structure in Java. The Union-Find data structure is used for solving problems related to connectivity and partitioning in graphs. The repository includes several implementations of Union-Find with varying levels of optimization and performance characteristics.

## Table of Contents
1. Introduction
2. Implementations
3. SlowUnionFind
4. QuickUnionFind
5. WeightedQuickUnionFind
6. PathCompressionWeightedQuickUnionFind
7. Usage

## Introduction
The Union-Find data structure is used to solve problems involving disjoint sets. It supports two main operations:

- `union(p, q)`: Merge two sets containing elements p and q.
- `connected(p, q)`: Check if elements p and q belong to the same set.

This repository provides multiple implementations of Union-Find with different trade-offs in terms of speed and memory usage. Understanding these implementations can help you choose the right one for your specific use case.

## Implementations
### SlowUnionFind
The SlowUnionFind implementation is the simplest but least efficient version of Union-Find. It uses an integer array to represent sets and performs a linear scan for each union operation, updating all elements in one set to belong to the other set.

### QuickUnionFind
The QuickUnionFind implementation improves on SlowUnionFind by using a tree-like structure to represent sets. Each element points to its parent, and union operations involve updating the root of one tree to point to the root of the other tree. This implementation has better performance than SlowUnionFind but can still suffer from tall trees.

### WeightedQuickUnionFind
The WeightedQuickUnionFind implementation enhances QuickUnionFind by keeping track of the size of each tree. When performing a union operation, it attaches the smaller tree to the root of the larger tree, ensuring that trees remain relatively balanced. This optimization reduces the time complexity of union operations.

### PathCompressionWeightedQuickUnionFind
The PathCompressionWeightedQuickUnionFind builds upon WeightedQuickUnionFind by adding path compression. When finding the root of an element, it compresses the path by making all elements along the path directly point to the root. This optimization improves the amortized time complexity of both union and connected operations, making it one of the most efficient Union-Find implementations.

## Usage
To use any of these Union-Find implementations, follow these steps:

1. Clone the repository to your local machine.
2. Import the desired implementation into your Java project.
3. Create an instance of the Union-Find implementation with the desired number of elements.
4. Use the union and connected methods to solve your connectivity problems.
Here's an example of how to use the QuickUnionFind implementation:

```java
import src.unionfind.QuickUnionFind;
import src.unionfind.IUnionFind;

public class Main {
    public static void main(String[] args) {
        int N = 10; // Number of elements
        IUnionFind uf = new QuickUnionFind(N);

        uf.union(0, 1);
        uf.union(2, 3);

        if (uf.connected(1, 2)) {
            System.out.println("1 and 2 are connected.");
        } else {
            System.out.println("1 and 2 are not connected.");
        }
    }
}
```