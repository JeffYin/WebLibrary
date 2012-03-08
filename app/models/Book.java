package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Book extends Item {
	
	@Column(length=64)
    public String bibliograph;
	
	
	@Column(length=64)
	public String translator;
	
	@Column(length = 64)
	public String callNumber; 
	
	public Blob coverImage;
    
	@ManyToMany(cascade=CascadeType.PERSIST)
    public Set<Author> authors=new TreeSet<Author>();
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	public Set<Tag> tags = new TreeSet<Tag>();
    
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="status_code",referencedColumnName="code")
	public ItemStatus status;
	
}
