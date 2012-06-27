package models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ItemStatus extends BusinessModel {
	@Column(length=16)
	public String code;
	
	@Column(length=64)
    public String name;
	@Override
	public String toString() {
		return "ItemStatus [code=" + code + ", name=" + name + "]";
	}

}
