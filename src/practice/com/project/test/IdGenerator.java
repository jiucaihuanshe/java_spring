package practice.com.project.test;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
public class IdGenerator {
	
	private String prefix;
	
	private String suffix;
	public IdGenerator() {
	}
	public String getPrefix() {
		return prefix;
	}
	@Value("#{ig.prefix}")
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getSuffix() {
		return suffix;
	}
	@Value("#{ig.suffix}")
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

}
