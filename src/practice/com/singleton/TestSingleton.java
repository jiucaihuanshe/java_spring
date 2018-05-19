package practice.com.singleton;
/**
 * ���ģʽ��һ����·��һ�־����ܽ�
 * ����ģʽ��
 * 1������һ�ִ�����ģʽ������󴴽���أ�
 * 2����Ϊ�˱�֤��Ķ������ڴ��е�ȫ��Ψһ�ԣ���������һ����ƹ���
 * ����ģʽӦ�ó�����
 * 1���ض����Ӧ�ã������ַ����أ�
 * 2����Դ���ʶ���
 * ����ģʽӦ�õ�Ŀ�ģ������ٶ������Դռ�ã�
 * ����ģʽ�ľ���ʵ��˼·��
 * ����
 * 1������ⲿ������ֱ�ӹ����������
 * 2������ⲿֻ��ͨ����̬�������ʴ˶���
 * ʵ�֣�
 * 1�����췽��˽�л�
 * 2��������ڲ���������
 * 3������һ����̬������ͨ���������ֱ�ӷ��ش˶���
 */

//������Ʒ���1�����߳���û���κ����⣬���̲߳���ִ�г������⡣��
class Singleton01{
	private Singleton01(){}
	private static Singleton01 instance;
	public static Singleton01 getInstance(){//�����ݼ��ϵĲ�������ԭ�Ӳ���
		if(instance==null){//instance�ǹ������ݼ�
			instance=new Singleton01();
		}
		return instance;
	}
}
//���ϵ�����Ƽ����ܴ���ʲô���⣿���̰߳�ȫ���⣩

//������Ʒ���2���̰߳�ȫ������
class Singleton02{
	private Singleton02(){}
	private static Singleton02 instance;
	public static synchronized Singleton02 getInstance(){//�������̰߳�ȫ
		if(instance==null){
			instance=new Singleton02();
		}
		return instance;
	}
}
//���ϵ�����Ƽ����ܴ���ʲô���⣿���������⣩

//������Ʒ���3���̰߳�ȫ+Ч�ʣ�(�����ϡ����)
class Singleton03{
	private Singleton03(){}
	private static Singleton03 instance;
	public static Singleton03 getInstance(){
		if(instance==null){
			synchronized (Singleton03.class) {
				if(instance==null){
					instance=new Singleton03();
				}
			}
		}
		return instance;
	}
}
//��������ʺ϶�instance�����Ƶ�������𣿣����ʺϣ�

//������Ʒ���4���ʺ�Ƶ�����ʣ�(С����Ƶ����)
class Singleton04{
	private Singleton04(){}
	//��������ʱ������ �����ʱ�������������ʼ��һ��
	private static final Singleton04 instance = new Singleton04();
	//�˷�����Ϊû���������⣬�����ʺ�Ƶ������
	public static Singleton04 getInstance(){
		return instance;
	}
	//public static void display(){}
}
//����������ƴ���ʲô���⣿���������Ƚϴ������ʱ�ʹ����˴˶��󣬼��粻���ã��Ϳ��ܳ�ʱ��ռ����Դ��

//������Ʒ���5�������ӳټ��ز����Ż���Ʒ���4��
class Singleton05{
	private Singleton05(){}
	static class Lazy{//���ʱ�����أ�ʹ�����ʱ����أ�1�����������ʱ����������  2��������ľ�̬�ĳ�Ա����̬�ı������߾�̬�ķ�����
		public static final Singleton05 instance = new Singleton05();
	}
	public static Singleton05 getInstance(){
		//��ʱ��Ҫ��ʱ����
		return Lazy.instance;
	}
	//���ʷ���Singleton05���display����ʱ������Lazy��  �����ᣩ
	public static void display(){}
	//���ʷ���Singleton05���show����ʱ������Lazy��  ���ᣩ
	public void show(){}
}


public class TestSingleton {
	public static void main(String[] args) {
		/*for(int i=0;i<10;i++){
			System.out.println(Singleton01.getInstance());
		}*/
		
		for(int i=0;i<10;i++){
			new Thread(){
				@Override
				public void run() {
					super.run();
					System.out.println(Singleton03.getInstance());
				};
			}.start();
		}
	}
}

//private static volatile Singleton03 instance;
//volatile ��ʲô����