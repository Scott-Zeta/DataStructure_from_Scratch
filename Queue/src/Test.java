public class Test {
    public static void main(String[] args) throws Exception {
        Queue<String> q1 = new Queue<>("Apple");
        q1.eat("Banana");
        System.out.println(q1.peek());
        System.out.println(q1.poop());
        System.out.println(q1.peek());
        System.out.println(q1.size());
        q1.poop();
        System.out.println(q1.isEmpty());
        System.out.println("Done");
    }
}
