import java.io.BufferedReader
import java.io.FileReader
import java.math.BigInteger
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap


/**
* Created by JayPC on 20-May-17. The learning resources are from Kotlin Tutorial Telusko Learnings on YouTube
*/

//MAIN
fun main (args: Array<String>) {

    //Print Hello Android!
    println("Hello Android!")

// 1st Classes
    println("----------1st Classes----------")
    val first = Android()
    first.name = "Yoda"
    println("Name is: " + first.name)

    val second = Android()
    second.name = "Vader"
    println("Name is: ${second.name}")

    val third = AndroidJava()
    third.nameJava = "Luke"      // For Kotlin, no need to call setter and getter
    println("Name is: ${third.nameJava}")

    // using null exceptions
    val fourth = AndroidJava()
    println("Name is: ${fourth.nameJava}")

    val fifth = AndroidJava()
    fifth.nameJava = "Obiwan"
    println("The length is ${fifth.nameJava?.length}")

    val sixth: AndroidJava? = null
    println(sixth?.nameJava)

// 2nd Operators
    println("----------2nd Operators----------")
    val num1 = 1
    val num2 = 2
    val sum= num1 + num2
    println("The sum of numbers $num1 and $num2 is $sum") // no need for bracket

// 3rd if and else statements
    println("----------3rd if and else statements----------")
    val result: Int
    if (num2 > num1)
        result = num2
    else if (num2 < num1)
        result = num1
    else
        result = 0

    // Above Code can be rewritten like this. This is better!
//    result = when {
//        num2 > num1 -> num2
//        num2 < num1 -> num1
//        else -> 0
//    }
    println("The larger number is : $result")

    // in Kotlin we can write this! We can use if-else statements as an expression that returns a value. So cool!
    val result2=
            if (num2 > num1)
                num2
            else if (num2 < num1)
                num1
            else
                0
    println("The larger number is : $result2")

// 4th String Comparison
    println("----------4th String Comparison----------")
    val str1 = "Adonai"
    val str2 = "adonai"
    if (str1 == str2)
        println("Same")
    else
        println("Not same")

// 5th Switch(When in Kotlin) Statements
    println("----------5th Switch(When in Kotlin) Statements----------")
    val num = 6
    when (num) {
        1 -> println("One")
        2 -> println("Two")
        3 -> println("Three")
        else -> println("Switch statements number: Your input is $num")
    }

    // Using when as an expression
    val num3 = 4
    val str = when (num3) {
        1 -> "One"
        2 -> "Two"
        3 -> "Three"
        else -> "Switch statements number: Your input is $num3"
    }
    println(str)

// 6th Loops and Range
    println("----------6th Loops and Range----------")

    val nums = 0 until 5 // for descending, 16 downTo 1 // For including 16, 1..16

    for (a in nums) // for descending, use nums.reversed()
    {
        println(a)
    }

    println("The count is ${nums.count()}")

// 7th List and Map
    println("----------7th List and Map----------")

    val nums2 = listOf(1, 2, 3, 4,4) //if you do not want to repeat the same value or any repeated number, use setOf (immutable) or mutableSetOf for mutability

    for ((index, value) in nums2.withIndex()) {
        println("The index is $index and the value is $value")
    }
    //nums2[0] = 1 This cannot work as list of is immutable. Use mutableListOf can solve this problem
    println(nums2[0]) // but  we can locate a value using its index


    //Maps
    val androids = TreeMap<String, Int>()
    androids["Navin"] = 543
    androids["Kishor"] = 409

    for ((name, age) in androids) {
        println("$name : $age")
    }
    //HUSSEIN TUTORIAL : Using hashmap. Is it similar to Java's treemap?
    val androids2 = HashMap<String, Int>() //Hasmap <key,value> , treat key as the index.
    androids2["Navin2"] = 5432
    androids2["Kishor2"] = 4092
    androids2.put("Testing", 5096)
    androids2.put("Navin2", 6000)  //This replaces the Navin2 key above

    for ((name, age) in androids2) {
        println("$name : $age")
    }
    println(androids2["Navin2"])

    val android3 = hashMapOf(1 to "Shit", 4 to "Bitch",5 to "Fuck")
    println(android3[1])
    android3[1] = "Shitz"
    println(android3[1])


// 8th Function Expression
    println("----------8th Function Expression---------")
    add(100, 101)        // calling the function called add

    add(100,101,102) //Function overloading, but why no smart cast for c?

    val sabat = add2(1000, 1001)         // calling the function called add2
    println("The answer is: $sabat")

    val sabat2 = add3(10000, 10001)      // calling the function called add3
    println("The answer is: $sabat2")

    val masdako = findmax(42, 32)
    println("The max number is $masdako")

    val masdako2 = findmax2(52, 42)
    println("The max number is $masdako2")

// 9th Default and Named Parameters
    println("----------9th Default and Named Parameters---------")

    val finalAmount = calcAmount(100, 20.0)
    println(finalAmount)


    //Fun Code 25 May 2017
    println("----------Fun Code 25 May 2017---------")
    //Adonai
    val Adonai = Person()
    Adonai.name = "Adonai"
    Adonai.age = 22
    Adonai.university = null
    println("Name : ${Adonai.name}")
    println("Age : ${Adonai.age}")
    println("University : ${Adonai.university.orEmpty()}")

    val checkAgeAdonai = Person().legalAge(Adonai.age)
    if (checkAgeAdonai)
        println("${Adonai.name} is legal")
    else
        println("${Adonai.name} is a minor")

    //Jireh
    val Jireh = Person()
    Jireh.name = "Jireh"
    Jireh.age = 23
    Jireh.university = "THEi"
    println("Name : ${Jireh.name}")
    println("Age : ${Jireh.age}")
    println("University : ${Jireh.university.orEmpty()}")

    val checkAgeJireh = Person().legalAge(Jireh.age)    //Repeating code?
    if (checkAgeJireh)
        println("${Jireh.name} is legal")
    else
        println("${Jireh.name} is a minor")

//10th String to Integer (try catch) 20 June 2017
    println("----------10th String to Integer---------")
    val str3 = "69"
    var num4: Int = str3.toInt() //Converting string to integer in Kotlin
    num4++
    println(num4)


    val str4 = "69e"
    var num5: Int
    try                                // if string is a valid integer, it will print this
    {
        num5 = str4.toInt()
        num5++
        println(num5)
    } catch (e: NumberFormatException) // if string is not a valid integer, it will output this
    {
        println("Give proper input")
    }
    finally
    {
    }

    // Try and catch can also be used as an expression that returns a value
    val str5 = "12e3"
    var num6: Int = try {
        str5.toInt()
    }
    catch (e: NumberFormatException) { //returns 0 if catches NumberFormatException
        0
    }
    if (num6 ==0) {
        println("Give a fucking proper input")
    }
    else {
    num6++
    println(num6)
    }

//11th Extension Function
    println("----------11th Extension Function----------")

    val a1 = Android()
    a1.skills ="Java"
    a1.show()

    val a2 = Android()
    a2.skills ="SQL"
    a2.show()

    val a3 = a1 plus a2 //So fucking cool, no need for a1.plus(a2)
    a3.show()

    val a4 = a2 + a3 + a1 //just insert operator on function. can do multiple
    a4.show()

    val array5 = ArrayList<Int>()
    array5.add(5)
    array5.add(10)
    array5.add(15)
    array5.add(20)
    array5.swap(0,1)
    println(array5)

// 12th Recursion
    println("----------12th Recursion----------")

    val num7 = 5  // Using basic for loop function to calculate factorial
    var fact = 1
    for (i in 1..num7)
    {
        fact *= i
    }
    println(fact)


    val num8 = BigInteger("10")    //Using Recursion function called fact, but cannot calculate big numbers
    println (fact(num8))

//13th Constructor
    println("----------13th Constructor----------")

    val adonai = human(22,"Adonai")
    adonai.think()
    val jadonai = human("adad")
    jadonai.think()

//14th Inheritance (added by Hussein)
    println("----------14th Inheritance----------")

    val adonis =Humans()
    adonis.think()

    val adonisius = Aliens()
    adonisius.think()
    adonisius.say()
    adonisius.dohussein()
    println(adonis.husseinsVisibilityModifier) //Experiment with visibility modifier and play with it

    val adonisiuses = Aliens() as Humans
    adonisiuses.think()  //The think function is still overriden by Aliens after casting as Humans


//15th Abstract Class
    println("----------15th Abstract Class----------")

    val drwakwak : Humans2 = Doctors()
    drwakwak.think()
    drwakwak.talk()

//16th Interface
    println("----------16th Interface----------")

    val obj = C()
    obj.show()
    obj.display()
    obj.abc()



//17th Data Class
    println("----------17th Data Class----------")

    val lap1 = Laptop("Dell", 2000)
    val lap2 = Laptop("Apple", 2500)

    val lap3 = lap1.copy(price = 2200) // gah dayum kotlin!

    println(lap1==lap2)
    println(lap3)
    lap1.show()

//18th Object
    println("----------18th Object----------")


    BookShelf.books.add(Book("Java",50))
    BookShelf.books.add(Book("Sql",40))
    BookShelf.books.add(Book("Kotlin",80))
    BookShelf.books.add(Book("C#",50))

    BookShelf.showBooks()

//19th Anonymous Inner Class - a class inside? lol
    println("----------19th Anonymous Inner Class - a class inside? lol----------")


    val programmer : Humans3 = object : Humans3
                            {
                                override fun think()
                                {
                                    println("think virtually")
                                }

                            }
    programmer.think()

// 20th Companion object
    println("----------20th Companion object----------")

    D.show()  //Instantiate is unnecessary


    val obj2= E.create() // Companion object factory pattern - creates an object in factory settings
    obj2.show()

// 21st Backtick as escape character
    println("----------21st Backtick as escape character----------")

    `in`()

//22nd User input in Kotlin
    println("----------22nd User input in Kotlin----------")

    //    val times = 1 until 20
    //    for (a in times)
    //    {
    //        println("INPUT: Please type anything in here : ")
    //        val input = readLine()
    //        println("Your fucking input is : $input")
    //    }

//23rd Arrays
    println("----------23rd Arrays----------")

    val nums3 = intArrayOf(0,10,20,30,40,50,60,70,80,90,100)
    nums3[3] = 21 // Similar to nums3.set(3,21)
    for(i in nums3)
    {
        println(i)
    }
    println(nums3.lastIndex)
    println(nums3.last())


    val nums4 = IntArray(4) // Can also use DoubleArray or FloatArray
    nums4[0]=1
    nums4[1]=2
    nums4[2]=3
    nums4[3]=4
    for(i in nums4)
    {
        println(i)
    }

    val str6 = arrayOfNulls<String>(2)
    str6[0]="Cristiano"
    str6[1]="Ronaldo"
    for(i in str6)
    {
        println(i)
    }

//24th List of objects
    println("----------24th List of objects----------")
    val list = listOf(ListClass("Ado",22),
            ListClass("Awing",18))

    for (i in list){
        println(i)
    }





//HUSSEIN CODES UDEMY
    println("----------HUSSEIN CODES UDEMY----------")

//1st Constructors
    println("----------1st Constructors----------")

    val adoCar = Car("Tesla", "Adonai")
    println("Get Owner: ${adoCar.GetOwner()}" )

    val anotherCons = Car("sup")
    println(anotherCons.anything)

//2nd Generics
    println("----------2nd Generics----------")
    val userAdmins = UserAdmins("Shit")
    userAdmins.display("Fuck")
    userAdmins.display(22)






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



    println(operation(3,5,::addTwoNumber))


} // --- END OF TOP LEVEL FUNCTION! ---












































