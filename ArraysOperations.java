package Java.Matrices;
import javax.swing.*;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ArraysOperations {
    public static void main(String[] args) {
        Random random = new Random();
        Arrays.stream(IntStream.generate(() -> Integer.parseInt(JOptionPane.showInputDialog("Introduce un valor"))).limit(5).toArray())
                .filter(e -> e > 10).forEach(System.out::println);
        int[] a = {1, 2, 3, 4, 5, 6,7,8};
        int[] b = {1, 2, 3, 4, 5, 6,7};
        Integer[] c = sumArray(a, b);
        Arrays.stream(c).forEach(System.out::println);
    }

    public static Integer[] sumArray(int[] a, int[] b) {
        AtomicInteger count = new AtomicInteger(0);
        AtomicInteger count2 = new AtomicInteger(0);
        if (a.length == b.length) {
            Integer[] c = new Integer[a.length];
            Arrays.stream(a).forEach(e -> {
                c[count.get()] = a[count.get()] + b[count.get()];
                count.incrementAndGet();
            });
            return c;
        } else {
            if (a.length < b.length) {
                Integer[] c = new Integer[b.length];
                Arrays.stream(b).forEach(e -> {
                    if(a.length==count2.get()) count2.set(0);
                    c[count.get()] = a[count2.get()] + b[count.get()];
                    if (a.length > count2.get()) {
                        count2.incrementAndGet();
                    }
                    count.getAndIncrement();
                });
                return c;
            } else {
                Integer[] c = new Integer[a.length];
                Arrays.stream(a).forEach(e -> {
                    if(b.length==count2.get()) count2.set(0);
                    c[count.get()] = a[count.get()] + b[count2.get()];
                    if (b.length > count2.get()) {
                        count2.incrementAndGet();
                    }
                    count.getAndIncrement();
                });
                return c;
            }
        }

    }
}
