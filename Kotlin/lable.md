

#### lable


 lable이란, 만약 i=1이고 j=가 2 면 종료 된다는 코드를 써보도록 하자

 예를 들어 다른 언어에서는
```
 for (i in 1. .10){ 
            for (j in 1..10 {
                if (i == 1 && j == 2) break
        
    } 
 }
 ``` 


 이렇게 해줘야 하지만
 코틀린에서는
```
loop@ for(i in 1..10){
for(j in 1..10{
if(i==1 && j==2) break @loop를 사용하면 된다.
   }
} 
 ```

 


 
