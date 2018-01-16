package abstractFactory.sportsShop;

public class FactoryProducer {
	public static AbstractFactory getFactory(String choice) {
		if(choice.equalsIgnoreCase("BRAND")){
	         return new BrandFactory();
	         
	      }else if(choice.equalsIgnoreCase("EQUIPMENT")){
	         return new EquipmentFactory();
	      }
	      
	      return null;
	}
}
