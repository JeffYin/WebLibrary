package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import controllers.Persons;

import play.db.jpa.Model;

@Entity
public class BorrowItem extends Model {
	@Column
    public String libraryCardBarcode;
	
	@ManyToOne
	public User reader;
//	public String userId;
	
	@ManyToOne
	public Item item;
	
//	public String itemBarcode;

	public Date borrowedDate; //The day when the item was borrowed.  
	
	public Date dueDate; //The day when the item should return to the library. 
	
	public Date returnedDate; //The date when the item is returned to the library. 

	@Override
	public String toString() {
		return "BorrowItem [libraryCardBarcode=" + libraryCardBarcode
				+ ", reader=" + reader + ", item=" + item + ", borrowedDate="
				+ borrowedDate + ", dueDate=" + dueDate + "]";
	}

}
