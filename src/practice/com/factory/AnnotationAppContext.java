package practice.com.factory;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
/**
 * 给定一个包，包中几个类
 * 定义一个工厂，扫描指定包中的类
 * 基于反射构建所有类的对象
 * 将对象存储于工厂对于的容器中(Map类型)
 * @author Administrator
 *
 */
public class AnnotationAppContext {
	private Map<String,Object> beanMap=new HashMap<>();
	public AnnotationAppContext() {
		String pkg="practice.com.service";
		scanPkg(pkg);
	}
	/** 扫描指定包，找到包中的类文件 */
	private void scanPkg(final String pkg){
		//1.替换包名中的. 将包结构转换为目录结构
		String pkgDir = pkg.replaceAll("\\.", "/");
		//2.获取目录结构在类路径中的位置 （url:统一资源定位）url中封装了具体资源的路径
		URL url = getClass().getClassLoader().getResource(pkgDir);
		//3.基于这个路径资源(url)，构建一个文件对象
		File file = new File(url.getFile());
		
		//4.获取词目录中指定标准的文件
		File[] fs = file.listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File file) {
				//获取文件名
				String fName = file.getName();
				
				if(file.isDirectory()){
					scanPkg(pkg+"."+fName);
				}
				//获取文件的后缀是否为.class文件
				if(fName.endsWith(".class")){
					return true;
				}
				return false;
			}
		});//所有的文件对象
		
		for(File f: fs){
			String fName = f.getName();
			fName=fName.substring(0,fName.lastIndexOf("."));
			String key = String.valueOf(fName.charAt(0)).toLowerCase()+fName.substring(1);
			String clsName=pkg+"."+fName;
			try {
				//通过反射构建对象
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
