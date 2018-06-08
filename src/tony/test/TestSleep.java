package tony.test;

/**
 * sleep不会释放锁
 * Created by tony on 2018/6/8.
 */
public class TestSleep {

    public static void main(String[] args){

        Service mService = new Service();

        Thread sleepThread = new Thread(new SleepThread(mService));
        Thread waitThread = new Thread(new WaitThread(mService));
        sleepThread.start();
        waitThread.start();

    }
}

class Service {

    public void mSleep(){
        synchronized(this){
            try{
                System.out.println(" Sleep 。当前时间："+System.currentTimeMillis());
                Thread.sleep(3*1000); //sleep不会释放锁
                System.out.println("sleep 结束");
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }

    public void mWait(){
        synchronized(this){
            System.out.println(" Wait 。结束时间："+System.currentTimeMillis());

        }
    }

}
class SleepThread implements Runnable{

    private Service service;

    public SleepThread(Service service){
        this.service = service;
    }

    public void run(){
        service.mSleep();
    }

}
class WaitThread implements Runnable{

    private Service service;

    public WaitThread(Service service){
        this.service = service;
    }

    public void run(){
        service.mWait();
    }

}