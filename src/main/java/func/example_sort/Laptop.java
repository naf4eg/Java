package func.example_sort;

class Laptop {
    private final String brand;
    private final int numberOfCores;
    private final double displaySize;

    public Laptop (String brand, int numberOfCores, double displaySize) {
        this.brand = brand;
        this.numberOfCores = numberOfCores;
        this.displaySize = displaySize;
    }

    public String getBrand () {
        return brand;
    }

    public int getNumberOfCores () {
        return numberOfCores;
    }

    public double getDisplaySize () {
        return displaySize;
    }

    @Override
    public String toString () {
        return "Laptop{" + "brand='" + brand + '\'' + ", numberOfCores=" + numberOfCores + ", displaySize=" + displaySize + '}';
    }
}
