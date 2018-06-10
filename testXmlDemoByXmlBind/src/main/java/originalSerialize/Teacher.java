package originalSerialize;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name="teacher")
@XmlSeeAlso({Clazz.class})  
public class Teacher implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6470725303780106556L;
	private String name;
	private char sex;
	private int year;
	private List<Clazz>clazzs;
	
	
	public Teacher() {

	}
	
	public Teacher(String name, char sex, int year, List<Clazz> clazzs) {
		super();
		this.name = name;
		this.sex = sex;
		this.year = year;
		this.clazzs = clazzs;
	}


	public String getName() {
		return name;
	}
	
	@XmlElement(name="teacherName")
	public void setName(String name) {
		this.name = name;
	}
	public char getSex() {
		return sex;
	}
	
	@XmlAttribute
	public void setSex(char sex) {
		this.sex = sex;
	}
	
	public int getYear() {
		return year;
	}
	
	@XmlAttribute
	public void setYear(int year) {
		this.year = year;
	}
	public List<Clazz> getClazzs() {
		return clazzs;
	}
	
	@XmlElementWrapper(name="clazzs")
	@XmlElement(name="class")
	public void setClazzs(List<Clazz> clazzs) {
		this.clazzs = clazzs;
	}
	
	
	
}
