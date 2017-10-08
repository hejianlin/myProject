package com.hejianlin.bank;

public class PersonB extends Thread {
	private Bank bank;

	// 传入bank对象，确保两个人进入的是同一家银行
	public PersonB(Bank bank) {
		this.bank = bank;
	}

	@Override
	public void run() {
		while (Bank.money >= 200) {// B在ATM取钱，每次取200
			synchronized (bank) {
				bank.atm(200);
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
