package models;

import play.*;
import play.data.validation.Required;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class IOwnYou extends BusinessModel {
	@Required
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="uid",referencedColumnName="uid")
    public User user; 
	
	@Required
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="item_barcode",referencedColumnName="barcode")
    public Item item;
	
	@Required
	@Temporal(TemporalType.DATE)
    public Date borrowDate;
	
	@Required
	@Temporal(TemporalType.DATE)
    public Date returnDate;
	
	@Required
	@Temporal(TemporalType.TIMESTAMP)
	public Date createdDate;

	
	
	public IOwnYou() {
		borrowDate = new Date();
		createdDate = new Date();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((borrowDate == null) ? 0 : borrowDate.hashCode());
		result = prime * result
				+ ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result
				+ ((returnDate == null) ? 0 : returnDate.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		IOwnYou other = (IOwnYou) obj;
		if (borrowDate == null) {
			if (other.borrowDate != null)
				return false;
		} else if (!borrowDate.equals(other.borrowDate))
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (returnDate == null) {
			if (other.returnDate != null)
				return false;
		} else if (!returnDate.equals(other.returnDate))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "IOwnYou [user=" + user + ", item=" + item + ", borrowDate="
				+ borrowDate + ", returnDate=" + returnDate + ", createdDate="
				+ createdDate + "]";
	}
	
	
    
}
