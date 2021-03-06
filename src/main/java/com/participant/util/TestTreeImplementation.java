package com.participant.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;


class TestTreeImplementation<E extends Comparable<E>> implements Set<E> {
	
	static class Node<E> {
		E value;
		Node<E> left;
		Node<E> right;
		
		Node(E value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}

	Node<E> root;
	int size;
	
	TestTreeImplementation() {
		this.root = null;
		this.size = 0;
	}

	boolean addNode(E value, Node<E> node) {
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
		if(value == null) {
			throw new NullPointerException("TreeSet cannot contain null entries.");
		}
		
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
		if(c == null) {
			throw new NullPointerException("Collection may not have been initialized.");
		}
		
		boolean result = false;
		for (E value: c) {
			result = this.add(value) ? true : result;
		}
		return result;
	}


	@Override
	public void clear() {
		size = 0;
		// TODO Auto-generated method stub
		
	}

	boolean containsNodeWith(E value, Node<E> node) {
		if (node == null) // not contains
			return false;
		
		if (value.compareTo(node.value) < 0) { // go left
			return containsNodeWith(value, node.left);
		} else if (value.compareTo(node.value) > 0) { // go right
			return containsNodeWith(value, node.right);
		} else { // is equal = contains
			return true;
		}
	}

	@Override
	public boolean contains(Object o) {
		if (o == null) {
			throw new NullPointerException("TreeSet cannot contain null entries.");
		}
		
		if (root == null || !root.value.getClass().isInstance(o)) {
			return false;
		}
		@SuppressWarnings("unchecked")
		E value = (E) o;
		return containsNodeWith(value, root);
	}


	@Override
	public boolean containsAll(Collection<?> c) {
		if(c == null) {
			throw new NullPointerException("Collection may not have been initialized.");
		}
		
		boolean result = true;
		for (Object value: c) {
			result = result && this.contains(value);
		}
		return result;
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
		return size;
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
