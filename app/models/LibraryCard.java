package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class LibraryCard extends BusinessModel {
  public String barcode;
  
  @Temporal(TemporalType.DATE)
  public Date createdDate;
  
  @ManyToOne(cascade=CascadeType.PERSIST)
  @JoinColumn(name="uid", referencedColumnName="uid")
  public User user;

  public LibraryCard() {
	  createdDate = new Date();
  }
  
	@Override
public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((barcode == null) ? 0 : barcode.hashCode());
	result = prime * result
			+ ((createdDate == null) ? 0 : createdDate.hashCode());
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
	LibraryCard other = (LibraryCard) obj;
	if (barcode == null) {
		if (other.barcode != null)
			return false;
	} else if (!barcode.equals(other.barcode))
		return false;
	if (createdDate == null) {
		if (other.createdDate != null)
			return false;
	} else if (!createdDate.equals(other.createdDate))
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
		return "LibraryCard [barcode=" + barcode + ", createdDate=" + createdDate
				+ ", user=" + user + "]";
	}
	  
  
}
