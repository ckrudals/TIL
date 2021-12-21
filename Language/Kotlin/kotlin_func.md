### first 함수

컬렉션 인자 중에서 첫번째를 return 한다.

### last 함수

컬렉션 인자 중에서 마지막 인자를 return 한다.


### repeat 함수

어떤 문자열을 주어진 횟수만큼 반복한다, 또한 어떤 함수를 주어진 횟수만큼 반복한다.  


``` kotlin
fun main() {
    println("A".repeat(5)) // 1

    repeat(5) { // 2
        print("B")
    }
}
```

``` kotlin
AAA
BBB
```

### sortedDescending()

내림차순 정렬

### replace()

String에서 찾고자 하는 문자열이 있으면 다른 문자열로 치환한다.

```kotlin
    val data="HELLO"
    print( data.replace("H","F"))

// FELLOW가 찍힌다.
```

### indices
배열의 값 알수있다.


### substring
문자열 자르는 함수
```kotlin
val s="hello"
print(s.substring(0..1))
```
### average

평균 구하는 함수


### fold
컬렉션 내의 데이터를 모으는 함수

```kotlin
val sumTotal = listOf(1,2,3,4,5).fold(0,{total,next -> total + next})
println("sumTotal : ${sumTotal}" )
// sumTotal : 15
```
초기값을 설정할 수 있고, 1부터 5까지 더한 15가 나온다.


### jotinToString
배열 -> String으로 변환

### zip

두 List를 묶어 줄 수 있는 함수.

### partition
어떤 원소에 특정 조건을 걸어서 부합하거나, 부합되지않는 것 이렇게 두리스트로 나뉘어진다.
first에는 부합된 list, 부합되지 않은 것은 second로 간다.
```kotlin
fun main() {
    val a: List<Int> = listOf(1, 2, 3, 4, 5, 6)

    val partition = a.partition { it % 2 == 0 }

    println(partition.first)   // 조건에 만족하는 녀석들
    println(partition.second)  // 조건에 만족하지 않는 녀석들
}
[2, 4, 6]
[1, 3, 5]
```