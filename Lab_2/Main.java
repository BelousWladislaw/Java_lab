public class Main {
    public static void main(String[] args) {
        // Создание объектов электроприборов
        Television tv = new Television("Sony", 200, 42);
        Refrigerator fridge = new Refrigerator("LG", 150, 250);
        WashingMachine washingMachine = new WashingMachine("Samsung", 300, 8);

        // Включение электроприборов
        tv.turnOn();
        fridge.turnOn();
        washingMachine.turnOn();

        // Подсчет потребляемой мощности
        int totalPower = tv.getPower() + fridge.getPower() + washingMachine.getPower();
        System.out.println("Total power consumption: " + totalPower + " watts");

        // Сортировка приборов по мощности
        ElectricalAppliance[] appliances = {tv, fridge, washingMachine};
        sortAppliancesByPower(appliances);

        // Поиск прибора в заданном диапазоне мощности
        int minPower = 100;
        int maxPower = 200;
        ElectricalAppliance foundAppliance = findApplianceByPowerRange(appliances, minPower, maxPower);
        if (foundAppliance != null) {
            System.out.println("Appliance found: " + foundAppliance.getBrand());
        } else {
            System.out.println("No appliance found in the specified power range");
        }
    }

    private static void sortAppliancesByPower(ElectricalAppliance[] appliances) {
        // Код для сортировки массива приборов по мощности
    }

    private static ElectricalAppliance findApplianceByPowerRange(
            ElectricalAppliance[] appliances, int minPower, int maxPower) {
        // Код для поиска прибора в заданном диапазоне мощности
        return null;
    }
}