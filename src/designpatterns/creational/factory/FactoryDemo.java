package designpatterns.creational.factory;

class Point {
	private double x, y;

	private Point(double x, double y) {
		this.x = x;
		this.y = y;

	}

	// Factory Method
	public static Point newCartesianPoint(double x, double y) {
		return new Point(x, y);
	}

	public static Point newPolarPoint(double rho, double theta) {
		return new Point(rho * Math.cos(theta), rho * Math.sin(theta));
	}

}

class FactoryDemo {
	public static void main(String[] args) {
		Point point = Point.newPolarPoint(2, 3);
	}
}
