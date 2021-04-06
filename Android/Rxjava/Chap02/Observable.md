## Observable

<img src="../Images/Rxjava1.xVS2,x.png">

 > RxJava 1.x에서는 Observable 만 있었지만 RxJava 2.x에서는 세분화 되었다.

  - Observable

  - Maybe

  - Flowable 
- Observable (관찰자) 아직 관찰되진 않았지만, 이론을 통하여 관찰할 가능성을 의미한다.
> 라이프 사이클은 존재하지 않는다.

### RxJava의 Observable은 세 가지의 알림을 구독자에게 전달한다.
 - **onNext :** Observable의 데이터 발행을 알린다.
 - **onComplete :** 모든 데이터의 발행을 완료했음을 알림, 단 한번만 발생하며 발생한 후에는 onNext 이벤트가 못발생함.
- **onError :** Observable에 어떠한 이유로 에러가 났다는걸 알린다. onError 이벤트가 밸생하면 onNext와 onComplete 이벤트가 발생하지 않는다. 즉 Observable의 실행이 중단된다.
 

## Observable Class의 함수들

### just함수

데이터를 발행하는 가장 쉬운 방법은 기존의 자료구조를 사용하는 것이다.

just() 함수는 인자로 넣은 데이터를 차례대로 발행하려고 Observable을 생성한다. 
> 실제 발행은 subscribe() 함수를 실행해야한다.
>> 한 개의 값을 넣을 수 있고 **최대 10개의 값**을 넣을 수 있다. *단 타입은 모두 같아야한다.*<br>

<img src="../Images/just.png" width="500" height="250"></br>
중앙으 원은 Observable에서 발핸하는 데이터로 just() 함수를 거치면 입력한 원을 그대로 발행한다. 파이프(|) 표시는 모든 데이터 발행이 완료되었다는 의미이다.(onComplete 이벤트)

>인자가 N개인 just() 함수의 다이어그램

<img src="../Images/justs.png" width="500" height="250">

just() 함수로 1~6 까지의 원을 1개씩 발행한다. 모두 발행한 이후에는 완료(|) 한다.


*코드*
~~~kotlin

class FirstExampleKotlinJust {
    fun emit(){
        Observable.just(1,2,3,4,5,6).subscribe(System.out::print)
    }
}

fun main(){
    val demo=FirstExampleKotlinJust()
    demo.emit()
    
}
~~~
*결과*
~~~kotlin
1
2
3
4
5
6   
~~~

### subscribe() 함수와 Disposable 객체

Observable은 just() 등의 팩토리 함수로 데이터 흐름을 정의한 후 subsrcibe() 함수를 호출해야 실제로 데이터를 발행한다.

Rxjava는 동작시키길 원하는걸 미리 선언한다음 그것이 실행되는 시점을 조절할 수 있다.
 
>Rxjava는 선언형 프로그래밍이다.
>>먼저 선언하고 필요할 때마다 가져다 쓸 수 있다. 
>>실행할 동작을 구체적으로 명시하는 명령어 프로그래밍과 달리 선언형 프로그래밍은 단순히 목표만 선언한다

- Disposable 인터페이스의 함수
  
dispose()는 Observable에게 더 이상 데이터를 발행하지 않도록 구독을 해지하는 함수.

Observable 계약에 따르면 Observable이 onComplete 알림을 보냈을 때 자동으로 dispose()를 호출해 Observable과 구독자의 관계를 끊는다.

따라서 onCompose 이벤트가 끝나면 구독자가 별도로 dispose()를 호출할 필요가 없다.


코드
```kotlin
   class ObservableNotificationsKotlin {

    fun emit() {
        val source = Observable.just("RED", "GREEN", "YELLOW")

        val d = source.subscribe(
            { v -> println("onNext() : value : $v") },
            { err -> println("onError() : err : ${err.message}") },
            { println("onComplete()") }

        )
        print("isDisposed() : "+d.isDisposed)
    }
}

fun main() {
    val demo = ObservableNotificationsKotlin()
    demo.emit()

```
출력
``` kotlin
onNext() : value : RED
onNext() : value : GREEN
onNext() : value : YELLOW
onComplete()
isDisposed() : true
```

~~~
subscribe는 Observable을 찍기 위한 함수이고, Disposed는 subscribe에 있는 함수 인건가 ?? 아시면 답 부탁드립니다.
~~~

### create() 함수