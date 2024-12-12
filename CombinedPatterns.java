package LP;
import java.util.ArrayList;
import java.util.List;
//Patron Observer
interface Observer {
   void update(String message);
}
class User implements Observer {
   private String name;
   public User(String name) {
       this.name = name;
   }
   @Override
   public void update(String message) {
       System.out.println(name + " recibio notificacion: " + message);
   }
}
//Patron Strategy
interface PricingStrategy {
   double calculatePrice(double basePrice);
}
class RegularPricing implements PricingStrategy {
   @Override
   public double calculatePrice(double basePrice) {
       return basePrice;
   }
}
class DiscountPricing implements PricingStrategy {
   private double discountPercentage;
   public DiscountPricing(double discountPercentage) {
       this.discountPercentage = discountPercentage;
   }
   @Override
   public double calculatePrice(double basePrice) {
       return basePrice * (1 - discountPercentage / 100);
   }
}
//Patron Command
interface Command {
   void execute();
}
class NotifyUsersCommand implements Command {
   private List<Observer> users;
   private String message;
   public NotifyUsersCommand(List<Observer> users, String message) {
       this.users = users;
       this.message = message;
   }
   @Override
   public void execute() {
       for (Observer user : users) {
           user.update(message);
       }
   }
}
//Aplicacion de los 3 patrones
class CombinedPatterns {
   private List<Observer> users;
   private PricingStrategy pricingStrategy;
   private List<Command> commands;
   public CombinedPatterns() {
       users = new ArrayList<>();
       commands = new ArrayList<>();
       pricingStrategy = new RegularPricing();
   }
   public void addUser(Observer user) {
       users.add(user);
   }
   public void setPricingStrategy(PricingStrategy strategy) {
       this.pricingStrategy = strategy;
   }
   public void addCommand(Command command) {
       commands.add(command);
   }
   public void executeCommands() {
       for (Command command : commands) {
           command.execute();
       }
       commands.clear();
   }
   public double calculatePrice(double basePrice) {
       return pricingStrategy.calculatePrice(basePrice);
   }
   public static void main(String[] args) {
       CombinedPatterns app = new CombinedPatterns();
       //Agregar usuarios (Observer)
       app.addUser(new User("Usuario1"));
       app.addUser(new User("Usuario2"));
       //Configurar estrategia de precios (Strategy)
       app.setPricingStrategy(new DiscountPricing(10));
       //Crear y ejecutar comandos (Command)
       app.addCommand(new NotifyUsersCommand(app.users, "Nueva oferta disponible!"));
       app.executeCommands();
       //Calcular precio con la estrategia actual
       double price = app.calculatePrice(100);
       System.out.println("Precio final: " + price);
   }
}

