package zx.json;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

//org.jsonֻ�ܹ���json�����л�ΪJSONObject�����������Զ����Bean
public class OrgJsonTestCases {
	
	Logger log = Logger.getLogger(OrgJsonTestCases.class);

	@Test
	public void testJSONObject() {
		JSONObject zhangsan = new JSONObject();
		JSONObject car = new JSONObject();
		car.put("brand", "audio");
		car.put("price", 200000);
		Object ooo = null;
		zhangsan.put("name", "����");
		zhangsan.put("age", 25);
		zhangsan.put("skill", new String[]{"english","program","sale"});
		zhangsan.put("single", false);
		zhangsan.put("car", car);
		zhangsan.put("house", ooo);
		log.info(zhangsan);
	}
	
	@Test
	public void testMapToJson(){
		Map<String,Object> zhangsan = new HashMap<String,Object>();
		JSONObject car = new JSONObject();
		car.put("brand", "audio");
		car.put("price", 200000);
		Object ooo = null;
		zhangsan.put("name", "����");
		zhangsan.put("age", 25);
		zhangsan.put("skill", new String[]{"english","program","sale"});
		zhangsan.put("single", false);
		zhangsan.put("car", car);
		zhangsan.put("house", ooo);
		log.info(new JSONObject(zhangsan));
	}
	
	@Test
	public void testBeanToJson(){
		Person p = new Person("zhangsan",18,false);
		log.info(new JSONObject(p));
	}
	
	@Test
	public void testFileToJSONObject() throws IOException{
		File file = new File(OrgJsonTestCases.class.getResource("jsonExample.json").getFile());
		String content = FileUtils.readFileToString(file);
		JSONObject jo = new JSONObject(content);
		if(!jo.isNull("name")){//Ϊ�˳���Ľ�׳��
			log.info("�����ǣ�" + jo.getString("name"));
		}
		log.info("������" + jo.getBoolean("single"));
		log.info("���䣺" + jo.getInt("age"));
		JSONArray ja = jo.getJSONArray("skill");
		for (Object object : ja) {
			log.info("רҵ�����У�" + (String)object);
		}
	}

}
