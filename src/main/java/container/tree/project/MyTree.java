package container.tree.project;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

//extends AbstractSet<E>

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
		// TODO: check if every node is eligible for gc
		root = null;
		size = 0;
		
	}

	private boolean containsNodeWith(E value, Node<E> node) {
		if (node == null) // doesn't contain
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
	
	private Node<E> findSuccessorNode(Node<E> node) {
		Node<E> successor;
		if (node.left == null) { // node is smallest
			successor = node;
		} else {
			successor = findSuccessorNode(node.left);
			if (node.left == successor) { // detach smallest from its parent
				node.left = successor.right;
			}
		}
		
		return successor;
	}
	
	private Node<E> removeNode(E value, Node<E> node) {
		if (node == null) {
	        return null;
	    }
	 
		if (value.compareTo(node.value) < 0) { // go left
			node.left = removeNode(value, node.left);
		} else if (value.compareTo(node.value) > 0) { // go right
			node.right = removeNode(value, node.right);
		} else { // is equal = delete node
			
			size--;
			if (node.left == null && node.right == null) {
			    return null;
			}
			
			if (node.right == null) {
			    return node.left;
			}
			 
			if (node.left == null) {
			    return node.right;
			}
			
			Node<E> successor = findSuccessorNode(node.right);
			node.value = successor.value;
			if (node.right == successor) { // successor was right child
				node.right = successor.right;
			}
			
		}
		
		return node;
	}

	@Override
	public boolean remove(Object o) {
		if (o == null) {
			throw new NullPointerException("TreeSet cannot contain null entries.");
		}
		
		if (root == null || !root.value.getClass().isInstance(o)) {
			return false;
		}
		@SuppressWarnings("unchecked")
		E value = (E) o;
		int size = this.size;
		root = removeNode(value, root);
		
		return size != this.size;
	}


	@Override
	public boolean removeAll(Collection<?> c) {
		if(c == null) {
			throw new NullPointerException("Collection may not have been initialized.");
		}
		
		boolean result = false;
		for (Object value: c) {
			result = result || this.remove(value);
		}
		return result;
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
