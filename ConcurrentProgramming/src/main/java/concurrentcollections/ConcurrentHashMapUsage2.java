package concurrentcollections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by rg029761 on 11/1/15.
 */
public class ConcurrentHashMapUsage2 implements Runnable{

    private String name;
    private static Map<String,String> conpage = new ConcurrentHashMap<String,String>();


    public ConcurrentHashMapUsage2(String name){
        conpage.put("1","A");
        conpage.put("2","B");
        conpage.put("3","C");
        this.name=name;
    }

    public void run() {
        try{
            Iterator<String> it = conpage.keySet().iterator();
            while(it.hasNext()){
                String key = it.next();
                conpage.put("A" + key, "A" + key);
            }
            System.out.println(name +" completed.");
        }catch(Exception e){
            e.printStackTrace();
        }finally{

        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService  executor = Executors.newCachedThreadPool();
        executor.submit(new ConcurrentHashMapUsage2("Thread one"));
        executor.submit(new ConcurrentHashMapUsage2("Thrad two"));

        executor.shutdownNow();

        System.out.println(conpage);
        executor.awaitTermination(1, TimeUnit.DAYS);
    }

}
