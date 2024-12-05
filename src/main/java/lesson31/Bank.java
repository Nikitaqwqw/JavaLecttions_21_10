package lesson31;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Bank {

    private final List<Client> clientList;

    public Bank() {
        this.clientList = new ArrayList<>();
    }

    public void addClient(Client client) {
        if (client == null) return;
        clientList.add(client);
    }

    public Card findCardByNumber(String cardNumber) {
        Card card = null;
        for (Client client : clientList) {
            for (Card clientCard : client.getCardsList()) {
                if (cardNumber.equals(clientCard.getCardNumber())) {
                    card = clientCard;
                }
            }
        }
        return card;
    }

    //повинен повертати картки у яких balance більше 10_000 гривень
    public List<Card> findUAHCardsWithHighBalance() {
        List<Card> cards = new ArrayList<>();
        //        for (Client client : clientList) {
//            for (Card clientCard : client.getCardsList()) {
//                if (clientCard.getBalance() >= 10_000 && clientCard.getCurrency() == Currency.UAH) {
//                    cards.add(clientCard);
//                }
//            }
//        }
        cards = clientList.stream()
                .flatMap(client -> client.getCardsList().stream())
                .filter(card -> card.getCurrency() == Currency.UAH && card.getBalance() >= 10_000)
                .collect(Collectors.toList());

        return cards;
    }

    public void saveClientToFile(String filePath) {
        try (FileChannel channel = FileChannel.open(Path.of(filePath),
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE)) {
            for (Client client : clientList) {
                ByteBuffer clientBuffer = client.toByteBuffer();
                channel.write(clientBuffer);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
            System.out.println("Cannot save clients to file");
        }
    }

    public List<Client> loadClientsFromFile() {
        List<Client> clients = new ArrayList<>();
        try (FileChannel channel = FileChannel.open(Path.of(CardUtils.CLIENTS_FILE_PATH), StandardOpenOption.READ)) {
           String data = extractDataFromFile(channel);
           String[] separatedParts = data.split("\n");
           Client currentClient = null;
           for (String part: separatedParts){
               if (part.length() < 16){ //Цє скоріше за все імя кліента
                   if (currentClient != null){
                       clients.add(currentClient);
                   }
                    currentClient = new Client(part,new ArrayList<>());
               } else {
                    String[] cardParts = part.split(" ");
                    String cardNumber = cardParts[0] + cardParts[1]+ cardParts[2]+ cardParts[3];
                    Currency currency = Currency.valueOf(cardParts[4]);
                    double balance =  Double.parseDouble(cardParts[5]);
                    Card card = new Card(cardNumber,currency,balance);
                    currentClient.addCard(card);
               }
           }
           clients.add(currentClient);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return clients;
    }

    private String extractDataFromFile(FileChannel channel) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        StringBuilder stringBuilder = new StringBuilder();
        channel.read(byteBuffer);
        byteBuffer.flip();
        while(byteBuffer.hasRemaining()){
            stringBuilder.append((char)byteBuffer.get());
        }
        byteBuffer.clear();
        return stringBuilder.toString();
    }



    //                    String cardNumber = part.substring(0,19);
//                    Currency currency = Currency.valueOf(part.substring(19,22));
//                    double balance =  Double.parseDouble(part.substring(22));


}
