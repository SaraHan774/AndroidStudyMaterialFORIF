## Layouts
안드로이드 에서는 xml 파일로 앱 디자인을 하도록 되어있습니다. 사진을 넣더라도 (만약 local 에서 넣는 경우 - 그러니까, 다른 주소에서 이미지를 불러오는 것(remote fetch)이 아니라 내 컴퓨터에 있는 `.png`, `.jpg` 파일 등을 넣는 경우) xml 파일들이 들어있는 `res` 폴더에서 자원을 관리하도록 되어있습니다.
[사진1]
![folder_structures](https://lh3.googleusercontent.com/JHh0wcb7kfEwP8Fgcys9DE96neoqnh_e0X_FUTA3_zG2r0OHkQByWADazZEM8A-ITL3CaKckFGtJ)

- 위의 화면에 보이는 `res` 폴더가 모든 xml 파일들을 관리하는 폴더들을 포함하고 있습니다. 
1. drawable 폴더 : 이미지 자료들을 넣는 곳입니다. vector 그래픽으로 된 이미지들도 저 폴더에서 관리합니다. 현재로서는 vector 그래픽이 뭔지 자세히 알 필요는 없고, 그냥 이미지 파일들을 넣는 곳 정도로 생각해 주시면 됩니다. 
2. layout 폴더 : 앱 화면 디자인을 넣는 곳입니다. 가장 많이 참조하게되는 폴더입니다. 후에 더 자세히 설명하도록 하겠습니다. 
3. mipmap 폴더 :  ic_ 로 시작하는 파일들을 볼 수 있을 것입니다. icon을 뜻하는 말로, 주로 앱 아이콘 파일을 mipmap 폴더에서 관리합니다. 안드로이드 버전별로 앱 아이콘의 모양이 다르고 사이즈도 다르기 때문에 별도로 관리해 줍니다. 
4. values 폴더 : 앱에서 사용되는 문자열, 레이아웃의 사이즈, 색, 앱의 테마 등에 대한 정보들을 담는 폴더입니다. 

![res](https://lh3.googleusercontent.com/ovj_lv8l5GQRQ2wYlcrPHCnFZYWC7rNnGauD1PBRwmD5N3rVxv-JEOzGf1UQ2NU62iHbzPOop-Dx)
- layout 폴더위에 커서를 올려두고 오른쪽 클릭을 하면 New -> Layout Resource file 이란 탭이 보일 것입니다. 이것을 클릭하면 위 처럼 새로운 레이아웃을 만들 때 초기 설정을 할 수 있는 창이 나타납니다.

![qualifiers](https://lh3.googleusercontent.com/2TNI9TVbfCHxL3q1Lqd8nz_jwPIzhhb0uLmNXKBErVoEyCUfFfZtHsNw3pTQ5zJSr_fZ0pHe1a-z)
- 레이아웃을 만들 때 여러가지 qualifier 를 적용해 줄 수 있습니다. (지금은 qualifier 를 layout에 가해주는 어떠한 `조건` 정도로 이해합시다.)
 
[사진 2-2, 2-3] 
![portrait](https://lh3.googleusercontent.com/GOTAde6GolBi4ku-KLAGeHNQsdBNI8DqOGAzxfNBI8uTvtNkwLbAAL_tCj0xRllHWRqx_AnLbnUD)

- 예를들어 위의 화면에 보이는 `orientation` 을 선택하는 경우를 살펴봅시다. 

![port](https://lh3.googleusercontent.com/tS1AffD51JUcsyg0-Qu0WrqPTOZDd_fyVpNnVZFfErEZeQXj96s0HfzDY10_QKz9G96OsHYpEckC)
- qualifier 를 portrait 으로 설정하면 layout - port 라는 폴더가 생성되고, 위의 화면처럼 <layout 이름> (port) 라고 표시됩니다. 
- 어떤 경우에 주로 활용되냐면, 예를들어 테블릿에서는 활용할 수 있는 공간이 많기 때문에 화면을 가로로 돌렸을 때 이메일 화면의 경우 왼쪽에는 메일 리스트, 오른쪽에는 메일 내용을 표시해 주는 경우가 많습니다. 또 마찬가지로 다시 세로로 돌리면 (가로 모드일 때 보다 가용 면적에 적어져서) 메일 리스트만 뜨도록끔 하고 싶을 수 도 있겠죠? 
- 이럴 때 만약 메일 화면 layout 이름을 mail_display.xml 이라고 정했다 합시다.  `mail_display (land)` 와 `mail_display (port)` 를 따로 만들어서 별도의 디자인을 만들어 주면 화면을 가로로 했을 때랑 세로로 했을 때 그에 알맞는 레이아웃이 나타나게 됩니다. 

> 반드시 "동일한 이름의 파일 두 개"에 qualifier만 달리 해서 만들어 주어야 안드로이드 에서 이를 화면 디자인에 적용하는 데 문제가 생기지 않을 수 있습니다.  

**Layout qualifier는 왜 쓰나요 ?**
**자바 코드를 줄여줍니다**. 안드로이드 개발에 있어서 앱 **내부 동작 코드**와 (예를들어 버튼 클릭시 어떤 효과가 나타나는가 등 과 같은 logic) **디자인 코드**를 분리해 주는 것이 매우 중요합니다. 만약 서버에서 이미지를 가져오는 코드와 이미지를 화면에 디스플레이 할 때 필요한 특정한 UI 요소들에 관련된 코드를 섞어두면 코드가 매우 더러워집니다. 따라서 최대한 UI관련된 요소는 Java 코드로 조작하기 보단 xml 파일로 따로 관리해 주는 것이 좋을 것입니다. 만약 위의 orientation qualifier 가 없었다면, Java 코드로 `현재 화면 orientation 을 불러와서 + 조건 체크를 해 준 후 + if portrait 이면 특정 레이아웃 불러오기, else if landscape 모드 이면 특정 레이아웃 불러오기`  와 같은 식으로 코드를 짜야 할 것입니다. ~~무엇보다 읽기 싫겠죠.~~

### 그러니까 도대체 Layout 디자인은 어떻게 합니까? 
> 죄송합니다. 안드로이드가 원래 서론이 절반이라 좀 답답하게 느껴지실 수 있는데, 인내심을 갖고 차근차근 해 나갑시다 ... 

- 레이아웃 파일을 열어보면 여러 태그들이 모여서 이루어 진다는 것을 발견할 수 있을 것입니다. 이 태그들은 마구잡이로 쓰여져 있는 것이 아니라 **전반적인 View 들의 배치에 특정한 Rule을 가해주는 Parent layout** 과 그 parent layout 안에 nested 되어서 들어간 **child layout** 혹은 여러 다른 **view** 들로 이루어져 있습니다. 

- Parent Layout 으로 사용할 수 있는 layout의 종류들로는 
	- Linear Layout 
	- Relative Layout 
	- ScrollView 
	- NestedScrollView 
	- Constraint Layout 
	- and many more ..... 

등등등 이 있습니다. 현재 안드로이드 개발에서는  Constraint Layout 을 사용하는 것을 권장하고 있으나, 여러 다른 기본 레이아웃을 익히고 나서 이해하는 것이 더 낫기 때문에 저는 사용하지 않겠습니다. 왜 Constraint layout을 사용하도록 하냐면 첫번째는 성능 문제이고 (다른 레이아웃보다 빌드시에 렌더링이 빠릅니다) 두번째는 화면 사이즈에 대한 걱정을 줄여주기 때문입니다. 
우선 기본적인 레이아웃 들에 대한 샘플 코드를 한 번 보면서 이해해 봅시다. 

### Linear Layout 
수업시간에 무지개떡이란 이상한 비유로 설명을 했었는데, 지금도 별다른 표현이 떠오르지 않네요... 무지개떡입니다. 
다만 가로로 늘어질 수 도 있고, 세로로 늘어질 수 도 있는 레이아웃 입니다. Linear Layout 안에 들어간 뷰들은 외롭게 한줄로만 줄을 서서 세로로 늘어지거나 가로로 늘어질 뿐입니다. 이런 규칙을 LinearLayout 이 강제해 준다고 생각하시면 됩니다. 

```
<?xml version="1.0" encoding="utf-8"?>  
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"  
  android:orientation="vertical"
  android:layout_width="match_parent"  
  android:layout_height="match_parent">  
  
</LinearLayout>
```
가장 위의 태그는 신경쓰지 않으셔도 됩니다. 여태 공부하면서 한번도 건드려 본 적 없는 태그입니다. 
두번째 태그인 `<LinearLayout ...> </LinearLayout>` 을 주목해 봅시다. 첫번째 / 가 없는 태그는 opening tag, 뒤의 /가 있는 태그는 closing tag 라고 합니다. **태그의 속성은 항상 opening tag 의 내부에 작성해 줍니다.** 
> 두 개 태그로 열고 닫는 것이 힘들어 보이죠? 위의 LinearLayout 은 부모 레이아웃 이기 때문에 내부에 여러 child layout 을 포함해해서 위의 방법으로 태그를 닫아줍니다. 하지만 child layout 중에는 또 다른 child 를 갖지 않는 경우가 많습니다.  이런 경우에는 <TextView ...태그 속성 나열 ...  하고 바로 /> 를 써줌으로써 태그를 닫아주면 됩니다.  (하지만 나중에 레이아웃이 복잡해지면 child 의 child의 child 까지 만들 수 있겠죠?)

- **도대체 저 속성이라는 것은 어디서 왔나요?**
`xmlns:android="http://schemas.android.com/apk/res/android" `
이 코드에서 왔습니다. xmlns 는 xml namespace 를 뜻한다고 설명드렸습니다. `android` 라는 이름을 불러주면 이 안에 정의된 레이아웃 속성들을 가져다 사용할 수 있습니다. 

- **속성의 종류** 
위 코드의 내부에 정의된 속성을 봅시다. 
```
android:orientation="vertical" //가로로 늘어집니다. 
android:layout_width="match_parent"  //레이아웃 사이즈를 부모 레이아웃에 맞춥니다
android:layout_height="match_parent"
```
우선 속성을 쓰실 때는 android: 로 namespace 를 정의해 주신 다음에 그 안에 정의된 orientation 과 같은 속성을 끌어다 써야 합니다. 속성의 종류는 "vertical" 과 같이 따옴표 안에 써주시면 됩니다. 

* Linear Layout 에서는 반드시 태그 안에 orientation 이 정의되어 있어야 합니다. 그래야 정확하게 child view 들에게 일정한 규칙을 강제할 수 있습니다. 여기서는 vertical 이 기본으로 설정되어 있습니다. 
* layout_width 과 layout_height 는 모든 view 들이 공통적으로 가져야만 하는 속성입니다. 쓰지 않으면 빨간줄로 오류가 날 것입니다. 그래픽 유저 인터페이스를 구성하는 요소가 가로와 세로 길이가 없다면 사람 눈에는 1차원 - 점 과 같은 것으로 보일테니 소용이 없겠죠. (물론 height 가 0이면 직선으로 보이긴 합니다)

- **가로 세로 길이가 숫자가 아니라 match_parent 혹은 wrap_content 로 나타나네요?** 
일일이 개발자가 숫자로 정의해주어야 했다면 아마 아무도 안드로이드 개발을 하지 않았을 것 같습니다. match_parent 는 부모 레이아웃의 사이즈에 맞추어 달라 라는 뜻이고 wrap_content 는 내부 view를 완전히 감싸도록 해달라는 뜻입니다. 

```
<?xml version="1.0" encoding="utf-8"?>  
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"  
  android:orientation="vertical"  
  android:background="@color/colorDeepOcean"  
  android:layout_width="match_parent"  
  android:layout_height="match_parent">  
  
     <ImageView  
  android:src="@drawable/star"
  android:layout_width="100dp"  
  android:layout_height="100dp"/>  
  
    <LinearLayout  
  android:background="@color/colorLightSky"  
  android:layout_width="match_parent"  
  android:layout_height="match_parent">  
  
        <ImageView  
  android:src="@drawable/earth"  
  android:layout_width="match_parent"  
  android:layout_height="match_parent"/>  
  
    </LinearLayout>  
  
</LinearLayout>
```
- 위와 같이 코드를 구성했을 때 어떤 결과가 나올 지 대충 예상이 되시나요? **안되는게 정상이겠죠** ... 하지만 꾸준히 하다보면 예상할 수 있게 될 것입니다. 

![linearlayout](https://lh3.googleusercontent.com/-MWzAq-kXlYTDtiF8UPmtkndzP1ERv6L30IXW-2oWuTeVyWu7vGQu_LNFIn6PqbYk0Is80GjWLPs)

이와같은 결과가 나옵니다. 
가장 부모인 리니어 레이아웃이 어두운 색, 그 아래 child로 들어간 linear layout이 child 로 설정되어 있습니다. 부모 태그를 닫기 전에 등장하므로, 부모 태그의 내부에 있는 상태니까요. 
각 속성값과 위의 결과를 비교해 보면서 감을 잡아 보시길 바랍니다. 
* match_parent 를 해도 사진이 깨지며 늘어나지 않고 원래의 비율은 유지한다는 것, 
* 그리고 속성 background 는 배경색뿐만 아니라 배경 이미지 등을 지정해 주는 속성임을 기억해 주시길 바랍니다. 추후에 더 자세한 설명 드리겠습니다. 
* 또한 이미 눈치 채셨겠지만 @color/ @drawable/ 과 같은 것은 해당 폴더 안에 있는 자원을 끌어오겠다는 뜻입니다. 사진 earth는 drawable 폴더 안에 있겠구나 생각해 주세요. 

- **근데 숫자로 길이 지정하는거 귀찮고 힘들다면서 왜 위에는 100dp로 썼어요?** 
> 그러게요?

보통 길이를 지정해 줄 때 일회성으로 딱 이 특정한 뷰는 길이가 100dp이고 다른 뷰들에는 이 100dp 라는 것이 재사용 되지 않을 것 같다 싶으면 저렇게 숫자로 써주셔도 됩니다. 하지만 저런 dimension 에 대한 정보가 계속해서 늘어난다면, 그리고 특히 특정한 숫자가 반복되어서 사용된다면 내가 얼만큼의 길이로 뭘 지정했는지 헷갈릴 수 있겠죠? 

- 그래서 dimen이란 파일이 존재합니다. (res > values 폴더 아래)

height 속성의 100dp라는 숫자 위에 커서를 올려두시고 alt + enter 를 해 주시면 extract dimension resource 라는 탭이 나타납니다. 해당 탭을 클릭하시면 이 리소스에 이름의 지정할 수 있습니다. 소문자로 이름을 지정해 주시고 ok를 누르시면 

```
<ImageView  
  android:src="@drawable/star"  
  android:layout_width="100dp"  
  android:layout_height="@dimen/img_layout_w_h"/>
```
코드가 이렇게 바뀌어 있는 것을 보실 수 있습니다. 해당 100dp라는 숫자는 dimen 파일에 아래와 같이 저장되어 있습니다. 

```
<?xml version="1.0" encoding="utf-8"?>  
<resources>  
    <dimen name="img_layout_w_h">100dp</dimen>  
</resources>
```
![enter image description here](https://lh3.googleusercontent.com/00IeeVKIOFxZqvDAn7k7jGwPYKQOIu1gkw6TD0yQOS-V71Q-p-ohlAOaitaV38svdnERMahdldZG)

- 숫자 위에 커서를 올려두고 알트 + 엔터를 눌러주세요 ! 그러면 아래와 같이 창이 뜹니다.
![enter image description here](https://lh3.googleusercontent.com/wCyPRX6Cs_YEppPEBgW9ZqLQEDzEkpdw7GFnLs9YUFNIhY1Gb43t5dW2WwtkZa4I_ZUoHkO0wO_w)


- 대충 감이 오시나요? width 에 대해서도 똑같이 100dp 라는 것을 빼 주시거나, 아니면 `@dimen/img_layout_w_h` 로 불러오는 식으로 지정해 주시면 됩니다. 일일이 모든 문법을 다 기억하실 필요 없고, 우선은 저렇게 자원을 따로 빼 준다는 사실을 기억하시길 바랍니다. 그러면 나중에 어떻게 빼야 하는지는 구글링하면 되니까요(?).
> 코드를 일일이 외우지 말고 어떤 행동을 취해줘야 한다 정도의 느낌만 가지시길 바랍니다. 


### Relative Layout 
상대 레이아웃이라고도 합니다. 저는 개인적으로 프로그래밍 용어를 한국말로 일일이 번역하는것을 별로 좋아하지 않지만... 아무튼. 상대라는 말에서 유추할 수 있듯이 다른 View와 `상대적으로` 어떤 위치에 있도록 하고 싶다 할 때 사용하는 레이아웃 입니다. Linear Layout과 달리 View의 배치가 좀 더 자유로워 정말 ~~만만하게~~ 많이 사용되는 레이아웃 입니다.
이 상대 레이아웃은 코드로 어떤식으로 나타나는지 확인해 봅시다. 


```
<?xml version="1.0" encoding="utf-8"?>  
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"  
  android:background="@color/colorLightSky"  
  android:layout_width="match_parent"  
  android:layout_height="match_parent">  
  
    <ImageView  
	  android:layout_marginBottom="32dp"  
	  android:layout_alignParentEnd="true"  
	  android:layout_above="@id/floting_action_btn"  
	  android:background="@drawable/earth"  
	  android:layout_width="300dp"  
	  android:layout_height="300dp"/>  
  
    <com.google.android.material.floatingactionbutton.FloatingActionButton  
	  android:id="@+id/floting_action_btn"  
	  android:src="@drawable/ic_camera_enhance_black_24dp"  
	  android:layout_alignParentEnd="true"  
	  android:layout_alignParentBottom="true"  
	  android:layout_margin="18dp"  
	  android:layout_width="wrap_content"  
	  android:layout_height="wrap_content"/>  
  
</RelativeLayout>
```


- 지금 디자인이 거슬려도 잠시만 참아주세요. View들의 경계를 명확하게 하기 위한 용도일 뿐입니다. 

![enter image description here](https://lh3.googleusercontent.com/Q-jVGWyuBSRlKWzTnvJ7ux8SpNd12YFzJGJDE3v5OdU7wB8r6HbexTO99yXn6NSWq7pThFA8T7kF)

결과 화면입니다. Floating action button 이라는 것을 부모 레이아웃의 하단 좌측(layout_alignParentBottom 과 layout_alignParentEnd)에 붙여주었고, 버튼의 상하좌우로 18dp만큼 띄워주었습니다(layout_margin). 그리고 이미지는 무조건 버튼의 위에 있도록 (layout_above) 하였고 하단에만 32dp margin 을 주었습니다. 버튼과 마찬가지로 부모 레이아웃의 좌측에 붙도록 설정하였습니다. 

- **좌측이라고 말하면서 왜 alignParentLeft 라고 안했나요?** 
세상에는 다양한 사람들이 살고있습니다. 아랍어는 우측에서 좌측으로 글을 쓰는 것 처럼 세상의 좌 우 기준은 나라별로 차이가 있습니다. 따라서 안드로이드 에서도 이를 반영하고자 right, left 의 개념을 start, end 로 바꾸었습니다. 이렇게 했을 경우, Right - to - Left support 를 적용했을 때 (문자 등의 좌우가 바뀌어서 나타나야 하는 국가에 최적화되어 앱을 만드는 기능) 우리의 좌우와 이들의 좌우는 바뀌어서 나타납니다. **Left, Right 가 들어간 속성은 전부 다 Start, End 로 바꾼 버전도 존재하며 이를 사용하는 것을 권장합니다.**

* [Blog post: Right-to-Left Support in android](https://android.jlelse.eu/rtl-support-on-android-here-is-all-you-need-know-e13f2df512e2)

> 여러가지 다양한 레이아웃이 있는데 지금은 이정도 감만 익혀두도록 합시다.

### 문자열 리소스 분리하기
안드로이드에서 철저히 지켜야 하는 원칙은 **"사용자 눈에 보이는 문자열은 모두 별도의 string resource 파일에 분리해 놓아야 한다"** 입니다. 나중에 앱 번역을 할 때도 이렇게 따로 관리하면 편리합니다. 그리고 애초에 문자열을 hard coding 하는 것은 프로그램의 유지 보수를 힘들게 하므로 - 왜 dimens 파일에 숫자를 빼 두었는지 떠올리세요 - 권장하는 규칙을 지켜서 프로그램을 만듭시다.

 제가 만든 샘플 앱의 res > values  폴더 밑의 strings 파일의 일부입니다. string 리소스도 문자열 위에 (Java 코드든 xml파일 안의 문자열이든) alt + enter 를 눌러주시면 dimens 와 같이 팝업 창이 뜨면서 리소스의 이름을 지정할 수 있습니다. 자동으로 stings.xml 파일에 저장됩니다. 

```
<resources>  
    <string name="app_name">Movie Database</string>  
  
    <!-- Main View Holder TextViews-->  
  <string name="checkout_details">Check out the details</string>  
  
    <!-- Detail Activity ViewPager TextViews-->  
  <string name="trailers_amp_videos"><![CDATA[Trailers & Videos]]></string>  
    <string name="click_to_watch">Click to watch</string>  
  
    <!-- Detail Activity ImageButton Toast & Other Texts-->  
  <string name="removed_from_db">Removed from your collections!</string>  
    <string name="saved_to_db">Saved to your collections!</string>  
    <string name="my_collections">My Collections</string>  
    <string name="no_collections_yet">No collections yet!</string>  
    <string name="save_first">Please save to the collections first</string>  
    <string name="write_comment_title">WRITE YOUR COMMENT</string>  
    <string name="comment_message">How was this movie?</string>  
    <string name="add_comment_btn_text">Add</string>  
    <string name="canceled">Canceled</string>  
    <string name="saved_comment">Successfully saved your comment</string>  
    <string name="blank_comment">Blank Comment!</string>  
    <string name="reviews">%1$d Reviews</string>  
    <string name="one_review">1 Review</string>  
    <string name="share_msg">Let\'s watch \"%1$s\" together!</string>  
    <string name="share_movie_title">Share this movie</string>  
  
</resources>
```

위의 스트링을 보시면 유저에게 어떠한 메시지를 주는 듯한 문자열들을 발견할 수 있을 것입니다. 예를들어 콜렉션에서 영화목록이 삭제되면 "삭제되었습니다." 하는 prompt를 주어야 할 것입니다.(안드로이드 에서는 이를 Toast 라고 부릅니다.) 이 때 이 문자열은 반드시 strings 파일에 위의 형식으로 들어가 있어야 합니다. 

- 색도 마찬가지로 수업시간에 한 것처럼 분리해 주세요. 

추가로 팁을 드리자면 저는 텍스트 크기를 small, medium, large 로 크게 구분해서 각각의 크기를 리소스 파일에 설정한 다음 불러와서 쓰기를 좋아합니다. 이렇게 하면 앱의 폰트 사이즈에 통일성있게 디자인을 할 수 있다는 장점이 있습니다. 

- **dimens 파일안에...**

```
<dimen name="text_size_x_small">12sp</dimen>  
<dimen name="text_size_small">16sp</dimen>  
<dimen name="text_size_x_medium">20sp</dimen>  
<dimen name="text_size_medium">24sp</dimen>  
<dimen name="text_size_large">32sp</dimen>
```

위와같이 `<resources> </resources>`  태그 내부에 저렇게 텍스트 사이즈를 지정해 주고 레이아웃 디자인을 시작합니다. 

---
주말 내로 Java 코드에 대한 설명을 추가로 올리도록 하겠습니다. 편하게 읽어주시고 xml파일에 대한 감을 좀 잡아서 다음 수업 시간에 만납시다. 어느정도 도움이 되었다면 좋겠네요. 
