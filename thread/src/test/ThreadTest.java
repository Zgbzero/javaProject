package test;

/**
 * 线程的创建方式：1.继承Thread类
 * 1.创建继承Thread类的子类
 * 2.重写run()方法
 * 3.实例化子类对象
 * 4.子类对象调用start方法
 *
 *线程的优先级:
 * 有时间片和抢占式
 * 抢占式是设定线程的优先级
 * 几个优先级的常量
 * MAX_PRIORITY 10
 * MIN_PRIORITY 1
 * NORM_PRIORITY 5 -->默认优先级
 *
 *  优先级比较高的不一定先执行
 * 获得和设置优先级
 * getPriority()
 * setPriority()
 *
 *
 * */

class  MyThread extends Thread{
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            if(i%2==0){
                System.out.println("优先级为"+getPriority()+"的"+getName()+":"+i);
            }
        }
    }

}
public class ThreadTest extends Thread {
    public static void main(String[] args) {
        Thread.currentThread().setName("主线程");
//        MyThread t1 = new MyThread("一线程");
        MyThread t2 = new MyThread("二线城");
//        t1.start();//start方法：1.启动当前线程2.启动线程的run方法
        t2.setPriority(Thread.MAX_PRIORITY);//设置线程的优先级在线程启动前
        t2.start();
        for (int i = 0; i <100 ; i++) {
            if(i%2!=0) {
                System.out.println(Thread.currentThread().getName() + "的优先级为" + Thread.currentThread().getPriority()+":"+i);
            }
        }


    }

}
