package git_lesson;

public interface CallableInterface {

    void call();

}

class CallableImpl implements  CallableInterface {

    @Override
    public void call() {
        System.out.println("Callable calling");
    }
}
