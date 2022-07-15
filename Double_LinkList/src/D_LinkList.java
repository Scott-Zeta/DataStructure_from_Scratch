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
}
