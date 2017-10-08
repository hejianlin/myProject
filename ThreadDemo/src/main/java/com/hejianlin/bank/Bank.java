package com.hejianlin.bank;

//一个银行账号同时被A和B使用，A在柜台取款，B在ATM机上取款
public class Bank {
	// 设置初始金额为1000
	static int money = 1000;
	
	//柜台取钱的
	public void counter(int money){
		Bank.money-=money;//取钱之后的钱的数量
		System.out.println("A取走了"+money+"，剩下了"+(Bank.money));
	}
	
	//atm取钱的方法
	public void atm(int money){
		Bank.money-=money;//取钱之后的钱的数量
		System.out.println("B取走了"+money+"，剩下了"+(Bank.money));
	}
	
}
