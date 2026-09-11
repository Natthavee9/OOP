interface Movable{
      public void moveUp();
      public void moveDown();
      public void moveLeft();
      public void moveRight();
}

class MovablePoint implements Movable{
      int x,y;
      int xSpeed , ySpeed;
	public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
		this.x = x;
		this.y = y;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}

      @Override 
      public String toString(){
            return "(x,y) = " + "("+ x + ","+y+")" +" "+ "speed = (" + xSpeed+","+ySpeed+")";
      }

      @Override
      public void moveUp(){
            y+=ySpeed;
      } 

      @Override 
      public void moveDown(){
            y-=ySpeed;
      }

      @Override 
      public void moveLeft(){
            x-=xSpeed;
      }

      @Override
      public void moveRight(){
            x+=xSpeed;
      }

}

class MovableCircle implements Movable{
      private int radius;
      private MovablePoint center;
      public MovableCircle(int x, int y, int xSpeed, int ySpeed,int radius) {
            this.center = new MovablePoint(x, y, xSpeed, ySpeed);
            this.radius = radius; 
      }

      @Override 
      public void moveUp(){
            center.moveUp();
      }

      @Override
      public void moveDown(){
      }

      @Override 
      public void moveLeft(){
            center.moveLeft();
      }

      @Override
      public void moveRight(){
            center.moveRight();
      }
      
      @Override
      public String toString() {
            return "radius = " + radius+" "+"center = " + center.toString();

      }
}
public class lab8_no6 {

      public static void main(String[] args) {
            System.out.println("MovablePoint");
            MovablePoint m1 = new MovablePoint(0, 0, 2, 3);
            System.out.println("start: " +m1.toString());

            m1.moveUp();
            System.out.println("moveUP(): " + m1.toString());
            m1.moveLeft();
            System.out.println("moveLeft(): " + m1.toString());

            System.out.println();
            System.out.println("MovableCircle");
            MovableCircle c1 = new MovableCircle(10, 10, 5, 5, 20);
            
            System.out.println("start circle: " + c1.toString());

            c1.moveDown();
            System.out.println("moveDown(): " + c1.toString());
            c1.moveRight();
            System.out.println("moveRight(): " + c1.toString());
      }
}