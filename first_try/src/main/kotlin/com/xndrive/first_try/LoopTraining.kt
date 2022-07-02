
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

    }
}