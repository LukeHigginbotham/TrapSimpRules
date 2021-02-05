/*
 * Use both the trapezoidal and simpson rule as methods for numerically calculating integration.  
 *
 * CSC 2262 Trapezoidal and Simpson Rules Program Findings
 *
 * @author Luke Higginbotham 899568628
 * @since 10/25/2020 
 */
package trapsimprules;


public class TrapSimpRules 
{

    //Main method used for calling the different rules with chosen intervals [a, b] and subintervals 512
    public static void main(String[] args) 
    {
        double a = 1;
        double b = 3;
        System.out.printf("Trapezoidal Rule: T512(f) = ");
        System.out.println(trapezoidal(a, b, 512));
        System.out.printf("Simpsons Rule: T512(f) = ");
        System.out.println(simpson(a, b, 512));
    }
    //This method uses f(x) = ln(x) on the intervals [a, b] using 512 subintervals to calculate the integration with Trapazoidal Rule.
    public static double trapezoidal(double a, double b, int subinterval)
    {
        double size = (b - a) / subinterval;
        double sum = 0.5 * (Math.log(a) + Math.log(b));
        //double sum = 0.5 * (Math.pow((1 + Math.pow(a, 2)), -1) + Math.pow((1 + Math.pow(b, 2)), -1));
        for(int i = 1; i < subinterval; i++)
        {
            double n = a + size * i;
            sum = sum + Math.log(n);
            //sum = sum + (Math.pow((1 + Math.pow(n, 2)), -1));
        }
        return sum * size;
    }
    //This method uses f(x) = ln(x) on the intervals [a, b] using 512 subintervals to calculate the integration with Simpson Rule.
    public static double simpson(double a, double b, int subinterval)
    {
        double size = (b - a) / (subinterval);
        //for 1/3
        double sum = 1.0 / 3.0 * (Math.log(a) + Math.log(b));
        //double sum = 1.0 / 3.0 * (Math.pow((1 + Math.pow(a, 2)), -1) + Math.pow((1 + Math.pow(b, 2)), -1));
        //for 4/3
        for(int i = 1; i < subinterval; i += 2)
        {
            double n = a + size * i;
            sum += 4.0 / 3.0 * Math.log(n);
            //sum += 4.0 / 3.0 * (Math.pow((1 + Math.pow(n, 2)), -1));
        }
        //for 2/3
        for(int i = 2; i < subinterval; i += 2)
        {
            double n = a + size * i;
            sum += 2.0 / 3.0 * Math.log(n);
            //sum += 2.0 / 3.0 * (Math.pow((1 + Math.pow(n, 2)), -1));
        }
        return sum * size;
    }
}
