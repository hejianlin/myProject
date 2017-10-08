package com.hejianlin.bank;

public class PersonA extends Thread {
	private Bank bank;

	// 传入bank对象，确保两个人进入的是同一家银行
	public PersonA(Bank bank) {
		this.bank = bank;
	}

	@Override
	public void run() {
		while (Bank.money >= 100) {// A在柜台取钱，每次取100
			//线程加锁，只有本次操作完之后才运行下次操作
			synchronized (bank) {
				bank.counter(100);
			}
			try {
				sleep(1000);// 休息1秒
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
