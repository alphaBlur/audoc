package abstractFactory.sportsShop;

public abstract class AbstractFactory {
	abstract Brands getBrand(String brand);
	abstract Equipments getEquipment(String equipment);

}
