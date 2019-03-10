package xianli.assignment3;

import junit.framework.TestCase;

public class ReturnItemServiceTest extends TestCase {
	ReturnItemService service = new ReturnItemService();

	public void testReturnItem() {
		//will fail if error thrown, otherwise it means success
		service.returnItem(0, 1, null);	
	}

}
