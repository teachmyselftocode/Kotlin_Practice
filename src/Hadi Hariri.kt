import java.io.BufferedReader
import java.io.FileReader
import java.util.*

fun main (args: Array<String>) {


    ////HADI HARIRI KOTLIN BASICS
    println("----------HADI HARIRI KOTLIN BASICS----------")

    val hadi= Customer("Hadi", 1964)
    println(hadi.name)
    println(hadi.age)
    println("Please input Social Security number: ")
//    for (a in 1..5) {
//        hadi.sss = readLine()!!
//    }

    //TODO ENUMS!


    println("----------HADI HARIRI Throw Exceptions----------")
    //Throw Exception
    try{
        checkIsNumber("A")

    }
    catch (e: NotANumberException){
        println("It was not a number")
    }


    val buffer = BufferedReader(FileReader("input.txt"))

    val catchingException = try{
        val char = CharArray(30)
        buffer.read(char,0,40)
    }
    catch (e:IndexOutOfBoundsException){
        println("Catched Exception")
        0
    }
    finally {
        println("Closing")
        buffer.close()
        //  1                 // Finally does not return value
    }
    print(catchingException)

//Declaring Constants
    println("----------HADI HARIRI Declaring Constants----------")

    println(Copyright.author)

//Higher order function

    println("----------HADI HARIRI Higher order function----------")


    println(operation(5,5,::addTwoNumber))

    //a lambda
    val sumLambda : (Int,Int) -> Int = { firstNumber, secondNumber -> firstNumber + secondNumber }

    //inserting a lambda
    println(operation(10,10, sumLambda))

    // This code.....
    println(  unaryOperation(3, {x -> x * x})  )
    // ... can also be written as
    println(  unaryOperation(3, { it*it})  ) // 'it' only works for single parameter function
    //also like this..
    println(  unaryOperation(3) { it*it}  ) //If the last or the only parameter of the function
                                                // is a higher order function, no need bracket
    unaryOp {    //can be like this
        it*it
    }

    //Sample code
    val db = Database()
    transaction (db) {      //If the last or the only parameter of the function is a higher order function, no need bracket
        //write code here
    }

    //Anonymous function - a function with no name. Or inline function
    unaryOperation(3 , fun (x:Int) : Int {return x*x })


}















// -------------- FUNCTIONS AND OTHER CLASSES ------------  //


////HADI HARIRI KOTLIN BASICS

class Customer (val name :String? = null, val yearOfBirth: Int ) {

    val age : Int
        get() =  Calendar.getInstance().get(Calendar.YEAR)- yearOfBirth

    var sss: String = ""
        set(anyNameOrNameItValueLOL){
            if (!anyNameOrNameItValueLOL.startsWith("SN")) {
                throw  IllegalArgumentException("Should start with SN")
            }
            field=anyNameOrNameItValueLOL
        }
}

//Throw Exceptions
class NotANumberException: Throwable() {
}

fun checkIsNumber(obj: Any){
    when (obj){
        !is Int, Long, Float, Double -> throw NotANumberException()
        else -> println("Input is valid")
    }
}

//Declaring Constants
object Copyright{     //Singletons are somehow   mconstants
    val author = "Tan Weiwei"
}

//Higher order functions and Lambdas

fun operation (x: Int, y: Int, op: (Int, Int) -> Int) : Int {
    return op(x,y)
}

fun addTwoNumber (a: Int, b:Int) = a + b

fun unaryOperation (x: Int, op: (Int) -> Int) : Int{
    return op(x)
}

fun unaryOp (op: (Int) -> Int):Int{
return op(3)
}

//Sample code
class Database{
    fun commit(){
    }
}
fun transaction (db: Database, code : () -> Unit){
    try{
        code()
    } finally{
        db.commit()
    }
}


