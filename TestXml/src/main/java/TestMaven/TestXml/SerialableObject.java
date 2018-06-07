package TestMaven.TestXml;

import java.io.Serializable;

public class SerialableObject implements Serializable {

	private static final long serialVersionUID = -1918020115057701453L;
	
	public SerialableObject() {
		
	}
	
    public SerialableObject(int id, String name,double value) {
    	this.id=id;
    	this.name=name;
    	this.value=value;
    }
    
    private int id;
    private String name;
    private double value;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
    
    
}
