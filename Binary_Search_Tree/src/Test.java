public class Test {
    public static void main(String[] args) throws Exception {
        B_Tree<Integer> tree1 = new B_Tree<>();
        tree1.add(5);
        tree1.add(4);
        System.out.println(tree1.contains(5));
        tree1.add(3);
        tree1.add(7);
        tree1.add(6);
        System.out.println(tree1.contains(5));
        tree1.traversal();
        System.out.println("Done");
    }
}
