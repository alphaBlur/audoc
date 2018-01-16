package abstractFactory.sportsShop;

public class BrandFactory extends AbstractFactory{
	@Override
	public Brands getBrand(String brand) {
		if(brand.equalsIgnoreCase("ADIDAS"))
			return new Adidas();
		if(brand.equalsIgnoreCase("NIKE"))
			return new Nike();
		return null;
	}

	@Override
	public Equipments getEquipment(String equipment) {
		// TODO Auto-generated method stub
		return null;
	}

}