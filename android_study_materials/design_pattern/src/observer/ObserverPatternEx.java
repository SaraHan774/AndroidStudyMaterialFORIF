package observer;

public class ObserverPatternEx {

    public static void main(String[] args) {
        System.out.println("=== Observer Pattern Demo ===");

        Observer observer = new Observer();
        Subject sub1 = new Subject();

        //observer 등록하기
        sub1.register(observer);

        //subject 속성 값 변경
        System.out.println("flag = 5 로 설정합니다.");
        sub1.setFlag(5);

        //subject 속성 값 다시 변경
        System.out.println("flag = 25 로 설정합니다.");
        sub1.setFlag(25);

        //observer 등록 해제
        sub1.unregister(observer);
        System.out.println("observer unregistered. 더이상 update() 가 호출되지 않습니다.");

        //update 가 호출되지 않음을 확인할 수 있다.
        System.out.println("flag = 50으로 설정합니다.");
        sub1.setFlag(50);
    }
}
