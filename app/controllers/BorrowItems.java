package controllers;

import java.lang.reflect.Constructor;
import java.util.List;

import models.BorrowItem;
import models.Item;
import models.ItemStatus;
import models.LibraryCard;

import org.joda.time.DateTime;

import play.Play;
import play.db.Model;
import play.exceptions.TemplateNotFoundException;
import utils.Globals;
import flexjson.JSONSerializer;

public class BorrowItems extends CRUD {
	public static void blank() throws Exception {
        ObjectType type = ObjectType.get(getControllerClass());
        notFoundIfNull(type);
        Constructor<?> constructor = type.entityClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        Model object = (Model) constructor.newInstance();
        try {
            render("BorrowItems/scanLibraryCard.html", type, object);
        } catch (TemplateNotFoundException e) {
            render("CRUD/blank.html", type, object);
        }
	}
	
	
	
	
	public static void scanItem(String barcode) throws Exception {
		List<Item> items = Item.find("barcode = ?", barcode).fetch();
		int numberFound = items.size();
		if (numberFound==1) { /* found the exact item */
			Item item = items.get(0);
			String info = toJson(item);
			renderJSON(info);
		} else if (numberFound==0) { /* found nothing */
			response.status =  700;
		} else { /* more than one items found */
            response.status = 710;			
		}
	}
	
	public static void scanLibraryCard(String librarycardBarcode) throws Exception {
		List<LibraryCard> cards = LibraryCard.find("barcode like ?", "%"+librarycardBarcode +"%").fetch();
		if (cards.size()>=1) {
			flash.put("libraryCardBarcode", cards.get(0).barcode);
			
			//TODO: prepare the page of scanning the material barcode.  
			render("BorrowItems/scanItem.html");
		}
		
	}
	
	/**
	 * Complete the checkout action. 
	 * @param libraryCardBarcode
	 * @param itemBarcodeScanned
	 */
	public static void checkout(String libraryCardBarcode,String[] itemBarcodeScanned) {
		System.out.println(libraryCardBarcode);
		
		//Get the userId of the library card. 
		LibraryCard libCard = LibraryCard.find("barcode = ?", libraryCardBarcode).first();
		String userId = "";
		
		if (libCard!=null) {
			//TODO:Check if the libraryCard is still available. 
			
			//get the userId
			userId = libCard.user.personId;
		}
		
		for (String itemBarcode: itemBarcodeScanned) {
			//TODO: Check if the item is expired.  
			
			Item item = Item.find("barcode = ?", itemBarcode).first();
			Integer dueDay = item.dueDay;
			//Get the due Date of the
			if (dueDay==null) {
				dueDay = Integer.parseInt(Play.configuration.getProperty("default_due_day"));
			}
						
			BorrowItem borrowItem = new BorrowItem(); 
			borrowItem.itemBarcode = itemBarcode; 
			borrowItem.libraryCardBarcode = libraryCardBarcode;
			borrowItem.userId = userId;
			borrowItem.dueDate = new DateTime().plusDays(dueDay).toDate();
			borrowItem.borrowedDate = new DateTime().toDate();
			
			borrowItem.save();
			
			//TODO: Change the status of the Item
			ItemStatus itemStatus = ItemStatus.find("code = ?", Globals.ItemStatusBorrowedCode).first();
			item.itemStatus = itemStatus;
			item.save();
		}
		
	}
        
	 
	//*
		private static String toJson(Item item) {
			JSONSerializer libraryCardListSerializer = new JSONSerializer().include("barcode", "name").exclude("*");
			String json = libraryCardListSerializer.serialize(item);
			return json;
		}
		//*/
	/*
	public static void create() throws Exception {
        ObjectType type = ObjectType.get(getControllerClass());
        notFoundIfNull(type);
        Constructor<?> constructor = type.entityClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        Model object = (Model) constructor.newInstance();
        Binder.bind(object, "object", params.all());
        validation.valid(object);
        if (validation.hasErrors()) {
            renderArgs.put("error", Messages.get("crud.hasErrors"));
            try {
                render(request.controller.replace(".", "/") + "/blank.html", type, object);
            } catch (TemplateNotFoundException e) {
                render("CRUD/blank.html", type, object);
            }
        }
        object._save();
        flash.success(Messages.get("crud.created", type.modelName));
        if (params.get("_save") != null) {
            redirect(request.controller + ".list");
        }
        if (params.get("_saveAndAddAnother") != null) {
            redirect(request.controller + ".blank");
        }
        redirect(request.controller + ".show", object._key());
    }

	*/
}
