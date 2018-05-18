package practice.com.project.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("point")
public class Point{
	@Value("5")
	private int x;
	@Value("8")
	private int y;
	public Point() {}
	@Autowired
	public Point(int x,int y) {
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return x;
	}
}
