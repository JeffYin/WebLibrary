package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import controllers.Persons;

import play.db.jpa.Model;

@Entity
public class BorrowItem extends Model {
	@Column
    public String libraryCardBarcode;
	
	public String userId;
	
	public String itemBarcode;

	public Date borrowedDate; //The day when the item was borrowed.  
	
	public Date dueDate; //The day when the item should return to the library. 
	
	
	@Override
	public String toString() {
		return "BorrowItem [libraryCardBarcode=" + libraryCardBarcode
				+ ", userId=" + userId + ", itemBarcode=" + itemBarcode
				+ "]";
	} 
	
	

}
