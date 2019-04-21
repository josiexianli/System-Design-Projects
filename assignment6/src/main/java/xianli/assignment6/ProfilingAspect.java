package xianli.assignment6;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;

@Aspect
public class ProfilingAspect {
	final static Logger log = Logger.getLogger(ProfilingAspect.class);
	
	@Around("execution(* xianli.assignment6.TransactionScript.*(..))")
	public Object profile(ProceedingJoinPoint joinPoint) throws Throwable{
		BasicConfigurator.configure();

		long currentTime = System.currentTimeMillis();
		try {
			return joinPoint.proceed();
		} finally {
			long timeToExecute = System.currentTimeMillis() - currentTime;
			log.info("Time to Execute" + joinPoint.getSignature().toShortString() + " : " + Long.toString(timeToExecute) + " ms");
		}
	}


}
