package main;

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

  public static int computeRecursive(int number) {
    efficiencyCounter = 0;
    recursiveIndex = number;
    recursiveFunction(FIRST_NUMBER, SECOND_NUMBER);
    return recursiveAnswer;
  }

  public static int getEfficiency() {
    return efficiencyCounter;
  }

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
