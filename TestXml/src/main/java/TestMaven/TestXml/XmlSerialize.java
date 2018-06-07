package TestMaven.TestXml;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * xml的序列化和反序列化
 * 
 * @author hejianlin
 * @Version 2018年6月7日
 */
public class XmlSerialize {
	public XmlSerialize() {

	}

	/**
	 * 序列化单个java对象
	 */
	public void serializeSingleObject(OutputStream os, Object obj) {
		XMLEncoder xEncoder = new XMLEncoder(os, "UTF-8", true, 0);
		// 编码器
		xEncoder.writeObject(obj); // 序列化成xml字符串
		xEncoder.close();
	}

	/**
	 * 反序列化为单个java对象
	 */
	public Object deserializeSingleObject(InputStream is) {
		// 解码器
		XMLDecoder xmlDecoder = new XMLDecoder(is);
		Object obj = xmlDecoder.readObject();
		xmlDecoder.close();
		return obj;
	}

	/**
	 * 序列化多个java对象
	 */
	public void serializeMultipleObject(OutputStream os, List<Object> oList) {
		XMLEncoder xmlEncoder = new XMLEncoder(os, "UTF-8", true, 0);
		xmlEncoder.writeObject(oList);
		xmlEncoder.close();
	}

	/**
	 * 反序列化为多个java对象
	 * 
	 * @param is
	 * @return
	 */
	public List<Object> deserializeMultipleObject(InputStream is) {
		XMLDecoder xmlDecoder = new XMLDecoder(is);
		@SuppressWarnings("unchecked")
		List<Object> objects = (List<Object>) xmlDecoder.readObject();
		xmlDecoder.close();
		return objects;
	}

	public void runMultipleObject() {
		File xmlFile = new File("objects.xml");

		List<SerialableObject> serialableObjects = new ArrayList<SerialableObject>();
		serialableObjects.add(new SerialableObject(1, "jianlin", 26));
		serialableObjects.add(new SerialableObject(2, "jianhong", 31));
		serialableObjects.add(new SerialableObject(3, "xiaoshan", 28));
		serialableObjects.add(new SerialableObject(4, "xiaoxuan", 29));

		// 序列化多个java对象到xml文件中
		// 文件输出流
		try {
			FileOutputStream oFileOutputStream = new FileOutputStream(xmlFile);
			serializeSingleObject(oFileOutputStream, serialableObjects);
			oFileOutputStream.close();
			System.out.println("xml文件的完整路径：" + xmlFile.getAbsolutePath());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		// 反序列化多个java对象
		try {
			FileInputStream iFileInputStream = new FileInputStream(xmlFile);
			List<SerialableObject> deserialableObjects = (List<SerialableObject>) deserializeSingleObject(
					iFileInputStream);
			for (SerialableObject serialableObject : deserialableObjects) {
				System.out.println("id: " + serialableObject.getId());
				System.out.println("name: " + serialableObject.getName());
				System.out.println("value: " + serialableObject.getValue());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void runSingleObject() {
		File xmlFile = new File("object.xml");
		SerialableObject serialableObject = new SerialableObject(5, "bama", 56);

		// 序列化单个java对象到xml文件中
		// 文件输出流
		try {
			FileOutputStream oFileOutputStream = new FileOutputStream(xmlFile);
			serializeSingleObject(oFileOutputStream, serialableObject);
			oFileOutputStream.close();
			System.out.println("xml文件的完整路径：" + xmlFile.getAbsolutePath());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		// 反序列化单个java对象
		try {
			FileInputStream iFileInputStream = new FileInputStream(xmlFile);
			SerialableObject deserialableObject = (SerialableObject) deserializeSingleObject(iFileInputStream);

			System.out.println("id: " + deserialableObject.getId());
			System.out.println("name: " + deserialableObject.getName());
			System.out.println("value: " + deserialableObject.getValue());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	

	public static void main(String[] args) {
		XmlSerialize xmlSerialize = new XmlSerialize();
//		xmlSerialize.runMultipleObject();
//		xmlSerialize.runSingleObject();
        System.out.println("当前类编译的绝对路径:"+XmlSerialize.class.getResource("/").getFile());
        System.out.println("获取Java项目的当前路径（工作目录）:"+System.getProperty("user.dir"));
		System.out.println("直接定位到resouce目录下的某个xml文件，反序列化");
		URL url=XmlSerialize.class.getResource("/xml/test.xml");
		System.out.println("文件的绝对路径："+url.getFile());
		File xmlFile = new File(url.getFile());

		// 反序列化多个java对象
		try {
			
			FileInputStream iFileInputStream = new FileInputStream(xmlFile);
			List<SerialableObject> deserialableObjects = (List<SerialableObject>) xmlSerialize.deserializeSingleObject(
					iFileInputStream);
			for (SerialableObject serialableObject : deserialableObjects) {
				System.out.println("id: " + serialableObject.getId());
				System.out.println("name: " + serialableObject.getName());
				System.out.println("value: " + serialableObject.getValue());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
