import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        BTree newTree = new BTree(3);

        double size = 30_000_000d;

        long startTime = System.nanoTime();

        for (int i = 0; i < size; i++) {
            newTree.insert(ThreadLocalRandom.current().nextInt());
        }

        long endTime = System.nanoTime();

        long elapsedTime = endTime - startTime;

        double elapsedTimeInSeconds = (double) elapsedTime / 1_000_000_000;

        System.out.println("insertion time: " + elapsedTimeInSeconds + " seconds");
    }
}