package controllers;

import java.util.ArrayList;
import java.util.List;

import flexjson.JSONSerializer;

import models.LibraryCard;
import models.User;

import play.mvc.*;

public class LibraryCards extends CRUD {
	public static List<LibraryCard> getByBarcode(String barcode) {
		//TODO: Change the criteria to Equal express
		List<LibraryCard> cards = LibraryCard.find("barcode like ?", "%"+barcode +"%").fetch();
		return cards;
//		System.out.println("getByBarcode "+barcode);
		
//		String info = toJson(cards);
//		renderJSON(info);

	}
	
	private static String toJson(List<LibraryCard>cards) {
		JSONSerializer libraryCardListSerializer = new JSONSerializer().include("barcode", "user.name").exclude("*");
		String json = libraryCardListSerializer.serialize(cards);
		return json;
	}
}
