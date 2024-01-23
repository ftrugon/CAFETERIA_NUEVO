import kotlin.random.Random

/*
Desarrolla un programa con las siguientes clases:

- Clase Cafetera con atributos ubicacion (nombre de la sala o habitación dónde se encuentra), capacidad (la cantidad
 máxima de café que puede contener la cafetera) y cantidad (la cantidad actual de café que hay en la cafetera).

Implementa, al menos, lo siguiente:

    * En la clase se debe establecer la capacidad máxima en 1000 (c.c.) y la cantidad actual en cero (cafetera vacía).

    * Constructor primario con la ubicacion.

    * Constructor secundario con la ubicación y la capacidad máxima de la cafetera. Inicializa la cantidad actual de
        café igual a la capacidad máxima.

    * Constructor secundario con la ubicacion, la capacidad máxima y la cantidad actual. Si la cantidad actual es
        mayor que la capacidad máxima de la cafetera, la ajustará al máximo.

    * llenar(): hace que la cantidad actual sea igual a la capacidad.

    * servirTaza(Taza): simula la acción de servir una taza con la capacidad que tenga la taza. Si la cafetera
        tiene café, llenará la taza y restará la cantidad servida en la cantidad de la cafetera. Si la cantidad actual
        de café “no alcanza” para llenar la taza, se sirve lo que quede. Actualizar la cantidad de la cafetera y aplicar
        el método adecuado de la taza.

    * vaciar(): pone la cantidad de café actual en cero.

    * agregarCafe(Int): añade a la cafetera la cantidad de café indicada. Por defecto añade 200 c.c. No se puede añadir
        más cantidad que su capacidad máxima, si ocurriera esta circunstancia, simplemente llenaríamos la cantidad de la
        cafetera a su capacidad máxima.

    * toString(): debe retornar por ejemplo "Cafetera(ubicación = Salón, capacidad = 1000 c.c., cantidad = 0 c.c.)"

- Clase Taza, que tendrá los atributos color, capacidad y cantidad.

Implementa, al menos, lo siguiente:

    * Un único constructor con el color (por defecto blanco) y la capacidad (por defecto 50 c.c.). La clase también contendrá un atributo con la cantidad que se establcerá a 0.
    * La propiedad cantidad debe modificarse para que si el valor que recibe es mayor que la capacidad de la taza, solo establezca el valor de dicha capacidad.
    * El método llenar() que establecerá la cantidad de la taza a su máxima capacidad.
    * El método "sobrecargado" llenar(Int) que establecerá la cantidad de la taza a la cantidad pasada como argumento al método.
    * Sobreescribir el método toString(), que debe retornar por ejemplo "Taza(color = BLANCO, capacidad = 50 c.c., cantidad = 30 c.c.)"

- Clase enumerada Color, que contendrá los colores disponibles: blanco, negro, gris, azul y verde.

En el programa principal se deben crear 3 cafeteras de capacidad 1000, 750 y 500 c.c. con 0, 750 y 200 c.c de cantidad respectivamente.
Para crear cada cafetera, debéis utilizar un constructor diferente.
También debéis generar una lista de 20 tazas con la capacidad de 50, 75 y 100 de manear aleatoria.
Implementar el resto de comentarios TODO de la función main().

NOTA:
la sobrecarga de métodos se refiere a la capacidad de definir varios métodos en una clase con el mismo nombre pero con diferentes parámetros.
Esto permite que una clase tenga varios métodos con la misma firma (nombre de método) pero con listas de parámetros diferentes.

La sobrecarga de métodos facilita la legibilidad del código y proporciona flexibilidad al programador al permitirle utilizar el mismo nombre de
método para realizar operaciones similares pero con diferentes conjuntos de datos.

*/
class Cafetera(private var ubicacion:String){
    var capacidad = 0
        set(value) {
            require(value <= 1000) { "La capacidad de la cafetera no puede ser superior a 1000" }
            field = value
        }
    init {
        this.capacidad = capacidad
    }

