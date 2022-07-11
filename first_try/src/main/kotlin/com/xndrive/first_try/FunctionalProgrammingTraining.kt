class FunctionalProgrammingTraining {
    
    private fun functionTidakUrutParameternya(param1 : String, param2: String, param3 : String){}
    private fun functionYangMemilikiNilaiDefault(param1 :String = "ini default nilai param1", param2 : String = "ini default nilai param2"){}
    private fun functionDenganVararg(vararg param1 : Int) = param1.sum()
    private fun functionDenganVararg2(vararg param1 : String) = param1
    private fun functiodDenganVararg3(vararg param1 : String): List<String> {
        val list1 = ArrayList<String>()
        for (item in param1) {
            list1.add(item)
        }

        return list1
    }

    fun debuggingFunctionalProgramming(){
        functionTidakUrutParameternya(param3 = "ini param 3", param2 = "ini param 2", param1 = "ini param 1") //caranya manggil fungsinya kalo gak urut
        functionYangMemilikiNilaiDefault() //kalo kosong gini semua parameternya pakai nilai default
        functionYangMemilikiNilaiDefault(param2 = "override nilai dari param2") //kalo salah satu kayak gini maka, nila satunya yang ngikutin nilai default
        println("ini output manggil fungsi vararg: ${functionDenganVararg(10,20,1,12)}")
        println("ini output manggil fungsi vararg2: ${functionDenganVararg2("halo")}")

        //memasukan array int kedalam parameter vararg
        val array_intejer_boy = intArrayOf(10,120,20,10)
        val total = functionDenganVararg(10,23,213,*array_intejer_boy, 100) //gini caranya, nambah *sebelum variable

        println("ini output menyusun list dengan menggunakan vararg: ${functiodDenganVararg3("brug", "heyo", "hahaha").toString()}")

    }

    //Extension Function and properties
    //Digunakan untuk menambahkan sebuah fungsi/properties tambahan kedalam sebuah kelas yang ada
    fun Int.fungsiTambahanPrint(){
        println("bernilai: $this")
    }

    val Int.bagi_setengah : Int  get() = this / 2
    val FunctionalProgrammingTraining.property_tambahan : String get() = "ahoy"

    fun debuggingExtensionFunctionAndProperties(){
        1000.fungsiTambahanPrint()
        20.bagi_setengah

        println("coba: ${this.property_tambahan}")

    }


}