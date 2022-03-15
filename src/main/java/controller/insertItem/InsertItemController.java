package controller.insertItem;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import db.vo.ItemVO;
import db.vo.UserVO;

@Controller
@RequestMapping("insertItem")
public class InsertItemController {
	private static Logger LOGGER = LogManager.getLogger();
	@Autowired
	InsertItemService service;
	
	@GetMapping
	public String view() {
		return "InsertItem";
	}

	@PostMapping("start")
	public String insertStart(Model model, HttpSession sess, HttpServletRequest request, ItemVO vo) {
		UserVO userInfo = (UserVO)sess.getAttribute("userInfo");
		if(userInfo == null) { // AOP로 처리해보기.
			LOGGER.error("로그인 안함.");
			String message = "로그인이 필요합니다.";
			model.addAttribute("message", message);
			return "complete";
//			throw new NeedLoginException();
		}
		try {
			if(userInfo.getUserType().equals("buyer")) {
				throw new DoNotAccessBuyer();
			}
		}catch(DoNotAccessBuyer e) {
			// 이전페이지 보여줌
			LOGGER.error(e.getClass().getName());
			String message = "매수자는 매도할 수 없습니다.";
			model.addAttribute("message", message);
			return "complete";
		}
		vo.setSellerID(userInfo.getId());
		LOGGER.debug(vo + " selectItem : " + vo.getSelectItem());
		boolean result = service.insertItem(vo);
		
		String message;
		if(result) {
			 message = "등록이 완료되었습니다!";
		}else {
			message = "등록실패";
		}
		
		model.addAttribute("message", message);
		return "complete";
	}

	@GetMapping("/charter")
	public String insertCharter(Model model) {
		Map<String, String> data = new LinkedHashMap<>();
		data.put("address", "주소");
		data.put("price", "가격");
		data.put("contractMonth", "계약 월수");

		model.addAttribute("data", data);
		String title = "전세";
		model.addAttribute("title", title);
		return "InsertItem_detail";
	}

	@GetMapping("/monthlyRent")
	public String insertMonthlyRent(Model model) {
		Map<String, String> data = new LinkedHashMap<>();
		data.put("address", "주소");
		data.put("price", "가격");
		data.put("contractMonth", "계약 월수");
		data.put("deposit", "보증금");
		data.put("monthlyRentPrice", "월세");

		model.addAttribute("data", data);
		String title = "월세";
		model.addAttribute("title", title);
		return "InsertItem_detail";
	}

	@GetMapping("/trading")
	public String insertTrading(Model model) {
		Map<String, String> data = new LinkedHashMap<>();
		data.put("address", "주소");
		data.put("price", "가격");

		model.addAttribute("data", data);
		String title = "매매";
		model.addAttribute("title", title);
		return "InsertItem_detail";
	}

	@GetMapping("/land")
	public String insertLand(Model model) {
		Map<String, String> data = new LinkedHashMap<>();
		data.put("address", "주소");
		data.put("price", "가격");
		data.put("SQM", "평수");
		data.put("pricePerSQM", "평당 가격");

		model.addAttribute("data", data);
		String title = "토지";
		model.addAttribute("title", title);
		return "InsertItem_detail";
	}
}
