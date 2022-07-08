data class DataClassTraining(var nama: String, var umur: Int, var hobby: String)

class DataClassTrainingInit {
    // List
    var muridAbydos: List<DataClassTraining> =
            listOf( // gunakan mutablelistof jika ingin data dapat bertambah secara dinamis
                    DataClassTraining("Sunaookami Shiroko", 16, "Gowes, Sports"),
                    DataClassTraining("Izayoi Nonomi", 16, "Shopping"),
                    DataClassTraining("Takanashi", 17, "Turu"),
                    DataClassTraining("Kuromi Serika", 15, "Saving Money, Working part-time"),
                    DataClassTraining(
                            "Okusora Ayane",
                            15,
                            "Keeping the accounts, collecting antiques"
                    )
            )

    // Set, set sama seperti List tapi dia unik elementnya. jadi nggak ada yang sama. yang sama
    // otomatis akan dihapus
    var namaSekolah: MutableSet<String> =
            mutableSetOf(
                    "Gehenna",
                    "Abydos",
                    "Trinity",
                    "Millenium",
                    "Shanghai-jin",
                    "Gehenna"
            ) // Gehenna yang dibelakang pasti akan dihapus

        /*
            info tambahan untuk set
            val mutableSet = mutableSetOf(1, 2, 4, 2, 1, 5)
            //mutableSet[2] = 6 // tidak bisa mengubah set immutable
            mutableSet.add(6) // menambah item di akhir set
            mutableSet.remove(1) //menghapus item yang memiliki nilai 1
        */

        //Map, map memiliki key dan value yang harus didefinisikan saat membuat elementnya. bedanya dari list atau array, kita hanya perlu mendefinisikan value, sementara dengan menggunakan map kita perlu mendefinisikan keynya juga.
        //yang kiri key yang kanan value
        var muridRandom: MutableMap<String, String> = mutableMapOf(
            "Shiroko" to "Abydos",
            "Hina" to "Gehenna",
            "Hoshino" to "Abydos",
            "Mika" to "Trinity"
        )

    fun manipulasiLanjut() {
        println("Data set dimanipulasi lanjut.")
        namaSekolah.add("Gehenna") // nggak akan bisa masuk
    }
}
