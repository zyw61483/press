/** Structure Service
 *  Copyright (C) 2015 THU DAVIS
 *  @author Davis
 *  @version 1.0
 *  Created Time: 2015-04-16
 */

package org.evr.service;

import org.evr.obj.Structure;

public class StructureService extends IService {

	@Override
	public int delete(String keyID, Object[] objects) {
		try {
			return operation.deleteAll("Structure", keyID, objects);
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public Object getInfo(String key) {
		try {
			return operation.getInfo(Structure.class, key);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Object getInfo(Integer key) throws Exception {
		try {
			return operation.getInfo(Structure.class, key);
		} catch (Exception e) {
			return null;
		}
	}
}
