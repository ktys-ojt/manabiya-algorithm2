package algorithm2;

import java.util.Arrays;

public class Algorithm2 {

    /**
     * Aの条件その1.
     */
    private static final int NUMBER_A1 = 2;
    /**
     * Aの条件その2.
     */
    private static final int NUMBER_A2 = 3;
    /**
     * Bの条件その1.
     */
    private static final int NUMBER_B1 = 3;
    /**
     * Bの条件その2.
     */
    private static final int NUMBER_B2 = 5;
    /**
     * 含まれるかチェックする値.
     */
    private static int NUMBER;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	try {
	    NUMBER = Integer.parseInt(args[0]);
	} catch (IndexOutOfBoundsException e) {
	    System.out.println("引数に値を入力してください.");
	    return;
	} catch (NumberFormatException e) {
	    System.out.println("整数を入力してください");
	    return;
	}

	checkInA(NUMBER);
	checkInB(NUMBER);
    }

    /**
     * 数値が集合Aに含まれるかチェックして、結果を標準出力する.
     *
     * @param num チェックしたい値.
     */
    private static void checkInA(int num) {
	int number1 = NUMBER_A1;
	int number2 = NUMBER_A2;
	int[] baseNum;
	int check = 0;
	if (number1 >= number2) {
	    baseNum = makeBaseNum(number1, number2);
	} else {
	    check = 1;
	    baseNum = makeBaseNum(number2, number1);
	}

	if (0 != (num % baseNum[0])) {
	    System.out.println(num + "は、Aには含まれない");
	} else {
	    int quot = num / baseNum[0];
	    String message = "第一引数はAに属する： arg[0] = "
		    + NUMBER_A1 + " * " + (quot * baseNum[1 + check])
		    + " + " + NUMBER_A2 + " * "
		    + (quot * baseNum[2 - check]);
	    System.out.println(message);
	}

    }

    /**
     * 数値が集合Bに含まれるかチェックして、結果を標準出力する.
     *
     * @param num チェックしたい値.
     */
    private static void checkInB(int num) {
	int number1 = NUMBER_B1;
	int number2 = NUMBER_B2;
	int[] baseNum;
	int check = 0;
	if (number1 >= number2) {
	    baseNum = makeBaseNum(number1, number2);
	} else {
	    check = 1;
	    baseNum = makeBaseNum(number2, number1);
	}

	if (0 != (num % baseNum[0])) {
	    System.out.println(num + "は、Bには含まれない");
	} else {
	    int quot = num / baseNum[0];
	    String message = "第一引数はBに属する： arg[0] = "
		    + NUMBER_B1 + " * " + (quot * baseNum[1 + check])
		    + " + " + NUMBER_B2 + " * " 
		    + (quot * baseNum[2 - check]);
	    System.out.println(message);
	}

    }

    /**
     * ユークリッドの互除法により最大公約数を計算する. 逆算もおこなっている.
     *
     * @param num1 整数1. 大きい方の値を入れる.
     * @param num2 整数2.
     * @return 最大公約数と最大公約数を求めるための係数.
     */
    private static int[] makeBaseNum(int num1, int num2) {
	//剰余が0であればnum2を返し、異なれば剰余とnum2で計算を繰り返す
	int quot = num1 / num2;
	int surp = num1 % num2;
	int[] resultSet;
	if (0 != surp) {
	    resultSet = makeBaseNum(num2, surp);
	} else {
	    return new int[]{num2, 0, 1};
	}

	int keisu1 = resultSet[1];
	int keisu2 = resultSet[2];
	resultSet[1] = keisu2;
	resultSet[2] = keisu1 - quot * keisu2;
	return resultSet;
    }
}
