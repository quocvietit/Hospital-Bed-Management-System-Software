package entities;

public class Bed {
	private String bedID;
	private String bedName;
	private double price;
	private String type;
	private String status;
	
	private Room room;
	
	public Bed(){
		this("","",0.0,"","");
	}

	public Bed(String bedID, String bedName, double price, String type, String status) {
		super();
		this.bedID = bedID;
		this.bedName = bedName;
		this.price = price;
		this.type = type;
		this.status = status;
	}

	public String getBedID() {
		return bedID;
	}

	public void setBedID(String bedID) {
		this.bedID = bedID;
	}

	public String getBedName() {
		return bedName;
	}

	public void setBedName(String bedName) {
		this.bedName = bedName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
	@Override
	public String toString() {
		return "Bed [bedID=" + bedID + ", bedName=" + bedName + ", price=" + price + ", type=" + type 
				+ ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bedID == null) ? 0 : bedID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bed other = (Bed) obj;
		if (bedID == null) {
			if (other.bedID != null)
				return false;
		} else if (!bedID.equals(other.bedID))
			return false;
		return true;
	}
	
}
