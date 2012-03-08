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
public class User extends Person{
    public String accessToken;
	public String secret; 
	public String authProvider;
	    
	
    @ManyToMany(cascade=CascadeType.PERSIST)
    public Set<Role> roles = new TreeSet();
    
    @OneToMany(mappedBy="user", cascade=CascadeType.PERSIST)
    public Set<LibraryCard> libraryCards = new TreeSet<LibraryCard>();
    
    
    public User() {
    	
    }
    
	@Override
	public String toString() {
		return "Person [key=" + personId + ", roles=" + roles + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((personId == null) ? 0 : personId.hashCode());
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
		if (personId == null) {
			if (other.personId != null)
				return false;
		} else if (!personId.equals(other.personId))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		return true;
	}

}
