# MVVM 패턴이란 무엇일까? 🤔

 
#### 이 MarkDown 는 [To-Do App & Clean Architecture -Android Development - Kotlin](https://www.udemy.com/course/to-do-app-clean-architecture-android-development-kotlin/#instructor-1) 강의를 참고하여 만들었습니다.


<br>

  # MVVM 패턴이란 무엇인가? 😀
  <h2> MVVM 이란  View **ViewModel Model이 결합된 형태로, 각각의 역할을 분리하여, 가독성과 재사용성을 높인 디자인 패턴이다 </h2>

  
<br>

> MVC와 MVVM의 차이점..
<img src="190316-mvc-mvvm.png">
<br>

# MVVM 패턴을 왜 공부해야 할까? 🙄

<h3>내가 맨처음 시작했을 때, 액티비티안에 모든 기능 소스를 넣었다.<br>
 그러다 보니 앱이 무거워지고, 어디에 무엇을 수정해야할지 참 골치 아팠다.
이렇게 코드를 게속 짜다 보니 디자이 패턴 의 필요성을 알게 되었고, 
*Android* 개발할 때 흔히 쓰인다고 하는 **MVVM** 패턴에 대해 알아봤다.</h3>

----------

<br>

# AAC MVVM 패턴의 구성요소와, 기능들 😄


 
  ## View

- <h3> 안드로이드의 **UI** 를 담당하는 프래그먼트, 액티비티를 의미한다.</h3> 
- <h3>화면에 그릴 것을 결정하고, 사용자와 상호작용 한다.</h3>
- <h3>데이터 변화를 감지하는 옵저버를 가지고 있다. </h3>

<h2> ViewModel</h2>

- <h3>**UI**를 그리는 데이터를 가지고 있으며, 변경되어도 괜찮다.</h3>

> 예제 소스
<h3>

```
@InternalCoroutinesApi
class ToDoViewModel(application: Application) : AndroidViewModel(application) {

    private val toDoDao = ToDoDatabase.getDatabase(
        application
    ).toDoDao()
    private val repository: ToDoRepository = ToDoRepository(toDoDao)
    val getAllData: LiveData<List<ToDoData>> = repository.getAllData


    fun insertData(toDoData: ToDoData) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertData(toDoData)
        }
    }

    fun updateData(toDoData: ToDoData) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateData(toDoData)
        }
    }

    fun deleteItem(toDoData: ToDoData) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteItem(toDoData)
        }
    }

    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()
        }
    }

}
```
</h3>

<h2> LiveData</h2>

- <h3>**Observer** 형식으로, 데이터 변경이 일어나면 감지가 가능하다.</h3>
- <h3>**UI** 와 데이터를 일치 시킬 수 있다.</h3>

<h2> Repository </h2>

- <h3>뷰모델과 상호작용하기 위해 잘 정리된(Clean) 데이터 API를 들고 있는 클래스이다. 앱에 필요한 데이터, 즉 내장 데이터베이스나 외부 웹 서버 등에서 데이터를 가져온다. 따라서 뷰모델은 DB나 서버에 직접 접근하지 않고, 리포지토리에 접근하는 것으로 앱의 데이터를 관리한다. </h3>

<h2> Room </h2>

- <h3>*Room 은 SQLlite 의 상위 버전으로, 더 직관이고 편리하게 DB를 사용할 수 있다. </h3>

<h2> Koin</h2>

- 공부중..

---
# MVVM 패턴의 장점은 무엇일까? 😀

- 1.  <h3>View가 data를 실시간으로 관찰이 가능해, 데이터와 불일치 확률을 줄여준다. (LiveData)  </h3>
- 2. <h3> 뷰모델을 통해 데이터를 참조하기 때문에 액티비티/프래그먼트의 생명주기를 따르지 않는다. 화면전환과 같이 액티비티가 파괴된 후 재구성 되어도 뷰모델이 데이터를 홀드하고 있기 때문에 영향을 받지 않는다. 또한 뷰가 활성화되어있을 경우에만 작동하기 때문에 불필요한 메모리 사용을 줄일 수 있다.</h3>
- 3.  <h3>기능별로 모듈화 되어있어, 역할 분리할수 있고 테스트 하기 쉽다.</h3>
  


# MVVM 패턴의 단점은 무엇일까? 😖

- <h3>MVVM 패턴의 단점은 class를 많이 만들어야하고, 서로 코딩하여 연결 시켜주어야 한다. 이 과정이 복잡해지면 시간이 많이 든다.</h3>


---
# 마무리..

<h3>MVVM 패턴을 공부하면서, 무척 편리하게 쓸 수 있다는걸 배웠다. 
<br>
MVVM 패턴 뿐만아니라 MVP, MVC 등 여러 디자인 패턴을 추가로 배워 상황에 따라 유동적으로 쓸수 있도록 공부해야 겠다.</h3>











