package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAnyAttribute;

@Entity
public class BookStatus extends BusinessModel {
	@Column(length=16)
	public String code;
	
	@Column(length=64)
    public String name;
	@Override
	public String toString() {
		return "BookStatus [code=" + code + ", name=" + name + "]";
	}

}
