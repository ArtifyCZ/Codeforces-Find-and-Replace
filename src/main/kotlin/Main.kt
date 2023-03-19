enum class InnerRes {
    EVEN, ODD, NOT_COUNTED
}

// solution for https://codeforces.com/contest/1807/problem/C
fun main() {
    (1..readln().toInt()).forEach { _ ->
        readln().toInt()
        val s = readln().trim()
        var answer = true
        for (i in (0x61..0x7a)) {
            if(!answer) break

            val c = i.toChar()

            s.mapIndexed { idx, it -> if(it == c) {
                if(idx % 2 == 0) InnerRes.EVEN else InnerRes.ODD
            } else InnerRes.NOT_COUNTED }
                .reduce { prev, it ->
                    if(it == InnerRes.NOT_COUNTED) prev
                    else if(prev == InnerRes.NOT_COUNTED) it
                    else if(prev == it) prev
                    else {
                        answer = false
                        return@reduce prev
                    }
                }
        }

        println(if(answer) "YES" else "NO")
    }
}
