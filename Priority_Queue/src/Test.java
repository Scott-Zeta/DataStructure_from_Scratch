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
        System.out.println(minqueue.removeAt(1));
        System.out.println(minqueue.removeAt(6));
        System.out.println(minqueue.removeAt(9));
        System.out.println("is it still minHeap? " + minqueue.isP_Queue(0));
        System.out.println("what size? should be 6 " + minqueue.size());
        System.out.println(minqueue.toString());
        minqueue.add(23);
        minqueue.add(-6);
        minqueue.add(-83);
        minqueue.add(-29);
        minqueue.add(35);
        System.out.println(minqueue.toString());
        System.out.println("should poll -83: " + minqueue.poll());
        System.out.println("next should be -29: " + minqueue.peek());
        System.out.println("is it still minHeap? " + minqueue.isP_Queue(0));
        System.out.println(minqueue.toString());
        while(minqueue.size() > 0){
            System.out.print(minqueue.poll() + ",");
        }
        System.out.println("Done");
    }
}
