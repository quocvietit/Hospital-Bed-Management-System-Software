package entities;

public class Bed {
	private String bedID;
	private String bedName;
	private double price;
	private String status;
	private String roomid;
	private String typebed;
	
	public Bed(){
		this("","",0.0,"","","");
	}

	public Bed(String bedID, String bedName, double price, String status, String roomid, String typebed) {
		super();
		this.bedID = bedID;
		this.bedName = bedName;
		this.price = price;
		this.status = status;
		this.roomid = roomid;
		this.typebed = typebed;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getRoomid() {
		return roomid;
	}

	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}

	public String getTypebed() {
		return typebed;
	}

	public void setTypebed(String typebed) {
		this.typebed = typebed;
	}

	@Override
	public String toString() {
		return "Bed [bedID=" + bedID + ", bedName=" + bedName + ", price=" + price + ", status=" + status + ", roomid="
				+ roomid + ", typebed=" + typebed + "]";
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
