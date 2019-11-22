/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuresproje1;

/**
 *
 * @author win7
 */
public class Point {
    
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public double calcDistance(Point a){
        if(!this.equals(a)){
       double dx = this.x - a.x;
        double dy = this.y - a.y;
        return  Math.sqrt(dx*dx + dy*dy);
        }
        return 0;
    }

    @Override
    public String toString() {
    
        return "x . "+x+" y. "+y;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Point){
            Point x=(Point)obj;
            if(x.x==this.x&&x.y==this.y){
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        
        Point a=new Point(3, 4);
        Point b=new Point(-2,-8);
        System.out.println(a.calcDistance(b));
        
    }
    
    
}

