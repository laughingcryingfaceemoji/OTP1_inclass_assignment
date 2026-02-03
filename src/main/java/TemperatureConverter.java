public class TemperatureConverter {

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }


    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static boolean isExtremeTemperature(double celsius) {
        return celsius < -40 || celsius > 50;
    }

    public static void main(String[] args) {
        double f = 98.6;
        double c = fahrenheitToCelsius(f);

        System.out.println("Fahrenheit: " + f);
        System.out.println("Celsius: " + c);
        System.out.println("Back to Fahrenheit: " + celsiusToFahrenheit(c));
        System.out.println("Is extreme? " + isExtremeTemperature(c));
    }
}
