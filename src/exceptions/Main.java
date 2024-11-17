package exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;

public class Main {

    public static void main(String[] args){

        try {
            System.out.println("Trying to write to file");
            callWriteToFile();
            System.out.println("End operation");
        } catch (ConnectException exception){
            exception.printStackTrace();
            System.out.println("Couldnt write to file");
        } catch (FileNotFoundException exception){
            exception.printStackTrace();
            System.out.println("Couldnt read to file");
        } finally {
            System.out.println("Bloc finally  calls");
        }

        System.out.println("Next step");
    }

    public static void callWriteToFile() throws ConnectException, FileNotFoundException  {
        writeToFile();
        System.out.println("Step After write to file");
        readFromFile();
    }


    public static void writeToFile() throws ConnectException {
        System.out.println("Everything okay");
        System.out.println("Everything okay");
        System.out.println("Everything okay");
        System.out.println("Oopps");
        throw new ConnectException();
    }

    public static void readFromFile() throws FileNotFoundException {
        System.out.println("Called read from file");
        throw new FileNotFoundException();
    }




}
