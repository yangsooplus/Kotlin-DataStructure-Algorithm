
## Array 
- Array 선언 시 지정한 크기가 고정적
- 중복 허용. 순서 있음
- 메모리 공간이 연속적으로 구성
![[Pasted image 20230102175910.png]]

시간 복잡도
|접근|탐색|삽입|삭제|
|------|---|---|---|
|O(1)|O(n)|O(n)|O(n)|


## List
- 저장 공간이 가변적

## ArrayList
```
public class ArrayList<E> extends AbstractList<E>  
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable
```

- 내부적으로 Array를 이용해 요소를 저장
- 저장 공간이 가변적
	- 단, 배열의 요소를 복사해서 새 배열로 옮기는 과정이 동일함
- 그럼 왜 씀?
	- 개발자가 Array를 가변적으로 사용할 수 있다 (일단 눈에 보이는 정도는..)
	- List 인터페이스를 구현하고 있음. List의 메서드 사용 가능

|접근|탐색|삽입|삭제|
|------|---|---|---|
|O(1)|O(n)|O(n)|O(n)|


### Vector와 ArrayList
- 크기가 동적인 배열

차이점: 동기화(Synchronize)
	Vector는 한 번에 하나의 스레드만 접근 가능, ArrayList는 여러 스레드가 접근 가능
	ArrayList에서 여러 스레드에서 접근하는 경우 명시적으로 동기화 해야함
	→ Vector는 Thread-Safe
	→ ArrayList는 동기화 되지 않아 Vector보다 빠름

배열 크기 변화되는 정도도 다르긴 하다.
- Vector: 현재 배열 크기의 100% 증가
- ArrayList: 현재 배열 크기의 50% 증가

Vector는 레거시 클래스. 이왕이면 ArrayList에서 동기화를 직접 구현해서 사용하라는 의견도 있음

## LinkedList

```
public class LinkedList<E>  
    extends AbstractSequentialList<E>  
    implements List<E>, Deque<E>, Cloneable, java.io.Serializable
```

- 노드를 활용하여 저장 공간이 가변적
- 원소 삽입/삭제 시 저장 공간 재할당 필요X. next, prev 만 수정
- 순차적 접근 → O(n)

|접근|탐색|삽입|삭제|
|------|---|---|---|
|O(n)|O(n)|O(1)|O(1)|

- 코틀린은 LinkedList를 제공하지 않음.
- 이유는... 아래 링크 참고해서 정리해두기 (먼 말인지 모르겠음)

https://discuss.kotlinlang.org/t/why-kotlin-does-not-provide-linkedlist-implementation/15991/12
https://blog.logrocket.com/arraylist-vs-linkedlist-kotlin-data-structure/
