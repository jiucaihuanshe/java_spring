package practice.com.factory;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
/***
 * 需求:
 * 构建ApplicationContext对象
 * 时,读取指定的文件(xml),根据配置
 * 创建对象,并将对象信息存储到
 * map,需要对象时,从map获取
 * @author adminitartor
 */
public class ApplicationContext {
	private static Map<String,Object> beanMap=
			new HashMap<>();
	public ApplicationContext(String file){
		init(file);
	}
	/**初始化对象,然后存储到map*/
	private void init(String file){//beans.xml
		//1.读取文件
		 InputStream in=getClass().getClassLoader()
		.getResourceAsStream(file);//推荐(直接从类路径下读取)
		//2.解析文件(重点dom4j解析,了解 DOM解析,SAX,PULL)
		//2.1创建解析器对象
		 SAXReader sr=new SAXReader();
		//2.2读取数据
		 Document doc=null;
		 try {
		  doc=sr.read(in);
		 } catch (DocumentException e) {
		  e.printStackTrace();
		  throw new RuntimeException(e);
		 }
		 //2.3获取根元素
		 Element root=doc.getRootElement();
		 //2.4获取根元素中的所有bean元素
		 List<Element> list=root.elements("bean");
		 //2.5迭代所有bean元素
		 for(Element e:list){
		  String idValue=e.attributeValue("id");
		  String clsValue=e.attributeValue("class");
		  Object obj=null;
		 //3.创建对象
		  try{
		  obj=Class.forName(clsValue).newInstance();
		  }catch(Exception e1){
		  throw new RuntimeException(e1);
		  }
		  //4.存储对象
		  beanMap.put(idValue, obj);
		 }
	}
	/**从map中获取对象*/
	public Object getBean(String key){
		return beanMap.get(key);
	}
	/**<T>写到方法的返回值左边时表示此方法
	 * 为一个泛型方法,具体泛型的类型会由相关
	 * 参数类型进行决定
	 * 何为泛型?编译时的一种类型,运行时无效.
	 * 应用场景?项目中的通用编程
	 * 泛型应用类型?泛型类,泛型方法
	 * */
	public <T>T getBean(String key,Class<T> cls){
		return (T)beanMap.get(key);
	}
	/**释放资源*/
	public void close(){
		beanMap.clear();
		beanMap=null;
	}
}