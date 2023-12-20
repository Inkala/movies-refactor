package main;

public enum MovieType {
    REGULAR {
        private double basePrice = 2;

        public int getFrequentRenterPoints(int daysRented) {
            return 1;
        }

        @Override
        public double getPrice(int daysRented) {
            double price = this.basePrice;
            if (daysRented > 2) {
                price += (daysRented - 2) * this.pricePerExtraDay;
            }
            return price;
        }
    },
    NEW_RELEASE {
        private final double basePrice = 3;

        public int getFrequentRenterPoints(int daysRented) {
            if (daysRented > 1) {
                return 2;
            }
            return 1;
        }

        @Override
        public double getPrice(int daysRented) {
            return this.basePrice;
        }
    },
    CHILDREN {
        private final double basePrice = 1.5;

        @Override
        public int getFrequentRenterPoints(int daysRented) {
            return 1;
        }

        @Override
        public double getPrice(int daysRented) {
            double price = this.basePrice;
            if (daysRented > 3) {
                price += (daysRented - 1) * this.pricePerExtraDay;
            }
            return price;
        }
    };

    protected final double pricePerExtraDay = 1.5;

    public abstract int getFrequentRenterPoints(int daysRented);
    public abstract double getPrice(int daysRented);
}
