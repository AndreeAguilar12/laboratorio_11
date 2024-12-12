
package LP;
import java.util.Scanner;
// Interfaz Command
interface Comando {
    void ejecutar();
}
// Clase para encender 
class EncenderDispositivo implements Comando {
    private Dispositivo dispositivo;
    public EncenderDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }
    @Override
    public void ejecutar() {
        dispositivo.encender();
    }
}
// Clase para apagar 
class ApagarDispositivo implements Comando {
    private Dispositivo dispositivo;
    public ApagarDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }
    @Override
    public void ejecutar() {
        dispositivo.apagar();
    }
}
// Clase receptor 
interface Dispositivo {
    void encender();
    void apagar();
}
// Implementación concreta Luz
class Luz implements Dispositivo {
    @Override
    public void encender() {
        System.out.println("La luz está encendida.");
    }
    @Override
    public void apagar() {
        System.out.println("La luz está apagada.");
    }
}
// Implementación concreta Ventilador
class Ventilador implements Dispositivo {
    @Override
    public void encender() {
        System.out.println("El ventilador está encendido.");
    }
    @Override
    public void apagar() {
        System.out.println("El ventilador está apagado.");
    }
}
// Clase Invocador 
class ControlRemoto {
    private Comando comando;
    public void setComando(Comando comando) {
        this.comando = comando;
    }
    public void presionarBoton() {
        comando.ejecutar();
    }
}
public class SistemaControlRemoto {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        // Crear dispositivos
        Dispositivo luz = new Luz();
        Dispositivo ventilador = new Ventilador();
        // Crear el control remoto
        ControlRemoto control = new ControlRemoto();
        System.out.println("CONTROL REMOTO ");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Encender luz");
        System.out.println("2. Apagar luz");
        System.out.println("3. Encender ventilador");
        System.out.println("4. Apagar ventilador");
        System.out.print("Opcion: ");
        int opcion = entrada.nextInt();
        // Comandos para seleccionar una opción
        switch (opcion) {
            case 1:
                control.setComando(new EncenderDispositivo(luz));
                break;
            case 2:
                control.setComando(new ApagarDispositivo(luz));
                break;
            case 3:
                control.setComando(new EncenderDispositivo(ventilador));
                break;
            case 4:
                control.setComando(new ApagarDispositivo(ventilador));
                break;
            default:
                System.out.println("Opción inválida.");
                return;
        }
        //Ejecutar comando
        control.presionarBoton();
    }
}

