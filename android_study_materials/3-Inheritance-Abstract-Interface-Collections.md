# 3 - Inheritance, Abstract class, Interface 

## Polymorphism 
자바에서 다형성이란 '여러가지 Type을 가질 수 있는 능력'이다. 
상속의 경우, Super class 타입의 참조변수(Reference Variable)로 Subclass 인스턴스를 참조할 수 있도록 하는 것. 

## Inheritance 
상속이란, 기존의 클래스를 재사용하려 새로운 클래스를 작성하는 것이다. 상속을 통해서 클래스를 작성하면 보다 적은 양의 코드로 새로운 클래스를 작성할 수 있고, 코드를 공통적으로 관리할 수 있기 때문에 코드의 추가 및 변경이 매우 용이하다. 

- 장점 : 코드의 재사용성을 높이고 코드의 중복을 제거하여 프로그램의 생산성과 유지보수에 기여. 

```
//Television.java
public class Television{
	boolean power; 
	int channel; 
	
	public Television(){
	//생성자를 명시하지 않아도 컴파일러가 빈 생성자를 자동으로 넣음 
	}
	
	public void powerOnAndOff(){
		power = !power; 
	}
	public void channelUp(){
		++channel; 
	}
	public void channelDown(){
		--channel; 
	}
} 

//CaptionTelevision.java
public class CaptionTelevision extends Television{
	String text; 

	public CaptionTelevision(String text){
		//명시적으로 super(); 를 하지 않아도 컴파일러가 자동으로 삽입. 
		//super class 의 생성자도 자동으로 호출됨 
		this.text = text; 
	}
	
	void caption(){
		//구현 생략 
	}
	
}
```

- 위의 코드에서 Television을 상속받은 CaptionTelevision은 Television class 안에 있는 메소드를 사용하기 위해 똑같은 메소드를 작성할 필요성이 없어졌다. => 코드의 재사용성 높아짐. 

```
public static void main(String [] args){
	CaptionTelevision ct = new CaptionTelevision(); 
	ct.powerOnAndOff();  //subclass 에서 명시적으로 이 메소드를 정의하지 않아도 호출 가능
}
```

- 다만 `상속은 subclass 의 기능을 확장한다` 는 말에 비추어 보았을때 조상 클래스로부터 물려받은 속성들을 아무런 수정 없이 그대로 가져다 쓰는 것은 약간 아쉬울 수 있다. 

- 이럴 때 사용하는 것이 `@Override` 키워드에도 나타나 있듯, `오버라이딩` 이라는 것이다. 

- `CaptionTelevision` 클래스에 아래의 메소드를 추가해주면 super class 로부터 물려받은 메소드의 기능이 확장된다. 
	- 전원을 단순히 키고 끄는 것 만이 아닌, 사용자에게 재생 상태를 저장할 것인지 묻는 대화상자를 띄울 수 있다. 

```
@Override
	public void powerOnAndOff(){
		super.powerOnAndOff(); // Super class 의 메소드 호출
		//Subclass 에서 기능을 확장한다. 
		printWarning("Would you like to save your playback status?"); 
	}

	public void printWarning(String warningText){
		System.out.println(warningText); 
	}
```

- 그렇다면 다형성이란 특징이 상속에서 어떻게 나타나는 것일까? 

- `CaptionTelevision` 클래스와 `Television` 을 집합 관계로 나타내면 CaptionTelevision 이 Television을 포함하는 관계임을 알 수 있다. CaptionTelevition은 Television에서 물려받은 속성 + 자신이 따로 구현한 속성도 있기 때문이다. 

- 따라서 CaptionTelevition 객체를 만들 때 속성을 Television으로 지정해 주는 것이 가능해진다. 

- Because Caption TV `is a`  TV ! 

```
pubilc static void main(String [] args){
	Television captionTv = new CaptionTelevision(); 
	captionTv.powerOnAndOff(); //super class 에도 있는 메서드 이므로 호출 가능 
	//다만 super class 에 없는 속성은 호출할 수 없다. Type 이 Television이기 때문이다. 
	captionTv.printWarning(); 
} 
```

## Inheritance in Android 
안드로이드에서 상속을 사용하는 가장 대표적인 예는 빈 화면을 처음 만들었을 때 생성되는 MainActivity.java 파일에서 확인할 수 있다. 

```
public class MainActivity extends AppCompatActivity{

	@Override //super class에서 가져온 메소드입니다 라는 태그 (annotation)
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState); //super class의 onCreate메소드 호출 
		
	}
	
}
```

