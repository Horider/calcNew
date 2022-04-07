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
        String stable1 = null, stable2 = null;
        String[] splitNumbers;
        String[] Numbers;
        char operation;

        operation = CalculatorHelper.underChar(inputString);
        splitNumbers = inputString.split("[+-/*]");
        try{
            stable1 = splitNumbers[0].trim();
            stable2 = splitNumbers[1].trim();
        } catch (ArrayIndexOutOfBoundsException e){
            throw new ArrayIndexOutOfBoundsException();
        }

        if (splitNumbers.length > 2)
            throw new ArrayIndexOutOfBoundsException();
        else
            Numbers = Arrays.copyOf(splitNumbers, 2);
        try {
            stable1 = Numbers[0].trim();
            stable2 = Numbers[1].trim();
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }

        // Производится вычесление взависимости от формата вводимых чисел
        if (Arrays.asList(CalculatorHelper.ROMAN).contains(stable1) && Arrays.asList(CalculatorHelper.ROMAN).contains(stable2)) {
            number1 = CalculatorHelper.convertRomanToArab(stable1);
            number2 = CalculatorHelper.convertRomanToArab(stable2);
            try {
                return CalculatorHelper.calculatorRome(number1, number2, operation);
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new ArrayIndexOutOfBoundsException();
            }

        } else {
            try {
                number1 = Integer.parseInt(stable1);
                number2 = Integer.parseInt(stable2);
            } catch (NumberFormatException e) {
                throw new NumberFormatException();
            }
            if ((number1 <= 0 || number1 > 10) || (number2 <= 0 || number2 > 10))
                throw new ArrayIndexOutOfBoundsException();
            else
                return String.valueOf(CalculatorHelper.calculated(number1, number2, operation));
        }
    }
}

