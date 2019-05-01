class Circle {
  
  int x;  //x position of the middle of the circle
  int y;  //y position of the middle of the circle
  int radius;  //radius of the circle (of course)
  boolean removed;  //boolean for continued existence of this collision circle
  
  public Circle(int x, int y, int radius) {
    this.x = x;
    this.y = y;
    this.radius = radius;
    removed = false;
  }
  
  boolean coll(int xMouse, int yMouse) {  //function for basic circle-mouse collision
    if(!removed) {
      return (radius >= (sqrt(sq(xMouse - x) + sq(yMouse - y))));
    } else {
      return false;
    }
  }
  
  void rem() {  //function to indicate removal of collision mask
    removed = true;
  }
  
}
