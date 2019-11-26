package observer2;

public class Observer1 implements IObserver{

    @Override
    public void update(int i) {
        System.out.println("Observer 1 : Subject 의 myValue 는 " + i);
    }
}
