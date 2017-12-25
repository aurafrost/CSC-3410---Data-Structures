/*
Jimmy Tran
Bhola
CSC 3410

Personal Note: The evaluate method fails to typecast the objects popped from 
the stack. I have no clue why, and as a result the program doesn't print
the expected/correct value. Aside from that, I believe I got the rest working.

Purpose: To gain experience with the Stack Data Structure and library

Solution: A Stack will be used to convert the infix equation into postfix
form. From there, the program will evaluate the equations with the evaluate
method, using the postfix equation and x value given.
 
Data Structures: Only Stacks will be used for converting and evaluating.

Input/Output: The user will input a string containing an equation in 
infix form with variable x included. After converting the equation to 
postfix form, the user will input a value to replace x, and the program
will solve the equation and return an answer.

Classes: The Calc class is the main class. All methods and main will be
in the Calc class as no other classes are needed.
*/
package calc;
import java.util.*;
//main class
public class Calc {
    //checks if the char is an operator
    //pre:true
    //post:returns true if a valid operator; false otherwise
    public boolean isOperator(char c) {
        return c=='+'||c=='-'||c=='*'||c=='/'||c=='%'||c=='('||c==')';
    }
    //checks if char is a space
    //pre:true
    //post:returns true if c is a space;false otherwise
    public boolean isSpace(char c) {
        return (c==' ');
    }
    //checks precedence of operators
    //pre:op1 and op2 are operators
    //post:returns true if op1<op2 in precedence; false otherwise
    public boolean lowerRank(char op1, char op2) {
        switch(op1) {
            case '+':case '-':
                return !(op2=='+'||op2=='-');
            case '*':case '/':case '%':
                return (op2=='(');
            case '(':
                return true;
            default:
                return false;
        }
    }
    //converts the infix equation to postfix form and returns it
    //pre: infix is a valid infix equation. spaces are allowed
    //post: returns the equation in postfix form w/o spaces and parentheses
    public String inToPost(String infix) {
        Stack opStack=new Stack();
        char c;
        StringTokenizer t=new StringTokenizer(infix,"+-*/%() ",true);
        StringBuffer postfix=new StringBuffer(infix.length());
        while(t.hasMoreTokens()) {
            String token=t.nextToken();
            c=token.charAt(0);
            if(token.length()==1&&isOperator(c)) {
                while(!opStack.empty()
                        &&!lowerRank(((String)opStack.peek()).charAt(0), c)) {
                    postfix.append((String)opStack.pop());
                }
                if (c==')') {
                    String operator = (String)opStack.pop();
                    while (operator.charAt(0)!='(') {
                         postfix.append(operator);
                         operator = (String)opStack.pop();  
                    }
                }
                else
                    opStack.push(token);// Push this operator onto the stack.
            }
            else if ((token.length()==1)&&isSpace(c)) {    
                ;  //ignores if a space
            }
            else {
                postfix.append(token);
            }
        }
        //Outputs remaining operators to stack.
        while(!opStack.empty())
             postfix.append((String)opStack.pop());
        postfix.append(" ");
        return postfix.toString();
    }
    
    //evaluates the given equation and prints an answer
    //pre:equation has no spaces
    //post:prints out the evaluated expression
    public void evaluate(String equation){
        int newOp=0;
        Stack operands=new Stack();
        for(int i=0;i<equation.length();i++) {
            char c=equation.charAt(i);
            if(isOperator(c)) {
                int op2=(Integer) operands.pop(); //doesn't typecast. Why?
                int op1=(Integer) operands.pop(); //also fails to typecast
                if(c=='+')
                    newOp=(op1+op2);
                if(c=='-')
                    newOp=(op1-op2);
                if(c=='*')
                    newOp=(op1*op2);
                if(c=='/')
                    newOp=(op1/op2);
                if(c=='%')
                    newOp=(op1%op2);
                operands.push(newOp);
            }
            else {
                operands.push((int)c);
            }
        }
        newOp=(int)operands.pop();
        System.out.println("Answer to expression: "+newOp);
    }
    
    //checks if the infix expression is valid
    //pre: infix has spaces between each char
    //post: returns true if all tests are passed; false otherwise
    public boolean checkValidity(String infix) {
        int pLeft=0;
        int pRight=0;
        int operandCount=0;
        int operationCount=0;
        for(int i=0;i<infix.length()-1;i++) {
            char c=infix.charAt(i);
            char end=infix.charAt(infix.length()-1);
            if(isOperator(end)) {
                System.out.println("Last token must be an operand.");
                return false;
            }
            if(c=='.') {
                System.out.println("Error in expression!! "
                        + "Cannot accept floating point numbers.");
                return false;
            }
            if(c=='(')
                pLeft++;
            if(c=='('&&isOperator(infix.charAt(i+2)))
                System.out.println("Error in expression!! No operator "
                        + "between operand and left parentheses.");
            if(c==')'&&isOperator(infix.charAt(i-2)))
                System.out.println("Error in expression!! No operator "
                        + "between operand and right parentheses.");
            if(c==')')
                pRight++;
            if(isOperator(c)&&!isSpace(c))
                operandCount=0;
            if(!isOperator(c)&&!isSpace(c))
                operationCount=0;
            if(!isOperator(c)&&isSpace(infix.charAt(i+1))) {
                operandCount++;
                if(operandCount>1) {
                    System.out.println("Error in expression!! "
                            + "No operator between operands.");
                    return false;
                }
            }
            if(isOperator(c)&&isSpace(infix.charAt(i+1))&&c!='('&&c!=')') {
                operationCount++;
                if(operationCount>1) {
                    System.out.println("Error in expression!! "
                            + "Cannot have consecutive operators.");
                    return false;
                }
            }
        }
        if(pLeft!=pRight) {
            System.out.println("Error in expression!! "
                    + "No matching parentheses.");
            return false;
        }  
        return true;
    }
    
    //test infix equation: ( 1 + 2 ) * 3 - 4 / x
    //pre:infix must have spaces b/t each char.numbers can only be 1 digit
    public static void main(String[]args) {
        Scanner k=new Scanner(System.in); 
        Calc c=new Calc();
        String repeat="r";
        String infix="";
        boolean check=false;
        while(check==false) {
            System.out.print("Enter infix expression: ");
            infix=k.nextLine();
            if(infix.equalsIgnoreCase("q"))
                System.exit(1);
            check=c.checkValidity(infix);
        }
        System.out.println("Infix Expression: "+ infix);
        String postfix=c.inToPost(infix);
        System.out.println("Converted expression: "+postfix);
        while(repeat.equals("r")) {
            postfix=c.inToPost(infix);
            System.out.print("Enter value of x: ");
            String x=k.nextLine();
            if(x.equalsIgnoreCase("q"))
                System.exit(1);
            postfix=postfix.replaceAll("x",x);
            
            //solves expression and prints answer
            c.evaluate(postfix);
        }
    }
}