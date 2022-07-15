import java.util.EmptyStackException;
import java.util.LinkedList;

public class Queue <T> {
    private LinkedList <T> list = new LinkedList<T>();
 
    public Queue(){
     //empty constructor
    }
 
    public Queue(T element){
     //constructor with first element.
     eat(element);
    }
 
    public int size(){
     return list.size();
    }
 
    public boolean isEmpty(){
     return size() == 0;
    }
 
    public void eat(T element){
     list.addFirst(element);
    }
 
    public T poop(){
     if(isEmpty()) throw new EmptyStackException();
     return list.removeLast();
    }
 
    public T peek(){
     if(isEmpty()) throw new EmptyStackException();
     return list.peekLast();
    }
 }
