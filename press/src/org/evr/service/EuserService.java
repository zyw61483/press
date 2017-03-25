/** Euser Service
 *  Copyright (C) 2015 THU DAVIS
 *  @author Davis
 *  @version 1.0
 *  Created Time: 2015-04-16
 */

package org.evr.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.evr.obj.Euser;

public class EuserService extends IService {

	@Override
	public int delete(String keyID, Object[] objects) {
		try {
			return operation.deleteAll("Euser", keyID, objects);
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public Object getInfo(String key) {
		try {
			return operation.getInfo(Euser.class, key);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Object getInfo(Integer key){
		try {
			return operation.getInfo(Euser.class, key);
		} catch (Exception e) {
			return null;
		}
	}

	public boolean isMobileNO(String mobiles){  
		  
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");  
		  
		Matcher m = p.matcher(mobiles);  
		  
		System.out.println(m.matches()+"---");  
		  
		return m.matches();  
	  
	}  
	

}