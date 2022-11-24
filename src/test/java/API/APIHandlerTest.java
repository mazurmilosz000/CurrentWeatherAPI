package API;

import API.Exceptions.CityNameException;
import API.Exceptions.EmptyRequestException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


class APIHandlerTest {


    APIHandler underTest = new APIHandler();


    @Test
    void getCoordinatesTest() throws Exception {

        assertEquals(50.0619474, underTest.getCoordinates("Kraków").getLat());
    }

    @Test
    void expectedExceptionWhenEmptyCityNameTest() {

        Exception exception = assertThrows(EmptyRequestException.class, () ->
        underTest.getCoordinates(""));

        String expectedMessage = "You have to type city name";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void expectedExceptionWhenIncorrectCityNameTest() {
        Exception exception = assertThrows(CityNameException.class, () ->
        underTest.getCoordinates("asabsdha"));

        String expectedMessage = "Cannot find that city";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void chekCurrentWeatherTest() throws Exception {

        // save in the outputStream what an application writes to the console
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        underTest.checkCurrentWeather(new Coordinates(50.0619474, 19.9368564));

        String expectedOut = "Current weather: ";

        assertTrue(outContent.toString().contains(expectedOut));
    }
}