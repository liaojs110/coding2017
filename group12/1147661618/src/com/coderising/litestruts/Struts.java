package com.coderising.litestruts;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Struts {

    public static View runAction(String actionName, Map<String,String> parameters) {

        /*
         
		0. 读取配置文件struts.xml
 		
 		1. 根据actionName找到相对应的class ， 例如LoginAction,   通过反射实例化（创建对象）
		据parameters中的数据，调用对象的setter方法， 例如parameters中的数据是 
		("name"="test" ,  "password"="1234") ,     	
		那就应该调用 setName和setPassword方法
		
		2. 通过反射调用对象的exectue 方法， 并获得返回值，例如"success"
		
		3. 通过反射找到对象的所有getter方法（例如 getMessage）,  
		通过反射来调用， 把值和属性形成一个HashMap , 例如 {"message":  "登录成功"} ,  
		放到View对象的parameters
		
		4. 根据struts.xml中的 <result> 配置,以及execute的返回值，  确定哪一个jsp，  
		放到View对象的jsp字段中。
        
        */
        View view = null;
    	try {
    		//读取struts.xml
    		File f = new File("src/com/coderising/litestruts/struts.xml");
    		SAXReader reader = new SAXReader();
    		Document doc = reader.read(f);
    		Element root = doc.getRootElement();
    		List<Element> childElements = root.elements();
	        for (Element child : childElements) {
	        	//寻找action配置，找到对应的action类执行默认的excute方法
	        	if("action".equals(child.getName())) {
	        		if(!actionName.equals(child.attributeValue("name"))) {
	        			continue;
	        		}
	        		String className = child.attributeValue("class");
	        		Class clazz = Class.forName(className);
	        		Constructor constructor = clazz.getConstructor();
	        		Object o = constructor.newInstance();//实例化类的对象
	        		
	        		//执行对象的setter方法，将传入的map对象键值对设置进去
	        		Set set = parameters.entrySet();
	        		Iterator i = set.iterator();
	        		while(i.hasNext()) {
	        			Map.Entry entry = (Entry) i.next();
	        			String key = entry.getKey().toString();
	        			Method settMethod = clazz.getMethod("set"+getMethodName(key),entry.getValue().getClass());
	        			settMethod.invoke(o, entry.getValue());
	        		}
	        		
	        		//执行excute方法
	        		Method method = clazz.getMethod("execute");
	        		Object jsp = method.invoke(o);

		            view = new View();
		            Map params = new HashMap();
		            Method[] methods = clazz.getMethods();
		            //通过反射找到对象的所有getter方法，并键值对写到parameter里面
		            for(Method m : methods) {
		            	String methodName = m.getName();
		            	if(methodName.length() >= 4 && "get".equals(methodName.substring(0, 3))) {
		            		params.put(getParameter(methodName.substring(3)), m.invoke(o));
		            	}
		            }
		            view.setParameters(params);
		            
		            //根据struts.xml中的 <result> 配置,以及execute的返回值，  确定哪一个jsp，放到View对象的jsp字段中
	        		List<Element> elementList = child.elements();
		            for (Element ele : elementList) {
		                if (jsp.equals(ele.attributeValue("name"))) {
		 		            view.setJsp(ele.getText());
		                }
		            }
	        	}
	        }
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	return view;
    }    
    
    private static String getMethodName(String fildeName) throws Exception{  
        byte[] items = fildeName.getBytes();  
        items[0] = (byte) ((char) items[0] - 'a' + 'A');  
        return new String(items);  
    }  
    
    private static String getParameter(String fildeName) throws Exception{  
        byte[] items = fildeName.getBytes();  
        items[0] = (byte) ((char) items[0] - 'A' + 'a');  
        return new String(items);  
    }  

}