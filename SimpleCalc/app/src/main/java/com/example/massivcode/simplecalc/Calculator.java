package com.example.massivcode.simplecalc;

import android.util.Log;

/**
 * Created by massivCode on 2015-08-05.
 */

public class Calculator {

    private String buffer = "";
    private String[] eed;
    private double operand1, operand2;
    private double result = 0;
    private int jungsu;
    private double sosu;
    private char operator = ' ';
    private boolean haveAll = false;
    private boolean haveOp = false;
    private boolean haveOr2 = false;



    private static Calculator calc = null;

    private Calculator() {

    }

    public static Calculator getInstance() {
        if (calc == null) {
            calc = new Calculator();
        }
        return calc;
    }

    /**
     * 데이터의 3가지 타입과, 입력을 원하는 내용을 전달받아 타입별로 다른 3가지의 분기점으로 나뉘어 입력을 처리합니다.
     *
     * @param type
     *            : 데이터의 타입을 입력합니다. 데이터의 타입으로는 숫자인 num, 연산자인 operator, 소수점인 dot이
     *            있습니다.
     * @param content
     *            : 데이터의 내용을 입력합니다. 데이터의 내용으로는 숫자(num) : 0, 1, 2, 3, 4, 5, 6, 7,
     *            8, 9 / 연산자(operator) : +, -, *, /, % / 소수점 구분 기호인 dot : . 이
     *            있습니다.
     */
    public void input(String type, String content) {

        switch (type) {
            case "num": {

                buffer += content;

                if (buffer.length() != 0 && operator != ' ') {

                    String[] ed = buffer.split("\\" + Character.toString(operator));
                    operand2 = Double.parseDouble(ed[1]);

                    haveAll = true;
                    haveOr2 = true;
                }

            }
            break;

            case "operator":

                if (buffer.length() != 0 && haveOp == false) { // 버퍼의 길이가 0이 아니고,
                    // op가 null 이면

                    buffer += content;

                    if (buffer.contains("*")) {
                        String[] splited = buffer.split("\\*");
                        operand1 = Double.parseDouble(splited[0]);
                        operator = '*';
                        haveOp = true;
                    } else if (buffer.contains("/")) {
                        String[] splited = buffer.split("\\/");
                        operand1 = Double.parseDouble(splited[0]);
                        operator = '/';
                        haveOp = true;
                    } else if (buffer.contains("+")) {
                        String[] splited = buffer.split("\\+");
                        operand1 = Double.parseDouble(splited[0]);
                        operator = '+';
                        haveOp = true;
                    } else if (buffer.contains("-")) {
                        String[] splited = buffer.split("\\-");
                        operand1 = Double.parseDouble(splited[0]);
                        operator = '-';
                        haveOp = true;
                    } else if (buffer.contains("%")) {
                        String[] splited = buffer.split("\\%");
                        operand1 = Double.parseDouble(splited[0]);
                        operator = '%';
                        haveOp = true;
                    }
                } else if (buffer.length() != 0 && haveOp == true && haveOr2 == false) {

                    buffer = operand1 + content;
                    operator = content.charAt(0);
                }

                break;

            case "dot": {

                if (buffer.length() != 0) {
                    buffer += ".";
                } else if (buffer.length() != 0 && operator != ' ') {
                    buffer += ".";
                    String[] ed = buffer.split("\\" + Character.toString(operator));
                    operand2 = Double.parseDouble(ed[1]);

                    haveAll = true;
                    haveOr2 = true;
                }

            }

            default:

        }

    }

    public String getBuffer() {
        return buffer;
    }

    public void clear() {

        buffer = "";
        operand1 = 0;
        operand2 = 0;
        operator = ' ';
        result = 0;
        haveOp = false;
        haveOr2 = false;

    }

