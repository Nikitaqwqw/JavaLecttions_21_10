package lesson31;

import lesson31.exceptions.InsufficientFundsException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Terminal {

    public static void main(String[] args) {
        if(Files.exists(Path.of(CardUtils.CLIENTS_FILE_PATH))){
            System.out.println(loadClientsFromFile());
        } else {
            createNewClients();
        }

    }

    public static void createNewClients(){
        Bank bank = new Bank();
        Card cardJohn1 = new Card("4444 4444 4444 4444",Currency.UAH,100.33);
        Card cardJohn2 = new Card("4445 4445 4445 4445",Currency.USD,400.01);
        Client clientJohn = new Client("John", List.of(cardJohn1, cardJohn2));
        Card cardSuzi1 = new Card("5555 5555 5555 5555",Currency.UAH,270);
        Card cardSuzi2 = new Card("5556 5556 5556 5556",Currency.UAH,700);
        Card cardSuzi3 = new Card("5556 5556 5556 5556",Currency.EUR,100);
        Client clientSuzi = new Client("Suzi", List.of(cardSuzi1,cardSuzi2,cardSuzi3));
        Card cardSmith = new Card("7777 7777 7777 7777",Currency.UAH,10_000.00);
        Client clientSmith = new Client("Smith",List.of(cardSmith));
        bank.addClient(clientJohn);
        bank.addClient(clientSuzi);
        bank.addClient(clientSmith);
        List<Card> cards = bank.findUAHCardsWithHighBalance();
        System.out.println(cards);
        Card card = bank.findCardByNumber("5556 5556 5556 5556");
        if (card != null){
            //doSomething
        }
        Card cardNonExist = bank.findCardByNumber("0000 0000 0000 0000");
        bank.saveClientToFile();
    }

    public static List<Client> loadClientsFromFile(){
        Bank bank = new Bank();
        return bank.loadClientsFromFile();
    }
}
