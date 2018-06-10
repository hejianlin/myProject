package originalSerialize;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name="student")
public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7449245509419598626L;
	private String name;
	private char sex;
	private int year;
	private double gpa;
	
	public Student() {
	
	}

	public Student(String name, char sex, int year, double gpa) {
		super();
		this.name = name;
		this.sex = sex;
		this.year = year;
		this.gpa = gpa;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	
	
    
}
