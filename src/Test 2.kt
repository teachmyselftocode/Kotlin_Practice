/**
 * Created by jim on 27/6/2017.
 */
fun main (args: Array<String>) {

    //Print Hello Android!
    println("Hello Android!")

    val obj = C3()
    obj.show()
    obj.display()
    obj.abc()
}

interface A1
{
    fun show() // In Interface, all the methods and function are abstract by default

    fun abc(){
        println("in abc A")
    }
}

interface B2
{
    fun display()
    fun abc(){
        println("in abc B")
    }
}

class C3 :A1,B2 {


    override fun show() {
        println("in show")
    }

    override fun display() {
        println("in display")
    }

    override fun abc()    // To call abc() in interface A, use super generics? lol
    {
        super<A1>.abc()
    }
}