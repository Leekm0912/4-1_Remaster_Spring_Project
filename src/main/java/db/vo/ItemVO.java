package db.vo;

import java.sql.Date;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ItemVO {
	private Integer itemNumber = -1;
	private String address;
	private String sellerID;
	private Date itemAddDate;
	private String sellerName;
	private Integer price = -1;
	private Integer contractMonth = -1;
	private Integer deposit = -1;
	private Integer monthlyRentPrice = -1;
	private Integer SQM = -1;
	private Integer pricePerSQM = -1;
	
	public int numOfExistData() {
		int num = -1; // getClass()는 제외시키기 위해 -1부터 시작.
		Method[] methods = ItemVO.class.getMethods();
		for(Method m : methods) {
			if(m.getName().substring(0, 3).equals("get")) {
				System.out.println(m.getName());
				try {
					Object o = m.invoke(this);
					if(o != null) { // null이 아닌 객체중에서
						if(o instanceof Integer) { // null이 아니고 Integer인데 -1이 아니라면 num 증가
							if((Integer)o != -1) {
								num++;
							}
						}else { // null이 아니고 숫자가 아니면 num 증가
							num++;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(num);
		return num;
	}

	@Override
	public String toString() {
		return "itemNumber : " + itemNumber + "\taddress : " + address;
	}

	public int getContractMonth() {
		return contractMonth;
	}

	public void setContractMonth(int contractMonth) {
		this.contractMonth = contractMonth;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getMonthlyRentPrice() {
		return monthlyRentPrice;
	}

	public void setMonthlyRentPrice(int monthlyRentPrice) {
		this.monthlyRentPrice = monthlyRentPrice;
	}

	public int getSQM() {
		return SQM;
	}

	public void setSQM(int sQM) {
		SQM = sQM;
	}

	public int getPricePerSQM() {
		return pricePerSQM;
	}

	public void setPricePerSQM(int pricePerSQM) {
		this.pricePerSQM = pricePerSQM;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

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
