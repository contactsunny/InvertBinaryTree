package com.contactsunny.poc.invertbinarytree;

public class App {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);

        node1.setChildren(node2, node3);
        node2.setChildren(node4, node5);
        node3.setChildren(node6, node7);
        node4.setChildren(node8, node9);

        System.out.println("Given binary tree");
        System.out.println(traversePreOrder(node1));
        System.out.println("--------------------");

        invertBinaryTree(node1);

        System.out.println("Inverted binary tree");
        System.out.println(traversePreOrder(node1));
        System.out.println("--------------------");
    }

    /**
     * Method to invert a binary tree.
     *
     * @param node The node at which inversion is to happen.
     */
    private static void invertBinaryTree(Node node) {
        // Checking if we've hit the leaf of a tree
        if (node != null) {
            // Getting pointers to the left and the right child of the
            // binary tree, which has to be used for inversion.
            Node left = node.getLeft();
            Node right = node.getRight();
            // Inverting the children of the node.
            node.setRight(left);
            node.setLeft(right);
            // Recursively inverting the right and left children of the tree.
            invertBinaryTree(node.getLeft());
            invertBinaryTree(node.getRight());
        }
    }

    public static String traversePreOrder(Node root) {

        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.getValue());

        String pointerRight = "└──";
        String pointerLeft = (root.getRight() != null) ? "├──" : "└──";

        traverseNodes(sb, "", pointerLeft, root.getLeft(), root.getRight() != null);
        traverseNodes(sb, "", pointerRight, root.getRight(), false);

        return sb.toString();
    }

    public static void traverseNodes(StringBuilder sb, String padding, String pointer, Node node, boolean hasRightSibling) {
        if (node != null) {
            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getValue());

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└──";
            String pointerLeft = (node.getRight() != null) ? "├──" : "└──";

            traverseNodes(sb, paddingForBoth, pointerLeft, node.getLeft(), node.getRight() != null);
            traverseNodes(sb, paddingForBoth, pointerRight, node.getRight(), false);
        }
    }
}
