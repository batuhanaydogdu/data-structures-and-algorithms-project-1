/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuresproje1;

import java.util.ArrayList;

/**
 *
 * @author win7
 */
public class Polygon<se> {
    
    private Node<se> first;
    private Node<se> last;
    private int numberOfElements;
    private LinkedStack<se> linkedStack;
    private LinkedQueue<se> linkedQueue;
    private boolean isClosed=false;
    
    

    public Polygon() {
    }
    
    public Polygon(se element) {
        first=new Node(element);
        
    }
    public Polygon(LinkedStack<se> linkedStack){
        
        
        convertLinkedStack(linkedStack);
        
    }
    public Polygon(LinkedQueue<se> linkedQueue){
        convertLinkedQueue(linkedQueue);
        
        
    }
    private void convertLinkedQueue(LinkedQueue lq){
        Node tmp=new Node(lq.dequeue());
        while(tmp.data!=null){
            this.addPoint((se)tmp.data);
            tmp=new Node(lq.dequeue());
            
        }
    }
    
    
    private void convertLinkedStack(LinkedStack ls){
    
            
        
        LinkedStack<se> reversedls=ls.reverseStack();
        
        Node tmp=new Node(reversedls.pop());
        
        while(tmp.data!=null){
             
            this.addPoint((se) tmp.data);
            tmp=new Node(reversedls.pop());
                       
        }
        
    }
    
    private double checkForAdd(se a){
        
        //if the area that new point added is smaller than the area that new point didn't added. the point can't added to the polygon.
        Polygon<se> deneme=this;
        Polygon<se> deneme2=this;
        deneme.last.next=first;
        System.out.println(deneme.toString());
        double firstArea=0,lastArea=0;
        deneme.closeThePolygon();
        firstArea=deneme.calculateArea();
        
        deneme2.addPoint(a);
        deneme2.closeThePolygon();
        lastArea=deneme.calculateArea();
        return lastArea-firstArea;
        //It will be done soon..
        
        
    }
    
    
    
    public void addPoint(se a){
        
        
     
        
        if(a.equals(first)){
            last.next=first;
            closeThePolygon();
        }
        if(!isClosed){
        if(last==null)
        last=new Node(a);
      
        Node oldfirst = first;
        first = new Node(a);
        first.data = a;
        first.next = oldfirst;
        numberOfElements++;
        
        }
    }
    public se removePoint(){
        se relement= first.data;
        first = first .next;
if ( first == null)
last = null;
         numberOfElements--;
         return relement;
    }
    


    @Override
    public String toString() {
        String returnstring="";
        Node tmp=first;
        while(tmp!=null){
            returnstring=returnstring+tmp.data+"\n";
            tmp=tmp.next;
        }
        return returnstring;
    }
    public void reversePolygon(){
        
        LinkedStack<se> a=new LinkedStack();
        Node tmp=first;
        
        while(tmp!=null){
            a.push((se) tmp.data);
            
            tmp=tmp.next;
                       
        }
        first=null;
        last=null;
        
        
        convertLinkedStack(a);
        
        
        
    }
    public ArrayList<se> convertToArray(){
        
        ArrayList<se> ra=new ArrayList();
        Node tmp=first;
        while(tmp!=null){
            
            ra.add((se) tmp.data);
            tmp=tmp.next;
            
        }
        return ra;
    }
    public void closeThePolygon(){
        if(!isClosed){
            isClosed=true;
        }
        else{
            System.out.println("The polygon had already closed");
        }
    }
    public double calculateLength(){
        double totalLength=0;
        
        Point x=(Point) first.data;
        Point x2=(Point)last.data;
        if(isClosed)
      totalLength=totalLength+x.calcDistance(x2);
        
        
        Node tmp1=first;
        Node tmp2=first.next;
        while(tmp2.next!=null){
            x=(Point) tmp1.data;
            x2=(Point) tmp2.data;
            totalLength=totalLength+x.calcDistance(x2);
            tmp1=tmp1.next;
            tmp2=tmp2.next;
        }
                return totalLength;
        
        
    }
    public double calculateArea(){
        double totalArea=0;
        if(isClosed){
        Node tmp1=first;
        Node tmp2=first.next;
        double x,x2,y,y2;
        while(tmp2.next!=null){
           Point a=(Point) tmp1.data;
           Point a2=(Point) tmp2.data;
           x=a.getX();
           y=a.getY();
           x2=a2.getX();
           y2=a2.getY();
           totalArea=totalArea-(x*y2-y2*x2);
           
            tmp1=tmp1.next;
            tmp2=tmp2.next;
        }
        return totalArea/2;}
        else
            System.out.println("you can't calculate area because, this polygon did'nt closed.");
        return 0;
    }
        public  void mergePolygons(Polygon<se> p1){
            if(!isClosed&&!p1.isClosed){
                
                
                Node tmp=p1.first;
                this.last.next=new Node(p1.first.data);
                this.last=last.next;
                while(tmp!=null){

                    if(tmp==first){
                        

                        last.next=first;
                        this.closeThePolygon();
                        break;
                }
                    
                    this.addPoint((se) tmp.data);
                    tmp=tmp.next;
                    
                }
                
            }
            
            
        }
    
    
    public static void main(String[] args) {
        Point a=new Point(3,4);
        Point b=new Point(123,45);
        Point c=new Point(3,43);
        Point d=new Point(-9,4);
        Point e=new Point(-12,-11);
//        Polygon<Point> p=new Polygon(a);
//        p.addPoint(new Point(7,8));
//        System.out.println(p.toString());
        
        LinkedStack<Point> ls=new LinkedStack();
        ls.push(d);
        ls.push(b);
//        
//        
//        Polygon<Point> p2=new Polygon(ls);
//        System.out.println(p2.toString());
//        p2.addPoint(a);
//        p2.addPoint(b);
//        System.out.println(p2.toString());
//
//        p2.removePoint();
//        p2.removePoint();
//        p2.addPoint(c);
//        System.out.println(p2.toString());
            
//            Polygon<Point> p3=new Polygon();
//            p3.addPoint(a);
//            p3.addPoint(b);
//            p3.addPoint(c);
//            p3.addPoint(d);
//            System.out.println(p3.toString());
//            p3.reversePolygon();
//           System.out.println("");
//           System.out.println(p3.toString());
                
               
                
               
                Polygon<Point> p4=new Polygon(ls);
                System.out.println(p4.toString());
                p4.addPoint(c);
                p4.addPoint(d);
                p4.addPoint(e);
                System.out.println(p4.toString());
                
                
//                Polygon<Point> p5=new Polygon();
//                System.out.println("");
//                
//                p5.addPoint(c);
//                p5.addPoint(d);
//                System.out.println(p5.toString());
//               p4.mergePolygons(p5);
//               System.out.println("mergee");
//                System.out.println(p4.toString());
                
                
                
                
                
//                System.out.println(p4.toString());
//                ArrayList<Point> ar=p4.convertToArray();
//                
//                for(int i=0;i<ar.size();i++){
//                    System.out.println(ar.get(i));
//                }

//          LinkedQueue<Point> lq=new LinkedQueue();
//          lq.enqueue(a);
//          lq.enqueue(b);
//          lq.enqueue(e);
//          Polygon<Point> p3=new Polygon(lq);
//          System.out.println(p3.linkedQueue.toString());
        
        
    }
    
    
}

