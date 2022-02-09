package controller.item;

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
			model.addAttribute("data", tradingViewService.view());
		}catch(ItemSearchException e) {
			e.printStackTrace();
		}
		return "DB/view/전세";
	}

}
