import org.junit.jupiter.api.Order;
import org.testng.annotations.Test;

import java.text.DecimalFormat;
import java.util.Random;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class TimeTest {
    Random random = new Random();

    public static final int size = 10_000_000;
    public final int value = random.nextInt(10_000_000);
    BTree testTree = new BTree(3);

    @Test
    @Order(1)
    public void A_RandomInsertionTime() {
        System.out.printf("Test is for %d elements %n", size);
        long startTime = System.nanoTime();

        for (int i = 0; i < size; i++) {
            testTree.insert(ThreadLocalRandom.current().nextInt());
        }

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        double elapsedTimeInSeconds = (double) elapsedTime / 1_000_000_000;
        System.out.printf("Random insertion time: %f seconds %n", elapsedTimeInSeconds);
    }

    @Test
    @Order(2)
    public void B_RandomSearchingTime() {
        long startTime = System.nanoTime();

        testTree.search(value);

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        double elapsedTimeInSeconds = (double) elapsedTime / 1_000_000_000;
        System.out.printf("Random searching time: %f seconds %n", elapsedTimeInSeconds);
    }

    @Test
    @Order(3)
    public void C_RandomDeletionTime() {
        long startTime = System.nanoTime();

        for (int i = 0; i < size; i++) {
            testTree.remove(ThreadLocalRandom.current().nextInt());
        }

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        double elapsedTimeInSeconds = (double) elapsedTime / 1_000_000_000;
        System.out.printf("Random deletion time: %f seconds %n%n", elapsedTimeInSeconds);
    }

    @Test
    @Order(4)
    public void D_SequenceInsertionTime() {
        long startTime = System.nanoTime();

        for (int i = 0; i < size; i++) {
            testTree.insert(i);
        }

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        double elapsedTimeInSeconds = (double) elapsedTime / 1_000_000_000;
        System.out.printf("Sequence insertion time: %f seconds %n", elapsedTimeInSeconds);
    }

    @Test
    @Order(5)
    public void E_SequenceSearchingTime() {
        long startTime = System.nanoTime();

        testTree.search(value);

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        double elapsedTimeInSeconds = (double) elapsedTime / 1_000_000_000;
        System.out.printf("Sequence searching time: %f seconds %n", elapsedTimeInSeconds);
    }

    @Test
    @Order(6)
    public void F_SequenceDeletionTime() {
        long startTime = System.nanoTime();

        for (int i = 0; i < size; i++) {
            testTree.remove(i);
        }

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        double elapsedTimeInSeconds = (double) elapsedTime / 1_000_000_000;
        System.out.printf("Sequence deletion time: %f seconds %n", elapsedTimeInSeconds);
    }
}
