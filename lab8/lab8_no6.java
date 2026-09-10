interface Movable{
      public void moveUp();
      public void moveDown();
      public void moveLeft();
      public void moveRight();
}

class MovablePoint implements Movable{
      int x,y;
      int xSpeed , ySpeed;
	public MovablePoint(int x, int y, int xSpeed, int ySeed) {
		this.x = x;
		this.y = y;
		this.xSpeed = xSpeed;
		this.ySeed = ySeed;
	}

      @Override 
      public String toString(){
            return
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
      public MovableCircle(int radius) {
            super();
            this.radius = radius;
            
      }
      
      

}
public class lab8_no6 {

      public static void main(String[] args) {
            
      }
}