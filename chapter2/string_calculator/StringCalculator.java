package chapter2.string_calculator;

import java.util.Arrays;

public class StringCalculator {

    public int stringSum(String str) {
        String[] split = str.split("/\n");
        int[] numbers;

        if (split.length>1) {
            numbers = getSplitedInts(split[0].replace("//",""), split[1]);
        } else {
            numbers = getSplitedInts(str);
        }
        return addAll(numbers);
    }

    /**
     * 문자열 기본 구분자로 분리하여 숫자 변환
     * pram : String
     * return : int[]
     * */
    public int[] getSplitedInts(String str) {
        String[] strings = str.split("[,|:]");
        return splitedStrToInt(strings);
    }
    public int[] getSplitedInts(String reg, String str) {
        String[] strings = str.replace(reg, " ").split(" ");
        return splitedStrToInt(strings);
    }

    private int[] splitedStrToInt(String[] splitedStr) {
        int[] result = new int[splitedStr.length];
        int idx = 0;

        for (String numberStr : splitedStr) {
            isBiggerThan0(Integer.parseInt(numberStr.trim()));
            result[idx++] = Integer.parseInt(numberStr.trim());
        }

        return Arrays.copyOfRange(result, 0,idx);
    }

    private void isBiggerThan0(int num) {
        if (num<0) {
            throw new RuntimeException("음수 입력입니다.");
        }
    }

    public int addAll(int[] ints) {
        return Arrays.stream(ints).sum();
    }
}
