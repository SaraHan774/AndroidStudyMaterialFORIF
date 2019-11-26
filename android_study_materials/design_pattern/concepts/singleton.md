### Singleton Pattern

* 어떤 클래스가 오직 하나의 객체만 가져야 하는 경우.
* 중앙 집중화된 자원 관리를 원할 경우 주로 사용한다.

```
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

```

* `private static [클래스명] instance;` 로 속성을 만든 후
* 생성자는 `private`으로 설정하고
* `getInstance()` 함수를 만들어서 객체가 없는지 확인 후 객체를 반환하는 것이 일반적.