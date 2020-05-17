public class Capital implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private ControlTower controlTower = new ControlTower(this.name);
	
	//Constructor
	public Capital(String name) {
		this.name = name;
	}
	
	//Getters and Setters
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public ControlTower getControlTower() {
		return controlTower;
	}
}
