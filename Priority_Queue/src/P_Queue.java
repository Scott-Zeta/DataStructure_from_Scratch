import java.util.List;
import java.util.ArrayList;

public class P_Queue <T extends Comparable<T>>{
    private List<T> heap;

    public P_Queue(int size){
        heap = new ArrayList<T>(size);
    }

    public P_Queue(){
        this(1);
    }

    public int size(){
        return heap.size();
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public T peek(){
        return heap.get(0);
    }

    public boolean contains(T element){
        for (int i = 0; i < size(); i++){
            if(heap.get(i).equals(element)){
                return true;
            }
        }
        return false;
    }
}
