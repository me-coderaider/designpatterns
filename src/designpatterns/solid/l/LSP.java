package designpatterns.solid.l;

class Rectangle {
	protected int width, height;

	public Rectangle() {
	}

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getArea() {
		return width * height;
	}

	@Override
	public String toString() {
		return "Rectangle{" + "width=" + width + ", height=" + height + '}';
	}

	public boolean isSquare() { // detecting whether the passed parameters form a 'rectangle' or 'square' 
		return width == height;
	}
}

class Square extends Rectangle {
	public Square() {
	}

	public Square(int size) {
		width = height = size;
	}

	@Override // adding special overrides to set width & height
	public void setWidth(int width) {
		super.setWidth(width);
		super.setHeight(width);
	}

	@Override
	public void setHeight(int height) {
		super.setHeight(height);
		super.setWidth(height);
	}
}

class RectangleFactory { // using 'factory' pattern to explicitly create 'square' & 'rectangle' objects. 
	public static Rectangle newSquare(int side) {
		return new Rectangle(side, side);
	}

	public static Rectangle newRectangle(int width, int height) {
		return new Rectangle(width, height);
	}
}

class LSP {
	// maybe conform to ++
	static void useIt(Rectangle r) {
		int width = r.getWidth();
		r.setHeight(10); // bad kind of setter when we store 'Square' objects in Rectangle 
		System.out.println("Expected area of " + (width * 10) + ", got " + r.getArea());
	}

	public static void main(String[] args) {
		Rectangle rc = new Rectangle(2, 3);
		useIt(rc);

		Rectangle sq = new Square();
//		sq.setHeight(5);
		sq.setWidth(5); // getting wrong answer, expected area: 25, but got 100
		useIt(sq);
	}
}