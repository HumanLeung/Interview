package com.company.concurrency.executor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
public class CallableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Future<String>> list = new ArrayList<>();
        Future<String> future1 = executorService.submit(new Processor("1"));
        Future<String> future2 = executorService.submit(new Processor("2"));
        Future<String> future3 = executorService.submit(new Processor("3"));
        Future<String> future4 = executorService.submit(new Processor("4"));

        list.add(future1);
        list.add(future2);
        list.add(future3);
        list.add(future4);

        for (Future<String> future: list) {
            System.out.println(future.get()+" "+Thread.currentThread().getName());
        }
        executorService.shutdown(); }
}
class Processor implements Callable<String> {
    private final String name;
    public Processor(String name) {
        this.name = name;
    }
    @Override
    public String call()  {
        System.out.println(Thread.currentThread().getName());
        return "id : "+ name;
    }
}