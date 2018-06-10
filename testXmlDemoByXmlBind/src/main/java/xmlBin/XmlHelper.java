package xmlBin;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import originalSerialize.Teacher;

public class XmlHelper {
	
	/**
	 * 泛型：反序列化为对象
	 * @param clazz
	 * @param xml
	 * @return
	 */
	public static <T extends BaseXml> T toObj(Class<T> clazz, String xml) {
		try {
			JAXBContext context = JAXBContext.newInstance(new Class[] { clazz });
			InputStream buf = new ByteArrayInputStream(xml.getBytes("UTF-8"));
			return (T) context.createUnmarshaller().unmarshal(buf);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 泛型：序列化为xml字符串
	 * @param obj
	 * @return
	 */
	public static <T extends BaseXml> String toXml(T obj) {
		try {
			StringWriter writer = new StringWriter();
			JAXBContext context = JAXBContext.newInstance(new Class[] { obj.getClass() });
			context.createMarshaller().marshal(obj, writer);
			return writer.getBuffer().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * 具体类型，反序列化为教师对象
	 * @param xml
	 * @return
	 */
	public static Teacher toTeacherObj(String xml) {
		try {
			JAXBContext context=JAXBContext.newInstance(Teacher.class);
			InputStream buf=new ByteArrayInputStream(xml.getBytes("UTF-8"));
			return (Teacher)context.createUnmarshaller().unmarshal(buf);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String toXmlString(Teacher teacher) {
		try {
			StringWriter writer=new StringWriter();
			JAXBContext context=JAXBContext.newInstance(Teacher.class);
			context.createMarshaller().marshal(teacher, writer);
			return writer.getBuffer().toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";

	}
	
	public static String toXmlFile(Teacher teacher,String filePath) {
		try {
			//得出xml字符串
			StringWriter stringWriter=new StringWriter();
			JAXBContext context=JAXBContext.newInstance(Teacher.class);
			context.createMarshaller().marshal(teacher, stringWriter);
			String xmlString=stringWriter.getBuffer().toString();
			
			//格式化输出到文件中
			SAXReader reader=new SAXReader();
			Document document=reader.read(new StringReader(xmlString));
			FileOutputStream out=new FileOutputStream(filePath);
			OutputFormat format = OutputFormat.createPrettyPrint();//格式好的形式，有空格和换行
			format.setEncoding("utf-8");
			XMLWriter writer=new XMLWriter(out, format);
			writer.write(document);
			writer.close();
			
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "falied";

	}
	
	public static Teacher toTeacherObjFromXml(String filePath) {
		try {
			JAXBContext context=JAXBContext.newInstance(Teacher.class);
			File file=new File(filePath);
			InputStream inputStream=new BufferedInputStream(new FileInputStream(file));
			return (Teacher)context.createUnmarshaller().unmarshal(inputStream);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
