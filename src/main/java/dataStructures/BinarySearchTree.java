package dataStructures;

public class BinarySearchTree {

    Node root;

    BinarySearchTree() {
        root = null;
    }

    Node insertKey(Node node, int key) {
        if (node == null) {
            node = new Node(key);
            return node;
        }

        if (key < node.key) {
            node.left = insertKey(node.left, key);
        } else if (key > node.key) {
            node.right = insertKey(node.right, key);
        }
        return node;
    }

    Node searchKey(Node root, int key) {
        if (root == null || root.key == key) {
            return root;
        }

        if (root.key < key) {
            return searchKey(root.right, key);
        }

        return searchKey(root.left, key);
    }

    class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
            this.left = this.right = null;
        }
    }


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Inserting nodes
        tree.root = tree.insertKey(tree.root, 50);
        tree.insertKey(tree.root, 30);
        tree.insertKey(tree.root, 20);
        tree.insertKey(tree.root, 40);
        tree.insertKey(tree.root, 70);
        tree.insertKey(tree.root, 60);
        tree.insertKey(tree.root, 80);

        // Key to be found
        int key = 6;

        // Searching in a BST
        if (tree.searchKey(tree.root, key) == null)
            System.out.println(key + " not found");
        else
            System.out.println(key + " found");

        key = 60;

        // Searching in a BST
        if (tree.searchKey(tree.root, key) == null)
            System.out.println(key + " not found");
        else
            System.out.println(key + " found");
    }
}

