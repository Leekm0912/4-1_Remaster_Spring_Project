package db.vo;

import java.sql.Date;

public class ItemVO {
	private int itemNumber;
	private String address;
	private String sellerID;
	private Date itemAddDate;

	public int getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSellerID() {
		return sellerID;
	}

	public void setSellerID(String sellerID) {
		this.sellerID = sellerID;
	}

	public Date getItemAddDate() {
		return itemAddDate;
	}

	public void setItemAddDate(Date itemAddDate) {
		this.itemAddDate = itemAddDate;
	}
}
