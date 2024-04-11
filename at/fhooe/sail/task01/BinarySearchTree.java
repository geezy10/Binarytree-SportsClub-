package at.fhooe.sail.task01;

import java.lang.Comparable;
import java.lang.String;
import java.lang.StringBuilder;

import javax.xml.crypto.Data;

public class BinarySearchTree<T extends Comparable<T>> {
    protected class BinaryTreeNode {
        public BinaryTreeNode left;
        public BinaryTreeNode right;
        public T data;

        public BinaryTreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * Root node of the tree.
     **/
    protected BinaryTreeNode root;
    /**
     * Number of elements stored in the tree.
     */
    protected int size;

    /**
     * Inserts the given element. Duplicate elements are not allowed. Returns true
     * if insertion was successful, false otherwise.
     */
    public boolean insert(T elem) {
        if (find(elem))
            return false; // Element already exists, insertion failed

        BinaryTreeNode newNode = new BinaryTreeNode(elem);
        if (root == null) { // If the tree is empty
            root = newNode;
            size++;
            return true; // Insertion successful
        }

        BinaryTreeNode temp = root;
        BinaryTreeNode parent = null;

        while (temp != null) {
            parent = temp;
            if (elem.compareTo(temp.data) < 0) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        // place was found, insert left or right from parent
        if (elem.compareTo(parent.data) < 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        size++;
        return true;
    }

    /**
     * Searches for the (first) element with the given key. Returns true if it could
     * be found, false otherwise.
     */
    public boolean find(T key) {
        if (root == null)
            return false;
        BinaryTreeNode temp = root;
        while (temp != null) {
            if (temp.data.compareTo(key) == 0)
                return true; // key found
            if (key.compareTo(temp.data) < 0)
                temp = temp.left;
            else
                temp = temp.right;
        }
        return false;

    }

    /**
     * Removes the element with the given key. Returns true if the key could be
     * found (and removed), false otherwise.
     */
    public boolean remove(T key) {
        if (root == null)
            return false; // empty

        BinaryTreeNode parent = null;
        BinaryTreeNode remove = root;

        // Find the node to remove and its parent
        while (remove != null) {
            if (key.compareTo(remove.data) < 0) {
                parent = remove;
                remove = remove.left;
            } else if (key.compareTo(remove.data) > 0) {
                parent = remove;
                remove = remove.right;
            } else {
                break; // key found
            }
        }

        if (remove == null) // Key not found
            return false;

        // Case 1: no child
        if (remove.left == null && remove.right == null) {
            if (parent == null) { // remove is the root
                root = null;
            } else if (remove.data.compareTo(parent.left.data) == 0) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        // Case 2: one child
        else if (remove.left == null) {
            if (parent == null) {
                root = remove.right;
            } else if (remove.data.compareTo(parent.left.data) == 0) {
                parent.left = remove.right;
            } else {
                parent.right = remove.right;
            }
        } else if (remove.right == null) {
            if (parent == null) {
                root = remove.left;
            } else if (remove.data.compareTo(parent.left.data) == 0) {
                parent.left = remove.left;
            } else {
                parent.right = remove.left;
            }
        }
        // Case 3: two children
        else {
            BinaryTreeNode successor = remove.right;
            BinaryTreeNode successorParent = remove;

            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            if (parent == null) {
                root = successor;
            } else if (remove.data.compareTo(parent.left.data) == 0) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }

            successor.left = remove.left;

            if (remove.right != successor) {
                successorParent.left = successor.right;
                successor.right = remove.right;
            }
        }

        size--;
        return true;
    }

    /**
     * Returns the number of elements stored in the tree.
     */
    public int size() {
        return size;
    }

    /**
     * Returns the parent element of the given key. Integer.MIN_VALUE if no parent
     * can be found.
     */
    public T getParent(T key) {
        if (root == null || root.data.compareTo(key) == 0) {
            return null;
        }

        BinaryTreeNode parent = null;
        BinaryTreeNode temp = root;

        while (temp != null) {
            if (key.compareTo(temp.data) < 0) {
                parent = temp;
                temp = temp.left;
            } else if (key.compareTo(temp.data) > 0) {
                parent = temp;
                temp = temp.right;
            } else {
                return parent.data;
            }
        }
        return null;

    }

    /**
     * Returns the elements of the tree in ascending (inorder traversal) or
     * descending (reverse inorder traversal) order.
     */
    public T[] toArray(boolean ascending) { // Left -> Root -> Right
        T[] array = (T[]) new Comparable[size];
        if (root != null) {
            if (ascending) {
                toArrayAscending(root, array, 0);
            } else {
                toArrayDescending(root, array, 0);
            }
        }
        return array;
    }

    private int toArrayAscending(BinaryTreeNode node, T[] array, int index) {
        if (node != null) {
            // call method with left child
            index = toArrayAscending(node.left, array, index);
            // when node.left is null, set node to index and increment index
            array[index++] = node.data;
            // check if there is a right node
            index = toArrayAscending(node.right, array, index);
        }
        return index;
    }

    private int toArrayDescending(BinaryTreeNode node, T[] array, int index) {
        if (node != null) {
            index = toArrayDescending(node.right, array, index);
            array[index++] = node.data;
            index = toArrayDescending(node.left, array, index);
        }
        return index;
    }

    /**
     * Returns the elements of the tree (postorder traversal).
     */
    public T[] toArrayPostOrder() { // Left -> Right -> Root
        T[] array = (T[]) new Comparable[size];
        if (root != null) {
            toArrayPost(root, array, 0);
        }
        return array;
    }

    private int toArrayPost(BinaryTreeNode node, T[] array, int index) {
        if (node != null) {
            index = toArrayPost(node.left, array, index);
            index = toArrayPost(node.right, array, index);
            array[index++] = node.data;
        }
        return index;
    }

    /**
     * Returns the elements of the tree (preorder traversal).
     */
    public T[] toArrayPreOrder() { // Root -> Left -> Right
        T[] array = (T[]) new Comparable[size];
        if (root != null) {
            toArrayPre(root, array, 0);
        }
        return array;
    }

    private int toArrayPre(BinaryTreeNode node, T[] array, int index) {
        if (node != null) {
            array[index++] = node.data;
            index = toArrayPre(node.left, array, index);
            index = toArrayPre(node.right, array, index);
        }
        return index;
    }

    /**
     * Returns largest number stored in the tree. Integer.MIN_VALUE if no largest
     * element can be found
     */
    public T max() {
        if (root == null)
            return null;

        BinaryTreeNode temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp.data;

    }

    /**
     * Returns smallest number stored in the tree. Integer.MIN_VALUE if no smallest
     * element can be found
     */
    public T min() {
        if (root == null)
            return null;

        BinaryTreeNode temp = root;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp.data;
    }

    public String toString() {
        return toString(root, 0);
    }

    private String toString(BinaryTreeNode node, int level) {
        StringBuilder builder = new StringBuilder();

        if (node != null) {
            // Append right subtree
            builder.append(toString(node.right, level + 1));

            // Append current node
            for (int i = 0; i < level; i++) {
                builder.append("        ");
            }
            builder.append(node.data).append("\n");

            // Append left subtree
            builder.append(toString(node.left, level + 1));
        }

        return builder.toString();
    }

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(17);
        tree.insert(16);
        tree.insert(34);
        tree.insert(5);
        tree.insert(12);
        tree.insert(4);
        tree.insert(20);
        tree.insert(24);
        tree.insert(40);
        System.out.println(tree.insert(17));
        System.out.println(tree.size);
        System.out.println(tree.max());
        System.out.println(tree.min());
        System.out.println(tree.find(4));
        System.out.println(tree.find(18));
        System.out.println(tree.find(34));
        System.out.println(tree.find(5));
        System.out.println(tree.getParent(5));
        System.out.println(tree.getParent(34));
        System.out.println(tree.remove(34));
        System.out.println(tree.size);
        System.out.println(tree.find(34));
        System.out.println(tree.max());
        System.out.println(tree.getParent(5));
        System.out.println(tree.find(34));

        Comparable[] ascendingArray = tree.toArray(true);
        System.out.println("Ascending Order: ");
        for (int i = 0; i < ascendingArray.length; i++) {
            System.out.print(ascendingArray[i] + " ");


            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("!!!  Please rotate your head to 90° !!! ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("root");
            System.out.println("|");
            System.out.println("V");
            System.out.println(tree.toString());
        }
    }
}
