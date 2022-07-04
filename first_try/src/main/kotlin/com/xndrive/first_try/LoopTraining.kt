
class LoopTraining{

    fun rangedLoop(){
        val rangedVal = 10.downTo(0) //atau
        val rangedChar = 'A'.rangeTo('Z')
        var arrString = arrayOf("A", "P", "C", "Z")

        if (7 in rangedVal) {
            println("7 tersedia didalam rangedval")
        }

        if('B' in rangedChar){
            println("B tersedia didalam rangedChar")
        }

        if("C" in arrString){
            println("C tersedia didalam arrString")
        }

        //////
        rangedLoopWithStep()
    }

    fun rangedLoopWithStep(){
        val rangedInt = 0.rangeTo(10) step 2

        for (bruh in rangedInt) {
            println("nilai bruh sekarang: $bruh")
        }

        loopWithContinue()

    }

    fun loopWithContinue(){
        println("Hasil kembalian loopwithcontinue: ")

        val sebuah_array = arrayOf("aku", null, 1,8, true, "aha", false)

        for(isi in sebuah_array){
            if(isi == null) continue //continue tujuannya ialah untuk skip nilai dalam pengkondisian
            print(isi.toString())
            if(isi == sebuah_array.lastIndex) println()
        }

        loopWithForeachindexed(sebuah_array)
    }

    fun loopWithForeachindexed(array : Array<*>){

        println("Output kembalian fungsi loopwithforeachindexed: ")
        array.forEachIndexed { index, _test ->
            println("index: $index, dengan nilai: "+_test)
        }

        loopWithBreak()
    }

    fun loopWithBreak(){
        println("ini output fungsi loopwithbreak: ")
        var array1 = 10..100
        var array2 = 'A'..'Z'

        inipenanda@ for ((i, nilai) in array1.withIndex()) {
            println("ini array luar dengan nilai: $nilai dengan indeks: $i")

            for ((j, nilai) in array2.withIndex()) {
                if(nilai > 'D') break@inipenanda //ini digunakan untuk break loop yang luar juga sesuai dengan nama penandanya
                println("ini array dalam dengan nilai: $nilai dengan indeks: $j")
            }

            if(nilai > 20) break
        }
    }
}