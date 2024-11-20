package org.example.calculate;

import java.util.List;
import org.example.calculate.AdditionOperator;
import org.example.calculate.DivisionOperator;
import org.example.calculate.MultiplicationOperator;
import org.example.calculate.NewArithmeticOperator;
import org.example.calculate.PositiveNumber;
import org.example.calculate.SubtractionOperator;

public class Calculator {

    private static final List<NewArithmeticOperator> arithmeticOperators = List.of(new AdditionOperator(), new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator());


    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2){
        /*if("+".equals(operator)) {
            return operand1 + operand2;
        }else if("-".equals(operator)) {
            return operand1 - operand2;
        }else if("*".equals(operator)) {
            return operand1 * operand2;
        }else if("/".equals(operator)) {
            return operand1 / operand2;
        }*/
        //return ArithmeticOperator.calculate(operand1, operator, operand2);
        return arithmeticOperators.stream()
            .filter(arithmeticOperators -> arithmeticOperators.supports(operator))
            .map(arithmeticOperators -> arithmeticOperators.calculate(operand1, operand2))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("올바른 사칙 연산이 아닙니다."));
    }

}
