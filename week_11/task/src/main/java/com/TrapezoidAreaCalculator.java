package com;

class TrapezoidAreaCalculator implements Runnable {
    private final double a;
    private final double b;
    private final int n;

    public TrapezoidAreaCalculator(double a, double b, int n) {
        this.a = a;
        this.b = b;
        this.n = n;
    }

    private double function(double x) {
        return Math.sin(x);
    }

    @Override
    public void run() {
        double h = (b - a) / n;
        double area = 0.0;

        for (int i = 0; i < n; i++) {
            double x1 = a + i * h;
            double x2 = x1 + h;
            area += (function(x1) + function(x2)) * h / 2;
        }

        System.out.println("Площадь криволинейной трапеции: " + area);
    }
}
