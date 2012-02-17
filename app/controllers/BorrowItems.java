package controllers;

import java.lang.reflect.Constructor;
import java.util.List;

import models.Item;
import models.LibraryCard;

import play.db.Model;
import play.exceptions.TemplateNotFoundException;

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
	
	public static void scanItem(String itemBarcode) throws Exception {
		List<Item> items = Item.find("barcode = ?", itemBarcode).fetch();
		int numberFound = items.size();
		if (numberFound==1) { /* found the exact item */
			Item item = items.get(0);
		} else if (numberFound==0) { /* found nothing */
			
		} else { /* more than one items found */
			
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
