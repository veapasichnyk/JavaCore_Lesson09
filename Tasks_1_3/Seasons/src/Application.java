/*
 * LOGOS IT Academy.
 * 08 Java Core OOP - ENUM, read console input
 * 09 Java Core OOP - Exception, code convention
 */

import java.util.Scanner;

/**
 * @author Veronika Pasichnyk
 * @since Java 1.8
 * @version 1.0
 */

public class Application {

    /* Displays the application menu on the console */
    static void menu ( ) {

        System.out.println ( "Натисність 0, щоб перевірити чи є такий місяць" );
        System.out.println ( "Натисність 1, щоб вивести всі місяці з такою ж порою року" );
        System.out.println ( "Натисність 2, щоб вивести всі місяці, які мають таку саму кількість днів" );
        System.out.println ( "Натисність 3, щоб вивести на екран всі місяці, які мають меншу кількість днів" );
        System.out.println ( "Натисність 4, щоб вивести на екран всі місяці, які мають більшу кількість днів" );
        System.out.println ( "Натисність 5, щоб вивести на екран наступну пору року" );
        System.out.println ( "Натисність 6, щоб вивести на екран попередню пору року" );
        System.out.println ( "Натисність 7, щоб вивести на екран всі місяці, які мають парну кількість днів" );
        System.out.println ( "Натисність 8, щоб вивести на екран всі місяці, які мають непарну кількість днів" );
        System.out.println ( "Натисність 9, щоб вивести на екран чи введений з консолі місяць має парну кількість днів" );
    }
    /*Main method*/
    public static void main ( String arg[] )  throws WrongInputConsoleParametersException {

        Months[] arrayMonths = Months.values ( ); //Array of Seasons from enum Seasons
        Seasons[] arraySeasons = Seasons.values ( ); //Array of Months from enum Months
        Scanner scanner = new Scanner ( System.in );

        /* Creates an infinite loop that calls the Menu method */
        while (true) {
            menu ( );

            /* Takes the values from the Scanner and runs the corresponding case */
            switch (scanner.next ( )) {

                case "0": {
                    System.out.println ( "Введіть назву місяця англійською мовою" );
                    // Scanner Input String the name of month
                    scanner = new Scanner ( System.in );
                    //Converts the character of a String to upper case
                    String month = scanner.next ( ).toUpperCase ( );

                    boolean flag = false;

                    for ( Months months : arrayMonths ) {
                        if ( months.name ( ).equals ( month ) ) {
                            System.out.println ( "Такий місяць існує" + "\n" );
                            flag = true;
                        }
                    }

                    if ( !flag ) {
                        /* flag false, so throw WrongInputConsoleParametersException */
                        try{throw  new WrongInputConsoleParametersException();}
                        catch (WrongInputConsoleParametersException e)
                        {
                            System.out.println("");
                        }
                    }

                    break;
                }

                case "1": {
                    System.out.println ( "Введіть назву пори року англійською мовою" );
                    scanner = new Scanner ( System.in );
                    String season = scanner.next ( ).toUpperCase ( );

                    boolean flag = false;
                    // Check if seasons exist in this seasons
                    for ( Months months : arrayMonths ) {
                        if ( months.getSeason ( ).name ( ).equals ( season ) ) {
                            flag = true;
                        }
                    }
                    /* flag true, so print all month of input season */
                    if ( flag ) {
                        Seasons seasonsValue = Seasons.valueOf ( season );
                        for ( Months months : arrayMonths ) {
                            if ( months.getSeason ( ).toString ( ).equalsIgnoreCase ( season ) ) {
                                System.out.println ( months + "\n" );
                            }
                        }
                    }

                    if ( !flag ) {
                        /* flag false, so throw WrongInputConsoleParametersException */
                        try{throw  new WrongInputConsoleParametersException();}
                        catch (WrongInputConsoleParametersException e)
                        {
                            System.out.println("");
                        }
                    }

                    break;
                }

                case "2": {
                    System.out.println ( "Введіть кількість днів у місяці" );
                    scanner = new Scanner ( System.in );

                    int days = scanner.nextInt ( ); // number of day per month

                    boolean flag = false;
                    /* Check if there are months with input number of days */
                    for ( Months months : arrayMonths ) {
                        if ( months.getDays ( ) == days ) {
                            System.out.println ( months.name ( ) + "\n" );
                            flag = true;
                        }
                    }

                    if ( !flag ) {
                        /* flag false, so throw WrongInputConsoleParametersException */
                        try {throw  new WrongInputConsoleParametersException();}
                        catch (WrongInputConsoleParametersException e)
                        {
                            System.out.println("");
                        }
                    }

                    break;
                }

                case "3": {
                    System.out.println ( "Введіть кількість днів у місяці" );
                    scanner = new Scanner ( System.in );
                    int days = scanner.nextInt ( );

                    boolean flag = false;
                    /* Checks for months with fewer days than entered */
                    for ( Months months : arrayMonths ) {
                        if ( months.getDays ( ) < days ) {
                            System.out.println ( months.name ( ) + "\n" );
                            flag = true;
                        }
                    }

                    if ( !flag ) {
                        /* flag false, so throw WrongInputConsoleParametersException */
                        try{throw  new WrongInputConsoleParametersException();}
                        catch (WrongInputConsoleParametersException e)
                        {
                            System.out.println("");
                        }
                    }

                    break;
                }

                case "4": {
                    System.out.println ( "Введіть кількість днів у місяці" );
                    scanner = new Scanner ( System.in );
                    int days = scanner.nextInt ( );

                    boolean flag = false;
                    /* Checks for months with more days than entered */
                    for ( Months months : arrayMonths ) {
                        if ( months.getDays ( ) > days ) {
                            System.out.println ( months.name ( ) + "\n" );
                            flag = true;
                        }
                    }

                    if ( !flag ) {
                        /* flag false, so throw WrongInputConsoleParametersException */
                        try {throw  new WrongInputConsoleParametersException();}
                        catch (WrongInputConsoleParametersException e)
                        {
                            System.out.println("");
                        }
                    }

                    break;
                }

                case "5": {
                    System.out.println ( "Введіть назву пори року англійською мовою" );
                    // Scanner Input String the name of season
                    scanner = new Scanner ( System.in );
                    //Converts the character of a String to upper case
                    String season = scanner.next ( ).toUpperCase ( );

                    boolean flag = false;
                    /* Checks whether the entered season exists */
                    for ( Seasons seasons : arraySeasons ) {
                        if ( seasons.name ( ).equals ( season ) ) {
                            flag = true;
                        }
                    }
                    /* flag true, so print next season */
                    if ( flag ) {
                        System.out.println ( "Наступна пора року " );
                        Seasons seasonsValue = Seasons.valueOf ( season );
                        int ordinal = seasonsValue.ordinal ( );
                        if ( ordinal == ( arraySeasons.length - 1 ) ) {
                            ordinal = 0;
                            System.out.println ( arraySeasons[ ordinal ] + "\n" );
                        } else {
                            System.out.println ( arraySeasons[ ordinal + 1 ] + "\n" );
                        }

                    }

                    if ( !flag ) {
                        /* flag false, so throw WrongInputConsoleParametersException */
                        try {throw  new WrongInputConsoleParametersException();}
                        catch (WrongInputConsoleParametersException e)
                        {
                            System.out.println("");
                        }
                    }

                    break;
                }

                case "6": {
                    System.out.println ( "Введіть назву пори року англійською мовою" );
                    scanner = new Scanner ( System.in );
                    String season = scanner.next ( ).toUpperCase ( );

                    boolean flag = false;

                    for ( Seasons seasons : arraySeasons ) {
                        if ( seasons.name ( ).equals ( season ) ) {
                            flag = true;
                        }
                    }
                    /* flag true, so print previous season */
                    if ( flag ) {
                        System.out.println ( "Попередня пора року " );
                        Seasons seasonsValue7 = Seasons.valueOf ( season );
                        int ordinal = seasonsValue7.ordinal ( );
                        if ( ordinal == 0 ) {
                            ordinal = ( arraySeasons.length - 1 );
                            System.out.println ( arraySeasons[ ordinal ] + "\n" );
                        } else {
                            System.out.println ( arraySeasons[ ordinal - 1 ] + "\n" );
                        }

                    }

                    if ( !flag ) {
                        /* flag false, so throw WrongInputConsoleParametersException */
                        try {throw  new WrongInputConsoleParametersException();}
                        catch (WrongInputConsoleParametersException e)
                        {
                            System.out.println("");
                        }
                    }

                    break;
                }

                case "7": {
                    System.out.println ( "Парна кількість днів: " );
                    scanner = new Scanner(System.in);

                    boolean flag = false;
                    /* Displays all months that have an even number of days */
                    for ( Months months : arrayMonths ) {
                        if ( months.getDays ( ) % 2 == 0 ) {
                            System.out.println ( months.name ( ) + "\n" );
                            flag = true;
                        }

                    }

                    break;
                }

                case "8": {
                    System.out.println ( "Непарна кількість днів" );
                    scanner = new Scanner(System.in);

                    boolean flag = false;
                    /* Displays all months that have an odd number of days */
                    for ( Months months : arrayMonths ) {
                        if ( months.getDays ( ) % 2 != 0 ) {
                            System.out.println ( months.name ( ) + "\n" );
                            flag = true;
                        }
                    }

                    break;
                }

                case "9": {
                    System.out.println ( "Введіть назву місяця англійською мовою" );
                    scanner = new Scanner ( System.in );
                    String month = scanner.next ( ).toUpperCase ( );

                    boolean flag = false;

                    for ( Months months : arrayMonths ) {
                        if ( months.name ( ).equals ( month ) ) {
                            flag = true;
                        }

                    }

                    if ( flag ) {
                        for ( Months months : arrayMonths ) {
                            if ( months.name ( ).equals ( month ) ) {
                                if ( months.getDays ( ) % 2 == 0 ) {
                                    System.out.println ( "Місяць має парну кількість днів"  + "\n" );
                                } else {
                                    System.out.println ( "Місяць має непарну кількість днів" + "\n" );
                                }
                            }
                        }

                    }

                    if ( !flag ) {
                        /* flag false, so throw WrongInputConsoleParametersException */
                        try {throw  new WrongInputConsoleParametersException();}
                        catch (WrongInputConsoleParametersException e)
                        {
                            System.out.println("");
                        }
                    }

                    break;
                }

            }

        }

    }
}
