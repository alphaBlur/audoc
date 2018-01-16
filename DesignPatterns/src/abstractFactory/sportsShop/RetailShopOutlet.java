package abstractFactory.sportsShop;

public class RetailShopOutlet {
	public static void main(String[] args) {
		
		AbstractFactory brandFactory = FactoryProducer.getFactory("BRAND");
		
		Brands firstBrand = brandFactory.getBrand("ADIDAS");
		firstBrand.getBrandName();
		
		Brands secondBrand = brandFactory.getBrand("NIKE");
		secondBrand.getBrandName();
		
		AbstractFactory equipmentFactory = FactoryProducer.getFactory("EQUIPMENT");
		
		Equipments firstEquipment = equipmentFactory.getEquipment("SHOES");
		firstEquipment.getEquipmentType();
		
		Equipments secondEquipment = equipmentFactory.getEquipment("APPARELS");
		secondEquipment.getEquipmentType();
		
	}
}
