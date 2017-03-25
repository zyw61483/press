/** Euser Service
 *  Copyright (C) 2015 THU DAVIS
 *  @author Davis
 *  @version 1.0
 *  Created Time: 2015-04-16
 */

package org.evr.service;

import org.evr.obj.Ebook;

public class EbookService extends IService {

	@Override
	public int delete(String keyID, Object[] objects) {
		try {
			return operation.deleteAll("Ebook", keyID, objects);
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public Object getInfo(String key) {
		try {
			return operation.getInfo(Ebook.class, key);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Object getInfo(Integer key){
		try {
			return operation.getInfo(Ebook.class, key);
		} catch (Exception e) {
			return null;
		}
	}

}