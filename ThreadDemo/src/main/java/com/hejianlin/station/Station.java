package com.hejianlin.station;
//对同一个数量进行操作
//三个窗口同时买票，总共20张票，需要使用线程锁
public class Station extends Thread {
	// 静态，表示票数的一致
	private static int tick = 20;
	// 创建一个静态钥匙
	private static Object ob = "这是钥匙";// 值是任意的
	// 线程名字赋值

	public Station(String name) {
		super(name);
	}

	// 重写run方法，实现买票操作
	@Override
	public void run() {
		while (tick>0) {
			synchronized (ob) {// 这个很重要，必须使用一个锁，进去的人会把钥匙拿在手上，出来后才把钥匙拿让出来
				if (tick-->0) {
					System.out.println(getName() + "卖出了第" + (tick+1)+ "张票");
				}else{
					System.out.println("票卖完了");
				}
				try {
					sleep(1000);//休息一秒
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
	}

	public static void main(String[] args) {
		Station station1=new Station("深圳东站");
		Station station2=new Station("深圳西站");
		Station station3=new Station("深圳北站");
		
		station1.start();
		station2.start();
		station3.start();
			
	}
}
