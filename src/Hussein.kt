fun main (args: Array<String>) {
//HUSSEIN CODES UDEMY
    println("----------HUSSEIN CODES UDEMY----------")

//1st Constructors
    println("----------1st Constructors----------")

    val adoCar = Car("Tesla", "Adonai")
    println("Get Owner: ${adoCar.GetOwner()}")

    val anotherCons = Car("sup")
    println(anotherCons.anything)

//2nd Generics
    println("----------2nd Generics----------")
    val userAdmins = UserAdmins("Shit")
    userAdmins.display("Fuck")
    userAdmins.display(22)
}










// -------------- FUNCTIONS AND OTHER CLASSES ------------  //
////HUSSEIN FUNCTION AND CLASSES UDEMY

class Car(){

    private var Type: String? = null
    private var Owner: String?=null
    var anything: String? = null
    constructor(initType:String, initOwner:String):this(){ // This means run the constructor Car(), but in this case its empty
        println("type: $Type")
        println("owner: $Owner")
        this.Owner  = initOwner
        this.Type = initType
    }

    //We can make another constructor , think of function overloading concept, also works here
    constructor(Anything:String):this(){
        println("This is another constructor")
        this.anything = Anything
        println(anything)
    }

    fun GetOwner():String?{
        return this.Owner
    }
}

//GENERICS

class UserAdmins<T>(credit:T){
    init {
        println(credit)
    }

    fun <T> display(process:T){
        println(process)
    }
}



