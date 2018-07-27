package 排序;

import java.util.Comparator;

public class 堆<T> {
	Comparator<T> comp;

	public 堆(Comparator<T> comp) {
		super();
		this.comp = comp;
	}

	public static void main(String[] args) {
		Integer[] a = { 0, 9, 8, 7, 6, 5 };
		堆<Integer> x = new 堆<Integer>(new Comparator<Integer>() {

			public int compare(Integer o1, Integer o2) {
				return o1 < o2 ? -1 : (o1 > o2 ? 1 : 0);
			}
		});
		x.build(a);
		x.sort(a);
		for (Integer integer : a) {
			System.out.println(integer);
		}
	}

	public void build(T[] x) {
		int point;
		for (int i = 1; i < x.length; i++) {
			point = i;
			while (point / 2 > 0 && comp.compare(x[point], x[point / 2]) < 0) {
				exchange(x, point, point / 2);
				point = point / 2;
			}
		}
	}

	public void sort(T[] x) {
		for (int i = x.length - 1; i > 1; i--) {
			exchange(x, 1, i);
			sort(x, 1);
		}
	}

	public void sort(T[] x, int point) {
		if (2 * point <= x.length - 1) {
			if (2 * point + 1 <= x.length - 1) {
				if (comp.compare(x[2 * point], x[2 * point + 1]) < 0) {
					if (comp.compare(x[point], x[2 * point]) > 0) {
						exchange(x, point, 2 * point);
						sort(x, 2 * point);
					} else {
						if (comp.compare(x[point], x[2 * point + 1]) > 0) {
							exchange(x, point, 2 * point + 1);
							sort(x, 2 * point + 1);
						}
					}
				}
			} else {
				if (comp.compare(x[point], x[2 * point]) > 0) {
					exchange(x, point, 2 * point);
				}
			}
		}
	}

	public void exchange(T[] x, int a, int b) {
		T c = x[a];
		x[a] = x[b];
		x[b] = c;
	}
}
