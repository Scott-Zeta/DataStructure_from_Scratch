import java.util.LinkedList;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws Exception {
        Chain_HashTable<Integer,String> numToFruit = new Chain_HashTable<>();
        numToFruit.add(1, "Apple");
        numToFruit.add(2, "banana");
        numToFruit.add(-20,"Tomato");
        System.out.println(numToFruit.isEmpty());
        System.out.println(numToFruit.toString());
        System.out.println(numToFruit.get(20));
        System.out.println(numToFruit.get(-20));
        System.out.println(numToFruit.containsKey(2));
        System.out.println(numToFruit.values());
        System.out.println(numToFruit.remove(1));
        numToFruit.remove(2);
        System.out.println(numToFruit.size());
        System.out.println(numToFruit.keys());
        numToFruit.clear();
        System.out.println(numToFruit.toString());
        System.out.println("Done");
    }
}
