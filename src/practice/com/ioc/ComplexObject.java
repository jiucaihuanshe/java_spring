package practice.com.ioc;

import java.util.List;
import java.util.Map;
import java.util.Properties;
/** 定义一个相对复杂的对象，如何为对象中这些数组或集合类型的属性注入值 */
public class ComplexObject {
	private String[] hobby;
	private List<String>address;
	private Map<String,String>phones;
	private Properties configs;
	
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	public List<String> getAddress() {
		return address;
	}
	public void setAddress(List<String> address) {
		this.address = address;
	}
	public Map<String, String> getPhones() {
		return phones;
	}
	public void setPhones(Map<String, String> phones) {
		this.phones = phones;
	}
	public Properties getConfigs() {
		return configs;
	}
	public void setConfigs(Properties configs) {
		this.configs = configs;
	}
	
}
