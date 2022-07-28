package by.ivanchenko.carrental.bean.car;

import java.util.Objects;

public class Car {
    private  int id;
    private String name;
    private double engineCapacity;
    private String transmission;
    private int year;
    private String drive;
    private int tank;
    private double consumption;
    private String fuel;
    private String bodyType;
    private int price;
    private  int mileage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDrive() {
        return drive;
    }

    public void setDrive(String drive) {
        this.drive = drive;
    }

    public int getTank() {
        return tank;
    }

    public void setTank(int tank) {
        this.tank = tank;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public Car() {
    }

    public Car(int id, String name, double engineCapacity, String transmission, int year, String drive,
               int tank, double consumption, String fuel, String bodyType, int price, int mileage) {
        setId(id);
        setName(name);
        setEngineCapacity(engineCapacity);
        setTransmission(transmission);
        setYear(year);
        setDrive(drive);
        setTank(tank);
        setConsumption(consumption);
        setFuel(fuel);
        setBodyType(bodyType);
        setPrice(price);
        setMileage(mileage);
    }

    public Car(String name, double engineCapacity, String transmission, int year, String drive,
               int tank, double consumption, String fuel, String bodyType, int price, int mileage) {

        setName(name);
        setEngineCapacity(engineCapacity);
        setTransmission(transmission);
        setYear(year);
        setDrive(drive);
        setTank(tank);
        setConsumption(consumption);
        setFuel(fuel);
        setBodyType(bodyType);
        setPrice(price);
        setMileage(mileage);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", engineCapacity=" + engineCapacity +
                ", transmission='" + transmission + '\'' +
                ", year=" + year +
                ", drive='" + drive + '\'' +
                ", tank=" + tank +
                ", consumption=" + consumption +
                ", fuel='" + fuel + '\'' +
                ", bodyType='" + bodyType + '\'' +
                ", price=" + price +
                ", mileage=" + mileage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return id == car.id && Double.compare(car.engineCapacity, engineCapacity) == 0 && year == car.year
                && tank == car.tank && Double.compare(car.consumption, consumption) == 0 && price == car.price
                && mileage == car.mileage && Objects.equals(name, car.name) && Objects.equals(transmission, car.transmission)
                && Objects.equals(drive, car.drive) && Objects.equals(fuel, car.fuel) && Objects.equals(bodyType, car.bodyType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, engineCapacity, transmission, year,
                drive, tank, consumption, fuel, bodyType, price, mileage);
    }
}
