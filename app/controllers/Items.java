package controllers;

import java.util.List;

import models.Item;
import models.LibraryCard;
import flexjson.JSONSerializer;

public class Items extends CRUD {
	public static void getByBarcode(String barcode) {
		List<Item> cards = Item.find("barcode like ?", "%"+barcode +"%").fetch();
//		System.out.println("getByBarcode "+barcode);
		String info = toJson(cards);
		renderJSON(info);

	}
	
	//*
	private static String toJson(List<Item>items) {
		JSONSerializer libraryCardListSerializer = new JSONSerializer().include("barcode", "name").exclude("*");
		String json = libraryCardListSerializer.serialize(items);
		return json;
	}
	//*/
}
