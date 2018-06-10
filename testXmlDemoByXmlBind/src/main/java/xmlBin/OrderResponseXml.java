package xmlBin;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="orderResponse")
public class OrderResponseXml implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8518424536653450622L;
	private OrderXml order;
	public OrderXml getOrder() {
		return order;
	}
	public void setOrder(OrderXml order) {
		this.order = order;
	}
	
	

}
