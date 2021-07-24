import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) throws IllegalAccessException, MyException {

        double a;
        double b;

        System.out.println ( "Enter two numbers a and b" );

        Scanner scanner = new Scanner ( System.in );
        a = scanner.nextDouble ( );
        b = scanner.nextDouble ( );

        Methods calc = new Methods ( );

        System.out.println (" a + b = " + calc.addition ( a,b ));
        System.out.println (" a / b = " + calc.division ( a,b ));
        System.out.println (" a - b = " + calc.subtraction ( a,b ));
        System.out.println (" a * b = " + calc.multiplication ( a,b ));

    }
}
