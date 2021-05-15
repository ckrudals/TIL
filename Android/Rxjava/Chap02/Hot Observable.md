## 뜨거운 Observable

### 차가운 Observable, 뜨거운 Observable 정의

Observable에는 뜨거운 Observable과 차가운 Observable이 있다.

차가운 Observable은 Observable을 선언하고, 함수를 호출해도 subscribe() 함수를 호출하지 않으면 데이터가 발행되지 않는다.

`게으른 접근법`

뜨거운 Observable()은 구독자 존재 여부 관계 없이 데이터를 발행하는 Observable 이다. 단, 구독자로서는 Observable에서 발행하는 데이터를 처음부터 모두 수신할 꺼라는 보장은 없다. 

즉 차가운 Observable 구독하면 준비된 데이터를 처음부터 발행한다, 하지만 뜨거운 Observable 은 구독한 시점부터 발행한 값을 받는다.

### 차가운 Observable과 뜨거운 Observable의 쓰임새
  차가운 Observable 의 에는 웹요청, 데이터베이스 쿼리, 파일 읽기 등이있다.
  내가 원하는 URL이나 데이터를 지정하면 그 때 부터 서버에 요청하고 결과를 받는다.

  뜨거운 Observable은 마우스 이벤트, 키보드 이벤트, 시스템 이벤트, 센서 데이터 와 주식 가격 등이 있다.

  > 구독자가 여려 명이라는 건 무슨뜻일까
  >> 만약 서버에 데이터를 날씨 정보, 지역 정보, 시간 정보를 반환한다 하면 Rxjava에서는 위의 3개의 정보가 구독자라고 한다.

>>데이터의 원천은 하나지만 거기서 얻어오는 데이터가 여러 개 일때는 각각의 구독자라고 하는게 좋다.

### 뜨거운 Observable 주의할 점

배압을 고려해야한다. 배열이란 , 데이터를 발행하는 속도와 구독자가 처리하는 속도의 차이가 클 때 발생한다.

  
차가운 Observable은 Observable을 선언하고 subscribe() 함수를 호출 x 실행 안됨
뜨거운 Observable subscribe없어도 호출됨