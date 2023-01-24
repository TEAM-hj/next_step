package chapter2.string_calculator;

import java.util.Arrays;

public class StringCalculator {
    /**
     * 문자열 기본 구분자로 분리하여 숫자 변환
     * pram : String
     * return : int[]
     * */
    public int[] getSplitedInts(String str) {
        String[] splitedStr = str.split("[,|:]");
        int[] result = new int[splitedStr.length];
        int idx = 0;

        for (String numberStr : splitedStr) {
            if (isBiggerThan0(Integer.parseInt(numberStr))) {
                result[idx++] = Integer.parseInt(numberStr);
            } else if (numberStr.charAt(0)=='-'){
                throw new RuntimeException("음수입력");
            }
        }

        return Arrays.copyOfRange(result, 0,idx);
    }

    private boolean isBiggerThan0(int num) {
        if (num<0) {
            throw new RuntimeException("음수 입력입니다.");
        }
        return num >= 0;
    }

    public int addAll(int[] ints) {
        return Arrays.stream(ints).sum();
    }
}
