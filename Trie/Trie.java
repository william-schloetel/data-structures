import java.util.*;

public class Trie {
	private static class Node {
		public HashMap<Character, Node> children;
		public char c;
		public String prefix;
		public boolean isCompleteWord;
		public int rank;

		public Node(char ch, String pref, boolean complete, int ranking) {
			c = ch;
			prefix = pref;
			children = new HashMap<Character, Node>();
			isCompleteWord = complete;
			rank = ranking;
		}
	}

	Node sentinel;
	int size;

	public Trie() {
		sentinel = new Node('o', "o", false, 0);
		size = 0;
	}

	public int size() {
		return size;
	}

	public void insert(String word, int ranking) {
		word.toLowerCase();
		char[] wordArr = word.toCharArray();
		Node p = sentinel;
		String prefix = "";
		for (int i = 0; i < wordArr.length; i++) {
			prefix += wordArr[i];
			Node child = p.children.get(wordArr[i]);
			if (child == null) {
				Node n = new Node(wordArr[i], prefix, false, 0);
				p.children.put(wordArr[i], n);
				p = n;
				size += 1;
			} else {
				p = child;
			}	
		}
		p.isCompleteWord = true;
		p.rank = ranking;
	}

	public boolean containsWord(String word) {
		word.toLowerCase();
		char[] wordArr = word.toCharArray();
		Node p = sentinel;
		for (char c : wordArr) {
			Node child = p.children.get(c);
			if (child == null) {
				return false;
			}
			p = child;
		}
		return p.isCompleteWord
	}

	public boolean containsPrefix(String prefix) {
		prefix.toLowerCase();
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

	public String shortestWordWithPrefix(String prefix) {
		prefix.toLowerCase();
		char[] prefixArr = prefix.toCharArray();
		Node p = sentinel;
		for (char c : prefixArr) {
			Node child = p.children.get(c);
			if (child == null) {
				System.out.println("Prefix not contained in Trie");
				return new ArrayList<String>();
			}
			p = child;	
		}
		if (p.isCompleteWord) {
			System.out.println(prefix);
			return prefix;
		}
		//Breadth first search of the last char children
		//Prefix "do", breadth first search of "o" children until you reach a 
		//complete word and then return that word
		Queue<Node> q = new LinkedList<Node>();
		for (Node node : p.children.values()) {
			q.add(node);		
		} 
		while (!q.element().isCompleteWord) {
			for (Node node : q.element().children.values()) {
				q.add(node);		
			}
			q.remove();
		}
		System.out.println(q.element().prefix);
		return q.element().prefix;
	}

	/* Returns a list of all words with the given prefix */
	public ArrayList<String> allWordsWithPrefix(String prefix) {
		prefix.toLowerCase();
		char[] prefixArr = prefix.toCharArray();
		Node p = sentinel;
		for (char c : prefixArr) {
			Node child = p.children.get(c);
			if (child == null) {
				System.out.println("Prefix not contained in Trie");
				return new ArrayList<String>();
			}
			p = child;	
		}
		// IMPORTANT:
		// IF THE GIVEN PREFIX IS A WORD, SHOULD IT BE RETURNED AS A ONE
		// OF THE WORDS WITH THE GIVEN PREFIX?
		// EX: sit (which is the prefix of sitting, but also itself a word)
		// if (p.isCompleteWord) {
		// 	ArrayList<String> arr = new ArrayList<String>();
		// 	arr.add(p.prefix);
		// 	return arr;
		// }	
		// Create ArrayList to store all the words
		ArrayList<String> arr = new ArrayList<String>();
		// Start a breadth first search on Trie after prefix
		Queue<Node> q = new LinkedList<Node>();
		for (Node node : p.children.values()) {
			q.add(node);		
		} 
		while(q.size() > 0) {
			for (Node node : q.element().children.values()) {
				q.add(node);		
			}
			// Must append to an ArrayList anytime isCompleteWord == True
			if (q.element().isCompleteWord) {
				arr.add(q.element().prefix);
			}
			q.remove();
		}
		return arr;
	}




	public static void main(String[] args) {
		Trie t = new Trie();

		System.out.println(t.size());
		System.out.println("--------------------");

		System.out.println("Input 5 words:");
		for (int i=0; i < 5; i++) {
			String word = System.console().readLine();
			t.insert(word, 0);
		}

		System.out.println("--------------------");
		System.out.println("Type in prefix:");
		while (true) {
			String prefix = System.console().readLine();
			for (String w : t.allWordsWithPrefix(prefix)) {
				System.out.println(w);
			}
		}

	// 	System.out.println("--------------------");
	// 	t.insert("tes", 0);
	// 	System.out.println(t.size());
	// 	System.out.println(t.containsWord("tes"));
	// 	System.out.println(t.containsWord("tes"));
	// 	System.out.println("--------------------");

	// 	t.insert("testing", 0);
	// 	System.out.println(t.size());
	// 	System.out.println(t.containsWord("tes"));
	// 	System.out.println(t.containsWord("test"));
	// 	System.out.println("--------------------");

	// 	t.insert("home", 0);
	// 	System.out.println(t.size());
	// 	System.out.println(t.containsWord("home"));
	// 	System.out.println(t.containsWord("homely"));
	// 	System.out.println("--------------------");

	// 	t.insert("homely", 0);
	// 	System.out.println(t.size());
	// 	System.out.println(t.containsWord("home"));
	// 	System.out.println(t.containsWord("homely"));
	// 	System.out.println("--------------------");

	}
}