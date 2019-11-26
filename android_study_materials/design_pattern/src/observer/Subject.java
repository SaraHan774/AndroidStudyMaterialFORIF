package observer;

import java.util.ArrayList;
import java.util.List;

public class Subject implements ISubject{

    List<Observer> observerList = new ArrayList<>();

    private int flag;

    public int getFlag(){
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
        //setFlag 에서 flag 값이 변경되므로
        notifyObservers();
        //를 호출한다.
    }

    @Override
    public void register(Observer o) {
        //subject 를 관찰할 Observer 객체를 등록한다
        //등록 = observerList 에 Observer 객체를 추가함.
        observerList.add(o);
    }

    @Override
    public void unregister(Observer o) {
        observerList.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(int i = 0; i < observerList.size(); i++){
            observerList.get(i).update();
        }
    }

}
