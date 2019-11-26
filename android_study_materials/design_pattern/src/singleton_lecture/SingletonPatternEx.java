package singleton_lecture;

public class SingletonPatternEx {

    public static void main(String[] args) {

        System.out.println("Make a captain test");

        MakeACaptain obj1 = MakeACaptain.getInstance();

        MakeACaptain obj2 = MakeACaptain.getInstance();

        if(obj1 == obj2){
            System.out.println("obj1 == obj2");
        }

    }
}
