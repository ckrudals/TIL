## Observable

<img src="../Images/Rxjava1.xVS2,x.png">

 > RxJava 1.x에서는 Observable 만 있었지만 RxJava 2.x에서는 세분화 되었다.
 >> Observable

 >> Maybe

 >> Flowable 
- Observable (관찰자) 아직 관찰되진 않았지만, 이론을 통하여 관찰할 가능성을 의미한다.
> 라이프 사이클은 존재하지 않는다.

### RxJava의 Observable은 세 가지의 알림을 구독자에게 전달한다.
> - **onNext :** Observable의 데이터 발행을 알린다.
> - **onComplete :** 모든 데이터의 발행을 완료했음을 알림, 단 한번만 발생하며 발생한 후에는 onNext 이벤트가 못발생함.
> - **onError :** Observable에 어떠한 이유로 에러가 났다는걸 알린다. onError 이벤트가 밸생하면 onNext와 onComplete 이벤트가 발생하지 않는다. 즉 Observable의 실행이 중단된다.
> 

