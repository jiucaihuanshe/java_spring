package practice.com.beans;

public class JdbcTemplate {
	private DataSource dataSource;

	public JdbcTemplate(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public JdbcTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
