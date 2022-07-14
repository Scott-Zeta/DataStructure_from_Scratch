public class Test {
    public static void main(String[] args) throws Exception {
        D_Array arr1 = new D_Array<>();
        System.out.println("size of array:" + arr1.size());
        System.out.println("is empty?" + arr1.isEmpty());
        arr1.add("element0");
        System.out.println("size of array: " + arr1.size());
        System.out.println("is empty? " + arr1.isEmpty());
        System.out.println("element from index 0? " + arr1.get(0));
        arr1.set(0, "element1");
        System.out.println("element from index 0? " + arr1.get(0));
        arr1.add("element3");
        System.out.println("size of array:" + arr1.size());
        arr1.clear();
        System.out.println("size of array:" + arr1.size());

        arr1.add(1);
        arr1.add(2);
        arr1.add(3);
        arr1.removeAt(1);
        System.out.println("element from index 0? " + arr1.get(0));
        System.out.println("element from index 1? " + arr1.get(1));
        System.out.println("Done");
    }
}
