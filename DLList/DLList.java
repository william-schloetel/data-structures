public class DLList {

	private static class IntNode {		
		public IntNode prev;
		public int item;
		public IntNode next;

		public IntNode(int i, IntNode p, IntNode n) {
			item = i;
			prev  = p;
			next = n;
		}
	}

	private IntNode sentinel;			
	private int size;

	public DLList() {
		sentinel = new IntNode(0, null, null);
		sentinel.prev = sentinel;
		sentinel.next = sentinel;
	}

	public DLList(int x) {
		sentinel = new IntNode(0, null, null);
		IntNode n = new IntNode(x, sentinel, sentinel);
		sentinel.next = n;
		sentinel.prev = n;
	}

	public void addFirst(int x) {
		IntNode n = new IntNode(x, sentinel, sentinel.next);
		sentinel.next.prev = n;
		sentinel.next = n;
		size++;
	}

	public int getFirst() {
		return sentinel.next.item;
	}

	public int size() {
		return size;
	}

	public void addLast(int x) {
		IntNode n = new IntNode(x, sentinel.prev, sentinel);
		sentinel.prev = n;
		sentinel.prev.next = n;
		size++;
	}

	public int getLast() {
		return sentinel.prev.item;
	}

	public void removeLast() {					
		sentinel.prev = sentinel.prev.prev;
		sentinel.prev.prev.next = sentinel;		
		size--;
	}

	public int get(int i) {
		IntNode p = sentinel.next;
		int j = 0;
		while (j < i) {
			p = p.next;
			j++;
		}
		return p.item;
	}

}