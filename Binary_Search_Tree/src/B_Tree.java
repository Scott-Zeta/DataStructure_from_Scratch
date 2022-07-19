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
            root = add(element, root);
            size++;
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

    public void traversal() {
        inOrder(root);
    }

    private void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + ", ");
        inOrder(root.right);
    }

    public boolean remove(T element) {
        if (contains(element)) {
            root = remove(element, root); // connected to parent
            size--;
            return true;
        }
        return false;
    }

    private Node remove(T element, Node node) {
        if (node == null) {
            return null;
        }
        int compare = element.compareTo(node.data);
        if (compare < 0) {
            node.left = remove(element, node.left);
        } else if (compare > 0) {
            node.right = remove(element, node.right);
        } else {
            // if only have one child subtree, remove and connect directly
            if (node.right == null) {
                return node.left;
            } else if (node.left == null) {
                return node.right;
            } else {
                //if have two branch, use left largest or right smallest as candidate
                Node candidate = max(node.left);
                node.data = candidate.data;//copy the candidate's data to current one.
                node.left = remove(candidate.data, node.left);//remove the swaped node
            }
        }
        return node;
    }

    // help find min or max candidate
    private Node min(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private Node max(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
}
