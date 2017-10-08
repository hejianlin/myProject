package com.hejianlin.bank;

public class MoneyTest {
	public static void main(String[] args) {
		//同一个银行
		Bank bank = new Bank();
		//A
		PersonA personA=new PersonA(bank);
		//B
		PersonB personB=new PersonB(bank);
		//开始取款
		personA.start();
		personB.start();
		
	}
}
