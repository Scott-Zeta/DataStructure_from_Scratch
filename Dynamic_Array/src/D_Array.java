@SuppressWarnings("unchecked")
public class D_Array<T> {
    // variable
    private T[] arr; // static array
    private int len = 0; // length that user thinks
    private int capacity = 0; // actual capacity size

    public D_Array(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("Illegal Capacity:" + capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public D_Array(){
        this(16); //default capacity without parameters
    }

    public int size() {
        return len;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(int index){
        if(index > len-1 || index < 0) throw new IndexOutOfBoundsException();
        return arr[index];
    }

    public void set(int index, T element){
        if(index > len-1 || index < 0) throw new IndexOutOfBoundsException();
        arr[index] = element;
    }

    public void add(T element){
        if(len + 1 > capacity){
            if(capacity == 0){
                capacity = 1;
            }else{
                capacity *= 2;
            }
            T[] new_arr = (T[]) new Object[capacity];
            for(int i = 0; i < len; i++){
                new_arr[i] = arr[i];
            }
            arr = new_arr;//new array with twice larger capacity
        }
        arr[len] = element;
        len++;
    }

    public void clear(){
        for(int i = 0; i < capacity; i++){
            arr[i] = null;
        }
        len = 0;
    }

    //remove and pop out the removed element
    public T removeAt(int index){
        if(index < 0 || index > len - 1) throw new IndexOutOfBoundsException();
        T popout = arr[index];
        T[] new_arr = (T[]) new Object[len - 1];
        for(int i = 0, j = 0; i < len; i++, j++){
            if (i == index){
                i++;
            }
            new_arr[j] = arr[i];
        }
        arr = new_arr;
        capacity = len--;
        return popout;
    }
}
