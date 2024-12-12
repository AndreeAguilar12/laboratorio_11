package LP;
import java.util.Scanner;
// Interfaz EstrategiaDescuento
interface EstrategiaDescuento {
    double aplicarDescuento(double precio);
}
// Implementaciones concretas de la estrategia
class SinDescuento implements EstrategiaDescuento {
    @Override
    public double aplicarDescuento(double precio) {
        return precio; 
    }
}
class DescuentoFijo implements EstrategiaDescuento {
    private static final double DESCUENTO = 0.10; 
    @Override
    public double aplicarDescuento(double precio) {
        return precio * (1 - DESCUENTO);
    }
}
class DescuentoPorcentual implements EstrategiaDescuento {
    private static final double DESCUENTO = 0.30; 
    @Override
    public double aplicarDescuento(double precio) {
        return precio * (1 - DESCUENTO);
    }
}
class DescuentoAcumulado implements EstrategiaDescuento {
    private static final double DESCUENTO = 0.50; 
    @Override
    public double aplicarDescuento(double precio) {
        return precio * (1 - DESCUENTO);
    }
}
class CalculadoraPrecios {
    private EstrategiaDescuento estrategiaDescuento;
    // metodo para cambiar la estrategia al momento de ejecutar
    public void setEstrategiaDescuento(EstrategiaDescuento estrategiaDescuento) {
        this.estrategiaDescuento = estrategiaDescuento;
    }
    public double calcularPrecio(double precio) {
        return estrategiaDescuento.aplicarDescuento(precio);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculadoraPrecios calculadora = new CalculadoraPrecios();
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        System.out.println("Seleccione una estrategia de descuento:");
        System.out.println("1. Sin Descuento");
        System.out.println("2. Descuento Fijo (10%)");
        System.out.println("3. Descuento Porcentual (30%)");
        System.out.println("4. Descuento Acumulado (50%)");
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                calculadora.setEstrategiaDescuento(new SinDescuento());
                break;
            case 2:
                calculadora.setEstrategiaDescuento(new DescuentoFijo());
                break;
            case 3:
                calculadora.setEstrategiaDescuento(new DescuentoPorcentual());
                break;
            case 4:
                calculadora.setEstrategiaDescuento(new DescuentoAcumulado());
                break;
            default:
                System.out.println("Sin descuento.");
                calculadora.setEstrategiaDescuento(new SinDescuento());
        }
        double precioFinal = calculadora.calcularPrecio(precio);
        System.out.println("El precio final es: S/." + precioFinal);
    }
}
