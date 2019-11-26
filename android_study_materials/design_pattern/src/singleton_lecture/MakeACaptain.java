package singleton_lecture;

public class MakeACaptain {

    private static MakeACaptain instance;

    private MakeACaptain(){

    }

    public static MakeACaptain getInstance(){
        if(instance == null){
            instance = new MakeACaptain();
            System.out.println("캡틴이 만들어 졌습니다. !");
        }else{
            System.out.println("캡틴이 이미 있습니다.");
        }

        return instance;
    }
}
