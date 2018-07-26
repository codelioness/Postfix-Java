import java.util.Scanner;

/**
 * Solves postfix expressions
 * 
 * Invariants: postfix != null && stack != null
 */
public class PostfixCalculator{
   
   private LinkedStack<Integer> stack;
   private String postfix;
   
   
   public PostfixCalculator(){
      stack = new LinkedStack<Integer>();
      postfix = "";
   }
   
   
   /**
    * Runs the program and writes errors.
    */
   public static void main(String[] args) {
      PostfixCalculator start = new PostfixCalculator();
      try{
         start.getExpression();
         int test = start.read();
         System.out.println(test);
      }catch(java.lang.ArithmeticException e){System.err.println("Arithmetic error.");
      }catch(WrongInputException e){System.err.println("Invalid operator entered.");
      }catch(java.lang.NumberFormatException e){System.err.println("Number out of bounds.");}
   }
   
   
   /**
    * Asks for and stores a postfix equation
    * @require User enters a valid postfix equation
    * @ensure  equation is stored
    */
   private void getExpression(){
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter the postfix expression to solve:");
      postfix = scan.nextLine();
   }
   
   
   /**
    * Reads and computes the expression and returns the answer
    * @require postfix is not an empty string or null
    * @ensure  answer is returned
    */
   private int read() throws WrongInputException{
      StringBuilder holdNum = new StringBuilder();
      // read each character in postfix and hand off to perform an operation on
      for(int i = 0; i < postfix.length(); i++){
         holdNum = readLoop(i, holdNum);
      }
      if(holdNum.length() > 0)
         stack.push(Integer.parseInt(holdNum.toString()));
      return stack.top();
   }
   
   
   /**
    * If the current character is a number, add it to the number being built
    * Else, hand it off to another helper
    * @require i < postfix.length() && holdNum != null && postfix is not empty or null
    * @ensure  holdNum is a StringBuilder of numbers or a blank StringBuilder
    */
   private StringBuilder readLoop(int i, StringBuilder holdNum) throws WrongInputException{
      Character character = postfix.charAt(i);
      String place = character.toString();
      if(place.equals("0") || place.equals("1") || place.equals("2") ||place.equals("3")
            || place.equals("4") ||  place.equals("5") | place.equals("6") || place.equals("7")
            || place.equals("8") || place.equals("9")){
         holdNum.append(place);
      }
      else{
         holdNum = ifNotNum(holdNum, place);
      }
      return holdNum;
   }
   
   
   /**
    * Performs miscellaneous things like pushing numbers onto the stack
    * and reading non-number characters
    * @require place != null && holdNum != null
    * @ensure  holdNum is a StringBuilder of numbers or a blank StringBuilder
    */
   private StringBuilder ifNotNum(StringBuilder holdNum, String place) throws WrongInputException{
      if(holdNum.length() > 0){
         stack.push(Integer.parseInt(holdNum.toString()));
         holdNum = new StringBuilder();
      }
      if(place.equals("+") || place.equals("-") || place.equals("*") || place.equals("/")){
         calculate(place);
      }
      else if(!place.equals(" ") && !place.equals("\t"))
         throw new WrongInputException();
      return holdNum;
   }
   
   
   /**
    * Pops the next to numbers out of the stack to calculate,
    * then pushes the answer onto the stack
    * @require !stack.isEmpty() && stack.size() >= 2
    * @ensure  calculation is pushed to stack
    */
   private void calculate(String next){
      int right = stack.top();
      stack.pop();
      int left = stack.top();
      stack.pop();
      stack.push(performAction(next, left, right));
   }
   
   
   /**
    * Starts the execution of the necessary operation
    * @require operands equals + || - || * || /
    * @ensure  returns the answer given
    */
   private int performAction(String operand, int left, int right){
      int answer = 0;
      if (operand.equals("+"))
         answer = (new Addition()).execute(left, right);
      else if (operand.equals("-"))
         answer = (new  Subtraction()).execute(left, right);
      else if (operand.equals("*"))
         answer = (new Multiplication()).execute(left, right);
      else
         answer = (new Division()).execute(left, right);
      return answer;
   }
   
   
   /**
    * Abstract class for below operator classes
    */
   private abstract class Operator{
   }
   
   
   /**
    * Computes addition of 2 integers
    */
   private class Addition extends Operator{
      /**
       * Adds left and right
       * @require -500000000 < left+right < 1000000000
       * @ensure  Numbers added. If out of bounds, ArithmeticException is thrown.
       */
      public int execute(int left, int right) throws java.lang.ArithmeticException{
         if(left+right > 1000000000 && left+right < -500000000)
            throw new java.lang.ArithmeticException();
         int answer = left + right;
         return answer;
      }
   }
   
   
   /**
    * Computes subtraction of 2 integers
    */
   private class Subtraction extends Operator{
      /**
       * Subtracts left and right
       * @require -500000000 < left-right < 1000000000
       * @ensure  Numbers subtracted. If out of bounds, ArithmeticException is thrown.
       */
      public int execute(int left, int right) throws java.lang.ArithmeticException{
         if(left-right > 1000000000 && left-right < -500000000)
            throw new java.lang.ArithmeticException();
         int answer = left - right;
         return answer;
      }
   }
   
   
   /**
    * Computes multiplication of 2 integers
    */
   private class Multiplication extends Operator{
      /**
       * Multiplies left and right
       * @require -500000000 < left*right < 1000000000
       * @ensure  Numbers multiplied. If out of bounds, ArithmeticException is thrown.
       */
      public int execute(int left, int right) throws java.lang.ArithmeticException{
         if(left*right > 1000000000 && left*right < -500000000)
            throw new java.lang.ArithmeticException();
         int answer = left * right;
         return answer;
      }
   }
   
   
   /**
    * Computes integer division of 2 integers
    */
   private class Division extends Operator{
      /**
       * Integer-divides left and right
       * @require -500000000 < left/right < 1000000000
       * @ensure  Numbers divided. If out of bounds, ArithmeticException is thrown.
       */
      public int execute(int left, int right) throws java.lang.ArithmeticException{
         if(left/right > 1000000000 && left/right < -500000000)
            throw new java.lang.ArithmeticException();
         int answer = left / right;
         return answer;
      }
   }
   
   
   /**
    * Exception for using unsupported operators
    */
   private class WrongInputException extends Exception{
      public WrongInputException(){
      }
   }
}