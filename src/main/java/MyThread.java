import java.util.concurrent.Callable;

public class MyThread implements Callable<Integer> {
//    static int count = 0;
    private int currentMessage;
    private String name;

    MyThread(int currentMessage, String name) {
        this.currentMessage = currentMessage;
        this.name = name;
    }

    //    @Override
    public Integer call() throws Exception {
       int countMessages = 0;
        do {
            countMessages++;
            Thread.sleep(10);
            System.out.println("Hello! " + this.name);
        } while (countMessages < this.currentMessage);
        return countMessages;
    }
}

