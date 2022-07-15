public class Test {
    public static void main(String[] args) throws Exception {
        Stack<String> stack1 = new Stack<String>("AAA");
        System.out.println("current size: " + stack1.size());
        stack1.push("BBB");
        System.out.println("current size: " + stack1.size());
        System.out.println("should be BBB:" + stack1.peek());
        System.out.println("BBB been pop out:" + stack1.pop());
        stack1.push("CCC");
        System.out.println("should be CCC:" + stack1.peek());
        System.out.println("empty? should not:" + stack1.isEmpty());
        System.out.println("Done");
    }
}
