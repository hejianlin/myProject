package com.hejianlin.main.service;

public class WindowsListService implements  ListServiceCmd{

	@Override
	public String showListCmd() {
		return "dir";
	}

}