- onCreate(Bundle)는 프로그램 시작 시 가장 먼저 실행되는 메소드이다. 

- Java 프로그램의 main 메소드와 같은 역할을 한다. 

- AppCompatActivity 로부터 기본적으로 어플리케이션이 갖추어야 할 속성들을 상속받는다. 

- 개발자는 상속받은 속성들 위에서 본인의 앱에 맞는 기능들을 구현하는 것이다. 

- 굳이 비유하자면 아예 맨손으로 시작하는 것이 아니라 주어진 스케치북과 색연필로 색칠을 하는 것. 


## Polymorphism in parameters
참조변수의 다형적인 특징은 메소드의 매개변수에도 적용된다. 아래와 같이 Product, Tv, Computer, Audio, Buyer 클래스가 있다고 가정하자. 

```
class Product{
	int price; //제품 가격 
	int bonusPoint; //제품 구매시 제공하는 포인트 
}

class Tv extends Product{}
class Computer extends Product{}
class Audio extends Product{}

class Buyer{
	int money = 1000; 
	int bonusPoint = 0; 
}
```

class Buyer를 좀 더 자세히 구현한다고 했을 때 다음과 같은 메소드가 있을 수 있다. 

```
class Buyer{
	int money = 1000; 
	int bonusPoint = 0; 

	void buy(Tv tv){
		money -= tv.price; 
		bonusPoint += tv.bonusPoint; 
	}

	void buy(Computer c){
		money -= c.price; 
		bonusPoint += c.bonusPoint; 
	}
	
	void buy(Audio aud)	{
		money -= aud.price; 
		bonusPoint += aud.bonusPoint; 
	}

}
```

위의 구현을 보고 이상하다는 생각이 들어야 한다. 만약 제품의 개수가 20000개 정도가 넘는다고 가정했을 때 소비자 클래스의 buy 메서드 또한 20000개를 구현해야 하기 때문이다. 이런 상황에서 `"제품들을 하나의 덩어리로 엮고 싶다"` 라는 생각을 해야 한다. 이를 위해 사용하는 것이 상속을 통한 다형성이다. Tv든, Computer 든 Audio든 모두 Product 이다. 따라서 buy메서드의 매개변수로 Product 타입을 받는다고 구현하면 제품을 새로 만들 때 Product class 만 extends 해주면 된다. Interface 도 이와 마찬가지로 Type을 포괄적으로 정의해주는 역할을 할 수 있다. 다만 상속과 다른 점은 extends 키워드는 반드시 하나의 클래스에서 상속을 받아야 하는 반면, Interface 의 경우 implements [인터페이스 이름1], [인터페이스 이름2] ... 이런식으로 여러가지 인터페이스를 구현해줄 수 있다는 점이다. 자바에서는 다중 상속을 금지시켜 놓았기 때문에 다중 상속과 비슷한 효과를 내고 싶을 땐 interface 를 사용한다. 

- 위의 클래스는 아래와 같이 간결해질 수 있다. 

```
class Buyer{
//생략 

	void buy(Product p)	{
	 //Product class 를 상속받은 모든 제품들은 이 메소드의 매개변수로 들어갈 수 있다. 
		money -= p.price; 
		bonusPoint += p.bonusPoint; 
	}

}
```

- main 함수에서 위의 클래스들을 아래와 같이 사용할 수 있을 것이다. 

```
public static void main(String [] args){
	Buyer buyer = new Buyer(); 
	Tv t = new Tv(); 
	Computer c = new Computer(); 

	//바이어의 돈에서 티비의 가격이 차감되고 보너스 포인트가 적립될 것이다. 
	buyer.buy(t); 
	//아래도 마찬가지. 
	buyer.buy(c); 
}
```

## Abstract class 

- class 를 설계도라고 한다면, Abstract class (추상 클래스)는 미완성 설계도에 비유할 수 있다. 클래스가 미완성이라는 것은 멤버의 개수에 관계된 것이 아니라, 단지 미완성 메서드(Abstract method) 를 포함하고 있다는 의미이다. 

- 미완성 설계도로 완성된 제품을 만들 수 없듯이, 추상클래스로 인스턴스는 생성할 수 없다. 추상클래스는 상속을 통해서 자손 클래스(subclass)에 의해서만 완성될 수 있다. 

