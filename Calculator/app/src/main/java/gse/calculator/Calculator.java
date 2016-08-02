package gse.calculator;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by GSE on 2016/7/30.
 */
public class Calculator {
    private String result = "";
    private ArrayList<Character> expression = new ArrayList<>();
    private boolean hasDot = false;
    private Character lastInputCharactor = null;

    public Calculator(){
    }

    static public boolean checkExprIsValid(String expr){
        return false;
    }

    public void clear(){
        result = "";
        expression.clear();
        hasDot = false;
        lastInputCharactor = null;
    }

    public int backsapce(){
        /*
        删除最后一个字符，并返回删除之后还剩余的字符个数
        如果没有字符了，直接返回
        如果删除的字符是点，那么要设置hasDot值为false，lastInputCharactor为删除后的最后一个字符
        如果删除后没有字符了设置hasDot值为false，lastInputCharactor为null
         */
        int charactorSize = expression.size();
        if (charactorSize > 0) {
            Character charWillRemove = expression.get(charactorSize-1);
            expression.remove(charactorSize-1);
            charactorSize--;
            if (charactorSize > 0){
                lastInputCharactor = expression.get(charactorSize-1);
                if (charWillRemove == '.'){
                    hasDot = false;
                }
            }else{
                lastInputCharactor = null;
                hasDot = false;
            }
        }
        return charactorSize;
    }

    public void inputCharactor(char ch) throws CalcException {
        if (expression.isEmpty()){//first input
            if (Character.isDigit(ch)){
                expression.add(ch);
            }else if (ch == '('){
                expression.add(ch);
            }else if (ch == '.'){
                expression.add('0');
                expression.add(ch);
            }else if (isOperator(ch)){
                expression.add(ch);
            }else{
                //error
                throw new CalcException("Input invalid!");
            }
            lastInputCharactor = ch;
        }else{
            if (ch == '('){
                if (checkLeftBracketIsValidInput(ch)){
                    hasDot = false;
                }else{
                    throw new CalcException("Input invalid!");
                }
            }else if (ch == '.'){
                if (checkDotIsValidInput(ch)){
                    hasDot = true;
                }else{
                    throw new CalcException("Input invalid!");
                }
            }else if (Character.isDigit(ch)){
                if (!checkDigitIsValidInput(ch)){
                    throw new CalcException("Input invalid!");
                }
            }else if (ch == ')'){
                if (!checkRightBracketIsValidInput(ch)){
                    throw new CalcException("Input invalid!");
                }
            }else if (isOperator(ch)){
                if (!checkOperatorIsValidInput(ch)) {
                    throw new CalcException("Input invalid!");
                }
            }else{
                throw new CalcException("Input invalid!");
            }
            expression.add(ch);
            lastInputCharactor = ch;
        }
    }

    private boolean checkOperatorIsValidInput(char ch) {
        assert(lastInputCharactor != null);
        return Character.isDigit(lastInputCharactor) || lastInputCharactor == ')';
    }

    private boolean checkRightBracketIsValidInput(char ch) {
        assert(lastInputCharactor != null);
        return Character.isDigit(lastInputCharactor);
    }

    private boolean checkDigitIsValidInput(char ch) {
        assert(lastInputCharactor != null);
        return lastInputCharactor != ')';
    }

    private boolean checkDotIsValidInput(char ch) {
        assert(lastInputCharactor != null);
        return Character.isDigit(lastInputCharactor) && hasDot == false;
    }

    private boolean checkLeftBracketIsValidInput(char ch) {
        assert(lastInputCharactor != null);
        return lastInputCharactor == '(' || isOperator(lastInputCharactor);
    }

