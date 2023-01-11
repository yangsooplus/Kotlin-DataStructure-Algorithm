class MyQueue<E>() {
    private val stackA = ArrayDeque<E>()
    private val stackB = ArrayDeque<E>()

    fun enqueue(e: E) {
        stackA.addLast(e)
    }

    fun dequeue(): E {
        if (stackB.isEmpty()) {
            while (stackA.isNotEmpty()) {
                stackB.addLast(stackA.removeLast())
            }
        }
        return stackB.removeLast()
    }
}
