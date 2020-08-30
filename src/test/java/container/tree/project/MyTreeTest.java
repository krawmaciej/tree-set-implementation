package container.tree.project;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Given a binary tree")
class MyTreeTest {
	
	private MyTree<Integer> myTree;
	private List<Integer> collection;
	
	@BeforeEach
	void setUp() {
		myTree = new MyTree<Integer>();
	}
	
	@DisplayName("When null value is added Then expect null pointer exception")
	@Test
	void testAddNull() {
		Throwable thrown = assertThrows(
				NullPointerException.class,
				() -> myTree.add(null)
		);
		assertEquals("TreeSet cannot contain null entries.", thrown.getMessage());
	}
	
	@Nested
	@DisplayName("When the tree is empty")
	class EmptyTree {
		
		@Test
		@DisplayName("Then tree has size of 0 and values can be added") 
		void testAddValues() {
			assertAll("Veryfiy that values are added",
					() -> assertEquals(0, myTree.size()),
					() -> assertTrue(myTree.add(1)),
					() -> assertEquals(1, myTree.size()),
					() -> assertTrue(myTree.add(3)),
					() -> assertEquals(2, myTree.size()),
					() -> assertTrue(myTree.add(5)),
					() -> assertEquals(3, myTree.size()),
					() -> assertTrue(myTree.add(0)),
					() -> assertEquals(4, myTree.size()),
					() -> assertTrue(myTree.contains(0)),
					() -> assertTrue(myTree.contains(1)),
					() -> assertTrue(myTree.contains(3)),
					() -> assertTrue(myTree.contains(5))
			);
		}
		
		@Test
		@DisplayName("Then tree has size of 0 and List can be added") 
		void testAddAllValues() {
			collection = Arrays.asList(2, 3, 0, 1);
			assertAll("Veryfiy that values are added",
					() -> assertEquals(0, myTree.size()),
					() -> assertTrue(myTree.addAll(collection)),
					() -> assertEquals(4, myTree.size()),
					() -> assertTrue(myTree.containsAll(collection))
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
			myTree.addAll(Arrays.asList(2, 3, 0, 1));
		}
		
		
	}
}