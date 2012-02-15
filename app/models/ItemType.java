package models;

import javax.persistence.Column;
import javax.persistence.Entity;

import play.data.validation.Max;
import play.data.validation.Min;
import play.data.validation.Required;

@Entity
public class ItemType extends BusinessModel{
 @Required
 @Column(length=32)
 public String code;
 
 @Required
 @Column(length=128)
 public String name; 
 
 @Required
 @Min(1)
 @Max(60)
 public Integer dueDay;
 
 
@Override
public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((code == null) ? 0 : code.hashCode());
	return result;
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (!super.equals(obj))
		return false;
	if (getClass() != obj.getClass())
		return false;
	ItemType other = (ItemType) obj;
	if (code == null) {
		if (other.code != null)
			return false;
	} else if (!code.equals(other.code))
		return false;
	return true;
}


@Override
public String toString() {
	return "ItemType [name=" + name + ", dueDay=" + dueDay + "]";
} 
 
 
}
