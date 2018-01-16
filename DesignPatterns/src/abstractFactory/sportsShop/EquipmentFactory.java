package abstractFactory.sportsShop;

public class EquipmentFactory extends AbstractFactory{

	@Override
	Brands getBrand(String brand) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Equipments getEquipment(String equipment) {
		if(equipment.equalsIgnoreCase("SHOES"))
			return new Shoes();
		if(equipment.equalsIgnoreCase("APPARELS"))
			return new Apparels();
		if(equipment.equalsIgnoreCase("ACCESSORIES"))
			return new Accessories();
		return null;
	}

}