- 즉, 새로운 클래스를 작성하는 데 있어서 바탕이 되는 조상 클래스(super class) 인것.

- 추상클래스 키워드 `abstrct` 를 붙이면 된다. 

```
abstract class 클래스 이름{
 //구현 생략 
}
```

- 추상클래스는 추상 메서드를 포함하고 있다는 것을 제외하고는 일반 클래스와 전혀 다르지 않다. 추상클래스에도 생성자가 있으며 멤버변수와 메서드도 가질 수 있다. 

### Abstract method 

- 일반적인 메소드는 선언부와 구현부로 구성되어 있으나, 추상 메서드는 선언부만 작성하고 구현부는 작성하지 않은 채로 남겨둔 메서드이다. 즉, 설계만 해 놓고 실제 수행될 내용은 작성하지 않았기 때문에 미완성 메서드인 것이다. 

- 상속받는 클래스에서 메소드의 내용을 구체적으로 구현한다. abstract class 에서는 주석으로 어떤 내용이 작성되어야 하는지 알려준다. 

- 추상 메서드 역시 키워드 `abstract` 를 붙여주고, 추상 메서드는 구현부가 없으므로 괄호 `{ }` 대신 끝을 알리는 `;` 를 적어준다. 

```
/*주석을 통해 어떤 기능을 수행할 목적으로 작성하였는지 설명한다. */
abstract 리턴타입 메소드이름(); //{}로 둘러싸인 구현부는 적지 않는다. 
```

- 추상클래스로부터 상속받는 자손클래스는 오버라이딩을 통해 조상인 추상 클래스의 추상 메서드를 모두 구현해 주어야 한다. 만일 추상 메서드를 모두 구현하지 않을 경우 자손클래스 또한 abstract class 로 지정해주어야 한다. 

```
abstract class Player{
	abstract void play(int playbackPosition); //재생 위치 
	abstract void stop(); 
}

class AudioPlayer extends Player{
	void play(int playbackPosition){
	//구현해주어야 한다
	}
	
	void stop(){
	//구현해 주어야 한다 
	}
}
```

- 상속이 자손 클래스를 만드는데 조상 클래스를 사용하는 것이라면, 이와 반대로 추상화는 기존의 클래스들의 공통부분을 뽑아내서 조상 클래스를 만드는 것이라고 할 수 있다. 
	- 반드시 그런 것 만은 아니다. 

- 추상화 < - > 구체화 

### Abstract class in Android

```
// 10-1. BaseActivity.class

public abstract class BaseActivity extends AppCompatActivity{
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(myView());

	    }

	public abstract void checkNetworkConnection(); 
}
```
- MainActivity 가 AppCompatActivity를 상속받은 BaseActivity를 상속받도록 바꿔준다.

```
public class MainActivity extends BaseActivity{
		
		//onCreate 함수 Override 생략 

		@Override
		public void checkNetworkConnection(){
		
		//implement code to check network connection
		
		};

}
```
- 이제 BaseActivity를 상속받은 액티비티 클래스들에서 네트워크 연결을 확인하는 메소드를 간편하게 이용할 수 있다.


## Interface 

- 인터페이스는 일종의 추상 클래스이다. 인터페이스는 추상 클래스처럼 추상 메서드를 갖지만 추상클래스보다 추상화 정도가 높아서 추상 클래스와 달리 몸통을 갖춘 일반 메서드, 또는 멤버변수를 구성원으로 가질 수 없다. 

- 또한 추상클래스처럼 그 자체로는 인스턴스를 생성할 수 없으며, 추상 클래스가 상속을 통해 추상 메서드를 완성하는 것 처럼 인터페이스도 자신에 정의된 추상메서드의 몸통을 만들어주는 클래스를 작성해야 한다. 
	- `class Example implements InterfaceExample{ }` 과 같이 작성한다. 

- 오직 추상메서드와 상수만을 멤버로 가질 수 있으며 기 외의 다른 요소는 허용하지 않는다. 

- 인터페이스 작성: 

```
interface 인터페이스이름{
	public static final 타입 상수이름 = 값; 
	
	public abstract 메서드 이름(매개변수); 
}
```

- 일반적인 클래스와 달리 인터페이스의 멤버들은 다음과 같은 제약사항이 있다. 

```
1. 모든 멤버변수는 public static final 이어야 하며 이를 생략할 수 있다. 
2. 모든 메서드는 public abstract 이어야 하며 이를 생략할 수 있다. 
	- 단 static method 와 default method 는 허용 
```