    private boolean isOperator(char ch){
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public void inputExpr(String expr) throws CalcException{
        for (char ch : expr.toCharArray()){
            inputCharactor(ch);
        }
    }

    public String calculate(){
        Queue<Object> itemQueue = parseExpression();
        itemQueue = infixToPostfix(itemQueue);

        Stack<Number> operandStack = new Stack<>();
        boolean isDoubleValue = false;
        for (Object obj : itemQueue) {
            if (obj instanceof Number) {
                operandStack.push((Number) obj);
            } else {
                Character ch = (Character) obj;
                switch (ch) {
                    case '+': {
                        Number right = operandStack.pop();
                        isDoubleValue |= (right instanceof Double);
                        Number left = operandStack.pop();
                        isDoubleValue |= (left instanceof Double);
                        Double resultTemp = (left.doubleValue() + right.doubleValue());
                        if (!isDoubleValue){
                            operandStack.push(resultTemp.intValue());
                        }else{
                            operandStack.push(resultTemp);
                        }
                        break;
                    }
                    case '-': {
                        Number right = operandStack.pop();
                        isDoubleValue |= (right instanceof Double);
                        Number left = operandStack.pop();
                        isDoubleValue |= (left instanceof Double);
                        Double resultTemp = (left.doubleValue() - right.doubleValue());
                        if (!isDoubleValue){
                            operandStack.push(resultTemp.intValue());
                        }else{
                            operandStack.push(resultTemp);
                        }
                        break;
                    }
                    case '*': {
                        Number right = operandStack.pop();
                        isDoubleValue |= (right instanceof Double);
                        Number left = operandStack.pop();
                        isDoubleValue |= (left instanceof Double);
                        Double resultTemp = (left.doubleValue() * right.doubleValue());
                        if (!isDoubleValue){
                            operandStack.push(resultTemp.intValue());
                        }else{
                            operandStack.push(resultTemp);
                        }
                        break;
                    }
                    case '/': {
                        Number right = operandStack.pop();
                        isDoubleValue |= (right instanceof Double);
                        Number left = operandStack.pop();
                        isDoubleValue |= (left instanceof Double);
                        if (right instanceof Integer && left instanceof Integer) {
                            Integer resultTemp = (left.intValue() / right.intValue());
                            operandStack.push(resultTemp);
                        } else {
                            Double resultTemp = (left.doubleValue() / right.doubleValue());
                            operandStack.push(resultTemp);
                        }
                        break;
                    }
                }
            }
        }
        Number resultTemp = operandStack.pop();
        result = resultTemp.toString();
//        if (isDoubleValue){
//            result = resultTemp.toString();
//        }else{
//            Integer intV = new Integer(resultTemp.intValue());
//            result = intV.toString();
//        }
        return result;
    }

    private Queue<Object> infixToPostfix(Queue<Object> itemQueue){
        Queue<Object> q = new LinkedList<>();
        Stack<Character> operatorStack = new Stack<>();
        while (!itemQueue.isEmpty()){
            Object obj = itemQueue.poll();
            if (obj instanceof Number){
                q.offer(obj);
            }else{
                assert(obj instanceof Character);
                Character ch = (Character)obj;
                if (ch == '('){
                    operatorStack.push(ch);
                }else if (ch == ')'){
                    while (!operatorStack.isEmpty()){
                        Character oper = operatorStack.pop();
                        if (oper == '('){
                            break;
                        }
                        q.offer(oper);
                    }
                }else{
                    if (!operatorStack.isEmpty()){
                        Character top = operatorStack.peek();
                        if (getOperatorLevel(ch) <= getOperatorLevel(top)){
                            q.offer(top);
                            operatorStack.pop();
                        }
                    }
                    operatorStack.push(ch);
                }
            }
        }
        while (!operatorStack.isEmpty()){
            q.offer(operatorStack.pop());
        }
        return q;
    }

    private int getOperatorLevel(Character operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    private Queue<Object> parseExpression() {
        Queue<Object> q = new LinkedList<>();
        String number = "";
        boolean dot = false;
        for (Character ch : expression){
            if (Character.isDigit(ch)){
                number += ch;
            }else if (ch == '.'){
                dot = true;
                number += ch;
            }else{
                if (!number.isEmpty()){
                    try {
                        Number n = NumberFormat.getInstance().parse(number);
                        if (dot) {
                            q.offer(n.doubleValue());
                            dot = false;
                        }else{
                            q.offer(n.intValue());
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    number = "";
                }
                q.offer(ch);
            }
        }
        if (!number.isEmpty()){
            try {
                Number n = NumberFormat.getInstance().parse(number);
                if (dot) {
                    q.offer(n.doubleValue());
                }else{
                    q.offer(n.intValue());
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return q;
    }

    public String getResult(){
        return result;
    }

    public String getExpression(){
        String expr = "";
        for (Character ch : expression){
            expr += ch;
        }
        return expr;
    }
}
