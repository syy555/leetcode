package cat.leetcodes


class test1 {

    fun test1() {
        test2("1",
                {
                },
                {

                })
    }

    private inline fun test2(string: String, dosth: (index: Int) -> Unit, dosth2: (index: Int) -> Unit) {
        dosth(1)
    }

}

