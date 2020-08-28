package containter.tree;

import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Set<Integer> tree = new MyTree<Integer>();
		System.out.println(tree.add(7));
		System.out.println(tree.add(7));
		System.out.println(tree.add(8));
		System.out.println(tree.add(7));
		System.out.println(tree.add(11));
		System.out.println(tree.add(11));
	}

}
