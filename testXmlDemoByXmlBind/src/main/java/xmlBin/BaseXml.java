package xmlBin;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;

//Serializable或Externalizable接口的类的对象才能被序列化，否则抛出异常
public class BaseXml implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8753567511152770345L;
	public static final String ERROR = "1";
	public static final String SUCCESS = "0";
	private String msgId;
	private String msg;
	private String sign;

	@XmlAttribute //JavaBean 属性映射到 XML 属性，即使是static final 字段，也能被映射
	public String getMsgId() { 
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	@XmlAttribute
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@XmlAttribute
	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

}
