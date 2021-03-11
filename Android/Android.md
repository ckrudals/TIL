BottomSheet 바텀 dialog
android:screenOrientation="portrait"

출처: https://www.crocus.co.kr/1672?category=22652 [Crocus] 화면 고정

<activity android:name="YourActivityName" android:icon="@drawable/icon" android:label="Your App Name" android:screenOrientation="landscape">
setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

출처: https://www.crocus.co.kr/1672?category=22652 [Crocus]
출처: https://www.crocus.co.kr/1672?category=22652 [Crocus]
화면 가로 고정

jvm 이란 자바가상머진
heep 이란 메모리에 사용자가 직접 관리할 수 있고 해야만 하는 영역
- 갯수나 크기를 미리 알 수 없을 때 유용
- 개체가 너무 커서 스택 할당자에 맞지 않을 경우
  
  **singleton** 패턴
  어플리케이션이 시작할 때 어떤 클래스가 최초 한번만 메모리를 할당, 그 메모리에 인스턴스를 만들어 사용

  new Instance 를 왜 쓸까 ?
  Android 에서는 메모리가 부족할 때 액티비티를 파게 하여 메모리를 확보한다.
  액티비티 뿐만 아니라, 프래그먼트도 파기하여 메모리를 확보하는데 
  이 때 재생성시 필요한 생성자는 아무것도 매개변수가 없는 생성자다. 그래서 생성자를 안만들어주면 오류가난다

  - 한줄요약
  ~~~
  프래그먼트나 액티비티 를 파괴하여 메모리를 확보한다. 이 때 매개변수가 없는 생성자를 안만들어 주면 오류가 난다.
  ~~~