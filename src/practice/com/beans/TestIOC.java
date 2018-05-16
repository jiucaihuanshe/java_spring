package practice.com.beans;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIOC {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("ioc.xml");
		DataSource ds = cxt.getBean("dataSource2", DataSource.class);
		System.out.println(ds);
		
		JdbcTemplate tp = cxt.getBean("jdbcTemplate", JdbcTemplate.class);
		System.out.println(tp.getDataSource());
		
		JdbcTemplate tp2 = cxt.getBean("jdbcTemplate2", JdbcTemplate.class);
		System.out.println(tp2.getDataSource());
		
		JdbcTemplate tp3 = cxt.getBean("jdbcTemplate3", JdbcTemplate.class);
		System.out.println(tp3.getDataSource());
		
		cxt.close();
	}
}