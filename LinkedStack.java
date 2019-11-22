/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuresproje1;

import java.util.NoSuchElementException;

/**
 *
 * @author win7
 */
public class LinkedStack<se> {
    private int numberOfElements;
    private Node<se> first;

    public LinkedStack() {
    }
    
    
    
   
    public LinkedStack<se> reverseStack(){
        LinkedStack<se> rls=new LinkedStack();
        Node tmp=this.first;
        while(tmp!=null){
            rls.push((se) tmp.getData());
            tmp=tmp.next;
        }
        return rls;
    }
    
    
     public boolean isEmpty() {
        return first == null;
    }
     public void push(se element){
         
           Node oldfirst = first;
        first = new Node();
        first.data = element;
        first.next = oldfirst;
        numberOfElements++;
        
             
         
     }

     public se pop() {
        if (isEmpty()) return null;
        se item = first.data;        
        first = first.next;            
        numberOfElements--;
        assert check();
        return item;                   
    }
     public se top(){
         if(isEmpty())
return null;
         return first.data;
     }

    @Override
    public String toString() {

        String returnString="";
        Node tmp=first;
        while(tmp!=null){
            returnString=returnString+tmp.data.toString()+"\n";
            tmp=tmp.next;
        }
        return returnString;

    }
     private boolean check() {

        
        if (numberOfElements < 0) {
            return false;
        }
        if (numberOfElements == 0) {
            if (first != null) return false;
        }
        else if (numberOfElements == 1) {
            if (first == null)      return false;
            if (first.next != null) return false;
        }
        else {
            if (first == null)      return false;
            if (first.next == null) return false;
        }

       
        int numberOfNodes = 0;
        for (Node x = first; x != null && numberOfNodes <= numberOfElements; x = x.next) {
            numberOfNodes++;
        }
        if (numberOfNodes != numberOfElements) return false;

        return true;
    }
     
     
     

     
     public int size() {
        return numberOfElements;
    }

    public Node getFirst() {
        return first;
    }
    public static void main(String[] args) {
        LinkedStack<Integer> ls=new LinkedStack();
        ls.push(3);
        ls.push(5);
        ls.push(8);
        System.out.println(ls.toString());
        LinkedStack<Integer> ls2= ls.reverseStack();
        System.out.println("");
        System.out.println(ls2.toString());
        
    }
    
     
}


