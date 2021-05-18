## MutubleList 와 List의 차이

 Android 코드를 짜다가 어떤건 List로 되고 어떤건 MutubleList로 되는게 있어서
 이게 도대체 무슨 차이가 있는지 궁금해서 찾아보았다.

 ### List -> 읽기전용으로 수정이 불가능하다.

 remove, add 함수를 사용하지 못한다.
 
 ### MutubleList -> 수정할 수 있는 List다.

ArrayList 와 유사하므로 ArrayList에서 사용하는 함수들을 모두 사용할수 있다.
 
또한 List를 MutableList로 변경, MutableList를 List로 변경할 수 있다.