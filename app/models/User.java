package models;

import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class User extends BusinessModel{
    public String accessToken;
	public String secret; 
	public String authProvider;
	    
	/* This column is the internal key column. */
	@Column(length=128,name="uid")
    public String userid;
    
	@Column(length=64)
	public String name; 
	
	@Column(length=64)
	public String email;
	
	@Column(length=128)
	public String phoneNumber; 
	
	public String address;
	
	
    @ManyToMany(cascade=CascadeType.PERSIST)
    public Set<Role> roles = new TreeSet();
    
    @OneToMany(mappedBy="user", cascade=CascadeType.PERSIST)
    public Set<LibraryCard> libraryCards = new TreeSet<LibraryCard>();
    
    
    public User() {
    	userid = UUID.randomUUID().toString();
    }
    
	@Override
	public String toString() {
		return "Person [key=" + userid + ", roles=" + roles + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		return true;
	}

}
