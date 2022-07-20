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

public class Chain_HashTable {

}
