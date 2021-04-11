package com.company;

public class BST {
    BST leftNode, rightNode, parentNode;
    int value, level;
    BSTUtil.Direction direction;

    BST(int value) {
        this.value = value;
        this.level = 1;
    }

    void add(int newValue) {
        BSTUtil.findEmptyNodeAndAdd(this, newValue);
    }

    void remove(int valueToDelete) {
        BSTUtil.findNodeAndDelete(this, valueToDelete);
    }

    boolean contains(int value) {
        return BSTUtil.findIfBSTContainsElement(this, value);
    }

}
