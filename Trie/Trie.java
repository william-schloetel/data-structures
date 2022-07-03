import java.util.HashMap;

public class Trie {

	private static class Node {
		public HashMap<Character, Node> children;
		public char _c;
		public boolean isCompleteWord;

		public Node(char c, boolean complete) {
			_c = c;
			children = new HashMap<Character, Node>();
			isCompleteWord = complete;
		}
	}

	Node sentinel;
	int size;

	public Trie() {
		sentinel = new Node('o', false);
		size = 0;
	}

	public int size() {
		return size;
	}

	public void insert(String word) {
		char[] wordArr = word.toCharArray();
		Node p = sentinel;
		for (char c : wordArr) {
			Node child = p.children.get(c);
			if (child == null) {
				Node n = new Node(c, false);
				p.children.put(c, n);
				p = n;
				size += 1;
			} else {
				p = child;
			}	
		}
		p.isCompleteWord = true;
	}

	public boolean containsWord(String word) {
		char[] wordArr = word.toCharArray();
		Node p = sentinel;
		for (char c : wordArr) {
			Node child = p.children.get(c);
			if (child == null) {
				return false;
			}
			p = child;
		}
		if (p.isCompleteWord) {
			return true;
		} else {
			return false;
		}
	}

	public boolean containsPrefix(String prefix) {
		char[] wordArr = prefix.toCharArray();
		Node p = sentinel;
		for (char c : wordArr) {
			Node child = p.children.get(c);
			if (child == null) {
				return false;
			}
			p = child;
		}
		return true;
	}



	public static void main(String[] args) {
		Trie t = new Trie();
		// t.insert("test");
		// System.out.println(t.size());
		// t.insert("quick");
		// System.out.println(t.contains("quickl"));
		// System.out.println(t.size());
		t.insert("testing");
		System.out.println(t.size());
		System.out.println(t.containsWord("tes"));
		System.out.println(t.containsWord("testing"));
		System.out.println(t.containsPrefix("sti"));
		System.out.println(t.containsPrefix("testing"));

	}


}