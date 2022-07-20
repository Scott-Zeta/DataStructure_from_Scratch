import java.util.*;

class Entry<K, V> {
    int hashCode;
    K key;
    V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
        this.hashCode = key.hashCode();
    }

    public boolean equals(Entry<K,V> anotherEntry){
        //if hash code are different, it must be different
        if(hashCode != anotherEntry.hashCode){
            return false;
        }
        //if hash code are same, might be the same, need to compare
        return key.equals(anotherEntry.key);
    }

    @Override
    public String toString(){
        return key + "->" + value;
    }
}

public class Chain_HashTable<K,V> {
    //load factor = number of entries / total size of array or table slot
    // 0.5 load factor = half full, conllision relavent.
    private static final int Deafault_Capacity = 3;
    private static final double Deafault_Load_Factor = 0.75;

    private double maxLoadFactor;
    private int capacity;
    private int threshold;
    private int size;
    private LinkedList<Entry<K,V>>[] slotArray; //the list contains entries with same slot

    public Chain_HashTable(int capacity, double maxLoadFactor){
        if(capacity<0) throw new IllegalArgumentException("Illegal capacity");
        //prevent it from negative, x/0 = infinite, sqrt(-1) = imaginary number
        if(maxLoadFactor <=0 || Double.isNaN(maxLoadFactor) || Double.isInfinite(maxLoadFactor)) 
            throw new IllegalArgumentException("Illegal maxLoadFactor");
        this.maxLoadFactor = maxLoadFactor;
        this.capacity = Math.max(capacity,Deafault_Capacity);
        //When over the threshold, like LoadFactor =0.75, 100 slots with 75 full, expand the hash table and do something else
        threshold = (int)(this.capacity * maxLoadFactor);
        //for each slot, a new linkedList for chain.
        slotArray = new LinkedList[this.capacity];
    }
}
