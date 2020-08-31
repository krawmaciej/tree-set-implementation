package com.participant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.participant.util.MyTree;

public class Main {

	public static void main(String[] args) {
		Set<Integer> tree = new MyTree<Integer>();
		System.out.println(tree.add(7));
		System.out.println(tree.add(7));
		System.out.println(tree.add(8));
		System.out.println(tree.add(7));
		System.out.println(tree.add(11));
		System.out.println(tree.add(11));
		System.out.println(tree.size());
		
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 5, 1));
		
		System.out.println(tree.addAll(list));
		System.out.println(tree.size());
		list.add(0);
		System.out.println(tree.addAll(list));
		System.out.println(tree.size());
		
		System.out.println("Contains:");
		System.out.println(tree.contains(8));
		System.out.println(tree.contains(-1));
		System.out.println(tree.contains(1));
		System.out.println(tree.containsAll(list));
		System.out.println(tree.containsAll(Collections.emptySet()));
		System.out.println(tree.containsAll(Arrays.asList(-1)));
		list.add(-1);
		System.out.println(tree.containsAll(list));
		
		
		
		/*
		Set<Integer> test = new TreeSet<Integer>();
		System.out.println(tst.add(1));
		list.clear();
		System.out.println("should be true: " + tst.containsAll(Collections.emptySet()));
		
		System.out.println(tst.contains(null));
		*/
		
		
	}

}
