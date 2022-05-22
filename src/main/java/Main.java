import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int sizeThreadPool = 4;
        int maxMessages = 5;
        List<Callable<Integer>> list = createMyCallablesCollection(sizeThreadPool, maxMessages);
        final ExecutorService threadPool = Executors.newFixedThreadPool(sizeThreadPool);
        List<Future<Integer>> totalCount = threadPool.invokeAll(list);
        Integer result = threadPool.invokeAny(list);
        System.out.println("Invoke Any: " + result);
        threadPool.shutdown();
    }


    public static List<Callable<Integer>> createMyCallablesCollection(int sizeCollection,
                                                                      int maxMessages) {
        List<Callable<Integer>> newMyCallablesCollection = new ArrayList<>();
        for (int i = 0; i < sizeCollection; i++) {
            String name = "thread # " + (i + 1);
            MyThread myCallable = new MyThread(maxMessages, name);
            newMyCallablesCollection.add(myCallable);
        }
        System.out.println("Потоки успешно созданы!");
        return newMyCallablesCollection;
    }
}

