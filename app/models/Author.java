package models;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Author extends Model {
	@Required
	@Column(length=64)
    public String name;
	
	@Column(length=64)
    public String otherName;

	@ManyToMany(cascade=CascadeType.PERSIST)
	public Set<Tag> tags=new TreeSet<Tag>();
	
	@ManyToMany(mappedBy="authors")
	public Set<Book> books = new TreeSet<Book>();
	@Override
	public String toString() {
		return "Author [name=" + name + ", otherName=" + otherName + "]";
	} 
	
	
	public Author tagItWith(String name) {
        tags.add(Tag.findOrCreateByName(name));
        return this;
    }
	
}
