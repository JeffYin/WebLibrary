package models;

import javax.persistence.Column;
import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class BorrowItem extends Model {
	@Column
    public String libraryCardBarcode;
	
	public String userName;
	
	public String itemBarcode;

	@Override
	public String toString() {
		return "BorrowItem [libraryCardBarcode=" + libraryCardBarcode
				+ ", userName=" + userName + ", itemBarcode=" + itemBarcode
				+ "]";
	} 
	
	

}
