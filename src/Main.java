public class Main {
    public static void main(String[] args) {
        BTree newTree = new BTree(3);

        double size = 1_0_000d;

        for (int i = 0; i < size; i++) {
            newTree.insert(i);
        }
        newTree.print();
        System.out.println();
        newTree.remove(3);
        newTree.print();
        System.out.println();
        for (int i = 10; i < 100; i++) {
            newTree.remove(i);
        }
        newTree.print();
    }
}