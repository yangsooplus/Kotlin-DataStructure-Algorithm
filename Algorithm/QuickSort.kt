class QuickSort {
    fun quickSort(array: Array<Int>, start: Int, end: Int) {
        if (start < end) {
            val criteria = partition(array, start, end)
            quickSort(array, start, criteria - 1)
            quickSort(array, criteria + 1, end)

        }
    }

    private fun partition(array: Array<Int>, start: Int, end: Int): Int {
        val pivot = array[end]
        var low = start
        var high = end - 1


        while (true) {
            while (array[low] <= pivot && low < end - 1) {
                low++
            }

            while (array[high] > pivot && high > start) {
                high--
            }

            if (low < high) {
                swap(array, low, high)
            } else {
                break
            }
        }
        swap(array, high, end)
        return high
    }

    private fun swap(array: Array<Int>, a: Int, b: Int) {
        val tmp = array[a]
        array[a] = array[b]
        array[b] = tmp
    }
}