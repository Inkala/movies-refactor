package main;

public enum MovieType {
    REGULAR(2, 2) {
        @Override
        public int getFrequentRenterPoints(int daysRented) {
            return 1;
        }

        @Override
        public double getPrice(int daysRented) {
            double price = this.basePrice;
            if (hasExtraDays(daysRented)) {
                price += (daysRented - baseRentedDays) * this.pricePerExtraDay;
            }
            return price;
        }
    },

    NEW_RELEASE(3, 1) {
        @Override
        public int getFrequentRenterPoints(int daysRented) {
            return hasExtraDays(daysRented) ? 2 : 1;
        }

        @Override
        public double getPrice(int daysRented) {
            return this.basePrice;
        }
    },

    CHILDREN(1.5, 3) {
        @Override
        public int getFrequentRenterPoints(int daysRented) {
            return 1;
        }

        @Override
        public double getPrice(int daysRented) {
            double price = this.basePrice;
            if (hasExtraDays(daysRented)) {
                price += (daysRented - 1) * this.pricePerExtraDay;
            }
            return price;
        }
    };

    final double basePrice;
    final double baseRentedDays;
    final double pricePerExtraDay = 1.5;

    MovieType(double basePrice, int baseRentedDays) {
        this.basePrice = basePrice;
        this.baseRentedDays = baseRentedDays;
    }

    public abstract double getPrice(int daysRented);

    public abstract int getFrequentRenterPoints(int daysRented);

    boolean hasExtraDays(int daysRented) {
        return daysRented > this.baseRentedDays;
    }
}
