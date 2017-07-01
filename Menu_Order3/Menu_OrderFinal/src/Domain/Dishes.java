package Domain;

public class Dishes {
	public int id;
	public String name;
	public double price;
	public int chief;
	public int type;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getChief() {
		return chief;
	}
	public void setChief(int chief) {
		this.chief = chief;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}
