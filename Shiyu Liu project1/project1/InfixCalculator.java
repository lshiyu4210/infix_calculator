package project1;
//author: Shiyu Liu

import java.util.*;
import java.io.*;


public class InfixCalculator<T> {
	
	private String inputString;
	private String numString;
	
	private myStack<String> s;
	private myQueue<String> q;
	private myStack<Double> Evals;
	
	public void InfixToPostfix(String iString) {
		inputString = iString;
		String inS = inputString.replaceAll(" ","");
		s = new myStack();
		q = new myQueue();
		numString = "";
		for(int i = 0; i < inS.length(); i++) {
			char curChar = inS.charAt(i);
			String curString = String.valueOf(curChar);
			if(!isOperator(curString)) {
				numString += curString;
				if(numString.equals("sin") || numString.equals("cos") || numString.equals("tan")) {
					s.push(numString);
					numString = "";
				}
	
			}
			else if(curString.equals("(")) {
				s.push(curString);
			}
			else if(curString.equals(")")) {
				q.enqueue(numString);
				numString = "";
				while(!s.isEmpty() && !s.peek().equals("(")) {
					q.enqueue(s.pop());
				}
				s.pop();
			}
			else {
				q.enqueue(numString);
				numString = "";
				if(!s.isEmpty() && precedence(curString) == 4 && precedence(s.peek()) == 4) {
					s.push(curString);
				}
				else {
					while(!s.isEmpty() && precedence(curString) <= precedence(s.peek())) {
						q.enqueue(s.pop());
					}
				s.push(curString);
				}
				
			}
			
		}
		if(!numString.equals(""))
			q.enqueue(numString);
		
		while(!s.isEmpty()) {
			if(s.peek().equals("("))
				System.out.println("Invalid expression!");
			q.enqueue(s.pop());
			
		}
		
	}
	
	public boolean isOperator(String o) {
		switch(o) {
		case "+":
			return true;
		case "-":
			return true;
		case "*":
			return true;
		case "/":
			return true;
		case "^":
			return true;
		case "<":
			return true;
		case ">":
			return true;
		case "&":
			return true;
		case "|":
			return true;
		case "(":
			return true;
		case ")":
			return true;
		case "=":
			return true;
		case "!":
			return true;
		case "sin":
			return true;
		case "cos":
			return true;
		case "tan":
			return true;
		case "%":
			return true;
		default:
			return false;
			
		}
	}
	
	
	public int precedence(String o) {
		switch(o) {
		case "+":
			return 2;
		case "-":
			return 2;
		case "*":
			return 3;
		case "/":
			return 3;
		case "^":
			return 4;
		case "<":
			return 1;
		case ">":
			return 1;
		case "&":
			return 1;
		case "|":
			return 1;
		case "!":
			return 5;
		case "=":
			return 1;
		case "(":
			return 0;
		case ")":
			return 0;
		case "sin":
			return 5;
		case "cos":
			return 5;
		case "tan":
			return 5;
		case "%":
			return 3;
		default:
			return -1;
		
		}
	}
	
	public double calculator() {
		
		Evals = new myStack();
		double left = 0.0;
		double right = 0.0;
		while(!q.isEmpty()) {
			if(q.peek().equals(""))
				q.dequeue(); 
			String curString = q.peek();
			if(!isOperator(curString)) {
				double d = Double.parseDouble(q.dequeue());
				Double curDouble = new Double(d);
				Evals.push(curDouble);
			}
			else {
				double result = 0.00;
				switch(curString) {
				case "+":
					right = Evals.pop();
					left = Evals.pop();
					result = left + right;
					break;
				case "-":
					right = Evals.pop();
					if(Evals.isEmpty())   left = 0.00;
					else                  left = Evals.pop();
					result = left - right;
					break;
				case "*":
					right = Evals.pop();
					left = Evals.pop();
					result = left * right;
					break;
				case "/":
					right = Evals.pop();
					left = Evals.pop();
					result = left / right;
					break;
				case "<":
					right = Evals.pop();
					left = Evals.pop();
					if(left < right)     result = 1.00;
					else                 result = 0.00;
					break;
				case ">":
					right = Evals.pop();
					left = Evals.pop();
					if(left > right)     result = 1.00;
					else                 result = 0.00;
					break;
				case "|":
					right = Evals.pop();
					left = Evals.pop();
					if(left == 1.00 || right == 1.00)   result = 1.00;
					else                                result = 0.00;
					break;
				case "&":
					right = Evals.pop();
					left = Evals.pop();
					if(left == 1.00 && right == 1.00)   result = 1.00;
					else                                result = 0.00;
					break;
				case "=":
					right = Evals.pop();
					left = Evals.pop();
					if(left ==  right)   result = 1.00;
					else                 result = 0.00;
					break;
				case "!":
					right = Evals.pop();
					if(right == 0)       result = 1.00;
					else                 result = 0.00;
					break;
				case "^":
					right = Evals.pop();
					left = Evals.pop();
					result = Math.pow(left, right);
					break;
				case "sin":
					right = Evals.pop();
					double sinR = Math.toRadians(right);
					result = Math.sin(sinR);
					break;
				case "cos":
					right = Evals.pop();
					double cosR = Math.toRadians(right);
					result = Math.cos(cosR);
					break;
				case "tan":
					right = Evals.pop();
					double tanR = Math.toRadians(right);
					result = Math.tan(tanR);
					break;
				case "%":
					right = Evals.pop();
					left = Evals.pop();
					result = left % right;
					break;
				default:
				    break;
				}
				Evals.push(result);
				q.dequeue();
				if(q.getSize() == 0)  break;
				
		
		}
		}
		return Evals.peek();
		
	}
	}

