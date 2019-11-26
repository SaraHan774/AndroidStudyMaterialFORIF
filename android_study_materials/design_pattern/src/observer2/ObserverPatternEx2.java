package observer2;

public class ObserverPatternEx2 {

    public static void main(String[] args) {

        Subject subject = new Subject();

        Observer1 observer1 = new Observer1();
        Observer2 observer2 = new Observer2();

        subject.register(observer1);
        subject.register(observer2);

        subject.setMyValue(5);

        subject.unregister(observer2);

        subject.setMyValue(25);
    }

}
