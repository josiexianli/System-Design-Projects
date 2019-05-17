package remoting;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @RequestMapping(value = "/createAccount", method = RequestMethod.POST)
    public boolean createAccount(@RequestParam Map<String,String> requestParams) {
    	TransactionScript script = new TransactionScript();
    	return script.createAccount(requestParams.get("username"), requestParams.get("password"), requestParams.get("email"));
    }
}
