/**
 * 
 */
package odro.api.apitest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author wizar
 *
 */
public class RequestApiBean {
	@JsonProperty("name")
	private String name;
	@JsonProperty("txt")
	private String txt;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}
	
	

}
