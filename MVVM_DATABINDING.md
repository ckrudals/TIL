DI 를 쓰는 이유는 간단히 말해서 테스팅을 하기 위해서라 말할 수 있다.
ViewModel를 만약 테스트를 해보자고 하자 그러면 ViewModel 이 의존하고 있는 Model은 어떻게 만들어서 ViewModel 에 줘야 테스팅을 할 수 있을까?
바로 ViewModel 에 Model를 생성자를 주는 것이다.

Model은 retrofit2의 GET으로 받아오는 함수, room insert 함수 등 을 들 수 있겠다.

의존성 주입에 나는 Dagger-Hilt를 겉햟기 정도로 알 고 있다.
그래서 이참에 koin도 배워 보도록하자

마인드로직에는 koin을 씀

koin의 어노테이션

applicatin Context context를 주입한다.
bean 싱글톤 컴포넌트를 선언한다. DaggerHilt의 Provide Singlton 인가 ?
factory 인스턴스를 가져올 Factory 패턴을 선언하여 inject 할 때 마다 새로운 인스턴스를 가져오도록 한다. Dagger-Hilt의 생성자 injet 랑 똑같나 ?
bind 종속시킬 class나 interface를 주입한다. AndroidHiltScope엿나 Dagger-Hlit에는
get  - been이나 factory를 통해 컴포넌트를 가져온다.
