package zx.json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class FastjsonTestCases {
	
	Logger log = Logger.getLogger(FastjsonTestCases.class);
	
	@Test
	public void testArrayToJson() {
		Object[] objArray = {"上海",99,true,12.22};
		String jsonResult = JSON.toJSONString(objArray);
		log.info(jsonResult);
		//["上海",99,true,12.22]
	}
	
	@Test
	public void testListToJson(){
		List<String> list = new ArrayList<String>();
		list.add("NewYork");
		list.add("London");
		String jsonResult = JSON.toJSONString(list);
		log.info(jsonResult);
		//["NewYork","London"]
	}
	
	@Test
	public void testSetToJson(){
		Set<Object> set = new HashSet<Object>();
		set.add("Java");
		set.add(12.22);
		set.add(true);
		String jsonResult = JSON.toJSONString(set);
		log.info(jsonResult);
		//[12.22,"Java",true]
	}
	
	@Test
	public void testMapToJson(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", "jack");
		map.put("age", 13);
		map.put("adult", false);
		String jsonResult = JSON.toJSONString(map);
		log.info(jsonResult);
		//{"name":"jack","adult":false,"age":13}
	}
	
	@Test
	public void testBeanToJson(){
		Person p = new Person("zhangsan",23,true);
		String jsonResult = JSON.toJSONString(p);
		log.info(jsonResult);
		//{"adult":true,"age":23,"name":"zhangsan"}
	}
	
	@Test
	public void testDateToJson(){
		Date date = new Date();
		log.info("Date : " + date);
		//Date : Sun Mar 05 12:45:11 CST 2017
		
		//转换为毫秒值
		log.info("JSON : " + JSON.toJSONString(date));
		//JSON : 1488689111132
		
		//输出默认格式
		log.info("JSON OF DEFAUT ：" + JSON.toJSONString(date, SerializerFeature.WriteDateUseDateFormat));
		//JSON OF DEFAUT ："2017-03-05 12:45:11"
		
		//输出定制格式
		log.info("JSON OF CUSTOMIZE : " + JSON.toJSONStringWithDateFormat(date, "yyyy-MM-dd", SerializerFeature.WriteDateUseDateFormat));
		//JSON OF CUSTOMIZE : "2017-03-05"
	}
	
	@Test
	public void testJsonToArray(){
		String json = "['上海',99,true,12.22]";
		Object[] oo = JSON.parseObject(json, Object[].class);
		log.info(Arrays.asList(oo));
		//[上海, 99, true, 12.22]
	}
	
	@Test
	public void testJsonToList(){
		String json = "['NewYork','London']";
		List list = JSON.parseObject(json, List.class);
		log.info(list);
		//[NewYork, London]
	}
	
	@Test
	public void testJsonToMap(){
		String json = "{\"name\":'jack','adult':false,\"age\":13}";
		Map map = JSON.parseObject(json,Map.class);
		log.info(map);
		//{name=jack, adult=false, age=13}
	}
	
	@Test
	public void testJsonToBean(){
		String json = "{'adult':true,'age':23,'name':'zhangsan'}";
		Person pp = JSON.parseObject(json, Person.class);
		log.info(pp);
		//Person [name=zhangsan, age=23, adult=true]
	}

}
