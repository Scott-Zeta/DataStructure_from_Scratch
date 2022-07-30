import java.util.*;

public abstract class OpenAddress_HashTable<K, V> {
    // open addressing can store in array dierectly but not a linkedList
    // So do not need to have entry class
    protected K[] keys;
    protected V[] values;

    protected double maxLoadFactor;
    protected int capacity;
    protected int threshold;
    private static final int Default_Capacity = 7;
    private static final double Default_Load_Factor = 0.65;

    protected int size;// this does not include the tomb, they are the true key value, pair.
    protected int usedSlot;// this include the tomb, the number shows how many slots in the array has been
                           // taken.

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
        // copied from chain hash table.
        keys = (K[]) new Object[capacity];
        values = (V[]) new Object[capacity];
    }

    private int normalizeIndex(int keyHash) {
        return (keyHash & 0x7FFFFFFF) % capacity;
        // strip off the negative number by bit operation &, then get the index of the
        // slot by mod the key's hash code.
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) {
            keys[i] = null;
            values[i] = null;
        }
        size = 0;
        usedSlot = 0;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("{");
        for (int i = 0; i < capacity; i++) {
            if (keys[i] != null && keys[i] != TombStone) {
                result.append(keys[i] + "->" + values[i] + ",");
            }
        }
        result.append("}");
        return result.toString();
    }

    // abstract for different probing method
    protected abstract int probe(int x);

    protected void resize() {

    }

    protected V add(K key, V value) {
        if (key == null)
            throw new IllegalArgumentException("Null key");
        if (usedSlot >= threshold) {
            resize();
        }

        // regular insert slot without moving
        final int slot = normalizeIndex(key.hashCode());

        for (int i = slot, j = -1, x = 0;; i = normalizeIndex(slot + probe(x++))) {
            // j, slot index of non-tombston, -1 if no tomb
            // i=normlaizeIndex(slot + probe(x++)), iterate probing with increasing x,
            // x start with 1.(first iterate without prob)
            // I wonder why it doesn't start with 0.
            if (keys[i] == TombStone) {
                // if encouter the tomb.
                if (j == -1) {
                    // this is the first time encouter tomb
                    j = i;
                }
            } else if (keys[i] != null) {
                // 1. this is not the first time, but finally find the availible plauce
                // the i should already be updated by
                // the probe, i and j are not equal. i point to next possible j point
                // to last i, which is the tomb
                // 2. Also, may be never been met with the tomb.
                if (keys[i].equals(key)) {
                    // if the keys exist and equal, update
                    V oldValue = values[i];
                    if (j == -1) {
                        // if never enconter tomb, update regularly
                        values[i] = value;
                    } else {
                        // if last slot is a tomb
                        // ????????? why swap with last tombstone?
                        keys[i] = TombStone;
                        values[i] = null;
                        keys[j] = key;
                        values[j] = value;
                        // NB: swap tomb incase every iteration go through
                        // too many tomb slowly
                    }
                    return oldValue;
                }
            } else {
                if (j == -1) {
                    // tomb never been encounted
                    usedSlot++;
                    size++;
                    keys[i] = key;
                    values[i] = value;
                } else {
                    // insert at previous tomb
                    size++;
                    keys[j] = key;
                    values[j] = value;
                }
                return null;
            }
        }
    }

    public boolean hasKey(K key) {
        if (key == null)
            throw new IllegalArgumentException("null key");

        final int slot = normalizeIndex(key.hashCode());

        for (int i = slot, j = -1, x = 1;; i = normalizeIndex(slot + probe(x++))) {
            if (keys[i] == TombStone) {
                // if hit tomb, i and j will keep update
                if (j == -1)
                    j = i;
            } else if (keys[i] != null) {
                // hit the non-tomb non-null key
                if (keys[i].equals(key)) {
                    // If j != -1 this means we previously encountered a deleted cell.
                    // We can perform an optimization by swapping the entries in cells
                    // i and j so that the next time we search for this key it will be
                    // found faster. This is called lazy deletion/relocation
                    if (j != -1) {
                        keys[j] = keys[i];
                        values[j] = values[i];
                        keys[i] = TombStone;
                        values[i] = null;
                    }
                    return true;
                }
            } else
                return false;
        }
    }
}
