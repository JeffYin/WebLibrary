import play.test.*;
import play.i18n.Lang;
import play.jobs.*;
import models.*;

@OnApplicationStart
public class Bootstrap extends Job {
    
    public void doJob() {
        // Load default data if the database is empty
    	//Fixtures.deleteDatabase();
        if(Author.count() == 0) {
        	Fixtures.loadModels("data.yml");
        }
    }
    
}