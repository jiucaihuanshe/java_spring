package practice.com.project.test;

public class TestIdGenerator {
	
	public static void main(String[] args) {
		IdGenerator ig = new IdGenerator();
		System.out.println(ig.getPrefix()+ig.getSuffix());
	}
}
