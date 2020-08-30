package container.tree.project;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
		Throwable throwAdd = assertThrows(
				NullPointerException.class,
				() -> myTree.add(null)
		);
		Throwable throwAddAll = assertThrows(
				NullPointerException.class,
				() -> myTree.addAll(null)
		);
		
		assertEquals("TreeSet cannot contain null entries.",throwAdd.getMessage());
		assertEquals("Collection may not have been initialized.",throwAddAll.getMessage());
	}
	
	@DisplayName("When checking if tree contains null Then expect null pointer exception")
	@Test
	void testContainsNull() {
		Throwable throwContains = assertThrows(
				NullPointerException.class,
				() -> myTree.contains(null)
		);
		Throwable throwContainsAll = assertThrows(
				NullPointerException.class,
				() -> myTree.containsAll(null)
		);
		
		assertEquals("TreeSet cannot contain null entries.",throwContains.getMessage());
		assertEquals("Collection may not have been initialized.",throwContainsAll.getMessage());
	}
	
	@DisplayName("When removing null value Then expect null pointer exception")
	@Test
	void testRemoveNull() {
		Throwable throwRemove = assertThrows(
				NullPointerException.class,
				() -> myTree.remove(null)
		);
		Throwable throwRemoveAll = assertThrows(
				NullPointerException.class,
				() -> myTree.removeAll(null)
		);
		
		assertEquals("TreeSet cannot contain null entries.",throwRemove.getMessage());
		assertEquals("Collection may not have been initialized.",throwRemoveAll.getMessage());
	}
	
	@DisplayName("When checking if contains empty list Then return true")
	@Test
	void testContainsEmpty() {
		assertTrue(myTree.containsAll(Collections.emptyList()));
	}
	
	@DisplayName("When deleting empty list Then tree wasn't changed")
	@Test
	void testRemoveEmpty() {
		assertFalse(myTree.removeAll(Collections.emptyList()));
	}
	
	@DisplayName("When adding empty list Then tree wasn't changed")
	@Test
	void testAddEmpty() {
		assertFalse(myTree.addAll(Collections.emptyList()));
	}
	
	@Nested
	@DisplayName("When the tree is empty")
	class EmptyTree {
		
		@Test
		@DisplayName("Then tree has size of 0 and values can be added") 
		void testAddValues() {
			assertAll("Verify that values are added",
					() -> assertTrue(myTree.isEmpty()),
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
			assertAll("Verify that values are added",
					() -> assertTrue(myTree.isEmpty()),
					() -> assertEquals(0, myTree.size()),
					() -> assertTrue(myTree.addAll(collection)),
					() -> assertEquals(4, myTree.size()),
					() -> assertTrue(myTree.containsAll(collection))
			);
		}
		
		@Test
		@DisplayName("Then values can be added and removed") 
		void testAddAndRemove() {
			assertAll("Verify that values are removed",
					() -> assertTrue(myTree.isEmpty()),
					() -> assertEquals(0, myTree.size()),
					() -> assertTrue(myTree.add(0)),
					() -> assertFalse(myTree.isEmpty()),
					() -> assertEquals(1, myTree.size()),
					() -> assertTrue(myTree.add(1)),
					() -> assertFalse(myTree.isEmpty()),
					() -> assertEquals(2, myTree.size()),
					() -> assertTrue(myTree.remove(0)),
					() -> assertFalse(myTree.isEmpty()),
					() -> assertEquals(1, myTree.size()),
					() -> assertTrue(myTree.add(0)),
					() -> assertFalse(myTree.isEmpty()),
					() -> assertEquals(2, myTree.size()),
					() -> assertTrue(myTree.remove(0)),
					() -> assertFalse(myTree.isEmpty()),
					() -> assertEquals(1, myTree.size()),
					() -> assertTrue(myTree.remove(1)),
					() -> assertTrue(myTree.isEmpty()),
					() -> assertEquals(0, myTree.size())
			);
		}
		
	}
	
	@Nested
	@DisplayName("When the tree has six nodes")
	class FourNodeTree {
		/*
		 * 		2
		 * 	  0   3
		 *     1    11
		 *         6    
		 */
		@BeforeEach
		void setUp() {
			collection = new ArrayList<Integer>(Arrays.asList(2, 3, 0, 1, 11, 6));
			myTree.addAll(collection);
		}
		
		@Test
		@DisplayName("Then first value added can be removed") 
		void testRemoveFirstValue() {
			int first = collection.get(0);
			assertAll("Verify that value is removed",
					() -> assertFalse(myTree.isEmpty()),
					() -> assertEquals(6, myTree.size()),
					() -> assertTrue(myTree.contains(first)),
					() -> assertTrue(myTree.remove(first)),
					() -> assertFalse(myTree.contains(first)),
					() -> assertFalse(myTree.remove(first)),
					() -> assertEquals(5, myTree.size())
			);
		}
		
		@Test
		@DisplayName("Then second value added can be removed") 
		void testRemoveSecondValue() {
			int second = collection.get(1);
			assertAll("Verify that value is removed",
					() -> assertFalse(myTree.isEmpty()),
					() -> assertEquals(6, myTree.size()),
					() -> assertTrue(myTree.contains(second)),
					() -> assertTrue(myTree.remove(second)),
					() -> assertFalse(myTree.contains(second)),
					() -> assertFalse(myTree.remove(second)),
					() -> assertEquals(5, myTree.size())
			);
		}
		
		@Test
		@DisplayName("Then third value added can be removed") 
		void testRemoveThirdValue() {
			int third = collection.get(0);
			assertAll("Verify that value is removed",
					() -> assertFalse(myTree.isEmpty()),
					() -> assertEquals(6, myTree.size()),
					() -> assertTrue(myTree.contains(third)),
					() -> assertTrue(myTree.remove(third)),
					() -> assertFalse(myTree.contains(third)),
					() -> assertFalse(myTree.remove(third)),
					() -> assertEquals(5, myTree.size())
			);
		}
		
		@Test
		@DisplayName("Then nodes can be removed") 
		void testRemoveValues() {
			assertAll("Verify that values are removed",
					() -> assertFalse(myTree.isEmpty()),
					() -> assertEquals(6, myTree.size()),
					() -> assertTrue(myTree.containsAll(collection)),
					// 2
					() -> assertTrue(myTree.remove(2)),
					() -> assertEquals(5, myTree.size()),
					() -> assertFalse(myTree.containsAll(collection)),
					() -> assertTrue(myTree.containsAll(Arrays.asList(3, 0, 1, 11, 6))),
					() -> assertFalse(myTree.isEmpty()),
					// 3
					() -> assertTrue(myTree.remove(3)),
					() -> assertEquals(4, myTree.size()),
					() -> assertTrue(myTree.containsAll(Arrays.asList(0, 1, 11, 6))),
					() -> assertFalse(myTree.isEmpty()),
					// 0
					() -> assertTrue(myTree.remove(0)),
					() -> assertEquals(3, myTree.size()),
					() -> assertTrue(myTree.containsAll(Arrays.asList(1, 11, 6))),
					() -> assertFalse(myTree.isEmpty()),
					// 1
					() -> assertTrue(myTree.remove(1)),
					() -> assertEquals(2, myTree.size()),
					() -> assertTrue(myTree.containsAll(Arrays.asList(11, 6))),
					() -> assertFalse(myTree.isEmpty()),
					// 11
					() -> assertTrue(myTree.remove(11)),
					() -> assertEquals(1, myTree.size()),
					() -> assertTrue(myTree.containsAll(Arrays.asList(6))),
					() -> assertFalse(myTree.isEmpty()),
					// 6
					() -> assertTrue(myTree.remove(6)),
					() -> assertEquals(0, myTree.size()),
					() -> assertTrue(myTree.containsAll(Arrays.asList())),
					() -> assertTrue(myTree.isEmpty())
			);
		}
		
		@Test
		@DisplayName("and tree is made into an array Then this array is sorted") 
		void testToArray() {
			Object[] array = { 0, 1, 2, 3, 6, 11 };
			assertAll("Verify that array is sorted",
					() -> assertEquals("[0, 1, 2, 3, 6, 11]", Arrays.toString(myTree.toArray())),
					() -> assertTrue(Arrays.equals(myTree.toArray(), array))
			);
		}
		
		
	}
}