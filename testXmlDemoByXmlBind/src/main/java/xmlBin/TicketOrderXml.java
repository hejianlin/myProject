package xmlBin;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ticketOrder")
public class TicketOrderXml implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2921967135831004095L;
	private String totalPrice;
	private String goodsName;
	public TicketOrderXml() {
	
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	
	
	

}
