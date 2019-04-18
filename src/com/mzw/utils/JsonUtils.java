package com.mzw.utils;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mzw.vo.JsonBean;
public class JsonUtils {
	public static void sendJsonData(int code, Object info, HttpServletResponse response){
		JsonBean bean = new JsonBean();
		bean.setCode(code);
		bean.setInfo(info);
		
		SerializerFeature[] features = new SerializerFeature[] {
				SerializerFeature.WriteDateUseDateFormat,
				SerializerFeature.WriteNullListAsEmpty,
				SerializerFeature.WriteNullStringAsEmpty,
				SerializerFeature.WriteMapNullValue
		};
		
		String jsonString = JSON.toJSONString(bean,features);
		try {
			response.getWriter().write(jsonString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
