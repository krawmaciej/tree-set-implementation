package containter.tree;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

//extends AbstractSet<E>
//implements Comparable<E>

public class MyTree<E extends Comparable<E>> implements Set<E> {
	
	private static class Node<E> {
		private E value;
		private Node<E> left;
		private Node<E> right;
		
		private Node(E value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}

	private Node<E> root;
	private int size;
	
	public MyTree() {
		this.root = null;
		this.size = 0;
	}

	private boolean addNode(E value, Node<E> node) {
		if (value.compareTo(node.value) < 0) { // go left
			if (node.left == null) {
				node.left = new Node<E>(value);
				return true;
			} else {
				return addNode(value, node.left);
			}
		} else if (value.compareTo(node.value) > 0) { // go right
			if (node.right == null) {
				node.right = new Node<E>(value);
				return true;
			} else {
				return addNode(value, node.right);
			}
		} else { // is equal
			return false;
		}
	}
	
	@Override
	public boolean add(E value) {
		boolean result = false;
		if (root == null) {
			root = new Node<E>(value);
			result = true;
		} else {
			result = addNode(value, root);
		}
		
		if (result) {
			size++;
		}
		return result;
	}


	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void clear() {
		size = 0;
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isEmpty() {
		return size == 0;
	}


	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean remove(Object o) {
		size--;
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}
