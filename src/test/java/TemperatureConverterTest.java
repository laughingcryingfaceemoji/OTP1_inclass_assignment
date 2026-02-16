import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TemperatureConverterTest {


    private static final double EPS = 1e-6;

    @Test
    public void testFahrenheitToCelsius_basic() {
        assertEquals(0.0, TemperatureConverter.fahrenheitToCelsius(32.0), EPS);
        assertEquals(100.0, TemperatureConverter.fahrenheitToCelsius(212.0), EPS);
        assertEquals(-40.0, TemperatureConverter.fahrenheitToCelsius(-40.0), EPS);
    }

    @Test
    public void testCelsiusToFahrenheit_basic() {
        assertEquals(32.0, TemperatureConverter.celsiusToFahrenheit(0.0), EPS);
        assertEquals(212.0, TemperatureConverter.celsiusToFahrenheit(100.0), EPS);
        assertEquals(-40.0, TemperatureConverter.celsiusToFahrenheit(-40.0), EPS);
    }

    @Test
    public void testConversions_roundTrip() {
        double[] testF = { -40.0, 0.0, 32.0, 98.6, 212.0 };
        for (double f : testF) {
            double c = TemperatureConverter.fahrenheitToCelsius(f);
            double back = TemperatureConverter.celsiusToFahrenheit(c);
            assertEquals(f, back, 1e-9);
        }
    }

    @Test
    public void testIsExtremeTemperature() {
        // Below lower threshold
        assertTrue(TemperatureConverter.isExtremeTemperature(-41.0));
        // At lower threshold (-40) - should be false because method uses < -40
        assertFalse(TemperatureConverter.isExtremeTemperature(-40.0));
        // Normal temperature
        assertFalse(TemperatureConverter.isExtremeTemperature(20.0));
        // Above upper threshold
        assertTrue(TemperatureConverter.isExtremeTemperature(51.0));
        // At upper threshold (50) - should be false because method uses > 50
        assertFalse(TemperatureConverter.isExtremeTemperature(50.0));
    }

    @Test
    public void testKelvinToCelsius_basic() {
        // Example from prompt
        assertEquals(26.85, TemperatureConverter.kelvinToCelsius(300.0), 1e-6);

        // Absolute zero
        assertEquals(-273.15, TemperatureConverter.kelvinToCelsius(0.0), 1e-6);

        // Some other values including fractional Kelvin
        assertEquals(0.0, TemperatureConverter.kelvinToCelsius(273.15), 1e-6);
        assertEquals(100.0, TemperatureConverter.kelvinToCelsius(373.15), 1e-6);
    }
}
