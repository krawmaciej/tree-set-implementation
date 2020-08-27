package containter.tree;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MyTree<E> implements Set<E> {
	
	private static class Node<E> {
		private E value;
		private Node left;
		private Node right;
		
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


	@Override
	public boolean add(E e) {
		size++;
		Node<E> node = new Node<E>(e);
		System.out.println(node.value);
		// TODO Auto-generated method stub
		return false;
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
