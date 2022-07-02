class WhenSwitchCaseTraining{

    fun basicWhen(){
        val value = 10
        
        when(value){
            9 -> {
                println("masuk ke 9")
            }
            10 -> {
                println("masuk ke 10")
            }
            11 -> {
                println("masuk ke 11")
            }
            else -> {
                println("tidak masuk manapun")
            }
        }
        println()
    }

    fun savingWhen(){
        val value = 10
        
        val saving_when:Int = when(value){
            9 -> {
                println("masuk ke 9")
                9
            }
            10 -> {
                println("masuk ke 10")
                10
            }
            11 -> {
                println("masuk ke 11")
                11
            }
            else -> {
                println("tidak masuk manapun")
                -1
            }
        }
        println("nilai variabel saving_when: " +saving_when.toDouble())
    }

    fun rangedWhen(){
        val value = 20
        val range = 10..50

        when(value){
            in range -> {
                println("nilai dalam jangkauan.")
            }

            !in range -> {
                println("nilai diluar jangkauan.")
            }
        }
    }

    fun rangedWhen2(){
        val value = 10
        
        when(value){
            in 10..50 -> {
                println("nilai dijangkauan 10-50")
            }

            in 51..100 -> {
                println("nilai dijangkuan 51-100")
            }
        }
    }

    fun datatypeWhen(){
        val value: Any = 10

        when(value){
            is Long -> {

            }

            is Int -> {

            }

            is String -> {
                
            }
        }
    }
    
}