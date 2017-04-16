package zx.json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

//官网地址：http://json-lib.sourceforge.net
public class JsonLibTestCases {

	Logger log = Logger.getLogger(JsonLibTestCases.class);

	@Test
	public void testStringArrayToJson() {
		String[] strArray = { "zhangsan", "Lisi", "Wangwwu" };
		JSONArray jsonArray = JSONArray.fromObject(strArray);
		log.info(jsonArray);
		//["zhangsan","Lisi","Wangwwu"]
	}
	
	@Test
	public void testObjectArrayToJson(){
		Object[] objArray = {"上海",99,true,12.22};
		JSONArray jsonArray = JSONArray.fromObject(objArray);
		log.info(jsonArray);
		//["上海",99,true,12.22]
	}
	
	@Test
	public void testListToJson(){
		List<String> list = new ArrayList<String>();
		list.add("NewYork");
		list.add("London");
		JSONArray jsonArray = JSONArray.fromObject(list);
		log.info(jsonArray);
		//["NewYork","London"]
	}
	
	@Test
	public void testSetToJson(){
		Set<Object> set = new HashSet<Object>();
		set.add("Java");
		set.add(12.22);
		set.add(true);
		JSONArray jsonArray = JSONArray.fromObject(set);
		log.info(jsonArray);
		//[12.22,"Java",true]
	}

	@Test
	public void testMapToJson(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", "jack");
		map.put("age", 13);
		map.put("adult", false);
		JSONObject jsonObject = JSONObject.fromObject(map);
		log.info(jsonObject);
		//{"name":"jack","adult":false,"age":13}
	}
	
	@Test
	public void testJavaBeanToJson(){
		Person p = new Person("zhangsan",23,true);
		JSONObject jsonObject = JSONObject.fromObject(p);
		log.info(jsonObject);
		//{"adult":true,"age":23,"name":"zhangsan"}
	}
	
	@Test
	public void testMapBeanToJson(){
		Map<String,Object> map = new HashMap<String,Object>();
		Person p = new Person("zhangsan",23,true);
		map.put("person", p);
		JSONObject jsonObject = JSONObject.fromObject(map);
		log.info(jsonObject);
		//{"person":{"adult":true,"age":23,"name":"zhangsan"}}
	}
	
	@Test
	public void testJsonConfig(){
		Map<String,Object> map = new HashMap<String,Object>();
		JsonConfig config = new JsonConfig();
		//把所有的name属性排除在外
		config.setExcludes(new String[]{"name"});
		Person p = new Person("zhangsan",23,true);
		map.put("person", p);
		map.put("name", "Lily");
		JSONObject jsonObject = JSONObject.fromObject(map,config);
		log.info(jsonObject);
		//{"person":{"adult":true,"age":23}}
	}
	
	@Test
	public void testJsonToArray(){
		JSONArray jsonArray = JSONArray.fromObject("[10,20,30]");
		Object array = JSONArray.toArray(jsonArray);
		log.info(Arrays.asList((Object[])array));
		//[10, 20, 30]
	}
	
	@Test
	public void testJsonToMap(){
		String str = "{\"name\":\"tom\",\"age\":90}";
		JSONObject jsonObject = JSONObject.fromObject(str);
		Map<String,Object> map = (Map<String, Object>) JSONObject.toBean(jsonObject,Map.class);
		log.info(map);
		//{name=tom, age=90}
	}
	
	@Test
	public void testJsonToBean(){
		String str = "{\"name\":\"jack\",\"age\":19,\"adult\":false}";
		JSONObject jsonObject = JSONObject.fromObject(str);
		Person p = (Person) JSONObject.toBean(jsonObject, Person.class);
		log.info(p);
		//Person [name=jack, age=19, adult=false]
	}
	
}
