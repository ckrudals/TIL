
## Android 공부하면서 새로 알게된 개념을 정리하는 repo

- BottomSheet 바텀 dialog


화면 회전하지 않으려면

 [화면 고정하기](https://www.crocus.co.kr/1672?category=22652)



- jvm 이란 자바가상머진
- heep 이란 메모리에 사용자가 직접 관리할 수 있고 해야만 하는 영역
> 갯수나 크기를 미리 알 수 없을 때 유용

> 개체가 너무 커서 스택 할당자에 맞지 않을 경우
  
  ### **singleton** 패턴

  어플리케이션이 시작할 때 어떤 클래스가 최초 한번만 메모리를 할당, 그 메모리에 인스턴스를 만들어 사용

  new Instance 를 왜 쓸까 ?

  Android 에서는 메모리가 부족할 때 액티비티를 파게 하여 메모리를 확보한다.

  액티비티 뿐만 아니라, 프래그먼트도 파기하여 메모리를 확보하는데 
  이 때 재생성시 필요한 생성자는 아무것도 매개변수가 없는 생성자다.

   그래서 생성자를 안만들어주면 오류가난다

  - 한줄요약
  ~~~
  프래그먼트나 액티비티 를 파괴하여 메모리를 확보한다. 이 때 매개변수가 없는 생성자를 안만들어 주면 오류가 난다.
  ~~~

  ### Activity vs fragment

  안드로이드 3.0 전까지만 해도 Activity 가 만능이였다. 하지만 시간이 흐를수록 비지니스 로직을 재사용할 방법이 필요했다. 이때 단일 액티비티가 거대해 지는 것을 막기 위해 프래그머트를 섞어서 사용했다.

  초반에는 많이 혼란스러웠다. Activity에서만 돌아가던 라이프사이클이 프래그먼트와 섞이면서 혼동이 일어난 것이다. 그래서 많이 어려워하고 문제점이 많았다.


android:ellipsize="end" size보다 텍스트가 뜬다.
    
시크바
>rangeslider 

popupwindow     ``` dialog```

Textwatch와 AndroidStudio recyclerView filDter

Android dependencies 에서 받아오는 라이브러리가 너무 많을 때 object로 모아서 가져올수있다!

    
### 데이터 스트림이란

> 구체적 데이터 형식이 정해지지 않는


### Fragment onCreateView와 onViewCreate 차이

onCreateView는 Activity의 onCreate처럼 view를 inflate 될때 사용되고,

onViewCreate는 onCreateView가 return 된 직후 바로 실행되는 것은 onViewCreate에 써야한다.

### mikephil
chart 라이브러리

### currentGradesInfoBalloon

dialog 라이브러리
