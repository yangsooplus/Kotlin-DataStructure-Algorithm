class QuickSort {
    fun quickSort(array: Array<Int>, start: Int, end: Int) {
        if (start < end) {
            val criteria = partition(array, start, end)
            quickSort(array, start, criteria - 1)
            quickSort(array, criteria + 1, end)
        }
    }

    private fun partition(array: Array<Int>, start: Int, end: Int): Int {
        var i = start - 1
        val pivot = array[end]

        for (j in start until end) {
            if (array[j] <= pivot) {
                swap(array, ++i, j)
            }
        }

        swap(array, i + 1, end)
        return i + 1
    }

    private fun swap(array: Array<Int>, a: Int, b: Int) {
        val tmp = array[a]
        array[a] = array[b]
        array[b] = tmp
    }
}