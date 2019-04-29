import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Fraction a = new Fraction(in.nextInt(), in.nextInt());

        Fraction b = new Fraction(in.nextInt(),in.nextInt());

        a.print();

        b.print();

        a.plus(b).print();

        a.multiply(b).plus(new Fraction(5,6)).print();

        a.print();

        b.print();

        in.close();
    }

}

class Fraction {
    int a;
    int b;
    Fraction(int a, int b) {
        this.a = a;
        this.b = b;
    }
    double toDouble() {
        return ((double) a)/b;
    }
    Fraction plus(Fraction r) {
        int sum_a = this.a * r.b +this.b * r.a;
        int sum_b = this.b * r.b;
        return new Fraction(sum_a,sum_b);
    }
    Fraction multiply(Fraction r) {
        return new Fraction(this.a*r.a, this.b*r.b);
    }
    void print(){
        if (a == b) {
            System.out.println(1);
        }
        else if (this.a > this.b) {
            System.out.println(this.a+"/"+this.b);
        }
        else {
            int numerater = this.a;
            int denominator = this.b;
            int r = 1;
            while (r != 0) {
                r = denominator % numerater;
                denominator = numerater;
                numerater = r;
            }

            System.out.println(this.a/denominator + "/" + this.b/denominator);
        }
    }
}