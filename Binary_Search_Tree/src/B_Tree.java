public class B_Tree<T extends Comparable<T>> {

    private int size = 0;
    private Node root = null;

    private class Node {
        T data;
        Node left;
        Node right;

        public Node(T data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(T element) {
        return contains(element, root);
    }

    private boolean contains(T element, Node root) {
        if (root == null) {
            return false;
        }

        if (element.compareTo(root.data) < 0) {
            return contains(element, root.left);
        } else if (element.compareTo(root.data) > 0) {
            return contains(element, root.right);
        } else {
            return true;
        }
    }

    public boolean add(T element) {
        if (contains(element)) {
            System.out.println("element has already exist");
            return false;
        } else {
            add(element, root);
            return true;
        }
    }

    private Node add(T element, Node node) {
        if (node == null) {
            node = new Node(element, null, null);
            // when no node at this position, add it.
        } else {
            if (element.compareTo(node.data) < 0) {
                node.left = add(element, node.left);
            } else {
                node.right = add(element, node.right); // keep going deeper until reach the null.
            }
        }
        return node;// return the new node to its parents left or right
    }
}
