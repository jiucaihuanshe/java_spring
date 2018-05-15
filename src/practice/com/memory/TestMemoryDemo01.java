package practice.com.memory;

class Outer{
	/** ʵ���ڴ��ࣺ��������������ⲿ�����Ĭ�ϻᱣ���ⲿ������һ������ */
	class WorkThread01 extends Thread{
		@Override
		public void run() {
			while(true){}
		}
	}
	
	/** ��̬�ڲ��ࣺ��̬�ڲ��಻�������ⲿ������ڣ����ᱣ���ⲿ������� */
	//Ϊʲô�þ�̬�ģ�ԭ�򣺿��ܴ����ڴ�й©���⣬Ϊʲô�����ڴ�й©����Ϊʵ���ڲ���ᱣ��
	//�ⲿ���һ�����ã���ʵ���ڲ��಻���ٵĻ����ᵼ���ⲿ�಻�ܱ����٣����о������ڴ�й©
	//������
	static class WorkThread02 extends Thread{
		@Override
		public void run() {
			while(true){}
		}
	}
	
	/** �˷����ڶ������֮ǰ���� */
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize()");
	}
}

public class TestMemoryDemo01 {
	public static void main(String[] args) {
		Outer out = new Outer();
		//out.new WorkThread01().start();
		new Outer.WorkThread02().start();
		out = null;
		//֪ͨJVM���ڴ����������ˣ���ʱ����Թ�����������
		System.gc();
	}
}
