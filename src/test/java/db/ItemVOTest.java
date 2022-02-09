package db;

import java.util.ArrayList;
import java.util.List;

import db.vo.ItemVO;

public class ItemVOTest {
	public static void main(String[] args) {
		ItemVO i = new ItemVO();
		i.setAddress("asdf");
		i.setPrice(10);
		i.numOfExistData();
		
		String menuList = "매물등록번호,등록일자,매도자명,주소,가격";
		List<String> menu = new ArrayList<>();
		while(menuList.indexOf(",") != -1) {
			int index = menuList.indexOf(",");
			String substr = menuList.substring(0,index);
			System.out.println("substr : " + substr);
			menu.add(substr);
			menuList = menuList.substring(index+1);
			System.out.println("menuList : " + menuList);
		}
	}
}
