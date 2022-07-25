import java.util.*;

public class OpenAddress_HashTable<K, V> {
    // open addressing can store in array dierectly but not a linkedList
    // So do not need to have entry class
    protected K[] keys;
    protected V[] values;

    protected double maxLoadFactor;
    protected int capacity;
    protected int threshold;
    private static final int Default_Capacity = 7;
    private static final double Default_Load_Factor = 0.65;

    // use a TombStone fake key as a token to take the place while deleting the key
    protected final K TombStone = (K) (new Object());

    protected OpenAddress_HashTable() {
        this(Default_Capacity, Default_Load_Factor);
    }

    protected OpenAddress_HashTable(int capacity, double maxLoadFactor) {
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
        //copied from chain hash table.
        keys = (K[]) new Object[capacity];
        values = (V[]) new Object[capacity];
    }
}
