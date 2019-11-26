package singleton;

public class MakeACaptain {

    private static MakeACaptain instance;

    //생성자는 private -> 여러개의 객체가 생성되는 것을 방지.
    private MakeACaptain(){

    }

    public static MakeACaptain getInstance(){
        if(instance == null) {
            //만약 MakeACaptain 의 객체가 아직 메모리에 없다면
            instance = new MakeACaptain();
            //생성자를 통해서 객체 생성
            System.out.println("새로운 캡틴이 생성되었습니다.");
            //확인차 출력
        }else{
            System.out.println("이미 캡틴이 있습니다.");
        }

        return instance;
    }
}
