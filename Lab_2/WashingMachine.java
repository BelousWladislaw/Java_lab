public class WashingMachine extends ElectricalAppliance {
    private int loadCapacity;

    public WashingMachine(String brand, int power, int loadCapacity) {
        super(brand, power);
        this.loadCapacity = loadCapacity;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    @Override
    public void turnOn() {
        // Код для включения стиральной машины
    }

    @Override
    public void turnOff() {
        // Код для выключения стиральной машины
    }
}