// --- FUNCTIONS AND OTHER CLASSES ---

// 8th Function Expression
fun add (a: Int, b:Int)         // This function prints a+b
{
    println("The answer is: ${a+b}")
}

fun add (a: Int, b:Int, c: Int)         // This function prints a+b
{
    println("The answer is: ${a+b+c}")
}

fun add2 (a: Int, b:Int) : Int      // This function returns a+b
{
    return a+b
}

fun add3 (a: Int, b:Int)   = a+b       // Can be written in one line in Kotlin!

fun findmax (a : Int, b : Int) : Int  //This function find the maximum between two numbers
{
    if (a>b)
        return a
    else
        return b
    //Can be written like this
//    return if (a>b)
//        a
//    else
//        b
}

fun findmax2 (a : Int, b : Int)  = if (a>b) a else b // Can be written in one line in Kotlin!Damn Kotlin!



// 9th Default and Named Parameters
fun calcAmount (amount : Int, interest: Double = 10.0) : Int
        =(amount * (1+(interest/100))).toInt()
//Interest rate 20.0 overloads 10.0, but if no interest is assigned, it will automatically use 10.0



//11th Extension Function - to create additional functions without touching the original code
operator infix fun Android.plus(a:Android): Android // just insert infix to make it more readable
                                                    //infix only takes one parameter while operator can do multiple
{
    val newAndroid = Android()
    newAndroid.skills=this.skills + " " + a.skills
    return newAndroid
}

