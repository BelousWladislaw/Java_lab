public class Television extends ElectricalAppliance {
    private int screenSize;

    public Television(String brand, int power, int screenSize) {
        super(brand, power);
        this.screenSize = screenSize;
    }

    public int getScreenSize() {
        return screenSize;
    }

    @Override
    public void turnOn() {
        // Код для включения телевизора
    }

    @Override
    public void turnOff() {
        // Код для выключения телевизора
    }
}