/**
 * Models a stack, which is a
 * first-in-first-out dispenser
 * 
 * Invariants: top is the most recently added element,
 * there is never a negative number of elements
 */
public interface Stack<Element>{
   
   
   /**
    * The stack contains no elements
    * @require
    * @ensure  true if no elements exist in the stack
    */
   public boolean isEmpty();
   
   
   /**
    * The most recent element
    * @require !isEmpty()
    * @ensure returns top element
    */
   public Element top();
   
   
   /**
    * Add the element to the stack
    * @require e != null
    * @ensure  !this.isEmpty()
    */
   public void push(Element e);
   
   
   /**
    * Removes the top element from the stack
    * @require !this.isEmpty()
    * @ensure  this.top() == the next one in the stack
    */
   public void pop();
   
   
   /**
    * Clears the whole stack
    * @require
    * @ensure  this.isEmpty()
    */
   public void clear();
   
}