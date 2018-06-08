package tony.test;

/**
 * wait释放锁
 * Created by tony on 2018/6/8.
 */
public class TestWait {
    public static void main(String[] args) {
        Service1 mService = new Service1();
        Thread sleepThread = new Thread(new SleepThread1(mService));
        Thread waitThread = new Thread(new WaitThread1(mService));
        waitThread.start();
        sleepThread.start();
    }
}
class Service1 {

    public void mSleep(){
        synchronized(this){
            try{
                Thread.sleep(3*1000);
                this.notifyAll();
                System.out.println(" 唤醒等待 。 结束时间："+System.currentTimeMillis());
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }

    public void mWait(){
        synchronized(this){
            try{
                System.out.println(" 等待开始 。 当前时间："+System.currentTimeMillis());
                this.wait();                      //wait会释放锁
                System.out.println("被唤醒");
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }

}
class SleepThread1 implements Runnable{

    private Service1 service;

    public SleepThread1(Service1 service){
        this.service = service;
    }

    public void run(){
        service.mSleep();
    }

}
class WaitThread1 implements Runnable{

    private Service1 service;

    public WaitThread1(Service1 service){
        this.service = service;
    }

    public void run(){
        service.mWait();
    }

}