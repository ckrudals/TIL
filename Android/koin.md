나는 이때까지 Dagger hilt로 의존성을 관리해 왔다.

dagger-hilt 뿐만 아니라 koin에도 관심이 있기 때문에 보고 정리 했다.



먼저 koin은

 - Kotlin DSL을 사용
 - 런타임에서 의존성 주입을 해줌
 - Annotation Processing으로 빌드 시간에 Stub파일을 생성하지 않음
 - AAC ViewModel 사용 시 별도의 라이브러리를 통해 의존성 주입이 가능 하다

그다음 koin을 쓰는 법은


클래스 정의 
```kotlin
class Controller(val service:BusinessService)

class BusinessService()

val myModule = module{


    single {Controller(get())}
    single {BusinessService()}
ㅐ
    viewModel {MyViewModel}
}
```
모듈 주입

Application에 주입한다.
```kotlin

startKoin{
        androidContext(this)

        modules(myModule)
}
```

컴포넌트 주입

inject로 주입한다.

```kotlin
val service : BusinessService by inject()
```

koin의 장점에는

- 러닝커브가 낮아 쉽고 빠르게 DI적용 가능
- Kotlin 개발 환경에 도입하기 쉬움
- 별도의 어노테이션을 사용하지 않기 때문에 컴파일 시간 단축됨
- ViewModel 주입을 쉽게 할 수 있는 별도의 라이브러리를 제공

koin의 단점에는

- 런타임시 컴포넌트 생성이 안되어있으면 클래시 발생
- 런타임에 서비스 로케이팅을 통해 인스턴스를 동적으로 주입해주기 때문에 퍼포먼스 떨어짐
- 리플렉션을 이용하기 때문에 성능상 좋지않다.
```리플렉션 :구체적인 클래스 타입을 알지 못해도, 그 클래스의 메소드 타입, 변수들을 접근할 수 있도록 해주는 자바 API```
- koin.get() 함수와 같은 모듈간 의존성에 대해 신경을 쓰지 않고 인스턴스를 사용하는 경우, 추후 멀티모듈로 전환시 어려움을 겪을 수 있다.