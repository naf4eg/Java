package func.task3_лямбда;

import java.util.Scanner;

//The rule should act as the following:
//
//if the digit is 5, it should replace it with 1;
//if the digit is 6, it should replace it with 2;
//if the digit is 7, it should replace it with 3;
//if the digit is 8, it should replace it with 4;
//if the digit is 9, it should replace it with 5;
//any other digits shouldn't be replaced.
//There is a whole variety of ways to contrive this rule. The shorter your solution, the better! :)
//Note that the substitution method belongs to the Utils class.
//Sample Input: 12765
//Sample Output: 12321
class DigitsSubstitution {

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt();
        int result = Utils.substitution(n, digit -> {
            switch (digit) {
                case 5: return 1;
                case 6: return 2;
                case 7: return 3;
                case 8: return 4;
                case 9: return 5;
                default: return digit;
            }
        });
        System.out.println(result);
    }
}
