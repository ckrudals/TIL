# Dagger2 어떻게 쓸까??

### Dagger2란
Dagger2를 알기전에 먼저 **DI**(Dependency Injection)를 먼저 알아야 한다.

[DI 정리](di.md)

클라이언트랑 서비스랑 연결해준다?? 



## Dagger2 용어

###   Inject 
- 의존성 주입을 요청한다 (DI를 주입당함).
-  Inject로 주입이 요청되면 Component가 Module로부터 객체를 생성하여 넘겨준다.
-  
### Component
-   연결된 Module를 이용하여 의존성을 생성하고, Inject에 요청받은 인스턴스에 생성된 객체를 주입한다. 
-   의존성을 요청받고 주입하는 Dagger의 주된 역할이다. (Inject -> Component) (Component -> Provides)
-    Inject와 prvides 사이의 연결다리이다.

### SubComponent
- inner Class의 방식의 하위계층 Component이다
- Dagger의 중요한 컨셉인 그래프를 형성한다
- Inject로 의존성 주입 요청을 받으면 SubComponent 로 먼저 의존성을 검색하고 부모로 올라간다
### Module
- Component에 연결되어 의존성 객체를 형성한다. Scope에 관리 되기도한다.



### Scope
- 생성된 객체의 Lifecycle이다 (Activity,Fragment)
- Module에서 Scope를 보고 객체를 관리한다.
###  Provides 
  - Di를 주입한다.
  
Component에 Inject Provides Module이 다있는건가 ??

Inject 에는
constructor Injection과 Field Injection 이 있다.
> Method Injection