
### ReactiveProgramming에 있는 코드
```java

import io.reactivex.rxjava3.core.Observable;

public class FirstExampleJava {
    public void emit(){
        Observable.just("Hello","RxJava 2!!").subscribe(System.out::println);

    }

    public static void main(String[] args) {

        FirstExampleJava demo=new FirstExampleJava();
        demo.emit();
    }
}
```
### io.reactivex

- Rxjava2의 기본 패키지명은 io.reactivex이다.
### Observable class
- 데이터의 변화가 발생하는 데이터 소스이다. 당장은 리액티브 프로그래밍이 Observable에서 시작하는것만 알아두자
> Android의 liveData 같은 느낌인가?
### just() 함수
- 가장 단순한 Observable의 선언방식이다. Integer와 같은 래퍼 타입부터 Order같은 사용자 정의 클래스의 객체도 넣을 수 있다.
### subscribe() 함수
- Observable를 구독한다. Observable은 무조건 subscribe() 함수를 호출해야만, 변화환 데이터를 구독자에게 발행한다.
> just()함수만 호출하면 데이터를 발행하지 않는다
>> 의존성 주입 같은건가 ??
### System.out::println
- System.out,println 을 통해 호출했다. System.out,println은 자바 8 래퍼런스를 활용했다. 만약 래퍼런스를 활용하지 않았다면 System.out.println(data)랑 똑같고, Observable이 발생하는 데이터는 data인자로 들어온다

### emit() 메서드
- emit 이란 뜻은 어떤것을 내보내다. 라는 뜻인데, Rxjava 개발 문서에는 Observable이 subscribe() 함수를 호출한 구독자에게 데이터를 발행하는 것을 표현하는 용어이다. 
> Observable -> subscribe() 호출한곳에 데이터전달 ?

