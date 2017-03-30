package com.aotu.util;

import java.io.IOException;
import javax.servlet.ServletException;
import com.google.gson.Gson;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Json处理工具类
 */
@SuppressWarnings("unchecked")
public class JsonUtil {
	
	protected static Logger logger = Logger.getLogger(JsonUtil.class);
	

	/**
	 * Json转换为entity对象
	 * @param jsonData
	 * @param clazz
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public static Object JsonStr2Entity(String jsonData, Class clazz) 
			throws ServletException, IOException {
		return new Gson().fromJson(jsonData, clazz);   
		
	}
	
	/**
	 * 实体转换为Json
	 * @param object
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public static JSONObject entity2Json(Object object) throws ServletException, IOException {
		JSONObject json = JSONObject.fromObject(object);
		return json;
	}
	
	/**
	 * 列表转换为Json
	 * @param object
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public static JSONArray array2Json(Object object) throws ServletException, IOException {
		JSONArray json = JSONArray.fromObject(object);
		return json;
	}
	
	
}
