public class WeightedQuickUnion implements DisjointSet {
	
	private int[] parent;

	public WeightedQuickUnion(int N) {
		parent = new int[N];
		for (int i = 0; i < N; i++) {
			parent[i] = -1;
		}
	}

	private int findRoot(int p) {
		while(parent[p] >= 0) {
			System.out.println(p);
			p = parent[p];
		}
		return p;
	}

	public void connect(int p, int q) {
		int pRoot = findRoot(p);
		int qRoot = findRoot(q);

		if (parent[pRoot] < parent[qRoot]) {
			parent[pRoot] += parent[qRoot];
			parent[qRoot] = pRoot;
		} else {
			parent[qRoot] += parent[pRoot];
			parent[pRoot] = qRoot;
		}
	}

	public boolean isConnected(int p, int q) {
		return findRoot(p) == findRoot(q);
	}

	/* TO DO: Add optimization w/ path compression */


}