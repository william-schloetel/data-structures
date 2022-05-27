public class IntList {
	int first;
	IntList rest;

	/** Constructor */
	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}


	public static IntList incrList(IntList L, int x) {
		if (L.rest == null) {
			return new IntList(L.first + x, null);
		}
		return new IntList(L.first, incrList(L.rest, x));
	}

	public static IntList dincrList(IntList L, int x) {
		L.first += x;
		if (L.rest == null) {
			return L;
		}
		L.rest = dincrList(L.rest, x);
		return L;
	}

	public int size() {
		if (this.rest == null) {
			return 1;
		}
		return this.rest.size() + 1;
	}

	public int iterSize() {
		IntList p = this;
		int size = 1;
		while (p.rest != null) {
			p = p.rest;
			size++;
		}
		return size;
	}

	public int get(int i) {
		IntList p = this;
		for (int j = 0; j < i; j++) {
			p = p.rest;
		}
		return p.first;
	}

	public int getRecursive(int i) {
		if (i == 0) {
			return this.first;
		}
		return this.rest.getRecursive(i - 1);
	}

	public void appendList(IntList J) {
		IntList p = this;
		while (p.rest != null) {
			p = p.rest;
		}
		p.rest = J;
	}

 // 	public static IntList squareMutative(IntList L) {
	// 	if (L == null) {
	// 		return L;
	// 	} else {
	// 		L.first = L.first * L.first;
	// 		squareMutative(L.rest);
	// 	}
	// 	return L;
	// }

	public static IntList squareMutative(IntList L) {
		if (L.rest == null) {
			L.first *= L.first;
			return L;
		} 
		L.first *= L.first;
		L.rest = squareMutative(L.rest);
		return L;
	}



	public static void main(String[] args) {
		IntList L = new IntList(5, new IntList(10, new IntList(15, null)));
		IntList S = squareMutative(L);
		System.out.println(S.get(0));
		System.out.println(L);
		System.out.println(S);
	}
}