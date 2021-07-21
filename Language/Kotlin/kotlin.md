## 코틀린을 다루는 기술 책을 보고 정리한 리드미


### 필드와 변수
코틀린에서 변수를 초기화 를 할때 바로 초기화 하는게 좋다.

초기화 하는방법은 2가지가 있다.

- lazy

lazy 에서는 

```kotlin
    val nameed = "Dd"

    // 람다 대신 함수 참조
    private val name: String by lazy(::nameed)  // 역참조
    private val name1: String by lazy { nameed }// 람다 대신 함수 참조
```

- lateinit

최초 사용시 초기화 하지 않지만 어떤 면에서는 lazy와 같은 효과를 낸다.

하지만 DI 등으로 외부에서 필드 초기화를 하는 경우 제외하면 lazy와 비교할때 장점이 절때 __없다__

### 클래스와 인터페이스

싱글턴 어떤 클래스에 객체가 하나만 있어야함 < 이런 인스턴스를 싱글턴