public class ArrayList<T> implements List<T>{
	private int size;
	private T[] arr;

	public ArrayList() {
		arr = (T[]) new Object[1024];
		size = 0;
	}

	public void growArr() {
		T[] arr_ = (T[]) new Object[2 * arr.length];
		for (int i = 0; i < arr.length; i++)
			arr_[i] = arr[i];
        arr = arr_;
	}
	public void add(T item) {
		if (arr.length == size) {
			growArr();
		}
		arr[size++] = item;
	}
	public void add(int pos, T item) {
		if (arr.length == size) {
			growArr();
		}
		for (int i = size; i >= pos+1; i--) {
			arr[i] = arr[i-1];
		}
		arr[pos] = item;
		size += 1;
	}
	public T get(int pos) {
		return arr[pos];
	}
	public T remove(int pos) {
		T ret = arr[pos];
		for (int i = pos; i <= size-2; i++) {
			arr[i] = arr[i+1];
		}
		size -= 1;
		return ret;
	}
	public int size() {
		return size;
	}
}
