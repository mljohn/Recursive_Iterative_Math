/**
 * File: Sequence
 * Author: Michelle John
 * Date: 03 Dec 2017
 * Purpose: Project 3: Recursion and Iteration
 */
package main;

/**
 * Class that holds the interative and recursive funtions.
 */
public class Sequence {

  private final static int FIRST_NUMBER = 0;
  private final static int SECOND_NUMBER = 1;
  private static int recursiveIndex = 0;
  private static int recursiveAnswer = 0;
  public static int efficiencyCounter = 0;

  /**
   * Private constructor to prevent instantiation
   */
  private Sequence() {
  }

  /**
   * Method to compute the value iteratively.
   * 
   * @param numberIterations the number of iterations
   * @return the calculated value
   */
  public static int computeIterative(int numberIterations) {
    int firstOperand = FIRST_NUMBER;
    int secondOperand = SECOND_NUMBER;
    int currentValue = 0;
    efficiencyCounter = 0;

    for (int i = 2; i <= numberIterations; i++) {
      currentValue = firstOperand + secondOperand * 2;
      firstOperand = secondOperand;
      secondOperand = currentValue;
      efficiencyCounter++;
    }
    return currentValue;
  }

  /**
   * Method to compute the value recursively.
   * 
   * @param number the number to calculate to
   * @return the calculated value
   */
  public static int computeRecursive(int number) {
    efficiencyCounter = 0;
    recursiveIndex = number;
    recursiveFunction(FIRST_NUMBER, SECOND_NUMBER);
    return recursiveAnswer;
  }

  /**
   * @return the efficiency
   */
  public static int getEfficiency() {
    return efficiencyCounter;
  }

  /**
   * Private method to recursively calculate the value.
   * 
   * @param operand1 the first operand
   * @param operand2 the second operand
   */
  private static void recursiveFunction(int operand1, int operand2) {
    if (recursiveIndex < 2) {
      return;
    }
    recursiveIndex--;
    recursiveAnswer = operand1 + operand2 * 2;
    efficiencyCounter++;
    recursiveFunction(operand2, recursiveAnswer);
  }
}
