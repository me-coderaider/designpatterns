package designpatterns.creational.factory;

class Point {
	private double x, y;

	private Point(double x, double y) {
		this.x = x;
		this.y = y;

	}
	
	public static class Factory {
	//public static class PointFactory { // no need to call it 'PointFactory' we can call it just Factory
		// Factory Method
		public static Point newCartesianPoint(double x, double y) {
			return new Point(x, y);
		}
		
		public static Point newPolarPoint(double rho, double theta) {
			return new Point(rho * Math.cos(theta), rho * Math.sin(theta));
		}
	}
}


class FactoryDemo {
	public static void main(String[] args) {
		Point point = Point.Factory.newPolarPoint(2, 3);
//		Point point1 = new Point(4, 5); // can't use as constructor is private
	}
}
