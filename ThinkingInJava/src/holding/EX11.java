package holding;
/****************** Exercise 11 *****************
 * Write a method that uses an Iterator to step
 * through a Collection and print the toString()
 * of each object in the container. Fill all the
 * different types of Collections with objects and
 * apply your method to each container.
 ***********************************************/
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;

class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Student s1 = new Student("小张");
        Student s2 = new Student("小李");
        Test.swap(s1, s2);
        System.out.println("s1:" + s1.getName());
        System.out.println("s2:" + s2.getName());
    }

    public static void swap(Student x, Student y) {
        Student temp = x;
        x = y;
        y = temp;
        System.out.println("x:" + x.getName());
        System.out.println("y:" + y.getName());
    }
}
interface newInterface {
    void testIt();
}

public class EX11 {
    public static void main(String[] args) throws IOException {
        LinkedList<Object> list = new LinkedList<>();
        list.add(new Gerbil(1));
        list.add(new MyClass());
        list.add(new Gerbil(3));
        list.add(new String("funny"));
        Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next().toString());
        String a = "a value";
        newInterface ni = new newInterface() {
            @Override
            public void testIt() {

            }
        };
        String b = "a value";
        Scanner in = new Scanner(System.in);
        while (true) {
            String line = in.nextLine();
            int length = line.length();
            String Char = line.substring(0,1);
            System.out.println(Char+","+line);
            if (line.equals("拜拜")) break;
        }
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(input.readLine());


    }
}


class SerializeDemo
{
    public static void main(String [] args)
    {
        Employee e = new Employee();
        e.name = "Reyan Ali";
        e.address = "Phokka Kuan, Ambehta Peer";
        e.SSN = 11122333;
        e.number = 101;
        try
        {
            FileOutputStream fileOut =
                    new FileOutputStream("/tmp/ employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/employee.ser");
        }catch(IOException i)
        {
            i.printStackTrace();
        }
    }
}