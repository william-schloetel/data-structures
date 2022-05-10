public class AList<Item> {
	private Item[] items;
	private int size;
	private static int RFACTOR = 2;

	public AList() {
		items = (Item[]) new Object[100]; 
		size = 0;
	} 
    
	public void resize(int capacity) {
		Item[] arr = (Item[]) new Object[capacity];
		System.arraycopy(items, 0, arr, 0, size);
		items = arr;
	}

	public void addLast(Item x) {
		if (size == items.length) {
			resize(size * RFACTOR);		
		}
		items[size] = x;
		size++;
	}

	public Item getLast() {
		return items[size -1];
	}

	/** Deletes the last item and returns it */
	public Item removeLast() {
		Item x = getLast();
		items[size - 1] = null;
		size--;
		return x;
	}

	public Item get(int i) {
		return items[i];
	}

	public int size(){
		return size;
	}


	public static void main(String[] args) {




	}




}