package polypoop;

public class failfish {

	public failfish() {
		
	}
	
	public class Shape {
		 public Shape() {
			 
		 }
		 
		 public void calcArea() {
			 System.out.println("sh");
		 }
		 
		 public void string() {
			 System.out.println("sh");
		 }
	}
	
	public class Circle extends Shape {
		 public Circle(int r) {
			 
		 }
		 
		 public void calcArea() {
			 System.out.println("c");
		 }
		 
		 public void string() {
			 System.out.println("c");
		 }
		 
		 public void getRadius() {
			 System.out.println("c");
		 }
	}
	
	public class Polygon extends Circle {
		public Polygon() {
			super(4);
		}
		
		public void calcArea() {
			System.out.println("p");
		}
	}
	
	public class Square extends Rectangle {
		public Square(int s) {
			super(s,s);
		}
		
		public void getHeight() {
			System.out.println("sq");
		}
		
		
	}
	
	public class Rectangle extends Shape {
		public Rectangle(int h, int w) {
			
		}
		
		public void getHeight() {
			System.out.println("r");
		}
		
		public void getWidth() {
			System.out.println("r");
		}
		
	}
	
	
	public static void main(String[] args) {
		failfish f = new failfish();
		Shape[] shapes = {f.new Circle(5), f.new Rectangle(4,5), f.new Square(4), f.new Polygon()};
		Rectangle r = f.new Square(3);
		Circle c = f.new Polygon();
		
		shapes[3].calcArea();
		c.getRadius();
		shapes[1].string();
		shapes[3].string();
		r.getWidth();
		r.getHeight();
	}
}
