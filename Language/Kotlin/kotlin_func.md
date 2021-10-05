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


