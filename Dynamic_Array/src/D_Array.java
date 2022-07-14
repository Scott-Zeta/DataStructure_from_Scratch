@SuppressWarnings("unchecked")
public class D_Array<T> {
    //variable
    private T [] arr; //static array
    private int len = 0; //length that user thinks
    private int capacity = 0; //actual capacity size

    public D_Array(int capacity){
        if(capacity < 0) throw new IllegalArgumentException("Illegal Capacity:" + capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }
}
