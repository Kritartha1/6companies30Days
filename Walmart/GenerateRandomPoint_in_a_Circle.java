//leetcode.com/problems/generate-random-point-in-a-circle/
class Solution {
    
    private double radius;
    private double x_center;
    private double y_center;
    public Solution(double radius, double x_center, double y_center) {
        this.radius=radius;
        this.x_center=x_center;
        this.y_center=y_center;
    }
    
    public double[] randPoint() {
        double[] xy=new double[2];
        double R=Math.sqrt(Math.random())*radius;
        double theta=Math.random()*2*Math.PI;
        xy[0]=x_center+(R*Math.cos(theta));
        xy[1]=y_center+(R*Math.sin(theta));
        
        return xy;
        
        
    }
}

