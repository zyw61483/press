/** Euser Service
 *  Copyright (C) 2015 THU DAVIS
 *  @author Davis
 *  @version 1.0
 *  Created Time: 2015-04-16
 */

package org.evr.service;

import org.evr.obj.Ebooktype;

public class EbooktypeService extends IService {

	@Override
	public int delete(String keyID, Object[] objects) {
		try {
			return operation.deleteAll("Ebooktype", keyID, objects);
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public Object getInfo(String key) {
		try {
			return operation.getInfo(Ebooktype.class, key);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Object getInfo(Integer key) {
		try {
			return operation.getInfo(Ebooktype.class, key);
		} catch (Exception e) {
			return null;
		}
	}
}