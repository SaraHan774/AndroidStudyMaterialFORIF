# API 사용하기 

[https://www.themoviedb.org/account/signup](https://www.themoviedb.org/account/signup)

### 1. 계정 만들기

signup 화면에 들어가서 회원가입을 해주세요. Chrome에서 하면 javascript 로 인해 문제가 날 수 있으니 에러가 생기면 microsoft edge 나 다른 브라우저에서 진행해 주세요. 

![](Untitled-b9dc1082-d270-48c5-b9f1-4c75ca77803c.png)

이메일 인증 요청이 갑니다. 

![](Untitled-488bc65b-f0c4-4f1c-8fcc-a56127f72069.png)

인증 메일을 확인합니다. 

![](Untitled-77016288-e292-428e-b90e-e15ed7e76ee3.png)

회원가입 완료 화면 

![](Untitled-04be897c-5fcd-4551-b276-afe3b1231c23.png)

[https://developers.themoviedb.org/3/getting-started/introduction](https://developers.themoviedb.org/3/getting-started/introduction)

setting 에 들어가 주세요 

![](Untitled-3982128b-0c85-4c31-98a2-8f63ff2e2c09.png)

![](Untitled-ce262018-e6b2-4ece-8c60-22282276fca8.png)

API 탭을 클릭해서 우측의 Request an API key 밑에 있는 click here 를 누릅니다. 

![](Untitled-555d2661-8a88-4ecd-a391-3ed7b4e2d861.png)

Developer 를 선택합니다. 

![](Untitled-e6442f1f-dfe8-4015-9a45-f2fd22d6aef9.png)

약관을 죽죽죽 내려서 동의 클릭 

기본 정보 입력 화면입니다. 앱 URL은 그냥 아무거나 써주셔도 괜찮습니다. 

![](Untitled-0d577530-0fd7-43ca-93c9-05ddf13a8b60.png)

📌전화번호는 `+821071528590` 와 같은 형태로 입력해 주세요 +82-10-XXXX-XXXX 

**API 키가 발급되었습니다. ✨**

![](Untitled-990dde66-643d-4016-83d7-20b68bceba0d.png)

위의 Example API Request 를 주소 입력창에 넣어봅시다. 

![](Untitled-561e6597-e97e-4837-9b70-6b82399b27dc.png)

이렇게 아무런 포맷팅 없이 줄줄이로 나타날 겁니다. 이를 좀 더 보기 편하도록 code beautify 사이트를 이용합시다. 

[JSON Viewer](https://codebeautify.org/jsonviewer)

→ 링크 클릭 

위의 주소를 복사해서 아래의 Load Url 을 클릭한 후 URL을 입력해 줍시다. 

![](Untitled-aee5f088-a091-4b29-99a0-7608f9b34b79.png)

그러면 우측에 정리가 되어서 나타납니다 

![](Untitled-d7f2b5aa-617d-47e8-9278-18f0029063ce.png)

→ 이런 Key : value 형태의 파일을 JSON파일이라고 합니다. 

    개발자들이 가져다 쓰기 편하도록 만든 형식 = JSON 
    이라고 기억합시다. 

---

### API 엔드포인트 + API키 가 있으니 이제 활용을 해 봅시다.

위의 예시를 분석해 봅시다. 

    https://api.themoviedb.org/3/movie/550?api_key=2c702e667781c19eb48ec3b2193c97c8
    
    이 주소를 분석해 보면 
    https://api.themoviedb.org/3 -> 이 부분이 endpoint 입니다. 이 주소와 적절한 쿼리가 있다면 
    우리는 이제 영화 웹사이트에서 정보를 JSON형태로 받아올 수 있습니다. 
    
    /movie/550 -> 웹사이트에서 어떤 정보를 가져올 지 명시하는 쿼리입니다. 사이트에서 제공하는 
    예제 JSON파일을 가져올 수 있도록 하는 쿼리겠죠? 
    
    ?api_key=2c702e667781c19eb48ec3b2193c97c8 -> 아무나 웹사이트 정보를 마구 가져갈 수 없도록 
    API키 또한 적어주어야 합니다. 
    

[API Docs](https://developers.themoviedb.org/3/movies/get-popular-movies)

→ 이 다큐먼트를 열어봅시다. 

![](Untitled-00dc5b20-8faa-4410-bbc7-7fcd87336f6c.png)

이런 페이지가 나타납니다. 

Query String 부분을 보시면 api key 는 필수 요소이고, 나머지 항복은 필수가 아님을 알 수 있습니다. 나머지 쿼리를 명시해 주면 특정 언어, 특정 페이지, 특정 지역의 결과물을 받아볼 수 있습니다. 

그 아래 Responses 를 보면 이 쿼리의 결과로 반환되는 텍스트가 무엇인지 보여줍니다. JSON형태로 반환이 되며, 응답 코드가 200이었을 때 정상 결과가 반환됩니다. 응답 코드 404는 그 유명한 PAGE NOT FOUND 를 의미하는 코드이며, 서버쪽에서 결과를 찾을 수 없을 때 반환되는 응답코드 입니다. 

**Definition 탭 말고 Try it out 탭으로 가서 이 쿼리를 어떻게 써야하는지 한 번 시도해 봅시다.** 

![](Untitled-f6b052c3-efcf-4957-8794-7dd2b1938a61.png)

api key 부분에 자신의 key값을 복사해서 넣어주시고 아래의 핑크? 보라?색 버튼 옆에 생긴 주소를 주소창에 입력해 보세요. 

![](Untitled-4a9299d6-e3b3-4cc8-9c48-29687e53fcbc.png)

못알아보겠습니다. → code beautify 를 이용합시다. 

![](Untitled-659af03c-ad8b-4024-b440-d6151efd6543.png)

트리 뷰어를 이용했을 때 위와 같이 결과가 나타남을 알 수 있습니다. 

크게 4개의 객체가 있습니다. 위의 results 배열을 펼쳐보면 또 14개의 요소들의 배열로 이루어진 객체들이 총 20개 담겨져 있음을 알 수 있습니다. 

![](Untitled-3d2942f3-f044-40f9-a715-e84891f89677.png)

- results → 20개의 배열 → 각 배열은 또 다시 14개의 요소 포함

✨**여기서 results 에 담긴 정보를 우리의 앱으로 끌어오는 것이 목표입니다!**