fun ArrayList<Int>.swap(index1: Int, index2:Int){
    val temp=this[index1]
    this[index1]=this[index2]
    this[index2]=temp
}
//12th Recursion (skipped #26 of Telusko learning : Tail Recursion, its quite complex. come back later)
fun fact(num8:BigInteger): BigInteger {
    if (num8 == BigInteger.ZERO)
        return BigInteger.ONE
    else
        println("hello" + num8)
        return num8 * fact(num8 - BigInteger.ONE) //5 * 4!, 4 * 3!, and so on
}

//13th Constructor
class human (n : String ="")  //This is primary constructor
{
    private var name : String = n   // can be initialized like this
    private var age = 0

    constructor(age : Int, name: String) :this(name) //Secondary Constructor? that also takes primary constructor parameter?
    {
        this.age =age
        this.name = name
    }
    fun think()
    {
        println("Kotlin is awesome.. $name: $age")
    }
}

//14th Inheritance

open class Humans  //By default all classes in Kotlin are final, therefore "open" is needed to allow this class to be inherited from
{

    // The visibility of this variable is public on default
    /* play with visibility modifier here */
    var husseinsVisibilityModifier :String? ="Can be accessed by the inherited class by calling super"

    open fun think() //open is needed to allow overriding. Kotlin is so easy!
    {
        println("Real Thinking")
    }
}

