### first 함수

컬렉션 인자 중에서 첫번째를 return 한다.

### last 함수

컬렉션 인자 중에서 마지막 인자를 return 한다.


### repeat 함수

어떤 문자열을 주어진 횟수만큼 반복한다, 또한 어떤 함수를 주어진 횟수만큼 반복한다.  ㅇ


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

### jotinToString
배열 -> String으로 변환



