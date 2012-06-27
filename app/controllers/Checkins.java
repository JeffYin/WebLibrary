package controllers;

import java.lang.reflect.Constructor;
import java.util.List;

import models.BorrowItem;
import models.Item;

import play.db.Model;
import play.exceptions.TemplateNotFoundException;
import controllers.CRUD.ObjectType;
import flexjson.JSONSerializer;

public class Checkins extends CRUD{
	public static void blank() throws Exception {
            render("Checkins/scanItem.html");
	}
	
	public static void checkin(String[] itemBarcodeScanned) throws Exception {
		
	}
	
	public static void scanItem(String barcode) throws Exception {
		// 
		//TODO: Lookup the barcode from the borrowed material.
		List<BorrowItem> items = BorrowItem.find("item.barcode = ?", barcode).fetch();
		
		int numberFound = items.size();
		if (numberFound==1) { /* found the exact item */
			BorrowItem borrowItem = items.get(0);
			Item item = borrowItem.item;
			String info = toJson(item);
			renderJSON(info);
		} else if (numberFound==0) { /* found nothing */
			response.status =  700;
		} else { /* more than one items found */
            response.status = 710;			
		}
	}
	
	private static String toJson(Item item) {
		JSONSerializer borrowedItemSerializer = new JSONSerializer().include("barcode", "name").exclude("*");
		String json = borrowedItemSerializer.serialize(item);
		return json;
	}
}
