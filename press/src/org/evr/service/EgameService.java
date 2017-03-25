
package org.evr.service;

import org.evr.obj.Egame;

public class EgameService extends IService {

	@Override
	public int delete(String keyID, Object[] objects) {
		try {
			return operation.deleteAll("Egame", keyID, objects);
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public Object getInfo(String key) {
		try {
			return operation.getInfo(Egame.class, key);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Object getInfo(Integer key){
		try {
			return operation.getInfo(Egame.class, key);
		} catch (Exception e) {
			return null;
		}
	}

}