mvc

Model View Controller Model을 정의 View 는 Model에 정의된것을 넣어주고 Controller는 view의 이벤트를 controller에서 받아서 해줌 (함수? 같은 것) callback??

Model 과 Controller 의 의존성이 강해진다. 그러면 스파게티 코드 보일러 플레이트 코드가 발생해 위험하다 ! 비용이 많이든다

여기서 파생된게 MVP 패턴

Model View Presenter MVC 패턴가 형식은 똑같지만 의존성이 없다? 그래서 mvp 패턴이 쓰인다
