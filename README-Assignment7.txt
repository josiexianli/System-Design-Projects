app runs at http://localhost:1527/remoting/

Since in web.xml I set the servlet-mapping to have a url-pattern of /spring/*, according to the lecture, I set the serviceUrl to be:
	http://localhost:1527/remoting/spring/HessianTransactionService,
	http://localhost:1527/remoting/spring/BurlapTransactionService,
	http://localhost:1527/remoting/spring/HttpInvokerTransactionService


After starting the server, running the client classes will result in an error with the root cause of: 
	com.caucho.burlap.client.BurlapRuntimeException: 404: java.io.FileNotFoundException: http://localhost:1527/remoting/spring/BurlapTransactionService 

I am thinking this might be an issue with the configuration rather than the remoting layer concept. Please advise. Thank you very much.