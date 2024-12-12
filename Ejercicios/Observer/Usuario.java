package LP;
public class Usuario implements Observer {
   private String nombre;
   public Usuario(String nombre) {
       this.nombre = nombre;
   }
   @Override
   public void update(String message) {
       System.out.println(nombre + " ha recibido una notificacion: " + message);
   }
   public String getNombre() {
       return nombre;
   }
}

