package com.hejianlin.main.service;

public class LinuxListService implements ListServiceCmd {

	@Override
	public String showListCmd() {
		return "ls";
	}

}
