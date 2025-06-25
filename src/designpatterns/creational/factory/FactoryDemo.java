package designpatterns.creational.factory;

enum CoordinateSystem {
	CARTESIAN, POLAR
}

class Point {
	private double x, y;

	public Point(double a, double b, CoordinateSystem cs) {
		switch (cs) {
		case CARTESIAN:
			this.x = a;
			this.y = b;
			break;
		case POLAR:
			this.x = a * Math.cos(b);
			this.y = a * Math.sin(b);
			break;
		}
	}
}

class FactoryDemo {
	public static void main(String[] args) {
	    Point point = new Point(2, 3, CoordinateSystem.CARTESIAN);
	}
}
