class QuickSort {
    fun quickSort(array: IntArray, start: Int, end: Int) {
        if (start >= end) return
        val pivotValue = array[end]

        var left = start
        var right = end - 1

        while (left < right) {
            while (array[left] <= pivotValue && left < right) left++
            while (array[right] > pivotValue && right > left) right--

            if (left < right) swap(array, left, right)
        }

        if (array[left] > pivotValue) swap(array, left, end)

        quickSort(array, start, left - 1)
        quickSort(array, left + 1, end)
    }


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