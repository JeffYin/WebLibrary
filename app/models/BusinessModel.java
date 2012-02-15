package models;

import play.db.jpa.Model;

public abstract class BusinessModel extends Model {
  public abstract String toString();
}
