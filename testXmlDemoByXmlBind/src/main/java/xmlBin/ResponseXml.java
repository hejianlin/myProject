package xmlBin;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Response")
public class ResponseXml extends BaseXml{//父类的私有和静态常量都不会被写到xml中

	/**
	 * 
	 */
	private static final long serialVersionUID = -1298123965894004148L;
	private String code;//没有用注释的时候，节点名称默认是字段名
	private String description;
    private OrderResponseXml orderResponse;
    private String alias;
    
    
	public String getAlias() {
		return alias;
	}
	
	@XmlAttribute(name="newName")
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public OrderResponseXml getOrderResponse() {
		return orderResponse;
	}
	public void setOrderResponse(OrderResponseXml orderResponse) {
		this.orderResponse = orderResponse;
	}
    
    
	

}
