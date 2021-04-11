package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class BSTUtil {

    enum Direction {
        LEFT, RIGHT
    }

    static boolean findEmptyNodeAndAdd(BST node, int newValue) {
        boolean newNode = false;

        if (node == null) {
            newNode = true;
        } else {
            if (newValue > node.value) {
                if (findEmptyNodeAndAdd(node.rightNode, newValue)) {
                    node.rightNode = new BST(newValue);
                    node.rightNode.level = node.level + 1;
                    node.rightNode.parentNode = node;
                    node.rightNode.direction = Direction.RIGHT;
                }
            } else {
                if (findEmptyNodeAndAdd(node.leftNode, newValue)) {
                    node.leftNode = new BST(newValue);
                    node.leftNode.level = node.level + 1;
                    node.leftNode.parentNode = node;
                    node.leftNode.direction = Direction.LEFT;
                }
            }
        }

        return newNode;
    }

    static boolean findNodeAndDelete(BST node, int valueToDelete) {
        boolean found = false;

        if (node != null) {
            if (node.value == valueToDelete) {
                found = true;
            } else {
                if (valueToDelete > node.value)
                    handleDeletionScenarios(node.rightNode, valueToDelete);
                else
                    handleDeletionScenarios(node.leftNode, valueToDelete);
            }
        }

        return found;
    }

    private static void handleDeletionScenarios(BST node, int newValue) {
        if (findNodeAndDelete(node, newValue)) {
            ArrayList<BST> childNodes = getDirectChildNodes(node);
            if (childNodes.size() == 0) {
                 if (node.direction == Direction.LEFT)
                     node.parentNode.leftNode = null;
                 else
                     node.parentNode.rightNode = null;
            }
            else if (childNodes.size() == 1) {
                if (node.direction == Direction.LEFT) {
                    node.parentNode.leftNode = childNodes.get(0);
                    node.parentNode.leftNode.parentNode = node.parentNode;
                    node.parentNode.leftNode.level = node.level;
                    node.parentNode.leftNode.direction = node.direction;
                }
                else {
                    node.parentNode.rightNode = childNodes.get(0);
                    node.parentNode.rightNode.parentNode = node.parentNode;
                    node.parentNode.rightNode.level = node.level;
                    node.parentNode.rightNode.direction = node.direction;
                }
            } else {
                // TODO implement inorder successor deletion logic
                System.out.println("Have not implemented inorder successor deletion yet...");
            }
        }
    }

    static boolean findIfBSTContainsElement(BST node, int value) {
        boolean contains = false;

        if (node != null) {
            if (node.value == value) {
                contains = true;
            } else if (value > node.value) {
                contains = findIfBSTContainsElement(node.rightNode, value);
            } else {
                contains = findIfBSTContainsElement(node.leftNode, value);
            }
        }

        return contains;
    }

    private static ArrayList<BST> getDirectChildNodes(BST node) {
        ArrayList<BST> childNodes = new ArrayList<>() {
            {
                add(node.leftNode);
                add(node.rightNode);
            }
        };
        childNodes.removeAll(Collections.singleton(null));
        return childNodes;
    }

}
