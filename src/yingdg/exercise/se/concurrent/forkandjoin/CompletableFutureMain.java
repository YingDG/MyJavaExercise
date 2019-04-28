package yingdg.exercise.se.concurrent.forkandjoin;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author YingDG
 * created in 2019/4/28 上午11:35
 */
public class CompletableFutureMain {
    public static void main(String[] args) {
        //
        String hello1 = CompletableFuture.completedFuture("hello").join();
        System.out.println(hello1);

        //
        try {
            String world = CompletableFuture.completedFuture("world").get();
            System.out.println(world);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        //
        String join = CompletableFuture.supplyAsync(() -> {
            if (true) {
                System.err.println("error");
                throw new RuntimeException();
            }
            return "world";
        }).exceptionally(e -> "exception").join();
        System.out.println(join);

        //
        boolean b = CompletableFuture.supplyAsync(() -> {
            if (true) {
                System.err.println("error");
                throw new RuntimeException();
            }
            return "world";
        }).completeExceptionally(new RuntimeException("error"));
        System.out.println(b);
    }
}