- [Default method example]([https://www.geeksforgeeks.org/default-methods-java/](https://www.geeksforgeeks.org/default-methods-java/))

- 인터페이스는 다른 인터페이스로부터 상속 받을 수 있다. 

**(지난 주 예제 파일) 8-3. Implementing Callback functions**

1.  callback method를 정의한 인터페이스를 구현한다.

```
interface ClickEventHandler{
     	
	public void handleClick(); 
     	
	//callback 은 이 메소드로 처리해 줄 거야 - 약속만 
     }
```

2.  callback 을 받아서 처리할 Handler를 구현한다.

```
class ClickHandler implements ClickEventHandler{
 	public void handleClick(){ 
		 System.out.println("Clicked"); 
 
 		//callback 을 받아서 구체적으로 이렇게 처리해 줄거야 - 실제 구현
	  } 
  }
```
    
3.  Click 이벤트의 대상이 되는 (callback을 발생시킬) 클래스를 작성한다.

```
class Button{ 

public void onClick(ClickEventHander clickEventHandler{     
	
	clickHandler.handleClick(); 
	
	// 버튼 객체에서 onClick 함수를 호출하면 위에서 구현된 메소드가 작동한다. 
	} 
}
```
    
4.  Button 객체를 만들고 onClick 메소드를 호출하는데, 이 때 인자값으로 ClickEventHandler type 의 reference 를 넘겨준다.

```
   public class TestButton{
   
     	public static void main(String [] args){
     			Button button = new Button(); 
     			ClickHandler clickHandler = new ClickHandler(); 
    
     			button.onClick(clickHandler); 
    
     		//android 에서는 아래와 같이 인터페이스를 구현하는 익명 클래스를 인자값으로 넘겨주는 방식을 주로 취한다. 
     			Button anonyButton = new Button(); 
     			anonyButton.onClick(new ClickEventHandler{
     					@Override
     					public void handleClick(){
     						System.out.println("Button is Clicked");
     					}
     			});
     	} 
    }

```
    
## Collections Framework 
![collectionsFramework](https://lh3.googleusercontent.com/g_SUxvvmCp7GdMrVzOrg5_f57fw3wqHn94AZ1LefpMrl-OYA_c70iY_PTdaNotfrAKZMDN_-IRGk "CollectionsFramework")

- Collections Framework(컬렉션 프레임웍)이란 '데이터들을 저장하는 클래스들을 표준화한 설계'를 뜻한다. 
- List, Set, Map 이렇게 크게 세 개의 인터페이스를 갖추고 있고, 구체적인 기능을 구현할때는 이 인터페이스들을 구현한 클래스를 통해서 한다. List 를 구현한 ArrayList 라는 클래스 객체를 통해 실질적으로 데이터를 넣고, 삭제하고, 탐색할 수 있는 것이다. 

```
//실제 List, ArrayList 를 라이브러리에서 확인해보자 

public interface List<E> extends Collection<E> { // 구현 내용 생략 }
//List 는 텅텅 비어있다. 다만 일련의 메서드의 구현을 강제할 뿐. 

public class ArrayList<E> extends AbstractList<E>  
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable  
	{ // 구현 내용 생략 }
	
//ArrayList 는 List 에서 구현을 강제받은 메서드들이 실질적으로 구현되어 있다. 
```

- 쉽게 말하면  특정한 삽입, 삭제, 탐색 기능을 갖추고 있는 데이터들을 담는 특별한 바구니...정도로 표현할 수 있다. 

- 바구니마다 어떤 기능에 특화되어 있는지 - 예를들어 A라는 바구니는 데이터를 넣고 빼는 것 보다 탐색이 더 쉬울 수 있다 - 하나씩 배워가는 것이 Collections Framework 을 공부하면서 해야 할 것들이다. 

- 하지만 Collections Framework 을 이해하기 전에 반드시 위에서 배운 상속, 인터페이스에 대한 이해가 있어야 하고 이 위에 Generics(제네릭) 이라는 개념도 탑재해야 한다. 만약 이 중 이해가 부족한 것이 있다면 개념들을 메꾸어 나가면서 Collections Framework 를 이해해야 한다. 

### Collections Framework's core interfaces 
컬렉션 프레임웍에서는 데이터를 담는 구조에는 크게 3가지가 있다고 보고 이 구조들을 다루는 데 필요한 기능을 가진 3개의 인터페이스를 정의하였다. 그리고 인터페이스 List 와 Set 의 공통된 부분을 다시 뽑아서 새로운 인터페이스인 Collection을 추가로 정의하였다. 

- interface Collection <----  interface List, interface Set (List 와 Set 인터페이스의 공통점을 묶은 Collection 인터페이스)
- interface Map (List, Set 과는 차이가 많아서 Collection 인터페이스로 묶이지 않았다) 

List 와 Set 을 구현한 컬렉션 클래스들은 서로 많은 공통부분이 있어서 공통된 부분을 다시 뽑아 Collection 인터페이스를 정의할 수 있었지만 Map 인터페이스는 이들과는 전혀 다른 방식으로 컬렉션을 다루기 때문에 같은 상속계층도에 포함되지 못하였다. 

* 각 인터페이스들의 특징 
1. List : 순서가 있는 데이터의 집합. 데이터에 인덱스로 접근한다. 따라서 데이터의 중복을 허용한다. 
> List 인터페이스를 구현한 클래스들 :  ArrayList, LinkedList, Stack, Vector 등이 있다. 
2. Set : 순서를 유지하지 않는 데이터의 집합. 데이터의 중복을 허용하지 않는다. '순서(인덱스)'라는 기준이 없으므로. 
> Set 인터페이스를 구현한 클래스들 : HashSet, TreeSet 등 
3. Map : Key 와 Value 의 쌍으로 이루어진 데이터의 집합. **순서는 유지되지 않으며 Key는 중복을 허용하지 않고, Value는 중복을 허용한다.** 
> Map 인터페이스를 구현한 클래스들 : HashMap, TreeMap, Hashtable, Properties 등 

----

 **자세한 내용은 생활코딩을 참고하세요** 
- [생활코딩 Java 강좌 - Generics](https://www.opentutorials.org/course/1223/6237)
- [생활코딩 Java 강좌 - Collections Framework](https://www.opentutorials.org/course/1223/6446)


### Android 에서 가장 많이 쓰게 될 ArrayList 

- 여러가지 자료 구조들을 공부하다 보면 많이 어렵다고 느낄 수 있는데, 사실 각 자료 구조들의 특성만 기억을 해 두고, 나중에 필요한 구조들에 대해서는 API문서를 찾아보는 식으로 ***사용*** 만 하면 된다. 

- 한편, **ArrayList** 라는 클래스는 안드로이드에서 데이터를 insert, delete, iterate, search 할 때 가장 보편적으로 쓰이는 클래스로, 반드시 알아두어야 한다. 

- **실습** 

```
// Movie.java 

public class Movie {  
    private String movieTitle;  
  
    public Movie(String movieTitle){  
        this.movieTitle = movieTitle;  
    }  
  
    public String getMovieTitle() {  
        return movieTitle;  
    }   
}
```

```
//MovieArrayList.java

import java.util.ArrayList;  
  
//ArrayList - size(), get(index), remove(Object), add(Object)  
  
public class MovieArrayList {  
  
    int numOfMovies;  
  
    public MovieArrayList(int numOfMovies){  
  
        this.numOfMovies = numOfMovies;  
  
    }  
  
    private ArrayList<Movie> arrayList = new ArrayList<>();  
  
    public void iterateMovies(){  
        for(int i = 0; i < arrayList.size(); i++){  
            System.out.println("Printing : " +    arrayList.get(i).getMovieTitle());   
        }  
    }  
  
    public void makeMoviesList(){  
        for(int i = 0; i < numOfMovies; i++){  
            arrayList.add(new Movie(movieTitleHelper(i)));  
        }  
        System.out.println("Added " + arrayList.size() + " movies!");  
    }  
  
    public void deleteMovieByIndex(int index){  
        Movie movie = arrayList.get(index);  
        System.out.println("deleting " + movie.getMovieTitle());  
        arrayList.remove(movie);  
    }  
  
    private String movieTitleHelper(int index){  
        return "movie #" + index;  
    }  
  
}
```

```
//Main.java
  
public class Main {  
  
    public static void main(String[] args) {  
  
        MovieArrayList arrayListEx = new MovieArrayList(10);  
  
        //make movies and insert into the arrayList  
	  arrayListEx.makeMoviesList();  
  
        //iterate through the movie array list  
	  arrayListEx.iterateMovies();  
  
        //remove index number 3 from the array list  
	  arrayListEx.deleteMovieByIndex(3);  
  
    }  
  
}
```

---- 
EOF 

