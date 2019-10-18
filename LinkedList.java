public class LinkedList<T> implements List<T>{
	private int size;
	private Node head;

	class Node{
		public T val;
		public Node next;

		public Node(T val){
			this.val = val;
			next = null;
		}
	}

	public LinkedList(){
		size = 0;
		head = null;
	}

	public void add(T item){
		size += 1;
		if (head == null) head = new Node(item);
		else {
			Node tail = new Node(item);
			Node node = head;
			while (node.next != null) node = node.next;
			node.next = tail;
		}
	}
	public void add(int pos, T item) {
		size += 1;
		Node insert = new Node(item);
		if (pos == 0) {
			insert.next = head;
			head = insert;
		} else {
			Node node = head;
			for (int i = 0; i <= pos-2; i++) {
				node = node.next;
			}
			insert.next = node.next;
			node.next = insert;
		}
	}
	public T get(int pos) {
		Node node = head;
		for (int i = 0; i <= pos-2; i++) {
			node = node.next;
		}
		return node.val;
	}
	public T remove(int pos) {
		size -= 1;
		if (pos == 0) {
			Node ret = head;
			head = head.next;
			return ret.val;
		}
		Node node = head;
		for (int i = 0; i <= pos-2; i++) {
			node = node.next;
		}
		Node ret = node.next;
		node.next = node.next.next;
		return ret.val;
	}
	public int size(){
		return size;
	}


}
