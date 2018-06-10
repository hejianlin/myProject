package originalSerialize;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name="class")
@XmlSeeAlso({Student.class})  
public class Clazz  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5268489956435562987L;
	private String name;
	private List<Student> students;
	
	public Clazz() {

	}

	public Clazz(String name, List<Student> students) {
		this.name = name;
		this.students = students;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	@XmlElementWrapper(name="students")
	@XmlElement(name="student")
	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
