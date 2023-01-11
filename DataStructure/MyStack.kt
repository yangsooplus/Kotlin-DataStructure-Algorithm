class MyStack<E>() {
    private val queueA = ArrayDeque<E>()
    private val queueB = ArrayDeque<E>()

    fun push(e: E) {
        while (queueA.isNotEmpty()) {
            queueB.addLast(queueA.removeFirst())
        }
        queueA.addLast(e)
        while (queueB.isNotEmpty()) {
            queueA.addLast(queueB.removeFirst())
        }
    }

    fun pop(): E {
        return queueA.removeFirst()
    }
}
