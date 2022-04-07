import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите математическое выражение с символами от 1 до 10 или два римских числа от I до X");
        String inputString = scanner.nextLine().toUpperCase();
    }

    public static String calc (String inputString) {
        int number1 = 0, number2 = 0;
        String stable1 = null, stable2 = null, answer = null;
        String[] splitNumbers;
        String[] Numbers = new String[2];
        char operation;


        operation = CalculatorHelper.underChar(inputString);
        splitNumbers = inputString.split("[+-/*]");
        if (splitNumbers.length > 2) {
            System.out.println("Больше 2х чисел");
            return null;
        } else
            Numbers = Arrays.copyOf(splitNumbers, 2);
        try {
            stable1 = Numbers[0].trim();
            stable2 = Numbers[1].trim();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка : " + e);
            System.out.println("Неполноценное математическое выражение");
        }

        // Производится вычесление взависимости от формата вводимых чисел
        if (Arrays.asList(CalculatorHelper.ROMAN).contains(stable1) && Arrays.asList(CalculatorHelper.ROMAN).contains(stable2)) {
            System.out.println("Римские вычесления");
            number1 = CalculatorHelper.convertRomanToArab(stable1);
            number2 = CalculatorHelper.convertRomanToArab(stable2);
            try {
                answer = CalculatorHelper.calculatorRome(number1, number2, operation);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Ошибка : " + e);
                System.out.println("Отрицательных Римских чисел нет");
            }
            return answer;

        } else {
            System.out.println("Арабские вычесления");
            try {
                number1 = Integer.parseInt(stable1);
                number2 = Integer.parseInt(stable2);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка : " + e);
                System.out.println("Неверный формат данных");
            }
            if ((number1 >= 0 && number1 <= 10) && (number2 >= 0 && number2 <= 10)) {
                answer = String.valueOf(CalculatorHelper.calculated(number1, number2, operation));
            } else
                System.out.println("Неверный формат данных");
        } return answer;
    }
}


