import junit.framework.TestCase;

public class LinkedStackTest extends TestCase{
   
   private LinkedStack<Integer> stack;
   
   public void setUp(){
      stack = new LinkedStack<Integer>();
   }
   
   
   public void testPush(){
      stack.push(1);
      assertTrue(stack.top() == 1);
      assertTrue(stack.size == 1);
      stack.push(2);
      assertTrue(stack.top() == 2);
      assertTrue(stack.size == 2);
      stack.push(3);
      stack.push(4);
      stack.push(5);
      assertTrue(stack.top() == 5);
      assertTrue(stack.size == 5);
   }
   
   
   public void testPop(){
      stack.push(1);
      stack.push(2);
      stack.push(3);
      stack.push(4);
      stack.push(5);
      assertTrue(stack.top() == 5);
      assertTrue(stack.size == 5);
      stack.pop();
      assertTrue(stack.top() == 4);
      assertTrue(stack.size == 4);
      stack.pop();
      assertTrue(stack.top() == 3);
      assertTrue(stack.size == 3);
      stack.pop();
      assertTrue(stack.top() == 2);
      assertTrue(stack.size == 2);
      stack.pop();
      assertTrue(stack.top() == 1);
      assertTrue(stack.size == 1);
      stack.pop();
      assertTrue(stack.top() == null);
      assertTrue(stack.size == 0);
      assertTrue(stack.isEmpty());
      //if pop() when nothing in stack
      stack.pop();
      assertTrue(stack.top() == null);
      assertTrue(stack.size == 0);
      assertTrue(stack.isEmpty());
   }
   
   
   public void testClear(){
      stack.push(1);
      stack.push(2);
      stack.push(3);
      stack.push(4);
      stack.push(5);
      assertTrue(stack.top() == 5);
      assertTrue(stack.size == 5);
      stack.clear();
      assertTrue(stack.top() == null);
      assertTrue(stack.size == 0);
      assertTrue(stack.isEmpty());
      stack.pop();
      assertTrue(stack.top() == null);
      assertTrue(stack.size == 0);
      assertTrue(stack.isEmpty());
   }
   
   
   public void testIsEmpty(){
      assertTrue(stack.isEmpty());
      stack.push(1);
      assertTrue(!stack.isEmpty());
      stack.push(2);
      stack.push(3);
      assertTrue(!stack.isEmpty());
      stack.pop();
      stack.pop();
      assertTrue(!stack.isEmpty());
      stack.pop();
      assertTrue(stack.isEmpty());
      stack.pop();
      assertTrue(stack.isEmpty());
   }
   
   
   public void testTop(){
      assertTrue(stack.top() == null);
      stack.push(1);
      assertTrue(stack.top() == 1);
      stack.push(2);
      stack.push(3);
      assertTrue(stack.top() == 3);
      stack.pop();
      assertTrue(stack.top() == 2);
      stack.pop();
      stack.pop();
      assertTrue(stack.top() == null);
      stack.pop();
      assertTrue(stack.top() == null);
   }
}