public class Test {
    public static void main(String[] args) throws Exception {
        P_Queue<Integer> minqueue = new P_Queue<>();
        minqueue.add(6);
        minqueue.add(10);
        minqueue.add(85);
        minqueue.add(43);
        minqueue.add(63);
        minqueue.add(-2);
        minqueue.add(25);
        minqueue.add(-13);
        System.out.println("is it still minHeap? " + minqueue.isP_Queue(0));
        System.out.println("First number? Should be -13: " + minqueue.peek());
        System.out.println("Done");
    }
}
