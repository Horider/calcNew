import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine().toUpperCase();
        System.out.println(Main.calc(inputString));
    }

    public static String calc (String inputString) {
        int number1 = 0, number2 = 0;
        String stable1 = null, stable2 = null, answer = null;
        String[] splitNumbers;
        String[] Numbers = new String[2];
        char operation;

        operation = CalculatorHelper.underChar(inputString);
        splitNumbers = inputString.split("[+-/*]");
        try{
            stable1 = splitNumbers[0].trim();
            stable2 = splitNumbers[1].trim();
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Ошибка : " + e);
        }

        if (splitNumbers.length > 2) {
            return null;
        } else
            Numbers = Arrays.copyOf(splitNumbers, 2);
        try {
            stable1 = Numbers[0].trim();
            stable2 = Numbers[1].trim();
        } catch (NullPointerException e) {
            System.out.println("Ошибка : " + e);
        }

        // Производится вычесление взависимости от формата вводимых чисел
        if (Arrays.asList(CalculatorHelper.ROMAN).contains(stable1) && Arrays.asList(CalculatorHelper.ROMAN).contains(stable2)) {
            number1 = CalculatorHelper.convertRomanToArab(stable1);
            number2 = CalculatorHelper.convertRomanToArab(stable2);
            try {
                return CalculatorHelper.calculatorRome(number1, number2, operation);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Ошибка : " + e);
            }

        } else {
            try {
                number1 = Integer.parseInt(stable1);
                number2 = Integer.parseInt(stable2);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка : " + e);
            }
            if ((number1 >= 0 && number1 <= 10) && (number2 >= 0 && number2 <= 10)) {
                return answer = String.valueOf(CalculatorHelper.calculated(number1, number2, operation));
            } else
                System.out.println("Неверный формат данных");
        }
        return null;
    }
}

