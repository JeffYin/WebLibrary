package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

@Entity
public class Item extends BusinessModel {
	@Column(length=64)
    public String barcode;
	
	@Column(length=128)
    public String name; 
	
	@Column(length=128)
    public String otherName; 
	
	@Column(length=1024)
    public String description;
	
	public Integer dueDay; 
	
	@Column
	public ItemType type;

	@Override
	public String toString() {
		return "Item [barcode=" + barcode + ", name=" + name + ", otherName="
				+ otherName + ", description=" + description + ", id=" + id
				+ "]";
	} 
    
	
}
