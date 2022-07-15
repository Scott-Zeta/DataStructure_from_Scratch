public class Test {
    public static void main(String[] args) throws Exception {
        D_LinkList<Integer> newList = new D_LinkList<>();
        newList.add(1);
        newList.add(2);
        newList.add(4);
        System.out.println("list: " + newList.toString());
        newList.addHead(0);
        newList.addAt(3, 3);
        System.out.println("list should add 0 at head, 3 at 3rd:" + newList.toString());
        newList.remove(3);
        newList.removeAt(2);
        System.out.println("2 and 3 should be removed:" + newList.toString());
        System.out.println("contain 1 or not? " + newList.contains(1));
        System.out.println("pop out the first element: " + newList.popFirst());
        System.out.println("first element should be removed:" + newList.toString());
        System.out.println("Where is element 4? " + newList.indexOf(4));
        System.out.println("Done");
    }
}