    var cantidad = 0

    constructor(ubicacion:String, capacidad:Int):this(ubicacion){
        this.capacidad = capacidad
    }
    constructor(ubicacion:String, capacidad:Int, cantidad:Int):this(ubicacion,capacidad){
        this.cantidad = cantidad
    }

    fun llenar(){
        this.cantidad = this.capacidad
        println("Se ha llenado la cafetera")
    }

    fun servirtaza(taza:Int){
        if (taza > cantidad){
            println("La cafetera se ha quedado sin cafe como para rellenar esta taza")
        }else {
            this.cantidad -= taza
        }
    }

    fun vaciar(){
        this.cantidad = 0

    }

    fun agregarcafe(cafeaagregar:Int){
        if (cafeaagregar > capacidad || (cafeaagregar + cantidad) > capacidad){

            this.cantidad = this.capacidad
        }else{
            this.cantidad += cafeaagregar
        }
    }

    override fun toString(): String {
        return "Cafetera: \n ubicacion : $ubicacion \n capacidad : $capacidad \n cantidad : $cantidad"
    }

}

class Taza (var color:String,var capacidad:Int,cantidad: Int){

    var cantidad = 0
        set(value) {
            field = if (this.cantidad < cantidad) {
                50
            }else{
                value
            }
        }
    init {
        this.cantidad
    }

    fun llenar(){
        this.cantidad = capacidad
    }

    fun sobrecargado(cap:Int){
        this.capacidad = cap
    }

    override fun toString(): String {
        return "TAZA: \n color : $color \n capacidad = $capacidad \n cantidad = $cantidad"
    }



}

