public class D_LinkList <T>{
    private class Node <Y>{
        T data;
        Node<T> prev;
        Node<T> next;
        public Node(T data, Node<T> prev, Node<T> next){
            this.data = data;
            this. prev = prev;
            this. next = next;
        }

        @Override
        public String toString(){
            return data.toString();
        }
    }

    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    public void clear(){
        Node<T> pinPoint = head;
        while(pinPoint != null){
            Node<T> nextStep = pinPoint.next;
            pinPoint.data = null;
            pinPoint.prev = null;
            pinPoint.next = null;
            pinPoint = nextStep;
        }
        head = tail = pinPoint = null;
        size = 0;
    }   

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public void add(T element){
        if(isEmpty()){
            head = tail = new Node<>(element, null, null);
        }else{
            tail.next = new Node<>(element, tail, null);
            tail = tail.next;
        }
        size++;
    }
    
}
