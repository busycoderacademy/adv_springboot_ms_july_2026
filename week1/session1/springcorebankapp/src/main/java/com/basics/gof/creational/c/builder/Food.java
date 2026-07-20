package com.basics.gof.creational.c.builder;

public class Food {
	
    private final String name;
    private final int unit;
    private final int vitC;
    private final int vitA;
    private final int vitB12;
    private final int vitB5;
    private final int vitD;

    private Food(Builder b) {
        this.name = b.name;
        this.unit = b.unit;
        this.vitC = b.vitC;
        this.vitA = b.vitA;
        this.vitB12 = b.vitB12;
        this.vitB5 = b.vitB5;
        this.vitD = b.vitD;
    }

    // Optional getters
    public String getName() { return name; }
    public int getUnit() { return unit; }
    public int getVitC() { return vitC; }
    public int getVitA() { return vitA; }
    public int getVitB12() { return vitB12; }
    public int getVitB5() { return vitB5; }
    public int getVitD() { return vitD; }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", unit=" + unit +
                ", vitC=" + vitC +
                ", vitA=" + vitA +
                ", vitB12=" + vitB12 +
                ", vitB5=" + vitB5 +
                ", vitD=" + vitD +
                '}';
    }

    public static class Builder {
        // required parameters
        private final String name;
        private final int unit;

        // optional parameters - initialized to defaults
        private int vitC = 100;
        private int vitA = 100;
        private int vitB12 = 100;
        private int vitB5 = 100;
        private int vitD = 5000;

        public Builder(String name, int unit) {
            if (name == null || name.isBlank()) throw new IllegalArgumentException("name required");
            this.name = name;
            this.unit = unit;
        }

        public Builder vitC(int vitC) {
            this.vitC = vitC;
            return this;
        }

        public Builder vitA(int vitA) {
            this.vitA = vitA;
            return this;
        }

        public Builder vitB12(int vitB12) {
            this.vitB12 = vitB12;
            return this;
        }

        public Builder vitB5(int vitB5) {
            this.vitB5 = vitB5;
            return this;
        }

        public Builder vitD(int vitD) {
            this.vitD = vitD;
            return this;
        }

        public Food build() {
            return new Food(this);
        }
    }
}
