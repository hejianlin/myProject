package com.hejianlin.testSpringMvcWithNoWebXml;

//此类用来演示获取request对象参数和返回此对象到response
public class DemoObj {
	private Long id;
	private String name;

	public DemoObj() {// jsckson对对象和json做转换时一定需要此空构造
		super();
	}

	public DemoObj(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
