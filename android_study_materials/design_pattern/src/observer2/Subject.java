package observer2;

import java.util.ArrayList;
import java.util.List;

public class Subject implements ISubject{

    List<IObserver> observerList = new ArrayList<>();

    private int flag;

    public void setMyValue(int i){
        this.flag = i;
        notifyObservers(i);
    }

    public int getMyValue(){
        return flag;
    }

    @Override
    public void register(IObserver o) {
        observerList.add(o);
        System.out.println("observer 를 추가하였습니다.");
    }

    @Override
    public void unregister(IObserver o) {
        observerList.remove(o);
        System.out.println("observer 를 제거하였습니다.");
    }

    @Override
    public void notifyObservers(int i) {
        for(int j = 0; j < observerList.size(); j++){
            observerList.get(j).update(i);
        }
    }
}
