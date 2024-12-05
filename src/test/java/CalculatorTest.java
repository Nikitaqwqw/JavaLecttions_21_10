import lesson37.Calculator;
import org.junit.jupiter.api.*;


//@BeforeEach Выполняется перед каждым тестовым методом.
//@BeforeAll Выполняется один раз перед всеми тестами (должен быть static).
//@AfterEach Выполняется после каждого теста.
//@AfterAll Выполняется один раз после всех тестов (должен быть static).
//@Disabled

public class CalculatorTest {

    private static Calculator calculator;

    @BeforeAll
    static void setUpBeforeAll(){
        calculator = new Calculator();
    }

//    @BeforeEach
//    void setUp(){
//        calculator = new Calculator();
//    }

    @Test
    void testAdd(){
        int addResult = calculator.add(10,10);
        Assertions.assertEquals(20,addResult);
        int subtractResult = calculator.subtract(100,49);
        Assertions.assertEquals(51,subtractResult);
        double divideResult = calculator.divide(100,5);
        Assertions.assertEquals(20,divideResult);
    }

    @Test
    void testAddIncorrect(){
        int result = calculator.add(50,60);
        Assertions.assertNotEquals(109,result);
    }

    @Test
    void testSubtract(){
        int result = calculator.subtract(100,49);
        Assertions.assertEquals(51,result);
    }

    @Test
    void testDivide(){
        double result = calculator.divide(20,5);
        Assertions.assertEquals(4.0,result);
    }

    @Test
    void divideByZero(){
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.divide(4,0));
        Assertions.assertEquals("Cannot divide by 0",exception.getMessage());
    }

}

//        assertEquals(expected, actual)
//        Проверяет, что два значения равны.

//        assertNotEquals(unexpected, actual)
//        Проверяет, что два значения не равны.

//        assertTrue(condition)
//        Проверяет, что условие истинно.

//        assertFalse(condition)
//        Проверяет, что условие ложно.

//        assertNull(object)
//        Проверяет, что объект равен null.

//        assertNotNull(object)
//        Проверяет, что объект не равен null.

//        assertThrows(exceptionClass, executable)
//        Проверяет, что выбрасывается определенное исключение.
