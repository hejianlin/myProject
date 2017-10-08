package com.hejianlin.station;

public class StationByRunnable implements Runnable{
    //静态，使数量变化保持一致
	private static int tick=50;
	//需要设置线程锁，同一个线程在操作的时候，其他线程不能操作
	private static Object lock="lock";// 值是任意的
	//重写run方法
	public void run() {
		while(tick > 0){
			synchronized (lock) {
				if(tick-->0){
					System.out.println(Thread.currentThread().getName()+"卖出了第"+(tick+1)+"张票");
				}else{
					System.out.println("票卖完了！");
				}
				try {
					Thread.sleep(1000);//休息1秒
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	public static void main(String[] args) {
		StationByRunnable stationByRunnable=new StationByRunnable();
		Thread thread1=new Thread(stationByRunnable,"深圳北站");
		Thread thread2=new Thread(stationByRunnable,"深圳南站");
		Thread thread3=new Thread(stationByRunnable,"深圳西站");
		thread1.start();
		thread2.start();
		thread3.start();
		
	}

}
