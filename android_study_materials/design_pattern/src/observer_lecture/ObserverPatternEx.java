package observer_lecture;

public class ObserverPatternEx {

    public static void main(String[] args) {

        Observer observer = new Observer();
        Subject subject = new Subject();

        subject.register(observer);

        System.out.println("int flag = 5");
        subject.setFlag(5);

        System.out.println("int flag = 15");
        subject.setFlag(15);

        subject.unregister(observer);
        subject.setFlag(25);

    }
}
