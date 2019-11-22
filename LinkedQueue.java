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
public class LinkedQueue<se> {
    
    private int numberOfElements;
    private Node<se> first;
    private Node<se> last;
    
    
    

    public LinkedQueue() {
        first=null;
        last=null;
        numberOfElements=0;
    }
    public boolean isEmpty(){
        return first==null;
    }
    public int size(){
        return numberOfElements;
    }
    public se peek(){
        if(isEmpty())throw new NoSuchElementException("neelerneler");
        return first.data;
    }
    public void enqueue(se Element){
        Node oldLast=last;
        last=new Node();
        last.data=Element;
        last.next=null;
        if(isEmpty()){
            first=last;
        }
        else{
            oldLast.next=last;
        }
        numberOfElements++;
        assert check();
    }
    public se dequeue(){
        if(isEmpty()){
           return null;
        }
        se rElement=first.data;
        first=first.next;
        numberOfElements--;
        if(isEmpty()){
            last=null;
        }
        assert check();
        return rElement;
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
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
        else if (numberOfElements == 0) {
            if (first != null) return false;
            if (last  != null) return false;
        }
        else if (numberOfElements == 1) {
            if (first == null || last == null) return false;
            if (first != last)                 return false;
            if (first.next != null)            return false;
        }
        else {
            if (first == null || last == null) return false;
            if (first == last)      return false;
            if (first.next == null) return false;
            if (last.next  != null) return false;

            
            int numberOfNodes = 0;
            for (Node x = first; x != null && numberOfNodes <= numberOfElements; x = x.next) {
                numberOfNodes++;
            }
            if (numberOfNodes != numberOfElements) return false;

            
            Node lastNode = first;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            if (last != lastNode) return false;
        }

        return true;
    } 
    
    
    
    
}
