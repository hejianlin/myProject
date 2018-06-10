package xmlBin;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="order") //将类或枚举类型映射到 XML 元素
public class OrderXml implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8614942295052948330L;
	private String orderId;
	private String partnerId;
	private List<TicketOrderXml> ticketOrders;
	
	@XmlElement  //将 JavaBean 属性（非 static、非 transient 字段）映射到派生于属性名称的 XML 元素。
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}
	public List<TicketOrderXml> getTicketOrders() {
		return ticketOrders;
	}
	
	@XmlElementWrapper(name="ticketOrders") //生成一个包装 XML 表示形式的包装器元素。 此元素主要用于生成一个包装集合的包装器 XML 元素。因此，该注释支持以下两种形式的序列化。
	@XmlElement(name="ticketOrder") //映射元素
	public void setTicketOrders(List<TicketOrderXml> ticketOrders) {
		this.ticketOrders = ticketOrders;
	}
	
	
	

}
