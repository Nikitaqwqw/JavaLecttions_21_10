package lesson31;

import lesson31.exceptions.InsufficientFundsException;
import lesson31.exceptions.MaxAmountException;
import lesson31.exceptions.WrongFormatException;

import java.nio.ByteBuffer;




public class Card {
    private final String cardNumber;
    private final Currency currency;
    private double balance;

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber='" + cardNumber + '\'' +
                ", currency=" + currency +
                ", balance=" + balance +
                '}';
    }

    public Card(String cardNumber,Currency currency, double balance) {
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.currency = currency;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) throws MaxAmountException {
        if (amount > CardUtils.MAX_DEPOSIT_AMOUNT) {
         throw new MaxAmountException("Ви перевищили максимальну сумму поповнення. Максимальна сумма 20.000 гривень");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        if (amount < 0 ){
            throw new WrongFormatException("Введіть суму без -");
        }
        if (balance < amount){
            throw new InsufficientFundsException("Не вистачає грошей на балансі");
        }
        balance -= amount;
    }

    public ByteBuffer toByteBuffer(){
        byte[] bytesCardsNumber = cardNumber.getBytes();
        byte[] currencyBytes = currency.toString().getBytes();
        byte[] balanceBytes = String.valueOf(balance).getBytes();
        byte[] spaceBytes = " ".getBytes(); // Используем пробел
        byte[] newLineBytes = "\n".getBytes();

        // Рассчитываем общий размер
        int bufferSize = bytesCardsNumber.length
                + spaceBytes.length
                + currencyBytes.length
                + spaceBytes.length
                + balanceBytes.length
                + newLineBytes.length;
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put(bytesCardsNumber);
        byteBuffer.put(spaceBytes);
        byteBuffer.put(currencyBytes);
        byteBuffer.put(spaceBytes);
        byteBuffer.put(balanceBytes);
        byteBuffer.put(spaceBytes);
        byteBuffer.put(newLineBytes);
        byteBuffer.flip();
        return  byteBuffer;
    }

}
