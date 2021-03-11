# 싱글턴 패턴이란 무엇일까 ? (Singleton patton)

- 싱글턴 패턴 : 인스턴스를 하나만 만들어 사용하기 위한 패턴이다.
  
## 싱글턴 패턴 왜 사용하는 걸까 ?  

- ### 첫번째 이유
> 인스턴스를 너무 많이 만들면, 불피료한 자원이 메모리가 많아진다.<br>
> **고정된 메모리 영역을 막으면서 한번의 new로 인스턴스를 사용하기 때문에 메모리를 낭비 할 수 있다.**

- ### 2번째 이유
> 싱글톤으로 만들어진 클래스의 인스턴스는 **전역 인스턴스** 이기 때문에 **다른 클래스의 인스턴스들이 데이터를 공유하기가 쉽다.(DBCP)**
>> **DBCP(DataBase Connection Pool)**

- ### 3번째 이유
> **싱글턴**이 나온 이유이기도 하지만, **인스턴스**가 절대적으로 한개만 존재하는 것을 보증하고 싶을 경우, 싱글턴을 쓴다.

- ### 4번째 이유
> "**싱글턴 패턴**"을 두 번째 이용시부터는 객체 로딩 시간이 현저하게 줄어들어, 성능이 좋아진다.!

## 싱글턴 패턴의 단점 이란 ?

- ### 첫번째 이유
> **싱글턴 인스턴스**가 너무 많은 일을 하거나 많은 데이터를 공유시킬 경우 다른 클래스의 인스턴스들의 간에 결합도가 높아져 **"개방-패쇄 원칙**"을 위배하게 된다.
>> => **객체 지향 설계 원칙에 어긋나며 수정이 어려워지고 테스트하기 어려워 진다.**
- ### 2번째 이유
> **멀티쓰레드** 환경에서 동기화 처리를 안하면 인스턴스가 2개가 생성된다든지 하는 경우가 발생할 수 있다.

## 싱글턴 패턴 예제

```kotlin

        @InternalCoroutinesApi
        fun getDatabase(context: Context): SignUpDatabase {

            val temInstance = INSTANCE
            if (temInstance != null) {
                return temInstance
            }
            kotlinx.coroutines.internal.synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SignUpDatabase::class.java,
                    "sign_up"
                ).build()

                // 다른 쓰레드에 권한을 못줌
                // thread 를 동기화 하기 위해서 제공
                // 스레드는 synchronized 메소드에 들어가기 위해 lock 을 얻고 메소드가 끝이나면 lock 을 반환
                INSTANCE = instance
                return instance

            }

   } 
   ```
   > 이런식으로 자기자신의 클래스를 인스턴스로 갖고 있고 getInstance()대상 instance를 초기화 후 리턴하는 패턴이다.

## synchronized 이란 무엇인가?

> **synchronized**는 공유 데이터를 사용하는 코드 영역을 임계 영역으로 지정해놓고, 공유 데이터(객체)가 가지고 있는 lock을 획득한 단 하나의 스레드만 이 영역 내의 코드를 수행할 수 있게 해준다.
>> **이처럼 한 스레드가 진행 중인 작업을 다른 스레드가 간섭하지 못하도록 막는 것을 스레드의 동기화 라고 한다.**

## volatile 이란 무엇인가?

- volatile 키워드는 java변수를 Main Memory에 저장하겠다는 것을 명시 하는 것
> 즉 매번 변수의 값을 **Read**할 때마다 CPU cashe에 저장된 값이 아닌 Main Memory에서 읽는 것입니다. <br>
> 또한 변수의 값을 **Write**할 때마다 Main Memory에 까지 작성하는 것입니다.

## volatile 이 왜 필요할까?

- volatile 변수를 사용하고 있지 않는 MultiThread 어플리케이션에서는 Task를 수행하는 동안 성능 향상을 위해 Main Memory에서 읽는 변수 값을 CPU Cache에 저장하게 됩니다.
> 만약 MultiThread환경에서 Thread가 변수 값을 가져올때 각각의 CPU Cache에 저장된 값이 다르기 때문에 변수 값불일치 문제가 생길 수 있습니다.

## volatile 주의할 점

> 하나의 Thread가 아닌 여러 Thread가 Write하는 상황에서는 적합하지 않습니다.
>여러 Thread가 write하는 상황이라면
  >> - synchroized를 통해 read*write의 원자성(automic)을 보장해야 합니다.