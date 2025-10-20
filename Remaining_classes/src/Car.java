public class Car {
    private final String brand;
    private final String model;
    private final int year;

    private Car(Builder builder) {
        this.brand = builder.brand;
        this.model = builder.model;
        this.year = builder.year;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Car(brand='" + brand + "', model='" + model + "', year=" + year + ")";
    }

    public static class Builder {
        private String brand;
        private String model;
        private int year;

        public Builder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setYear(int year) {
            this.year = year;
            return this;
        }

        public Car build() {
            if (brand == null || brand.trim().isEmpty()) {
                throw new IllegalArgumentException("Brand cannot be null or empty");
            }
            if (year <= 1900) {
                throw new IllegalArgumentException("Year must be greater than 1900");
            }
            return new Car(this);
        }
    }

    public static void main(String[] args) {
        try {
            Car car = new Car.Builder()
                    .setBrand("Toyota")
                    .setModel("Camry")
                    .setYear(2023)
                    .build();

            System.out.println(car);

            Car invalidCar = new Car.Builder()
                    .setBrand("")
                    .setModel("Test")
                    .setYear(1800)
                    .build();

            System.out.println(invalidCar);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
