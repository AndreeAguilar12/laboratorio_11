package LP;
import java.util.ArrayList;
import java.util.List;
interface Observer {
   void update(String message);
}
class User implements Observer {
   private String name;
   private String email;
   public User(String name, String email) {
       this.name = name;
       this.email = email;
   }
   @Override
   public void update(String message) {
       sendEmail(message);
   }
   private void sendEmail(String message) {
       System.out.println("Enviando correo a "+email+": "+message);
   }
}
class Notificaciones {
   private List<Observer> observers = new ArrayList<>();
   public void addObserver(Observer observer) {
       observers.add(observer);
   }
   public void removeObserver(Observer observer) {
       observers.remove(observer);
   }
   public void notifyObservers(String message) {
       for (Observer observer : observers) {
           observer.update(message);
       }
   }
}
public class SistemaNotificaciones {
   public static void main(String[] args) {
       Notificaciones system = new Notificaciones();
      
       User user1 = new User("Andree", "andree.aguilar@ucsm.com");
       User user2 = new User("Juan", "Juan15@gmail.com");
       system.addObserver(user1);
       system.addObserver(user2);
       system.notifyObservers("¡Nuevo mensaje importante!");
   }
}
