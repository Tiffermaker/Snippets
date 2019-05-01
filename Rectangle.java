class Rectangle {
  
  int x;  //x position of top-left corner
  int y;  //y position of top-left corner
  int wide;  //width of the rectangle
  int high;  //height of the rectangle
  boolean removed;  //boolean for the continued existence of this collision rectangle
  
  public Rectangle(int x, int y, int wide, int high) {
    this.x = x;
    this.y = y;
    this.wide = wide;
    this.high = high;
    removed = false;
  }
  
  boolean coll(int xMouse, int yMouse) {  //function for basic rectangle-mouse collision
    if(!removed) {
      return (xMouse > x && xMouse < (x+wide) && yMouse > y && yMouse < (y+high));
    } else {
      return false;
    }
  }
  
  void rem() {  //function to indicate removal of collision mask
    removed = true;
  }
  
}
