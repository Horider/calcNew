import java.util.InputMismatchException;

class CalculatorHelper {
    static final String [] ROMAN = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV",
            "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX",
            "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII",
            "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII",
            "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI",
            "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII",
            "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI",
            "XCVII", "XCVIII", "XCIX", "C"};

    // Метод конвертирует Римские цифры в Арабские
    static int convertRomanToArab (String numRoman) {
        try {
            switch (numRoman) {
                case "I" -> {return 1;}
                case "II" -> {return 2;}
                case "III" -> {return 3;}
                case "IV" -> {return 4;}
                case "V" -> {return 5;}
                case "VI" -> {return 6;}
                case "VII" -> {return 7;}
                case "VIII" -> {return 8;}
                case "IX" -> {return 9;}
                case "X" -> {return 10;}
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Неверный формат данных");
        } return -1;
    }

    // Метод производит математическое вычесление
    static int calculated (int num1, int num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                try {
                    return num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Ошибка : " + e);
                } break;
        } return 0;
    }

    // Метод производит вычесление для Римских цифр
    static String calculatorRome (int number1, int number2, char operation){
        int answerInt;
        String answer = null;
        if (number1 > 0 && number2 > 0) {
            answerInt = CalculatorHelper.calculated(number1, number2, operation);
            answer = CalculatorHelper.ROMAN[answerInt];
        }
        return answer;
    }

    // Метод ловит знак операции
    static char underChar (String userInput) {
        char[] under_char = new char[10];
        for (int i = 0; i < userInput.length(); i++) {
            under_char[i] = userInput.charAt(i);
            switch (under_char[i]) {
                case '+': return '+';
                case '-': return '-';
                case '*': return '*';
                case '/': return '/';
            }
        } return 0;
    }
}
