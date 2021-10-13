##  Kotlin 흐름 알기

코루틴에서 흐름은 단일 값만 반환하는 정지 함수와 달리 여러 값을 순차적으로 내보낼 수 있다.

### Flow와 LiveData의 차이

LiveData
 - 일방적으로 데이터를 전송하는 용도로 사용된다.

Flow
- 고유한 방식으로 데이터를 비동기 처리하는데 사용된다

LiveData는 ViewModel에서 메모리 누수를 줄임으로서 생명주기 인식을 보장하고 있다.
> 메모리 누수가 생겨면 oncreate()에 나타날 로직이 꼬일 수 있다.

즉 LiveData는 안드로이드 구성요소에서 관찰할 수 있는 데이터 집합을 보유할 수 있다.(__Android__,__Fragment__,__Service__)

LiveData는 생명주기를 인식하기 때문에 데이터가 파괴되거나 활성화 하지않으면 observer에게 데이터 전송을 하지않는다 ! 메모리누수 해결

Flow는 Rx 처럼 비동기 처리 방식중 하나인데 순차적으로 실행하는 데이터 스트림을 비동기 적으로 처리할 수 있어 Rx의 대안으로 떠올랐다.

Room으로 내부 db를 할때

LiveData를 사용하여 db -> ui로 데이터를 전송할 수 있지만 향후 변동사항이 있을때 LiveData는 무력하다

이때 Flow를 쓰는것이다. Flow는 LiveData처럼 Observing 이 가능하다.

그래서 backpressure, thread가 변동되었을때 repository level 단에서 해결이 가능한 것이다.

Flow를 viewModel에서 쓸때

asLiveData()를 쓰거나, LiveData를 Observing 하는 방식으로 쓸 수 있다.

<br>

__asLiveData__
```kotlin
val users: LiveData<List<User>> = repository.getAllUsersFlow().asLiveData()
```
__LiveData Observing__

val users: LiveData<List<User>> = liveData { // some additional work repository.getAllUsersFlow() }

한줄요약
>> ViewModel과 View의 상호작용은 **LiveData**, 복잡한것을 **Flow**