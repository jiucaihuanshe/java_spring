package practice.com.factory;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
/**
 * ����һ���������м�����
 * ����һ��������ɨ��ָ�����е���
 * ���ڷ��乹��������Ķ���
 * ������洢�ڹ������ڵ�������(Map����)
 * @author Administrator
 *
 */
public class AnnotationAppContext {
	private Map<String,Object> beanMap=new HashMap<>();
	public AnnotationAppContext() {
		String pkg="practice.com.service";
		scanPkg(pkg);
	}
	/** ɨ��ָ�������ҵ����е����ļ� */
	private void scanPkg(final String pkg){
		//1.�滻�����е�. �����ṹת��ΪĿ¼�ṹ
		String pkgDir = pkg.replaceAll("\\.", "/");
		//2.��ȡĿ¼�ṹ����·���е�λ�� ��url:ͳһ��Դ��λ��url�з�װ�˾�����Դ��·��
		URL url = getClass().getClassLoader().getResource(pkgDir);
		//3.�������·����Դ(url)������һ���ļ�����
		File file = new File(url.getFile());
		
		//4.��ȡ��Ŀ¼��ָ����׼���ļ�
		File[] fs = file.listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File file) {
				//��ȡ�ļ���
				String fName = file.getName();
				
				if(file.isDirectory()){
					scanPkg(pkg+"."+fName);
				}
				//��ȡ�ļ��ĺ�׺�Ƿ�Ϊ.class�ļ�
				if(fName.endsWith(".class")){
					return true;
				}
				return false;
			}
		});//���е��ļ�����
		
		for(File f: fs){
			String fName = f.getName();
			fName=fName.substring(0,fName.lastIndexOf("."));
			String key = String.valueOf(fName.charAt(0)).toLowerCase()+fName.substring(1);
			String clsName=pkg+"."+fName;
			try {
				//ͨ�����乹������
				Class<?> c = Class.forName(clsName);
				if(c.isAnnotationPresent(CGB1803.class)){
					Object obj = c.newInstance();
					beanMap.put(key, obj);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
	public Object getBean(String key){
		return beanMap.get(key);
	}
	public void close(){
		beanMap.clear();
		beanMap=null;
	}
	public static void main(String[] args) {
		AnnotationAppContext ctx = new AnnotationAppContext();
		Object obj = ctx.getBean("userService");
		System.out.println(obj);
		ctx.close();
	}
}
