import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by niuyi on 2017/5/15.
 */
public class MyQueue {

    private List<String> queue = new ArrayList<String>();

    public String get(){
        synchronized (this){
            while (queue.size() == 0){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            String s = queue.remove(0);
            return s;
        }
    }

    public void put(String s){
        synchronized (this){
            queue.add(s);
            this.notifyAll();
        }
    }


    public static final void main(String args[]){
        final MyQueue q = new MyQueue();

        new Thread(){
            @Override
            public void run() {
                super.run();

                while(true){
                    String s = q.get();
                    System.out.println("get s: " + s);
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                super.run();

                while(true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    q.put("put: " + String.valueOf(System.currentTimeMillis()));
                }
            }
        }.start();

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
