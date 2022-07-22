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

    public boolean equals(Entry<K, V> anotherEntry) {
        // if hash code are different, it must be different
        if (hashCode != anotherEntry.hashCode) {
            return false;
        }
        // if hash code are same, might be the same, need to compare
        return key.equals(anotherEntry.key);
    }

    @Override
    public String toString() {
        return key + "->" + value;
    }
}

public class Chain_HashTable<K, V> {
    // load factor = number of entries / total size of array or table slot
    // 0.5 load factor = half full, conllision relavent.
    private static final int Default_Capacity = 3;
    private static final double Default_Load_Factor = 0.75;

    private double maxLoadFactor;
    private int capacity;
    private int threshold;
    private int size;
    private LinkedList<Entry<K, V>>[] slotArray; // the list contains entries with same slot

    public Chain_HashTable(int capacity, double maxLoadFactor) {
        if (capacity < 0)
            throw new IllegalArgumentException("Illegal capacity");
        // prevent it from negative, x/0 = infinite, sqrt(-1) = imaginary number
        if (maxLoadFactor <= 0 || Double.isNaN(maxLoadFactor) || Double.isInfinite(maxLoadFactor))
            throw new IllegalArgumentException("Illegal maxLoadFactor");
        this.maxLoadFactor = maxLoadFactor;
        this.capacity = Math.max(capacity, Default_Capacity);
        // When over the threshold, like LoadFactor =0.75, 100 slots with 75 full,
        // expand the hash table and do something else
        threshold = (int) (this.capacity * maxLoadFactor);
        // for each slot, a new linkedList for chain.
        slotArray = new LinkedList[this.capacity];
    }

    public Chain_HashTable() {
        this(Default_Capacity, Default_Load_Factor);
    }

    public Chain_HashTable(int capacity) {
        this(capacity, Default_Load_Factor);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void clear() {
        // empty all slot linked lists
        Arrays.fill(slotArray, null);
        size = 0;
    }

    public boolean containsKey(K key){
        int slotIndex = normalizeIndex(key.hashCode());
        return searchEntryInSlot(slotIndex, key) != null;
    }

    private int normalizeIndex(int keyHash) {
        return (keyHash & 0x7FFFFFFF) % capacity;
        // strip off the negative number by bit operation &, then get the index of the
        // slot by mod the key's hash code.
    }

    private Entry<K, V> searchEntryInSlot(int slotIndex, K key) {
        // see if the key exsist in the particular slot.
        if (key == null) {
            return null;
        }
        LinkedList<Entry<K, V>> slot = slotArray[slotIndex];
        for (Entry<K, V> entry : slot) {
            if (entry.key.equals(key)) {
                return entry;
            }
        }
        return null;
    }

    public V remove(K key) {
        if (key == null) {
            return null;
        }
        int slotindex = normalizeIndex(key.hashCode());
        return removeInSlot(slotindex, key);
    }

    private V removeInSlot(int slotIndex, K key){
        Entry<K,V> entry = searchEntryInSlot(slotIndex, key);
        if(entry != null){
            V value = entry.value;
            //since linkedlist and similar datastruture is actually a memeory address, like a pointer to particalur info.
            //So remove the element in the new list that point to the same address will also work for the original list.
            LinkedList<Entry<K,V>> links = slotArray[slotIndex];
            links.remove(entry);
            size--;
            return value;
        }else{
            return null;
        }
    }
}
