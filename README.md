# RPN Calculator
##### The calculator has a stack that can contain real numbers.
##### The calculator waits for user input and expects to receive strings containing whitespace separated lists of numbers and operators.
##### The ‘undo’ operator undoes the previous operation. “undo undo” will undo the previo us two operations.
##### sqrt performs a square root on the top item from the stack.
##### The ‘+’, ‘-’, ‘*’, ‘/’ operators perform addition, subtraction, multiplication and division respectively on the top two items from the stack.
##### After processing an input string, the calculator displays the current contents of the stack as a space-separated list.

## Build
##### JDK1.8+ is required.
### Windows:
#####    gradlew.bat clean build
### UNIX
#####    ./gradlew clean build

## Run
##### JDK1.8+ is required.
##### Build the project
##### cd build/libs/
##### java -jar RPNCalculator-0.0.2.jar 

