### Observer Pattern

* UI 가 데이터베이스 (혹은 다른 비즈니스 로직)과 연결되어 있는 경우 주로 이 패턴을 사용한다.
* 유저는 UI를 통해서 특정한 query 를 날리고, 밑의 레이어에서 데이터베이스를 검색한 후 결과가 UI에 반영된다.
* 대부분의 경우 UI는 데이터베이스 코드와 분리된다.
* 만약 DB에 변화가 생기면 그 변화는 바로 UI에 반영되어야 한다.


#### 1. 단순한 버전

* ObserverPatternEx : main 함수를 포함하는 클래스. 작성된 Observer 를 테스트 하는 용도.
* Subject : 관찰의 대상이 되는 객체
* Observer : Subject 클래스의 변화를 관찰한다.
* ISubject : interface 로, 여러개의 Subject 들을 만들 때 이 인터페이스를 implement 해서 만든다.

#### 2. 좀 더 복잡한 버전

* 추가되는 내용
    * 여러개의 Observer 를 만들 것 -> IObserver 라는 인터페이스를 구현해야
    * Subject 안의 변화를 구체적으로 확인. Value 를 확인하는 메소드 추가. (getValue(), setValue() 등)


