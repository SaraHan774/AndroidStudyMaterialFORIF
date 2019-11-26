package observer;

interface ISubject {
//Subject 객체가 여러개일 경우 이 인터페이스를 정의해서 implement 해야한다.
    void register(Observer o);
    void unregister(Observer o);
    void notifyObservers();
}
