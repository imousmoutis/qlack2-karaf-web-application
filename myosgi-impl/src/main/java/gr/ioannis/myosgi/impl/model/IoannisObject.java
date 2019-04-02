package gr.ioannis.myosgi.impl.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class IoannisObject {

	private Integer id;

	private String name;

	private Integer num;

	public IoannisObject() {
		super();
	}

	public IoannisObject(Integer id, String name, Integer num) {
		super();
		this.id = id;
		this.name = name;
		this.num = num;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

}
