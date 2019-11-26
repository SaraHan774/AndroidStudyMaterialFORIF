package singleton;

public class SingletonPatternEx {

    public static void main(String[] args) {

        System.out.println("싱글톤 패턴 테스트! \n 캡틴을 만들래요~");

        MakeACaptain obj1 = MakeACaptain.getInstance();

        System.out.println("캡틴을 다시 만들래요 ~~ ");

        MakeACaptain obj2 = MakeACaptain.getInstance();

        if(obj1 == obj2){
            System.out.println("obj1 == obj2 / 캡틴이 새로 만들어지지 않았습니다.");
        }
    }

}
