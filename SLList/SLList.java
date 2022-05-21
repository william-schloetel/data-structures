/** Singley Linked List */

public class SLList {		//"Singly Linked List"
	
	/* Nested class */
	private static class IntNode {		
		public int item;				
		public IntNode next;

		public IntNode(int i, IntNode n) {
			item = i;
			next = n;
		}
	}

	/* The first item, if it exists, is at sentinel.next */
	private IntNode sentinel;
	private int size;

	/** Creates an empty SLList. */
	public SLList() {
		sentinel = new IntNode(0, null);
		size = 0;
	}

	public SLList(int x) {
		sentinel = new IntNode(0, null);
		sentinel.next = new IntNode(x, null);
		size = 1;
	}

	/** Inserts integer x into the list at index i */
	public void insert(int x, int i) {
		IntNode p = sentinel.next;
		int j = 0;
		while (j < i - 1) {
			p = p.next;
			j++;
		}
		IntNode newNode = new IntNode(x, p);
		p.next = newNode;
	}

	/** Adds x to the front of a list */
	public void addFirst(int x) {
		sentinel.next  = new IntNode(x, sentinel.next);
		size++;
	}

	/* Assumes there is at least one element */
	public int getFirst() {
		return sentinel.next.item;
	}

	/** Retrieves item at index i */
	public int get(int i) {
		IntNode p = sentinel.next;
		int j = 0;
		while (j < i) {
			p = p.next;
			j++;
		}
		return p.item;
	}


	public void addLast(int x) {
		IntNode p = sentinel;
		while (p.next != null) {
			p = p.next;
		}
		p.next = new IntNode(x, null);
		size++;
	}

	public int size(){
		return size;
	}
 
	/* Iterative size */
	public int iterativeSize(){
		IntNode p = sentinel;
		int size = 0;
		while (p.next != null){
			p = p.next;
			size++;
		}
		return size;
	}

	//Recursive size must have a helper method because SLList itself is not a recursive data structure
	/** Returns the size of the list that starts at IntNode p. */
	private static int recurseSizeHelper(IntNode p) {
		if (p.next == null) {
			return 1;
		}
		return recurseSizeHelper(p.next) + 1;
	}

	public int recurseSize() {
		return recurseSizeHelper(sentinel);
	}


}