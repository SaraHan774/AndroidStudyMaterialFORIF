package observer2;

public class Observer2 implements IObserver{

    @Override
    public void update(int i) {
        System.out.println("Observer2 : Subject 의 myValue 는 " + i);
    }
}
