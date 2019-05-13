package account.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path="/returnItem")
public class ItemController {
	@SuppressWarnings("resource")
	@RequestMapping(method=RequestMethod.POST)
	public String saveAccount(Model model, ItemDAO item){
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
		TransactionScript script = (TransactionScript) context.getBean("transactionBean");
		script.returnItem(item.getName() , item.getActorId());
		return "response";
	}
}
