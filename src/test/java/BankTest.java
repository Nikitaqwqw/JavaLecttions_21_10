import lesson31.Bank;
import lesson31.Card;
import lesson31.Client;
import lesson31.Currency;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class BankTest {

    @Test
    void testFileCreation() throws IOException {
        String testFilePath = "clients.txt";
        Path testFile = Path.of(testFilePath);
        Files.deleteIfExists(testFile);
        Bank bank = new Bank();
        bank.saveClientToFile(testFilePath);
        Assertions.assertTrue(Files.exists(testFile));
        Files.deleteIfExists(testFile);
    }

    @Test
    void testFileContent() throws IOException {
        String testFilePath = "clients_test.txt";
        Path testFile = Path.of(testFilePath);

        List<Card> cards = List.of(
                new Card("123456", Currency.EUR,150.00),
                new Card("789123",Currency.UAH,350.15)
        );

        Client client = new Client("John Doe",cards);

        Bank bank = new Bank();
        bank.addClient(client);
        bank.saveClientToFile(testFilePath);

        String expectedContent = "John Doe\n" +
                "123456 EUR 150.0 \n" +
                "789123 UAH 350.15";

        String actualContent = Files.readString(testFile);
        Assertions.assertEquals(expectedContent.trim(), actualContent.trim());

        Files.deleteIfExists(testFile);
    }

}
