/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package com.xndrive.first_try

import java.util.Arrays
import com.andreapivetta.kolor.*

fun main(args: Array<String>) {
    println(App().greeting)
    App().showSomeAmazingWords()
    print(App().sebuahFungsiYangUnik("Nama saya Yudha", "dan saya suka coding")+"\n")
    App().sebuahFungsiYangBiasa("Halo saya Adi")

    App().sebuahFungsiDebuggingTipeData()
    App().readAbleNumberTest()
    App().bermainDenganArray()

    App().bermainDenganSafeNull()
    App().bermainDenganStringTemplate()

    EnumTry().printEnumBasic()
}

class App {
    val greeting: String
        get() {
            return "Hello world."
        }
    var sebuahSapaanYangRamah: String = "Selamat Pagi"
    val sebuahBarisYangRapi: String =
            """
        Baris 1
        Baris 2
        Baris 3
        Baris 4
        Baris 5
    
    """.trimIndent()

    fun sebuahFungsiYangBiasa(words: String) {
        println("Ini output dari Fungsi yang Biasa: $words") // atau bisa dengan cara dibawah
        println("Ini output dari Fungsi yang Biasa II: " + words)
        println("")

    }
    fun sebuahFungsiYangUnik(words: String, wordsII: String) =
            "Ini merupakan hasil output dari Fungsi yang Unik: $words, $wordsII \n"

    fun showSomeAmazingWords() {
        print("Hello Kotlin\n")
        println("Mari belajar Kotlin bersama")
        print(sebuahSapaanYangRamah + " dan " + "Tetap semangat jangan menyerah. \n")
        println("Ini output dari Baris yang Rapi: \n" + sebuahBarisYangRapi)
        println("")

    }

    fun sebuahFungsiDebuggingTipeData(){
        println("Nilai maksimal int: "+Int.MAX_VALUE)
        println("Nilai minimum int: "+Int.MIN_VALUE)
        println("Nilai maksimal double: "+Double.MAX_VALUE)
        println("Nilai minimum int: "+Double.MIN_VALUE)
        println("")

    }

    fun readAbleNumberTest(){
        val readable_number = 1_100_999_21_1
        println("Output dari Readable Number Test: "+readable_number.toString()+" yang merupakan tipe data dari: "+readable_number::class.java.typeName)
        println("")

    }

    fun bermainDenganArray(){
        val arrCampuran = arrayOf(1,3,6, "a", "d", 9.1)
        val arrInt = intArrayOf(1,2,3,4,5,6)
        val arrDenganLambda = Array(10) { a -> a+1+15 }

        println("Output dari bermain dengan Array:")
        println(Arrays.toString(arrCampuran))
        println(Arrays.toString(arrInt))
        println(Arrays.toString(arrDenganLambda))
        println("")
    }

    fun bermainDenganSafeNull(){
        var sebuah_variable_nullable : String? = null
        var sebuah_variable_non_null : Int = sebuah_variable_nullable?.length ?: 10 //defaultnya 10 kalo null

        // sebuah_variable_nullable = "Bola adalah teman"

        println("Output dari fungsi bermain dengan safe null")
        println(sebuah_variable_nullable)
        println(sebuah_variable_non_null)
        println(sebuah_variable_nullable?.length)
        println(sebuah_variable_nullable?.length?:10)

        println("")

    }

    fun bermainDenganStringTemplate() {
        var jam = 7

        println("Toko sedang ${if(jam >7) "tutup" else "buka"}")
        // print("Office ${if (jam > 7) "already close" else "is open"}")
        println("")
    }
}

class EnumTry{
    fun printEnumBasic(){
        println("Hasil output dari Enum Training".yellow())
        println(Kolor.foreground("Ini text warna merah.", Color.RED))
        println(EnumTraining.HIJAU)
        println(EnumTraining.BIRU)
        
    }
}

enum class EnumTraining(val warna : Int) {
    MERAH(0xFF0000),
    HIJAU(0x00FF00),
    BIRU(0x0000FF)
}
