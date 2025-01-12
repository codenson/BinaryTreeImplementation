/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.solocoding.binarytreeimplementation;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Binary tree implementation. the code includes methods to build and search the
 * tree.
 *
 * @author guero
 */
public class BinaryTreeImplementation {

    /**
     * Root of the tree.
     */
    private node root = null;

    /**
     * Root getter.
     *
     * @return this root.
     */
    public node rootGetter() {
        return this.root;
    }

    /**
     * Method to populate data into the binary tree.
     *
     * @param data data to be inserted into the tree.
     */
    protected void populateRoot(int data) {
        if (root == null) {
            root = new node(data);

        } else {

            populateData(root, data);

        }

    }

    /**
     * Method to populate data into the binary tree.
     *
     * @param temp tree root.
     * @param data data to be inserted into the tree.
     */
    private void populateData(node temp, int data) {
        if (temp == null) {
            return;
        }

        {

            if (data < temp.data) {
                if (temp.left != null) {
                    populateData(temp.left, data);
                } else {
                    temp.left = new node(data);
                    return;

                }

            } else {
                if (temp.right != null) {
                    populateData(temp.right, data);
                } else {
                    temp.right = new node(data);
                    return;
                }

            }

        }

        return;

    }

    /**
     * Method to calculate the distance between two nodes.
     *
     * @param temp The temprary root.
     * @param nodeData initial node to start the search from.
     * @param target the targeted final node
     * @return the number of branches seperating two nodes. returns -1 if a node
     * does not exist in tree.
     */
    protected int backTrackCounter(node temp, int nodeData, int target) {

        node localRoot = findCommonroot(temp, nodeData, target);

        int branch1 = countBranchesFromNode(localRoot.data, nodeData);
        int branch2 = countBranchesFromNode(localRoot.data, target);
        if (branch1 == -1 || branch2 == -1) {
            return -1;
        }

        if ((nodeData < localRoot.data && target > localRoot.data) || (nodeData > localRoot.data && target < localRoot.data)) {
            return branch1 + branch2;

        } else {
            return Math.abs(branch1 - branch2);

        }

    }

    /**
     * Method to find common root between two nodes.
     *
     * @param temp The root to start the search from.
     * @param target1 first node.
     * @param target2 second node.
     * @return the common root between two nodes.
     */
    private node findCommonroot(node temp, int target1, int target2) {
        if (temp == null) {
            return temp;
        }
        if (target1 < temp.data && target2 > temp.data) {
            return temp;
        } else if (target1 < temp.data && target2 < temp.data) {

            temp = findCommonroot(temp.left, target1, target2);

        } else if (target1 > temp.data && target2 > temp.data) {

            temp = findCommonroot(temp.right, target1, target2);

        }

        return temp;

    }

    /**
     * Method to count how many branches the target node is from the root. It
     * retrieves the local root node.
     *
     * @param localRoot the val of the node to look for its distance from the
     * @param nodeTarget
     * @return -1 if the targeted node does not exist in the tree., otherwise,
     * returns branch distance from the local root.
     */
    protected int countBranchesFromNode(int localRoot, int nodeTarget) {

        node temp = findNode(root, localRoot);
        if (temp == null) {
            return -1;
        }
        return searchSteps(temp, nodeTarget);
    }

    /**
     * Method to check if a node exists in the tree.
     *
     * @param temp local root.
     * @param data the data carried in the searched for node.
     * @return null if the node does not exist in the tree, other wise return
     * the node if found.
     */
    protected node findNode(node temp, int data) {
        node target = null;

        if (temp == null) {

            return null;
        }

        if (temp.data == data) {

            return temp;
        }
        if (data < temp.data) {

            temp = findNode(temp.left, data);

        } else if (data > temp.data) {

            temp = findNode(temp.right, data);
        }

        return temp;

    }

    /**
     * Method to return the distance of a node from the local root.
     *
     * @param temp local root.
     * @param data data of the target node.
     * @return the distance of branches from two nodes in the tree.
     */
    private int searchSteps(node temp, int data) {
        int count = 0;

        if (temp == null) {
            count = -1;

            return -1;

        }
        if (temp.data == data) {

            return 0;

        } else if (data < temp.data) {
            int num = searchSteps(temp.left, data);
            if (num == -1) {

                return -1;
            } else {
                return num + 1;
            }

        } else if (data > temp.data) {
            int num = searchSteps(temp.right, data);
            if (num == -1) {

                return -1;
            } else {
                return num + 1;
            }

        }

        return count;

    }

