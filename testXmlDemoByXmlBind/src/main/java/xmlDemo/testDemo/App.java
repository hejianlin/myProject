package xmlDemo.testDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;
import originalSerialize.Clazz;
import originalSerialize.Student;
import originalSerialize.Teacher;
import xmlBin.ResponseXml;
import xmlBin.XmlHelper;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("/*****************************原始方法序列化***********************************/");
    	Student student=new Student("jianlin", 'M', 25, 4.0);
    	File file=new File("G:\\student.txt");
    	try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//student序列化
    	try {
			FileOutputStream fos=new FileOutputStream(file);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(student);
			oos.flush();
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//student反序列化
    	try {
			FileInputStream fis=new FileInputStream(file);
			ObjectInputStream ois=new ObjectInputStream(fis);
			Student newStudent=(Student)ois.readObject();
			System.out.println("name = "+newStudent.getName());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	System.out.println("/*****************************javax.xml.bind序列化***********************************/");
        StringBuilder sb=new StringBuilder();
        sb.append("<Response sign='1234567'>");
        sb.append("<code>1000</code>");
        sb.append("<description>测试</description>");
        sb.append("<orderResponse>");
        sb.append("<order>");
        sb.append("<orderId>330182198804273139</orderId>");
        sb.append("<partnerId>12345</partnerId>");
        
        sb.append("<ticketOrders>");
        
        for (int i = 0; i <= 1; i++) {
            sb.append("<ticketOrder>");
            sb.append("<totalPrice>100</totalPrice>");
            sb.append("<goodsName>测试票</goodsName>");
            sb.append("</ticketOrder>");
        }
        sb.append("</ticketOrders>");
        sb.append("</order>");
        sb.append("</orderResponse>");
        sb.append("</Response>");
        System.out.println("原始字符串:" + sb.toString());
        
        ResponseXml respone = (ResponseXml) XmlHelper.toObj(ResponseXml.class, sb.toString());
        System.out.println("获取节点值:" + respone.getOrderResponse().getOrder().getOrderId());
        System.out.println("获取属性:" + respone.getSign());
        System.out.println("转换字符串:" + XmlHelper.toXml(respone));
        
        
        
        System.out.println("这里测试序列化为xml");
        ResponseXml newRespone = new ResponseXml();
        newRespone.setCode("3322");
        newRespone.setAlias("isNewName");
        System.out.println("得到新的xml字符串："+XmlHelper.toXml(newRespone));
        
        
        
        System.out.println("/*****************************javax.xml.bind序列化和反序列化教师对象***********************************/");
        List<Student>students=new ArrayList<Student>();
        for(int i=0;i<3;i++) {
        	students.add(new Student("jianlin"+i, 'M', 20, 4.0));
        }
        
        List<Clazz>clazzs=new ArrayList<Clazz>();
        Clazz clazz= new Clazz("五年一班", students);
        clazzs.add(clazz);
        
        Teacher teacher=new Teacher("陈老师", 'F', 28, clazzs);
        String xmlString=XmlHelper.toXmlString(teacher);
        System.out.println("序列化后的教师xml:"+xmlString);
        
        Teacher newteacher=XmlHelper.toTeacherObj(xmlString);
        JSONObject json = JSONObject.fromObject(newteacher);//将java对象转换为json对象
        String str = json.toString();//将json对象转换为字符串
        System.out.println("反序列化出来的教师对象："+str);
        
        
        System.out.println("/*****************************javax.xml.bind序列化和反序列化xml文件***********************************/");
        XmlHelper.toXmlFile(teacher, "G:\\new2.xml");
        
        
        Teacher teacher2=XmlHelper.toTeacherObjFromXml("G:\\new2.xml");
        JSONObject json2 = JSONObject.fromObject(teacher2);//将java对象转换为json对象
        String str2 = json2.toString();//将json对象转换为字符串
        System.out.println("根据文件路径反序列化教师对象："+str2);
    
    }
}
