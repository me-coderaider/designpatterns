package designpatterns.creational.factory;

class Point {
	private double x, y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(double rho, double theta) { // Illegal & not acceptable to have constructor with same signature.
		this.x = rho * Math.cos(theta);
		this.y = rho * Math.sin(theta);
	}
}

class FactoryDemo {
	public static void main(String[] args) {
		
	}
}
