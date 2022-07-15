public class D_LinkList<T> {
    private class Node<Y> {
        T data;
        Node<T> prev;
        Node<T> next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    public void clear() {
        Node<T> pinPoint = head;
        while (pinPoint != null) {
            Node<T> nextStep = pinPoint.next;
            pinPoint.data = null;
            pinPoint.prev = null;
            pinPoint.next = null;
            pinPoint = nextStep;
        }
        head = tail = pinPoint = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void add(T element) {
        if (isEmpty()) {
            head = tail = new Node<T>(element, null, null);
        } else {
            tail.next = new Node<T>(element, tail, null);
            tail = tail.next;
        }
        size++;
    }

    public void addHead(T element) {
        if (isEmpty()) {
            head = tail = new Node<T>(element, null, null);
        } else {
            head.prev = new Node<T>(element, null, head);
            head = head.prev;
        }
        size++;
    }

    public void addAt(int index, T element) throws Exception {
        if (index < 0 || index > size)
            throw new Exception("invalid Index");
        if (index == 0) {
            addHead(element);
            return;
        }
        if (index == size) {
            add(element);
            return;
        }

        Node<T> pinpoint = head;
        for (int i = 0; i < index; i++) {
            pinpoint = pinpoint.next;
        }

        Node<T> newNode = new Node<T>(element, pinpoint.prev, pinpoint); // put the new node before pinpoint
        pinpoint.prev.next = newNode;
        pinpoint.prev = newNode;

        size++;
    }

    public T getFirst() {
        if (isEmpty())
            throw new RuntimeException("Empty List");
        return head.data;
    }

    public T getLast() {
        if (isEmpty())
            throw new RuntimeException("Empty List");
        return tail.data;
    }

    public T popFirst() {
        if (isEmpty())
            throw new RuntimeException("Empty List");
        T data = head.data;
        head = head.next;
        size--;

        if (isEmpty()) {
            tail = null;
        } else
            head.prev = null;

        return data;
    }

    public T popLast() {
        if (isEmpty())
            throw new RuntimeException("Empty List");
        T data = tail.data;
        tail = tail.prev;
        size--;

        if (isEmpty()) {
            head = null;
        } else
            tail.next = null;

        return data;
    }

    private T remove(Node<T> node) {
        // remove by node
        if (node.equals(head)) {
            return popFirst();
        }
        if (node.equals(tail)) {
            return popLast();
        }

        T data = node.data;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.data = null;
        node = node.next = node.prev = null;// clean the node
        size--;

        return data;
    }

    public T removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }

        Node<T> pinpoint;
        if (index < size / 2) {
            // if the index is at first half of link list
            pinpoint = head;
            for (int i = 0; i != index; i++) {
                pinpoint = pinpoint.next;
            }
        } else {
            // index is at second half of link list
            pinpoint = tail;
            for (int i = size - 1; i != index; i--) {
                pinpoint = pinpoint.prev;
            }
        }

        return remove(pinpoint);
    }

    public boolean remove(Object element) {
        for (Node<T> pinpoint = head; pinpoint != null; pinpoint = pinpoint.next) {
            if (element.equals(pinpoint.data)) {
                remove(pinpoint);
                return true;
            }
        }
        return false;
    }

    public int indexOf(Object element) {
        int index = 0;
        for (Node<T> pinpoint = head; pinpoint != null; pinpoint = pinpoint.next, index++) {
            if (element.equals(pinpoint.data)) {
                return index;
            }
        }
        return -1;
    }

    public boolean contains(Object element) {
        return indexOf(element) != -1;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        Node<T> pinpoint = head;
        while (pinpoint != null) {
            result.append(pinpoint.data.toString());
            if (pinpoint.next != null) {
                result.append(",");
            }
            pinpoint = pinpoint.next;
        }
        result.append("]");
        return result.toString();
    }
}
