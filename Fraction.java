import java.util.Scanner;

public class Fraction {
    public int denominator;
    public int numerator;

    public Fraction(int numerator, int denominator){
        this.denominator = denominator;
        this.numerator = numerator;
    }

    private int nod(int a,int b){   //Наибольший общий делитель
        return b == 0 ? a : nod(b,a % b);
    }

    private int nok(int a,int b){   //Наименьшее общее кратное
        return a / nod(a,b) * b;
    }


    public Fraction plus(Fraction other) {
        Fraction result = new Fraction(1, 1);
        if (this.denominator == other.denominator) { //если знаменатели одинаковые
            result.denominator = this.denominator;
            result.numerator = this.numerator + other.numerator;
        }
        else {
            int nok = nok(this.denominator, other.denominator);
            result.denominator = nok;
            result.numerator = this.numerator * (nok/this.denominator) + other.numerator * (nok/other.denominator);
        }
        return result;
    }

    public Fraction plus2(Fraction first, Fraction second) {
        Fraction result = new Fraction(1, 1);
        if (first.denominator == second.denominator) { //если знаменатели одинаковые
            result.denominator = first.denominator;
            result.numerator = first.numerator + second.numerator;
        } else {
            int nok = nok(first.denominator, second.denominator);
            result.denominator = nok;
            result.numerator = first.numerator * (nok / first.denominator) + second.numerator * (nok / second.denominator);
        }
        return result;
    }

    public Fraction minus(Fraction other) {
        Fraction result = new Fraction(1, 1);
        if (this.denominator == other.denominator) { //если знаменатели одинаковые
            result.denominator = this.denominator;
            result.numerator = this.numerator - other.numerator;
        }
        else {
            int nok = nok(this.denominator, other.denominator);
            result.denominator = nok;
            result.numerator = this.numerator * (nok/this.denominator) - other.numerator * (nok/other.denominator);
        }
        return result;
    }

    public Fraction minus2(Fraction first, Fraction second) {
        Fraction result = new Fraction(1, 1);
        if (first.denominator == second.denominator) { //если знаменатели одинаковые
            result.denominator = first.denominator;
            result.numerator = first.numerator - second.numerator;
        }
        else {
            int nok = nok(first.denominator, second.denominator);
            result.denominator = nok;
            result.numerator = first.numerator * (nok/first.denominator) - second.numerator * (nok/second.denominator);
        }
        return result;
    }

    public Fraction multiply(Fraction other) {
        Fraction result = new Fraction(1, 1);
        result.denominator = this.denominator * other.denominator;
        result.numerator = this.numerator * other.numerator;
        return result;
    }

    public Fraction multiply2(Fraction first, Fraction second) {
        Fraction result = new Fraction(1, 1);
        result.denominator = first.denominator * second.denominator;
        result.numerator = first.numerator * second.numerator;
        return result;
    }

    public Fraction divide (Fraction other) {
        Fraction result = new Fraction(1, 1);
        result.denominator = this.denominator * other.numerator;
        result.numerator = this.numerator * other.denominator;
        return result;
    }

    public Fraction divide2 (Fraction first, Fraction second) {
        Fraction result = new Fraction(1, 1);
        result.denominator = first.denominator * second.numerator;
        result.numerator = first.numerator * second.denominator;
        return result;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);

        System.out.println("Введите числитель первой дроби: ");
        if ((in.hasNext("0")) || (!in.hasNextInt())){
            System.out.println("Введите целое число: ");
            throw new Exception();
        }
        int num1 = in.nextInt();

        System.out.println("Введите знаменатель первой дроби: ");
        if ((in.hasNext("0")) || (!in.hasNextInt())){
            System.out.println("Введите целое число: ");
            throw new Exception();
        }
        int den1 = in.nextInt();

        System.out.println("Введите числитель второй дроби: ");
        if ((in.hasNext("0")) || (!in.hasNextInt())){
            System.out.println("Введите целое число: ");
            throw new Exception();
        }
        int num2 = in.nextInt();

        System.out.println("Введите знаменатель второй дроби: ");
        if ((in.hasNext("0")) || (!in.hasNextInt())){
            System.out.println("Введите целое число: ");
            throw new Exception();
        }
        int den2 = in.nextInt();
        in.close();

        Fraction frac1 = new Fraction (num1, den1);
        Fraction frac2 = new Fraction (num2, den2);

        Fraction sum = frac1.plus(frac2);
        Fraction sum2 = frac1.plus2(frac1, frac2);
        System.out.println("Сумма 1 вариант: " + frac1 + " + " + frac2 +" = " + sum);
        System.out.println("Сумма 2 вариант: " + frac1 + " + " + frac2 +" = " + sum2);

        Fraction razn = frac1.minus(frac2);
        Fraction razn2 = frac1.minus2(frac1, frac2);
        System.out.println("Разность 1 вариант: " + frac1 + " - " + frac2 +" = " + razn);
        System.out.println("Разность 2 вариант: " + frac1 + " - " + frac2 +" = " + razn2);

        Fraction mult = frac1.multiply(frac2);
        Fraction mult2 = frac1.multiply2(frac1, frac2);
        System.out.println("Произведение 1 вариант: " + frac1 + " * " + frac2 +" = " + mult);
        System.out.println("Произведение 2 вариант: " + frac1 + " * " + frac2 +" = " + mult2);

        Fraction div = frac1.divide(frac2);
        Fraction div2 = frac1.divide2(frac1, frac2);
        System.out.println("Частное 1 вариант: " + frac1 + " : " + frac2 +" = " + div);
        System.out.println("Частное 2 вариант: " + frac1 + " : " + frac2 +" = " + div2);
    }

}

