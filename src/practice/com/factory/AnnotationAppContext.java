package practice.com.factory;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
/**
 * ����һ���������м�����
 * ����һ��������ɨ��ָ�����е���
 * ���ڷ��乹��������Ķ���
 * ������洢�ڹ������ڵ�������(Map����)
 * @author Administrator
 *
 */
public class AnnotationAppContext {
	public AnnotationAppContext() {
		String pkg="practice.com.beans";
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
		file.listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File file) {
				//��ȡ�ļ���
				String fName = file.getName();
				if(file.isDirectory()){
					scanPkg(pkg+"."+fName);
				}
				//��ȡ�ļ��ĺ�׺�Ƿ�Ϊ.class�ļ�
				if(fName.endsWith(".class")){
					//ͨ�����乹�����class�ļ��Ķ���
					fName= fName.substring(0,fName.lastIndexOf("."));
					String clsName=pkg+"."+fName;
					try {
						Object obj = Class.forName(clsName).newInstance();
						System.out.println(obj);
					} catch (Exception e) {
						e.printStackTrace();
					}
					return true;
				}
				return false;
			}
		});//���е��ļ�����
	}
	public static void main(String[] args) {
		AnnotationAppContext ctx = new AnnotationAppContext();
		
	}
}
