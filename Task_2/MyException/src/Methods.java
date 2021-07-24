public class Methods {

    void chek (double a, double b) throws MyException, IllegalAccessException {
        try {
            if ((a < 0) && (b < 0)) {
                throw new IllegalArgumentException("Illegal Argument Exception");
            }
            if (((a == 0) && (b != 0)) || ((a != 0) && (b == 0))) {
                throw new ArithmeticException("Arithmetic Exception");
            }
            if ((a == 0) && (b == 0)) {
                throw new IllegalAccessException("Illegal Access Exception");
            }
            if ((a > 0) && (b > 0)) {
                throw new MyException("My Exception!");
            }

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (MyException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    double addition (double a, double b) throws IllegalAccessException, MyException {
        chek (a,b);
        return a+b;
    }
    double subtraction(double a, double b) throws IllegalAccessException, MyException {
        chek (a,b);
        return a-b;
    }
    double multiplication (double a, double b) throws IllegalAccessException, MyException {
        chek (a,b);
        return a * b;
    }
    double division (double a, double b) throws IllegalAccessException, MyException {
        chek (a,b);
        return a / b;
    }
}