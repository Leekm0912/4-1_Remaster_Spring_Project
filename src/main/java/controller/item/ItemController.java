package controller.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ItemController {
	private static Logger LOGGER = LogManager.getLogger();
	@Autowired
	ItemViewService itemViewService;
	
	@GetMapping("view")
	public String view() {
		return "ItemView";
	}
	
	@GetMapping("view/trading.view")
	public String viewTrading(Model model) {
		try {
			// DB에서 결과 불러온걸 모델에 저장.
			Map<String, String> m = new HashMap<>();
			m.put("selectItem", "trading");
			model.addAttribute("data", itemViewService.getItemData(m)); 
			// 보여줄 메뉴 생성
			String menu = "매물등록번호,등록일자,매도자명,주소,가격"; // 나중에 리소스 분리.
			addMenuToModel(model, menu);
		}catch(ItemSearchException e) {
			e.printStackTrace();
		}
		return "ItemView_detail";
	}
	
	@GetMapping("view/charter.view")
	public String viewCharter(Model model) {
		try {
			// DB에서 결과 불러온걸 모델에 저장.
			Map<String, String> m = new HashMap<>();
			m.put("selectItem", "charter");
			model.addAttribute("data", itemViewService.getItemData(m)); 
			// 보여줄 메뉴 생성
			String menu = "매물등록번호,등록일자,매도자명,주소,계약기간(월),가격"; // 나중에 리소스 분리.
			addMenuToModel(model, menu);
		}catch(ItemSearchException e) {
			e.printStackTrace();
		}
		return "ItemView_detail";
	}
	
	@GetMapping("view/monthlyRent.view")
	public String viewMonthlyRent(Model model) {
		try {
			// DB에서 결과 불러온걸 모델에 저장.
			Map<String, String> m = new HashMap<>();
			m.put("selectItem", "monthlyRent");
			model.addAttribute("data", itemViewService.getItemData(m)); 
			// 보여줄 메뉴 생성
			String menu = "매물등록번호,등록일자,매도자명,주소,계약기간(월),보증금,월세"; // 나중에 리소스 분리.
			addMenuToModel(model, menu);
		}catch(ItemSearchException e) {
			e.printStackTrace();
		}
		return "ItemView_detail";
	}
	
	@GetMapping("view/land.view")
	public String viewLand(Model model) {
		try {
			// DB에서 결과 불러온걸 모델에 저장.
			Map<String, String> m = new HashMap<>();
			m.put("selectItem", "land");
			model.addAttribute("data", itemViewService.getItemData(m)); 
			// 보여줄 메뉴 생성
			String menu = "매물등록번호,등록일자,매도자명,주소,평수,평당 가격"; // 나중에 리소스 분리.
			addMenuToModel(model, menu);
			
		}catch(ItemSearchException e) {
			e.printStackTrace();
		}
		return "ItemView_detail";
	}
	
	private void addMenuToModel(Model model, String menu) {
		List<String> menuList = itemViewService.makeMenuList(menu);
		model.addAttribute("menuList", menuList);
		model.addAttribute("type", "view");
	}
}
