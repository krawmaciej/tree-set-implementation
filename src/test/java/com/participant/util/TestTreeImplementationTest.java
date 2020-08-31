package com.participant.util;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Given a binary tree")
class TestTreeImplementationTest {
	
	private TestTreeImplementation<Integer> myTree;
	
	@Nested
	@DisplayName("When the tree is empty")
	class EmptyTree {
		
		@BeforeEach
		void setUp() {
			myTree = new TestTreeImplementation<Integer>();
		}
		
		@Test
		@DisplayName("Then root is null") 
		void testIfEmptyTree() {
			assertAll("Verify that tree is empty",
					() -> assertNull(myTree.root),
					() -> assertEquals(0, myTree.size)
			);
		}
		
		// checks if node is created correctly
		@Test
		@DisplayName("and a value was added Then root's children are null") 
		void testIfEmptyRootChildren() {
			assertTrue(myTree.add(2), () -> "Add root node");
			TestTreeImplementation.Node<Integer> root = myTree.root;
			
			assertAll("Verify that root node children are empty",
					() -> assertNotNull(root),
					() -> assertEquals(2, root.value),
					() -> assertNull(root.left),
					() -> assertNull(root.right)
			);
		}
	}
	
	@Nested
	@DisplayName("When the tree has four nodes")
	class FourNodeTree {
		/*
		 * 		2
		 * 	  0   3
		 *     1
		 */
		@BeforeEach
		void setUp() {
			myTree = new TestTreeImplementation<Integer>();
			myTree.addAll(Arrays.asList(2, 3, 0, 1));
		}
		
		@Test
		@DisplayName("Then the nodes should be in a correct order") 
		void testAdd() {
			TestTreeImplementation.Node<Integer> root = myTree.root;
			TestTreeImplementation.Node<Integer> right3 = root.right;
			TestTreeImplementation.Node<Integer> left0 = root.left;
			TestTreeImplementation.Node<Integer> leftRight1 = left0.right;
			assertAll("Verify that the tree builds correctly",
					// not null
					() -> assertNotNull(root),
					() -> assertNotNull(right3),
					() -> assertNotNull(left0),
					() -> assertNotNull(leftRight1),
					// equal
					() -> assertEquals(2, root.value),
					() -> assertEquals(3, right3.value),
					() -> assertEquals(0, left0.value),
					() -> assertEquals(1, leftRight1.value),
					// null
					() -> assertNull(right3.left),
					() -> assertNull(right3.right),
					() -> assertNull(left0.left),
					() -> assertNull(leftRight1.left),
					() -> assertNull(leftRight1.right)
			);
		}
	}
}