    public void backspace() {

        if (buffer.length() != 0) {

            if (buffer.contains("*") || buffer.contains("%") || buffer.contains("-") || buffer.contains("+")
                    || buffer.contains("/")) {
                int opIndex = buffer.indexOf(operator) + 1;
                String[] ed = buffer.split("\\" + operator);
                if (buffer.length() > opIndex) { // 문자열이 연산자의 위치보다 크다 = op1 =
                    // 왼쪽, op2 = 오른쪽
                    operand1 = Double.parseDouble(ed[0]);
                    operand2 = Double.parseDouble(ed[1]);
                } else if (buffer.length() == opIndex) { // 문자열이 연산자의 위치와 동일하다
                    // == op1 = 왼쪽, op2
                    // = 없음
                    operand1 = Double.parseDouble(ed[0]);
                    operand2 = 0;
                    haveAll = false;
                    haveOr2 = false;
                    haveOp = true;
                } else {
                    operand1 = Double.parseDouble(buffer);
                    operand2 = 0;
                    operator = ' ';
                    haveAll = false;
                    haveOr2 = false;
                    haveOp = false;
                }

            } else {
                haveOp = false;
                haveAll = false;
                haveOr2 = false;
                operator = ' ';
                operand2 = 0;
            }

            buffer = buffer.substring(0, buffer.length() - 1);

        }

    }

    public void calculate() {

        if (haveAll) {

            try {
                if ((buffer.contains("*") || buffer.contains("-") || buffer.contains("/") || buffer.contains("+")
                        || buffer.contains("%")) && buffer.contains("-")) {
                    if (buffer.contains("*")) { //
                        eed = buffer.split("\\*");
                        operand1 = Double.parseDouble(eed[0]);
                        operand2 = Double.parseDouble(eed[1]);
                        result = operand1 * operand2;
                    } else if (buffer.contains("/")) { //
                        eed = buffer.split("\\/");
                        operand1 = Double.parseDouble(eed[0]);
                        operand2 = Double.parseDouble(eed[1]);
                        result = operand1 / operand2;
                    } else if (buffer.contains("+")) { //
                        eed = buffer.split("\\+");
                        operand1 = Double.parseDouble(eed[0]);
                        operand2 = Double.parseDouble(eed[1]);
                        result = operand1 + operand2;
                    } else if (buffer.contains("%")) { //
                        eed = buffer.split("\\%");
                        operand1 = Double.parseDouble(eed[0]);
                        operand2 = Double.parseDouble(eed[1]);
                        result = operand1 % operand2;
                    } else if (buffer.contains("--")) { //
                        eed = buffer.split("\\--");
                        operand1 = Double.parseDouble(eed[0]);
                        operand2 = -1 * Double.parseDouble(eed[1]);
                        result = operand1 - operand2;
                    } else if (buffer.contains("-")) { //
                        // -5-2 일 경우에...
                        if (buffer.indexOf("-") == 0) {
                            String bf = buffer.substring(1, buffer.length());
                            eed = bf.split("\\-");
                            operand1 = -Double.parseDouble(eed[0]);
                            operand2 = -Double.parseDouble(eed[1]);
                            result = operand1 + operand2;
                        } else {
                            eed = buffer.split("\\-");
                            operand1 = Double.parseDouble(eed[0]);
                            operand2 = Double.parseDouble(eed[1]);
                            result = operand1 - operand2;
                        }

                    }

                } else {
                    if (buffer.contains("*")) { //
                        eed = buffer.split("\\*");
                        operand1 = Double.parseDouble(eed[0]);
                        operand2 = Double.parseDouble(eed[1]);
                        result = operand1 * operand2;
                    } else if (buffer.contains("/")) { //
                        eed = buffer.split("\\/");
                        operand1 = Double.parseDouble(eed[0]);
                        operand2 = Double.parseDouble(eed[1]);
                        result = operand1 / operand2;
                    } else if (buffer.contains("+")) { //
                        eed = buffer.split("\\+");
                        operand1 = Double.parseDouble(eed[0]);
                        operand2 = Double.parseDouble(eed[1]);
                        result = operand1 + operand2;
                    } else if (buffer.contains("%")) { //
                        eed = buffer.split("\\%");

                        operand1 = Double.parseDouble(eed[0]);
                        operand2 = Double.parseDouble(eed[1]);
                        result = operand1 % operand2;
                    }

                }

            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다.");
            }

            jungsu = (int) result;

            sosu = result - jungsu;

        } else {
            buffer = "";
            operand1 = 0;
            operand2 = 0;
            operator = ' ';
            haveOp = false;
            haveOr2 = false;
        }

    }

    public int getJungsu() {
        return jungsu;
    }

    public double getSosu() {
        return sosu;
    }

    public double getResult() {
        return result;
    }

}
