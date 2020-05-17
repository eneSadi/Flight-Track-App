public class ControlTower implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	
	//Constructor
	public ControlTower(String name) {
		this.name = name;
	}

	//Getter and Setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
