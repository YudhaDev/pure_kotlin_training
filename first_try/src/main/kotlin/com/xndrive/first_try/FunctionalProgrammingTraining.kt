import kotlin.text.replaceFirst

typealias SebuahFungsiKali = (Int, Int) -> Int

typealias SebuahFungsiPrinKeString = (Int, Int) -> String

typealias SebuahFungsiNullable = ((Int, Int) -> String)?

class FunctionalProgrammingTraining {

    private fun functionTidakUrutParameternya(param1: String, param2: String, param3: String) {}
    private fun functionYangMemilikiNilaiDefault(
            param1: String = "ini default nilai param1",
            param2: String = "ini default nilai param2"
    ) {}
    private fun functionDenganVararg(vararg param1: Int) = param1.sum()
    private fun functionDenganVararg2(vararg param1: String) = param1
    private fun functiodDenganVararg3(vararg param1: String): List<String> {
        val list1 = ArrayList<String>()
        for (item in param1) {
            list1.add(item)
        }

        return list1
    }

    fun debuggingFunctionalProgramming() {
        functionTidakUrutParameternya(
                param3 = "ini param 3",
                param2 = "ini param 2",
                param1 = "ini param 1"
        ) // caranya manggil fungsinya kalo gak urut
        functionYangMemilikiNilaiDefault() // kalo kosong gini semua parameternya pakai nilai
        // default
        functionYangMemilikiNilaiDefault(
                param2 = "override nilai dari param2"
        ) // kalo salah satu kayak gini maka, nila satunya yang ngikutin nilai default
        println("ini output manggil fungsi vararg: ${functionDenganVararg(10,20,1,12)}")
        println("ini output manggil fungsi vararg2: ${functionDenganVararg2("halo")}")

        // memasukan array int kedalam parameter vararg
        val array_intejer_boy = intArrayOf(10, 120, 20, 10)
        val total =
                functionDenganVararg(
                        10,
                        23,
                        213,
                        *array_intejer_boy,
                        100
                ) // gini caranya, nambah *sebelum variable

        println(
                "ini output menyusun list dengan menggunakan vararg: ${functiodDenganVararg3("brug", "heyo", "hahaha").toString()}"
        )
    }

    // Extension Function and properties
    // Digunakan untuk menambahkan sebuah fungsi/properties tambahan kedalam sebuah kelas yang ada
    fun Int.fungsiTambahanPrint() {
        println("bernilai: $this")
    }

    val Int.bagi_setengah: Int
        get() = this / 2
    val Int?.bagi_empat: Int
        get() = if (this == null) 0 else this / 3 // bisa juda untuk nullable
    val Int?.bagi_lima: Int
        get() = this?.div(5) ?: 0 // bisa juda untuk nullable + elvis operator
    val FunctionalProgrammingTraining.property_tambahan: String
        get() = "ahoy"

    fun debuggingExtensionFunctionAndProperties() {
        1000.fungsiTambahanPrint()
        20.bagi_setengah

        println("coba dengan nilai null: ${null.bagi_empat}")
        println("coba dengan nilai null + elvis operator: ${10.bagi_lima}")
        println("coba: ${this.property_tambahan}")
    }

    // Funtion Type
    // Fungsi sebagai tipe data pada variabel
    val implementasi_hasil_kali: SebuahFungsiKali = { IntA, IntB ->
        IntA * IntB
    } // baris ini gunanya untuk implement dari typealias yang sudah tertulis diatas(paling atas)
    val implementasi_ke_string: SebuahFungsiPrinKeString = { intA, intB ->
        intA.toString() + "==" + intB.toString()
    }
    val implementasi_fungsi_nullable: SebuahFungsiNullable = { intA, intB ->
        "isinya $intA dan $intB"
    }
    fun debuggingFunctionType() {
        println("=====debugging function type====")
        println("hasil kali: ${implementasi_hasil_kali.invoke(10, 2)}")
        println("hasil ke string: ${implementasi_ke_string.invoke(10, 2)}")
        println("hasil nullable: ${implementasi_fungsi_nullable?.invoke(10, 2)}")
    }

    // Lambda
    // Fungsi yang tidak memiliki nama
    val sebuahLambda = { println("Halo ini fungsi lambda simpel") }
    val sebuahLambdabaru = { pesan: String, pengirim: String ->
        println("Isi pesan: $pesan, dikirim oleh: $pengirim")
    }

    fun debuggingLambda() {
        sebuahLambda()
        sebuahLambdabaru("halo selamat pagi", "Yudha")
    }

    // High Order Function
    val sebuah_high_order: (String, String) -> String = { nama_karakter, sekolah ->
        "$nama_karakter bersekolah di $sekolah"
    }

    fun arsip_biru_dengan_high_order(
            nama_arsip: String,
            nama_karakter: String,
            nama_sekolah: String,
            high_order: (String, String) -> String
    ) {
        println("$nama_arsip" + high_order(nama_karakter, nama_sekolah))
    }

    fun debuggingHighOrder() {
        arsip_biru_dengan_high_order("Blue Archive", "Shiroko", "Abydos", sebuah_high_order)
    }

    // Lambda dengan receiver
    /*
    Menyingkat kode dibawah
    fun buildString(): String {
        val stringBuilder = StringBuilder()
        stringBuilder.append("Hello ")
        stringBuilder.append("from ")
        stringBuilder.append("lambda")
        return stringBuilder.toString()
    }
    */

    fun membangunString(aksi: StringBuilder.() -> Unit): String {
        val stringBuilder = StringBuilder()
        stringBuilder.aksi()
        return stringBuilder.toString()
    }

    fun debuggingLambdaReceiver() {
        val sebuahRangkaianString = membangunString {
            append("aku ")
            append("adalah ")
            append("aku ")
        }
        println("Debugging lambdaReceiver: $sebuahRangkaianString.toString()")
    }

    // scope function dengan lambda reciver
    fun debuggingScopeFunLambdaReceiver() {
        val sebuahText = "halo aku text"

        val hasilText =
                sebuahText
                        .run { // run menghasilkan sebuah kembalian, jadinya variable asal nilainya
                            // tidak berubah
                            this.replace("text", "ahoy")
                        }

        with(
                sebuahText
        ) { // with lebih ke meringkas kodingan saja dengan mengubah kodingan yang di dalam kurung
            // mnejadi this
            println("debug dengan menggunakan with: $this")
        }

        val debugApply =
                StringBuilder().apply { // apply cocoknya untuk sebuah object hasil instansiasi
                    append("halo aku yudha,")
                    append("hobby saya adalah menggambar dan coding")
                }

        val debugLet: String? = "debug let"

        debugLet?.let { println("isi dari debug let: $it") }
                ?: let { println("nilai bernilai null") }

        val debugAlso =
                debugLet.also { // also cocoknya untuk melakukan sesuatu tanpa mengubah nilai dari
                    // variablenya
                    println("didalm also: " + it?.replaceFirst("let", "also") ?: "nilainya null")
                }

        println("debug also: $debugAlso")

        println("====Debugging Scope Function Lambda====")
        println(hasilText)
        println(sebuahText)
        println(debugApply)
    }
}
