import java.util.EmptyStackException;
import java.util.LinkedList;

public class Stack <T> {
   private LinkedList <T> list = new LinkedList<T>();

   public Stack(){
    //empty constructor
   }

   public Stack(T element){
    //constructor with first element.
    push(element);
   }

   public int size(){
    return list.size();
   }

   public boolean isEmpty(){
    return size() == 0;
   }

   public void push(T element){
    list.addFirst(element);
   }

   public T pop(){
    if(isEmpty()) throw new EmptyStackException();
    return list.removeFirst();
   }

   public T peek(){
    if(isEmpty()) throw new EmptyStackException();
    return list.peekFirst();
   }
}
