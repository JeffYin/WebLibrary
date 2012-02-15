package controllers;

import java.util.List;

import models.Author;

import org.junit.Before;

import play.test.Fixtures;
import play.test.UnitTest;

public class AuthorControllerTest extends UnitTest {
	@Before
	public void setUp() {
	    Fixtures.deleteDatabase();
	    Fixtures.loadModels("data.yml");
	}
	
	public void testIndex() {
		List<Author> bookings = Author.all().fetch();
		assertTrue(bookings.size()>0);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