    /**
     * Method to perform in-order nodes printing of the binary tree.
     *
     * @param temp root.
     */
    protected void print(node temp) {

        if (temp == null) {

            return;
        }

        print(temp.left);
        System.out.println(temp.data);
        print(temp.right);

        return;

    }

    /**
     * Method to print the tree in reverse.
     *
     * @param temp root.
     */
    private void printInreverseOrder(node temp) {
        if (temp == null) {

            return;
        }
        printInreverseOrder(temp.right);
        System.out.println(temp.data);
        printInreverseOrder(temp.left);

    }

    /**
     * Method to perform breadth first printing.
     *
     * @param temp root.
     */
    private void printBreadthFirst(node temp) {

        Queue<node> q = new LinkedList();

        q.add(temp);

        while (!q.isEmpty()) {

            System.out.print(" " + q.peek().data);
            if (q.peek().left != null) {
                q.add(q.peek().left);
            }
            if (q.peek().right != null) {
                q.add(q.peek().right);
            }

            q.poll();

        }

    }

    /**
     * Method prints a range of the tree from the local root fed into it. Ex: it
     * prints the nodes from 30-30 which in this case means it prints half a
     * tree. or it prints any range ex: 30- 100 where it d print everything upto
     * node with val 100. Prints in order.
     *
     * @param temp root node to start from.
     * @param targetVal the target to stop printing at.
     */
    private void printHalfTree(node temp, int targetVal) {
        if (temp == null) {
            return;
        }

        printHalfTree(temp.left, targetVal);

        if (temp.data > targetVal) {
            return;

        }
        System.out.print(temp.data + " ");
        printHalfTree(temp.right, targetVal);

    }

    /**
     * Method to print odd or even levels.
     *
     * @param temp root
     * @param counter counter to keep track of the current level.
     * @param level takes 0 for even levels and 1 for odd levels.
     * @return current level.
     */
    private int skipLevel(node temp, int counter, int level) {

        if (temp == null) {
            return counter;
        }

        if (counter++ % 2 == level) {
            System.out.print(temp.data + ",");
        }
        skipLevel(temp.left, counter, level);
        skipLevel(temp.right, counter, level);

        return counter;

    }

    /**
     * Method to print leafs
     *
     * @param temp root of the tree.
     */
    private void printLeafs(node temp) {

        if (temp == null) {
            return;
        }

        printLeafs(temp.left);
        if (temp.left == null && temp.right == null) {
            System.out.println(" -- " + temp.data);

        }
        printLeafs(temp.right);

    }

    /**
     * Main method for running and testing the program.
     *
     * @param args
     */
    public static void main(String[] args) {
        // TODO code application logic here

        BinaryTreeImplementation mast = new BinaryTreeImplementation();
        mast.populateRoot(30);
        mast.populateRoot(40);
        mast.populateRoot(20);
        mast.populateRoot(100);
        mast.populateRoot(0);
        mast.populateRoot(-100);
        mast.populateRoot(27);
        mast.populateRoot(35);
        mast.populateRoot(90);
        mast.populateRoot(80);
        mast.populateRoot(10);
        mast.populateRoot(5);
        mast.populateRoot(12);
        mast.populateRoot(95);
        mast.populateRoot(120);
        mast.populateRoot(115);
        mast.populateRoot(130);
        mast.populateRoot(-200);
        mast.print(mast.root);
        int val = mast.backTrackCounter(mast.root, -200, -200);
        System.err.println("****" + val);
        node p = mast.root;
        mast.printHalfTree(p.right, 115);

    }

    protected class node {

        /**
         * Data to be inserted into the node.
         */
        private int data;
        /**
         * Node's pointers to left and right.
         */
        private node left, right;

        /**
         * Constuctor for the node.
         *
         * @param data
         */
        public node(int data) {
            this.data = data;

        }

        /**
         * Data getter
         *
         * @return this data.
         */
        public int dataGetter() {
            return this.data;
        }

    }

}
