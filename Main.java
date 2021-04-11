package com.company;

public class Main {

    public static void main(String[] args) {
	    BST tree = new BST(5);
	    tree.add(3);
	    System.out.println(tree.contains(3));
	    tree.add(2);
	    tree.add(4);
	    tree.remove(2);
	    tree.remove(3);
	    System.out.println(tree.contains(3));
	    tree.add(8);
	    tree.add(7);
    }

}
