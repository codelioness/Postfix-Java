/**
 * Models a stack, which is a
 * first-in-first-out dispenser,
 * using links.
 * 
 * Invariants: top is the most recently added element,
 * there is never a negative number of elements
 */
public class LinkedStack<Element> extends AbstractStack<Element>{
   
   int size;
   Node top;
   
   public LinkedStack(){
      size = 0;
      top = new Node(null);
   }
   
   
   /**
    * The stack contains no elements
    * @require
    * @ensure  true if no elements exist in the stack
    */
   public boolean isEmpty(){
      return size == 0;
   }
   
   
   /**
    * The most recent element
    * @require !isEmpty()
    * @ensure returns top element
    */
   public Element top(){
      return top.element;
   }
   
   
   /**
    * Add the element to the stack
    * @require e != null
    * @ensure  !this.isEmpty()
    */
   public void push(Element e){
      Node add = new Node(e);
      add.next = top;
      top = add;
      size = size + 1;
   }
   
   
   /**
    * Removes the top element from the stack
    * @require !this.isEmpty()
    * @ensure  this.top() == old.top.next
    */
   public void pop(){
      if(!isEmpty()){
         top = top.next;
         size = size - 1;
      }
   }
   
   
   /**
    * Clears the whole stack
    * @require
    * @ensure  this.isEmpty()
    */
   public void clear(){
      top = new Node(null);
      size = 0;
   }
   
   
   /**
    * Node helper class for holding elements
    */
   private class Node{
      Element element;
      Node next;
      
      public Node(Element e){
         element = e;
         next = null;
      }
   }
}