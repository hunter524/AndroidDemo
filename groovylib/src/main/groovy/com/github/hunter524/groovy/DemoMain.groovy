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
   File.listRoots().each {
       println(it.absolutePath)
       new File(it.getAbsolutePath()).eachFile {
           println(it.absolutePath)
       }
   }
    new File("E:\\").eachFile {
        println(it)
    }
    Runtime runtime = Runtime.getRuntime();
    Process process = runtime.exec("E:\\gradle-2.12-all\\gradle-2.12\\bin\\gradle.bat -v")
    println("start :"+Calendar.getInstance().getTime().toString())
    if (process.waitFor() == 0){
        println("end :"+Calendar.getInstance().getTime().toString())
    }
    BufferedInputStream bufferedInputStream = new BufferedInputStream(process.inputStream)
    bufferedInputStream.eachLine {
        line ->println(line)
    }

}
int method(String arg) {
    return 1;
}
int method(Object arg) {
    return 2;
}


