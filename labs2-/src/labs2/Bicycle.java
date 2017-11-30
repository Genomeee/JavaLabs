package labs2;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Bicycle")
public class Bicycle implements Comparable<Bicycle>
{
  public enum Type {
	  ROAD,  MOUNTAIN,  HYBRID,  CRUISER,  CITY,  BMX;
	}

private String made;
  private int id;
  private int price;
  private int gear;
  private int speed;
  private Bicycle.Type type;
  
  public int hashCode()
  {
    int prime = 31;
    int result = 1;
    result = 31 * result + this.gear;
    result = 31 * result + (this.made == null ? 0 : this.made.hashCode());
    result = 31 * result + this.price;
    result = 31 * result + this.speed;
    result = 31 * result + (this.type == null ? 0 : this.type.hashCode());
    return result;
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Bicycle other = (Bicycle)obj;
    if (this.gear != other.gear) {
      return false;
    }
    if (this.made == null)
    {
      if (other.made != null) {
        return false;
      }
    }
    else if (!this.made.equals(other.made)) {
      return false;
    }
    if (this.price != other.price) {
      return false;
    }
    if (this.speed != other.speed) {
      return false;
    }
    if (this.type != other.type) {
      return false;
    }
    return true;
  }
  
  public String toString()
  {
    return 
      "Bicycle [made=" + this.made + ", id=" + this.id + ", price=" + this.price + ", gear=" + this.gear + ", speed=" + this.speed + ", type=" + this.type + "]";
  }
  
  public Bicycle(String made, int price, int gear, int speed, Bicycle.Type type, int id)
  {
    this.made = made;
    this.price = price;
    this.gear = gear;
    this.speed = speed;
    this.type = type;
    this.id = id;
  }
  
  public Bicycle() {}
  
  public int In_Dollars()
  {
    int curs = 27;
    return this.price / curs;
  }
  
  @XmlElement
  public String getMade()
  {
    return this.made;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public int getPrice()
  {
    return this.price;
  }
  
  public int getGear()
  {
    return this.gear;
  }
  
  public int getSpeed()
  {
    return this.speed;
  }
  
  public Bicycle.Type getType()
  {
    return this.type;
  }
  
  public void setId(int id)
  {
    this.id = id;
  }
  
  public Bicycle setMade(String made)
  {
    this.made = made;
    return this;
  }
  
  public void setPrice(int price)
  {
    this.price = price;
  }
  
  public void setGear(int gear)
  {
    this.gear = gear;
  }
  
  public void setSpeed(int speed)
  {
    this.speed = speed;
  }
  
  public void setType(Bicycle.Type type)
  {
    this.type = type;
  }
  
  public int compareTo(Bicycle o)
  {
    Bicycle one = o;
    if (one.made.length() < this.made.length()) {
      return -1;
    }
    return 1;
  }
}
