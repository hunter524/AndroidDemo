import com.sun.org.apache.xpath.internal.operations.String

public static void main(String[] arg){
    System.out.println("print")
    def var = "println"
    def a = 1
    def b = 2
    def c = a+b
    def d = method(new Object());
    System.out.println(d);
    println('c'.getClass()==String)
    println("c".getClass()==String)
    println("c${1}".getClass() in GString)
    for (i in 0..5){
        println(i)
    }
}
int method(String arg) {
    return 1;
}
int method(Object arg) {
    return 2;
}


