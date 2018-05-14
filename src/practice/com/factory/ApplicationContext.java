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
 * ����:
 * ����ApplicationContext����
 * ʱ,��ȡָ�����ļ�(xml),��������
 * ��������,����������Ϣ�洢��
 * map,��Ҫ����ʱ,��map��ȡ
 * @author adminitartor
 */
public class ApplicationContext {
	private static Map<String,Object> beanMap=
			new HashMap<>();
	public ApplicationContext(String file){
		init(file);
	}
	/**��ʼ������,Ȼ��洢��map*/
	private void init(String file){//beans.xml
		//1.��ȡ�ļ�
		 InputStream in=getClass().getClassLoader()
		.getResourceAsStream(file);//�Ƽ�(ֱ�Ӵ���·���¶�ȡ)
		//2.�����ļ�(�ص�dom4j����,�˽� DOM����,SAX,PULL)
		//2.1��������������
		 SAXReader sr=new SAXReader();
		//2.2��ȡ����
		 Document doc=null;
		 try {
		  doc=sr.read(in);
		 } catch (DocumentException e) {
		  e.printStackTrace();
		  throw new RuntimeException(e);
		 }
		 //2.3��ȡ��Ԫ��
		 Element root=doc.getRootElement();
		 //2.4��ȡ��Ԫ���е�����beanԪ��
		 List<Element> list=root.elements("bean");
		 //2.5��������beanԪ��
		 for(Element e:list){
		  String idValue=e.attributeValue("id");
		  String clsValue=e.attributeValue("class");
		  Object obj=null;
		 //3.��������
		  try{
		  obj=Class.forName(clsValue).newInstance();
		  }catch(Exception e1){
		  throw new RuntimeException(e1);
		  }
		  //4.�洢����
		  beanMap.put(idValue, obj);
		 }
	}
	/**��map�л�ȡ����*/
	public Object getBean(String key){
		return beanMap.get(key);
	}
	/**<T>д�������ķ���ֵ���ʱ��ʾ�˷���
	 * Ϊһ�����ͷ���,���巺�͵����ͻ������
	 * �������ͽ��о���
	 * ��Ϊ����?����ʱ��һ������,����ʱ��Ч.
	 * Ӧ�ó���?��Ŀ�е�ͨ�ñ��
	 * ����Ӧ������?������,���ͷ���
	 * */
	public <T>T getBean(String key,Class<T> cls){
		return (T)beanMap.get(key);
	}
	/**�ͷ���Դ*/
	public void close(){
		beanMap.clear();
		beanMap=null;
	}
}