class Aliens : Humans()
{
    override fun think()
    {
        println("Virtual Thinking")
    }

    fun say(){
        println("I will inherit something from human class")

    }

    fun dohussein(){
        println(super.husseinsVisibilityModifier)
    }
}


//15 Abstract classes  - abstract classes are meant to be inherited or overridden. Its just abstract, somebody will implement it. Nice tip by Navin

abstract class Humans2
{
    abstract fun think() //Just abstract, no details in this method

    fun talk()
    {
        println("Surgeon?")
    }
}

class Doctors: Humans2()
{
    override fun think()
    {
        println("Critical Thinking")
    }
}

//16 Interface - Interface can support multiple inheritance (implementations). Given a choice always use interface instead of abstract classes.

interface A
{
    fun show() // In Interface, all the methods and function are abstract by default

    fun abc(){
        println("in abc A")
    }
}

interface B
{
    fun display()
    fun abc(){
        println("in abc B")
    }
}

class C :A,B
{
    override fun show()
    {
        println("in show")
    }

    override fun display()
    {
        println("in display")
    }

//  override fun abc()             //To call abc() in class C
//  {
//      println("in abc C")
//  }

    override fun abc()    // To call abc() in interface A, use super generics? lol
    {
        super<A>.abc() //means superclass?
    }
}

//17th Data Class - just a normal class which automatically does these 3 functions
    // 1. Every class needs a toString()
    // 2. Equals and hash codes
    // 3. copy
    // In java, these 3 functions are done manually which is inefficient

data class Laptop (val brand : String, val price : Int)
{
    fun show(){
        println("Amazing Laptop")
    }
}

//18th Object - is also a class, for singleton class - makes sure you only have on object which is the bookshelf
    // In java, we have to create a class, then create a private constructor, then get instance method
    // In Kotlin no need, just type object.

data class Book ( val name: String, val price : Int)

object BookShelf
{
    val books = arrayListOf<Book>()

    fun showBooks()
    {
        for (i in books)
        {
            println(i)
        }
    }
}

//19th Anonymous inner class - creating a class inside the main while using the features of an interface.
    //Keep in mind that we cannot instantiate an interface therefore we need to reference the object to an interface.

interface Humans3 {
    fun think()
}

// 20th Companion object  - Static classes in Java. No need to instantiate just directly call the function.
                            //Just write companion object and @JvmStatic
class D
{
    companion object
    {
        @JvmStatic          // To let it run on Java code in Javatest File
        fun show()
        {
            println("something")
        }

    }
}

class E              //Companion object factory pattern
{
    companion object
    {
        fun create():E = E()
    }

    fun show()
    {
        println("Sup?")
    }
}

// 21st Backtick as escape character

fun `in` ()
{
    println("use backtick if you want to name a function that is typically not allowed")
}

//24th List of objects
data class ListClass (var name: String?= null,
                 var age: Int?= null){
    init{
        println("List is added")
    }
}







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

//Higher order function

fun operation (x: Int, y: Int, op: (Int, Int) -> Int) : Int = op(x,y)


fun addTwoNumber (a: Int, b:Int) = a+b