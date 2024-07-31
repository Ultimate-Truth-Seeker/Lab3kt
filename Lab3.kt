// Lab 3 Roberto Nájera

// Clase base llamada Food
abstract class Food(val name: String, val price: Double) {
    abstract fun cook(): String
}

// Subclase de Food para hamburguesas
class Burger(name: String, price: Double) : Food(name, price) {
    override fun cook(): String {
        return "Cocinando la hamburguesa a la parrilla. Colóquela y espere un tiempo de cada lado."
    }
}

// Subclase de Food para pizzas
class Pizza(name: String, price: Double) : Food(name, price) {
    override fun cook(): String {
        return "Horneando la pizza en el horno. Caliente el horno e introduzca la pizza por un tiempo hasta que se cocine."
    }
}

// Interfaz Dessert
interface Dessert {
    fun eat(): String
}

// Clase IceCream que implementa Dessert y extiende Food
class IceCream(name: String, price: Double) : Food(name, price), Dessert {
    override fun cook(): String {
        return "Enfriando el helado. Introduzca su helado en una nevera y espere por el tiempo necesario para que sea sólido."
    }

    override fun eat(): String {
        return "Comiendo el helado. Saboreelo con su lengua a medida que lame poco a poco su contenido."
    }
}

// Clase abstracta Drink que extiende Food
abstract class Drink(name: String, price: Double) : Food(name, price) {
    abstract fun pour(): String
}

// Subclase de Drink llamada Juice
class Juice(name: String, price: Double) : Drink(name, price) {
    override fun pour(): String {
        return "Vertiendo el jugo en un vaso. Incline levemente el recipiente con jugo y dejelo salir en su vaso."
    }

    override fun cook(): String {
        return "Exprimiendo el jugo. Parta y apriete con fuerza la fruta para su jugo y viertalo en un recipiento"
    }
}

// Extension function para Food. El porcentaje es un número en base de 100.
fun Food.discountedPrice(discountPercentage: Double): Double {
    return price - (price * discountPercentage / 100)
}

// Extra: Nuevo alimento que implementa a Dessert: Cake.
class Cake(name: String, price: Double) : Food(name, price), Dessert {
    override fun cook(): String {
        return "Cocinando el pastel. Mezcle los ingredientes como harina, huevos y leche, e introduzca en el horno hasta que se cocine."
    }

    override fun eat(): String {
        return "Comiendo el pastel. Corte una rebanada y con un tenedor agarre poco a poco bocados."
    }
}

fun main() {
    // Creación de instancias de diferentes alimentos
    val burger = Burger("Hamburguesa", 50.0)
    val pizza = Pizza("Pizza", 75.0)
    val iceCream = IceCream("Helado", 30.0)
    val juice = Juice("Jugo", 20.0)
    val cake = Cake("Pastel", 45.0)

    // Llamadas a cook() y mensajes impresos
    println(burger.cook())
    println(pizza.cook())
    println(iceCream.cook())
    println(juice.cook())
    println(juice.pour())

    // Llamada a eat() en IceCream y mensaje impreso
    println(iceCream.eat())

    // Uso de discountedPrice() en Burger
    val discountedBurgerPrice = burger.discountedPrice(10.0)  // 10% de descuento
    println("Precio con descuento de la hamburguesa: $discountedBurgerPrice")

    // Extra: Cocinar y comer pastel
    println(cake.cook())
    println(cake.eat())
}