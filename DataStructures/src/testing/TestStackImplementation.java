package testing;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
import stack.ArrayStack;
import stack.CursorStack;
import stack.LinkedListStack;

public class TestStackImplementation {

	public static void main(String[] args) throws IOException {
	}
	
	static boolean checkBalance(String exp) {
		int i = 0;
		Stack<Character> stack = new Stack<>();
		while (i < exp.length()) {
			char nextCharacter = exp.charAt(i++);
			switch (nextCharacter) {
			case '{':
			case '(':
			case '[':
				stack.push(nextCharacter);
				break;
			case '}':
			case ')':
			case ']':
				if (stack.isEmpty())
					return false;
				else {
					char openDelimiter = stack.pop();
					if (nextCharacter == '}' && openDelimiter != '{' ||
							nextCharacter == ']' && openDelimiter != '[' ||
							nextCharacter == ')' && openDelimiter != '(')
						return false;
				}
				break;
			}
		}
		return stack.isEmpty();
	}
	
	static String convertToPostfix(String infix) {
		LinkedListStack<Character> operatorStack = new LinkedListStack<>();
		String postfix = "";
		int i = 0;
		while (i < infix.length()) {
			char ch = infix.charAt(i++);
			switch (ch) {
				case '0': case '1': case '2': case '3': case '4':
				case '5': case '6': case '7': case '8': case '9':
					postfix += ch;
					break;
					
				case '^':
					operatorStack.push(ch);
					break;
				
				case '+': case '-': case '*': case '/':
					while (!operatorStack.isEmpty() && 
							precedence(ch) <= precedence(operatorStack.peek())) 
						postfix += operatorStack.pop();
					operatorStack.push(ch);
					break;
					
				case '(':
					operatorStack.push(ch);
					break;
				
				case ')':
					char topOperator = operatorStack.pop();
					while (topOperator != '(') {
						postfix += topOperator;
						topOperator = operatorStack.pop();
					}
					break;
	
				default: break;
			}
		}
		while (!operatorStack.isEmpty()) {
			char topOperator = operatorStack.pop();
			postfix += topOperator;
		}
		return postfix;
	}
	
	static int evaluateInfix(String infix) {
		Stack<Character> operatorStack = new Stack<>();
		Stack<Integer> valueStack = new Stack<>();
		int i = 0;
		while (i < infix.length()) {
			char ch = infix.charAt(i++);
			switch (ch) {
				case '0': case '1': case '2': case '3': case '4':
				case '5': case '6': case '7': case '8': case '9':
					valueStack.push(ch - '0');
					break;
					
				case '^':
					operatorStack.push(ch);
					break;
				
				case '+': case '-': case '*': case '/':
					while (!operatorStack.isEmpty() && 
							precedence(ch) <= precedence(operatorStack.peek())) {
						char topOperator = operatorStack.pop();
						int operandTwo = valueStack.pop(),
								operandOne = valueStack.pop();
						int result = evaluateExp(topOperator, operandOne, operandTwo);
						valueStack.push(result);
					}
	
				case '(':
					operatorStack.push(ch);
					break;
					
				case ')':
					char topOperator = operatorStack.pop();
					while (topOperator != '(') {
						int operandTwo = valueStack.pop(),
								operandOne = valueStack.pop();
						int result = evaluateExp(topOperator, operandOne, operandTwo);
						valueStack.push(result);
						topOperator = operatorStack.pop();
					}
					break;
					
				default: break;
			}
		}
		while (!operatorStack.isEmpty()) {
			char topOperator = operatorStack.pop();
			int operandTwo = valueStack.pop(),
					operandOne = valueStack.pop();
			int result = evaluateExp(topOperator, operandOne, operandTwo);
			valueStack.push(result);
		}
		return valueStack.peek();
	}
	
	static int evalutePostfix(String postfix) {
		Stack<Integer> valueStack = new Stack<>();
		int i = 0;
		while (i < postfix.length()) {
			char ch = postfix.charAt(i);
			switch (ch) {
				case '0': case '1': case '2': case '3': case '4':
				case '5': case '6': case '7': case '8': case '9':
					valueStack.push(ch - '0');
					break;
					
				case '^': case '+': case '-': case '*': case '/':
					int operandTwo = valueStack.pop(),
					operandOne = valueStack.pop();
					int result = evaluateExp(ch, operandOne, operandTwo);
					valueStack.push(result);
					break;
				
				default: break;
			}
		}
		return valueStack.peek();
	}

	private static int evaluateExp(char operator, int operandOne, int operandTwo) {
		switch (operator) {
			case '+': 
				return operandOne + operandTwo;
			case '-': 
				return operandOne - operandTwo;
			case '*': 
				return operandOne * operandTwo;
			case '/': 
				return operandOne / operandTwo;
		}
		return 0;
	}

	private static int precedence(char operator) {
		switch (operator) {
			case '+': case '-': return 0;
			case '*': case '/': return 1;
		}
		return -1;
	}
}
