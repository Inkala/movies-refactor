package main;

public enum MovieType {
    REGULAR {
        private double basePrice = 2;

        @Override
        public double getPrice(int daysRented) {
            double price = this.basePrice;
            if (daysRented > 2) {
                price += (daysRented - 2) * 1.5;
            }
            return price;
        }
    },
    NEW_RELEASE {
        private final double basePrice = 1.5;

        @Override
        public double getPrice(int daysRented) {
            return this.basePrice;
        }
    },
    CHILDREN {
        private final double basePrice = 1.5;
        private final double pricePerExtraDay = 0;

        @Override
        public double getPrice(int daysRented) {
            double price = this.basePrice;
            if (daysRented > 3) {
                price += (daysRented - 1) * 1.5;
            }
            return 0;
        }
    };

    public abstract double getPrice(int daysRented);
}
