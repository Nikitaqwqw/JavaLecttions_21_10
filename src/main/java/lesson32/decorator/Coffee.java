package lesson32.decorator;


//Паттерн "Декоратор" (Decorator)

//Ключевые элементы паттерна:
//        Component — общий интерфейс для объектов, которые можно декорировать. //Coffee
//        ConcreteComponent — конкретный объект, который декорируется.
//        Decorator — абстрактный класс для декораторов, реализующий интерфейс Component.
//        ConcreteDecorator — классы, добавляющие конкретные функции.

public interface Coffee {

    String getDescription();

    double getCost();


}
