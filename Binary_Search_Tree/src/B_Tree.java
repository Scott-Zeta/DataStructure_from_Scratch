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
}
