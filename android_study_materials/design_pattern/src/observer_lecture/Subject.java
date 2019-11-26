package observer_lecture;

import java.util.ArrayList;
import java.util.List;

public class Subject implements ISubject{

    List<Observer> observerList = new ArrayList<>();

    private int flag;

    public void setFlag(int flag) {
        this.flag = flag;

        notifyObservers();
    }

    public int getFlag() {
        return flag;
    }

    @Override
    public void register(Observer o) {
        System.out.println("observer registered");
        observerList.add(o);
    }

    @Override
    public void unregister(Observer o) {
        System.out.println("observer unregistered");
        observerList.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(int i = 0; i < observerList.size(); i++){
            observerList.get(i).update();
        }
    }
}
