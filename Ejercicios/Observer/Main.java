package LP;
public class Main {
   public static void main(String[] args) {
       SistemaNotificaciones sistema = new SistemaNotificaciones();
       Usuario usuario1 = new Usuario("Juan");
       Usuario usuario2 = new Usuario("Maria");
       Usuario usuario3 = new Usuario("Carlos");
       sistema.registerObserver(usuario1);
       sistema.registerObserver(usuario2);
       sistema.registerObserver(usuario3);
       sistema.enviarNotificacion("Nueva promocion de verano disponible!");
       sistema.removeObserver(usuario2);
       sistema.enviarNotificacion("Actualizacio    n de productos en la tienda.");
       sistema.registerObserver(usuario2);
       sistema.enviarNotificacion("Evento especial para clientes VIP.");
   }
} 
