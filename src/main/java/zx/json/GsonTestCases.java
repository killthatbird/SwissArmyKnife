package zx.json;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonTestCases {

	Logger log = Logger.getLogger(GsonTestCases.class);
	
	@Test
	public void testBeanToJson() {
		Person p = new Person("lisi",22,true);
		Gson gson = new Gson();
		log.info(gson.toJson(p));
		//{"NAME":"lisi","age":22,"adult":true}
	}
	
	@Test
	public void testBeanToJson2() {
		Person p = new Person("lisi",22,true);
		GsonBuilder gb = new GsonBuilder();
		gb.setPrettyPrinting();//格式化JSON数据，使其更美观,主要在调试的时候用
		gb.setFieldNamingStrategy(new FieldNamingStrategy(){//在生成JSON之前可以做一些处理

			public String translateName(Field f) {
				if(f.getName().equals("age")){
					return "AGE";
				}
				return f.getName();
			}
			
		});
		Gson gson = gb.create();
		log.info(gson.toJson(p));
	}
	
	@Test
	public void testBeanToJson3() {
		Person p = new Person("lisi",22,true);
		p.setIgnore("被忽略");
		Gson gson = new Gson();
		log.info(gson.toJson(p));
	}
	
	@Test
	public void testJsonToBean() throws IOException{
		File file = new File(GsonTestCases.class.getResource("person.json").getFile());
		String content = FileUtils.readFileToString(file);
		Gson gson = new Gson();
		//json文件中的key必须与bean中的属性严格一致，大小写敏感
		Person p = gson.fromJson(content, Person.class);
		log.info(p);
	}
	
	@Test
	public void testJsonToDate(){
		String date = "1990-02-24";
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Date dd = gson.fromJson(date, Date.class);
		log.info(dd);
	}

}
