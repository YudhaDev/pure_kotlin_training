import kotlin.system.measureTimeMillis
import kotlinx.coroutines.*

class PraktekCoroutine {
    suspend fun getNilaiA(): Int {
        delay(1000)
        return 12
    }

    suspend fun getNilaiB(): Int {
        delay(1012)
        return 22
    }

    fun PraktekMembuatJob(){
        //job yg langsung jalan
        runBlocking {
            val job1 = launch {
                
            }
        }

        //job yg tidak langsung jalan melainkan menunggu sampai kita perintahkan untuk jalan

        //menjalankan job dengan start()
        runBlocking{
            val job2 = launch(start = CoroutineStart.LAZY){
                delay(1000)
                println("Job2 berhasil dijalankan")
            }

            job2.start() //untuk memulai job dan tidak menunggu job tersebut selesai untuk mengeksekusi baris selanjutnya
            println("sebuah kata setelah job2")
        }

        //menjalakan job dengan join()
        runBlocking{
            val job3 = launch(start = CoroutineStart.LAZY){
                delay(1000)
                println("Job3 berhasil dijalankan")
            }

            job3.join() //untuk memulai job dan menunggu job tersebut selesai untuk mengeksekusi baris selanjutnya
            println("sebuah kata setelah job3")
        }

        //cancel sebuah job
        runBlocking{
            val job4 = launch{
                delay(1000)
                print("Job4 berhasil dijalankan")

                // cancel() bisa didalam

            }

            job4.cancel(cause = CancellationException("Dicancel karena kelamaan")) //bisa diluar
        }

    }

    fun debuggingPraktekCoroutine() {
        runBlocking {
            val time1 = measureTimeMillis {
                val nilai_a = getNilaiA()
                val nilai_b = getNilaiB()

                println(
                        "Nilai pertama adalah: $nilai_a, dan nilai kedua adalah: $nilai_b."
                )
            }

            val time2 = measureTimeMillis { 
                val nilai_a = async {getNilaiA()}
                val nilai_b = async {getNilaiB()}

                println(
                        "Nilai pertama adalah: ${nilai_a.await()}, dan nilai kedua adalah: ${nilai_b.await()}"
                )
             }

             println("Perbedaan waktu eksekusi \n Waktu 1: $time1 \n Waktu 2: $time2")
        }

        PraktekMembuatJob()
    }
}
