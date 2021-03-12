# Intent
## 첫번째 방식

안드로이드 에서는  데이터를 전달할 때 key value 방식으로 넘긴다.
보통 

~~~ 
val intent= Intent(this, Activity::class.java) 
~~~
식으로 화면을 전달 할때
**putExtra** 을 사용해 넘겨준다.
이때 쓰는 방식이 __key__ __value__ 방식이다.

~~~ 
val intent= Intent(this, Activity::class.java) 
intent.putExtra("key",value)
~~~
key는 이름이고 value는 값이다.


데이터를 받을 때는 타입을 명시적으로 지정해야한다.

전달할 때 단순 putExtra로 전달 하는게 아닌, `getIntExtra,getStringExtra 등등` 받아온다.

``` 
val variable= intent.getSttringExtr("key", 0)
``` 
***
## 2번째 방식

~~~
val intent2=Intent(this,Activity::class.java)
intent2.apply{
    getSttringExtr("key", 0)
}
~~~

**Apply** 란 <br> 수신 객체 람다 내부에서 수신 객체의 함수를 사용하지 않고 수신 객체 자신을 다시 반환 하려는 경우에 apply 를 사용한다.

--- 
## 암시적 Intent
~~~
val intent=Intent(Intent.ACTION_VIEW,URI.PARSE("http://naver.com))
~~~
암시적 Intent란 -> 대상이 명확하지 않을 때 쓴다.
ex) 네이버 를 열때, 크롬, 웨일 등등 명확하지 않을 때 쓴다.
