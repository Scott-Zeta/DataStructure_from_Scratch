import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception {
        LinkedList<String>[] listArray = new LinkedList[10];
        listArray[1] = new LinkedList<>();
        listArray[1].add("Apple");
        System.out.println(listArray[1].contains("Apple"));
        
        LinkedList<String> copyList = listArray[1];
        copyList.remove("Apple");
        System.out.println(copyList.size());
        System.out.println(listArray[1].size());
        System.out.println(listArray[1].contains("Apple")); 
        System.out.println("Done");
    }
}
