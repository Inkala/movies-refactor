package main;

public enum MovieType {
    REGULAR {
        @Override
        public double getBasePrice() {
            return 2;
        }
    },
    NEW_RELEASE {
        @Override
        public double getBasePrice() {
            return 3;
        }
    },
    CHILDREN {
        @Override
        public double getBasePrice() {
            return 1.5;
        }
    };

    public abstract double getBasePrice();
}
