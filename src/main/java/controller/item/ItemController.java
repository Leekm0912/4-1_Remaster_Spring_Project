package controller.item;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ItemController {
	@Autowired
	TradingViewService tradingViewService;
	
	@GetMapping("view")
	public String view() {
		return "DB/ViewTable";
	}
	
	@GetMapping("view/trading.view")
	public String viewTrading(Model model) {
		try {
			// DB에서 결과 불러온걸 모델에 저장.
			model.addAttribute("data", tradingViewService.view()); 
			// 보여줄 메뉴 생성
			String menu = "매물등록번호,등록일자,매도자명,주소,가격"; // 나중에 리소스 분리.
			List<String> menuList = new ArrayList<>();
			while(menu.indexOf(",") != -1) {
				int index = menu.indexOf(",");
				String substr = menu.substring(0,index);
				menuList.add(substr);
				menu = menu.substring(index+1);
			}
			menuList.add(menu); // 마지막 남은 하나도 넣어줌.
			model.addAttribute("menuList", menuList);
			model.addAttribute("type", "view");
		}catch(ItemSearchException e) {
			e.printStackTrace();
		}
		return "ItemView";
	}

}
