package templatePattern.designHouse;
public abstract class HomeDesigner {
	
	public final void buildHouse(){
		FindDesigner(); // common function
		DesignStructure();
		DesignWalls();
		DesignDoors();
		DesignWindows();
		DesignFurnishing();
		
		System.out.println("House is built.");
	}
	
	// default implementation for all subclasses ( all types of houses)
	public void FindDesigner() {
		System.out.println("Finding designer for all kinds of houses");
	}
	
	//abstract methods for subclasses to implement
	public abstract void DesignStructure();
	public abstract void DesignWalls();
	public abstract void DesignDoors();
	public abstract void DesignWindows();
	public abstract void DesignFurnishing();
}