## map() 함수

map() 함수는 입력값을 어떤 함수에 넣어서 원하는 값으로 변환하는 함수

String -> String Or String -> Integer 등등

객체지향 프로그래밍과 다른 점은 '어떤 화면에 넣어서' 이다.

map() 함수는 입력 데이터와 그것을 변환해줄 함수를 이어주는 중개업자가 있다고 생각하면 편하다.

> map() 함수의 마블 다이어그램
<img src="../Images/map.png" with="500dp" height="250dp">

원을 받아서 다이아로 변환한다.

자바(코틀린) 은 포인터가 없기 때문에 함수에 '넣어서' 사용 못한다.

그래서 Rx를 쓴다.

아래는 마블 다이어그램 형식으로 코드를 쓴 것이다.

```kotlin
class MapExampleKotlin {
    fun emit(){
        val balls= arrayOf("1","2","3","4","5")
        val source = Observable.fromArray(*balls)
            .map { ball -> "$ball🤍" }
        source.subscribe{data -> println(data)}
    }
}

fun main() {

    val demo=MapExampleKotlin()
    demo.emit()

}
```

``` 결과
1?
2?
3?
4?
5?
```

```
아마도 ?는 🤍이 인식하지 못해 뜨는 것 같다.
```



Function 인터페이스 형식 
```  kotlin
// 오류
//class MapFunctionKotlin {
//    fun mapFunction() {
//        val getDiamond = Functㄴion<String, String> { ball -> "$ball◇" }
//
//        val balls = arrayOf("1", "2", "3", "5")
//        val source = Observable.fromArray(*balls)
//            .map(getDiamond)
//        source.subscribe { data -> println(data) }
//    }
//}
//
//fun main() {
//    val demo = MapFunctionKotlin()
//    demo.mapFunction()
//
//}
```
```결과
???
```
