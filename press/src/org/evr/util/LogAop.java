package org.evr.util;

import java.util.Formatter;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.opensymphony.xwork2.ActionContext;

@Aspect
public class LogAop {

	private static Logger log = Logger.getLogger("LogAop");

	@Before("execution(* org.evr.action.*.*(..)) and !execution(* org.evr.action.*.set*(..))")
	public void before(JoinPoint joinPoint) {
		// System.out.println("LogAop Info Action: "
		// + joinPoint.getTarget().getClass().getName()
		// +" Method:"+joinPoint.getSignature().getName()
		// +" Time:"+FileUtil.yms.format(new Date()));
		ActionContext actionContext = ServletActionContext.getContext();
		Map map = actionContext.getParameters();
		Set set = map.entrySet();
		Iterator i = set.iterator();
		StringBuffer s = new StringBuffer("Args:");
		while (i.hasNext()) {
			Map.Entry<String, String> entry = (Map.Entry<String, String>) i.next();
			try {
				for (String temp : (String[]) map.get(entry.getKey())) {
					s.append(entry.getKey() + "=" + temp + " ");
				}
			} catch (Exception e) {}
		}
		Formatter formatter = new Formatter();
		formatter.format("%-20s %-20s %-30s", joinPoint.getTarget().getClass().getSimpleName(),joinPoint.getSignature().getName(),s.toString());
		log.info(formatter.toString());
	}
}
