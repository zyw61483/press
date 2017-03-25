/** Euser Service
 *  Copyright (C) 2015 THU DAVIS
 *  @author Davis
 *  @version 1.0
 *  Created Time: 2015-04-16
 */

package org.evr.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.evr.obj.Ebooksets;
import org.json.JSONArray;
import org.json.JSONObject;

public class EbooksetsService extends IService {

	@Override
	public int delete(String keyID, Object[] objects) {
		try {
			return operation.deleteAll("Ebooksets", keyID, objects);
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public Object getInfo(String key) {
		try {
			return operation.getInfo(Ebooksets.class, key);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Object getInfo(Integer key) throws Exception {
		try {
			return operation.getInfo(Ebooksets.class, key);
		} catch (Exception e) {
			return null;
		}
	}

	public byte[] getSetsByType(String type) throws UnsupportedEncodingException {
		Ebooksets temp = new Ebooksets();
		temp.setType(type);
		List<Ebooksets> list = (List<Ebooksets>)operation.findList(temp);
		List<Map<String,Object>> list2 = new ArrayList<Map<String, Object>>();
		if(list!=null){
			for (Ebooksets set : list) {
				Map<String,Object> map = new HashMap<String, Object>();
				map.put("name", set.getItem());
				map.put("value", set.getId());
				list2.add(map);
			}
		}
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("flag", true);
		map.put("list", list2);
		JSONObject jsonObject = new JSONObject(map);
		return jsonObject.toString().getBytes("utf-8");
	}
}