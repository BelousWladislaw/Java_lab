public class Refrigerator extends ElectricalAppliance {
    private int capacity;

    public Refrigerator(String brand, int power, int capacity) {
        super(brand, power);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public void turnOn() {
        // Код для включения холодильника
    }

    @Override
    public void turnOff() {
        // Код для выключения холодильника
    }
}
