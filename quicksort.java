import java.util.ArrayList;

class quicksort {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			arr.add((int) (Math.random() * 101));
		}
		qsort(arr);
		System.out.println(arr);
	}

	/**
	 * Sorts an Array of Integers with quicksort.
	 * pre: arr != null
	 * post: arr is sorted
	 */
	private static void qsort(ArrayList<Integer> arr) {
		if (arr == null) {
			throw new IllegalArgumentException("arr can't be null");
		}
		recurse(arr, 0, arr.size() - 1);
	}

	/**
	 * Uses quicksort with the first element as pivot to sort arr from l to r inclusive.
	 * @param arr the array to be sorted
	 * @param l the left index to start from (inclusive)
	 * @param r the right index to start from (exclusive)
	 */
	private static void recurse(ArrayList<Integer> arr, int l, int r) {
		if (l < r) {
			//assume pivot is initially at index l
			int piv = l;
            for (int i = l + 1; i <= r; i++) {
				if (arr.get(i) < arr.get(piv)) {
					int val = arr.get(piv); //avoids creation of new array
					arr.set(piv, arr.get(i));
					arr.set(i, arr.get(piv + 1));
					arr.set(piv + 1, val);
					piv++;
				}
			}
			recurse(arr, l, piv);
			recurse(arr, l + 1, r);
		}
	}
}