enum class color {
    blanco, negro, gris, azul, verde
}
fun main() {

    //TODO: Crear 3 cafeteras en la Sala, Cocina y Oficina

    val cafetera1 = Cafetera("Sala",1000,0)
    val cafetera2 = Cafetera("Cocina",750,750)
    val cafetera3 = Cafetera("Oficina",500,200)


    //TODO: Crear una lista de 20 tazas con capacidades aleatorias


    val taza1 = Taza("blanco",Random.nextInt(1,50), 0)
    val taza2 = Taza("negro",Random.nextInt(1,50), 0)
    val taza3 = Taza("gris",Random.nextInt(1,50), 0)
    val taza4 = Taza("azul",Random.nextInt(1,50), 0)
    val taza5 = Taza("verde",Random.nextInt(1,50), 0)
    val taza6 = Taza("blanco",Random.nextInt(1,50), 50)
    val taza7 = Taza("blanco",Random.nextInt(1,50), 50)
    val taza8 = Taza("negro",Random.nextInt(1,50), 0)
    val taza9 = Taza("azul",Random.nextInt(1,50), 0)
    val taza10 = Taza("verde",Random.nextInt(1,50), 50)
    val taza11 = Taza("gris",Random.nextInt(1,50), 0)
    val taza12 = Taza("blanco",Random.nextInt(1,50),0)
    val taza13 = Taza("azul",Random.nextInt(1,50), 0)
    val taza14 = Taza("negro",Random.nextInt(1,50), 50)
    val taza15 = Taza("verde",Random.nextInt(1,50), 50)
    val taza16 = Taza("blanco",Random.nextInt(1,50),50)
    val taza17 = Taza("gris",Random.nextInt(1,50), 0)
    val taza18 = Taza("azul",Random.nextInt(1,50), 0)
    val taza19 = Taza("blanco",Random.nextInt(1,50),0)
    val taza20 = Taza("verde",Random.nextInt(1,50), 0)

    val lista = listOf<Taza>(
        taza1, taza2, taza3, taza4, taza5, taza6, taza7, taza8, taza9, taza10, taza11, taza12, taza13, taza14,
        taza15, taza16, taza17, taza18, taza19, taza20
    )


    println("**********************************************")
    //TODO: Mostrar por pantalla el contenido de las 3 cafeteras y las tazas.

    println(cafetera1.toString())
    println(cafetera2.toString())
    println(cafetera3.toString())

    for (taza in lista){
        println(taza.toString())
    }

    println("**********************************************")
    println("Llenar la cafetera1 de café...")
    println("Vaciar la cafetera2...")
    println("Agregar café a la cafetera2 a la mitad de su capacidad...")
    println("Agregar 400 c.c. de café a la cafereta3...")

    //TODO: Llenar la cafetera1 de café.

    cafetera1.llenar()

    //TODO: Vaciar la cafetera2.

    cafetera2.vaciar()

    //TODO: Agregar café a la cafetera2 a la mitad de su capacidad.

    cafetera2.agregarcafe(cafetera2.capacidad / 2)

    //TODO: Agregar 400 c.c. de café a la cafereta3

    cafetera3.agregarcafe(400)

    println("**********************************************")
    //TODO: Mostrar por pantalla el contenido de las 3 cafeteras

    println(cafetera1.toString())
    println(cafetera2.toString())
    println(cafetera3.toString())

    println("**********************************************")
    println("Servir café en las tazas...")

/////////////////////////////////////////////////
    //TODO: Servir café en las tazas... siempre que haya café en la cafetera y en el orden cafetera1, cafetera2 y cafetera3.

    //cafetera1.servirtaza(taza1.capacidad)
    //taza1.llenar()
    //cafetera1.servirtaza(taza2.capacidad)
    //taza2.llenar()
    //cafetera1.servirtaza(taza3.capacidad)
    //taza3.llenar()
    //cafetera1.servirtaza(taza4.capacidad)
    //taza4.llenar()
    //cafetera1.servirtaza(taza5.capacidad)
    //taza5.llenar()
    //cafetera1.servirtaza(taza6.capacidad)
    //taza6.llenar()
    //cafetera1.servirtaza(taza7.capacidad)
    //taza7.llenar()
    //cafetera1.servirtaza(taza8.capacidad)
    //taza8.llenar()
    //cafetera1.servirtaza(taza9.capacidad)
    //taza9.llenar()
    //cafetera1.servirtaza(taza10.capacidad)
    //taza10.llenar()
    //cafetera1.servirtaza(taza11.capacidad)
    //taza11.llenar()
    //cafetera1.servirtaza(taza12.capacidad)
    //taza12.llenar()
    //cafetera1.servirtaza(taza13.capacidad)
    //taza13.llenar()
    //cafetera1.servirtaza(taza14.capacidad)
    //taza14.llenar()
    //cafetera1.servirtaza(taza15.capacidad)
    //taza15.llenar()
    //cafetera1.servirtaza(taza16.capacidad)
    //taza16.llenar()
    //cafetera1.servirtaza(taza17.capacidad)
    //taza17.llenar()
    //cafetera1.servirtaza(taza18.capacidad)
    //taza18.llenar()
    //cafetera1.servirtaza(taza19.capacidad)
    //taza19.llenar()
    //cafetera1.servirtaza(taza20.capacidad)
    //taza20.llenar()


    for (taza in lista){
        if (cafetera1.cantidad > 25){
            cafetera1.servirtaza(taza.capacidad)
            taza.llenar()
        }else if (cafetera2.cantidad > 25){
            cafetera2.servirtaza(taza.capacidad)
            taza.llenar()
        }else if (cafetera3.cantidad > 25){
            cafetera2.servirtaza(taza.capacidad)
            taza.llenar()
        }
    }




    println("**********************************************")
/////////////////////////////////////////////////
    //TODO: Mostrar por pantalla el contenido de las 3 cafeteras y las tazas.

    println(cafetera1.toString())
    println(cafetera2.toString())
    println(cafetera3.toString())

    for (taza in lista){
        println(taza.toString())
    }

}