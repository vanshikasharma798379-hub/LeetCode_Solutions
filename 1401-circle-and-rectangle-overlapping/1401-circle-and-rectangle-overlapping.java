class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int xclosest  = Math.max(x1,Math.min(xCenter , x2));
        int yclosest  = Math.max(y1,Math.min(yCenter , y2));
        int distance  = (xclosest - xCenter)*(xclosest - xCenter)+(yclosest - yCenter)*(yclosest - yCenter);
        if(radius*radius>=distance)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
}