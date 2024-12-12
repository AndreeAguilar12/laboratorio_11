package LP;
interface PromotionStrategy {
   double applyPromotion(double price);
}
class NoPromotion implements PromotionStrategy {
   @Override
   public double applyPromotion(double price) {
       return price;
   }
}
class PercentageDiscount implements PromotionStrategy {
   private double percentage;
   public PercentageDiscount(double percentage) {
       this.percentage = percentage;
   }
   @Override
   public double applyPromotion(double price) {
       return price * (1 - percentage / 100);
   }
}
class FixedDiscount implements PromotionStrategy {
   private double discount;
   public FixedDiscount(double discount) {
       this.discount = discount;
   }
   @Override
   public double applyPromotion(double price) {
       return Math.max(0, price - discount);
   }
}
class PromotionSystem {
   private PromotionStrategy strategy;
   public void setStrategy(PromotionStrategy strategy) {
       this.strategy = strategy;
   }
   public double calculatePrice(double originalPrice) {
       return strategy.applyPromotion(originalPrice);
   }
   public static void main(String[] args) {
       PromotionSystem system = new PromotionSystem();
       double originalPrice = 100.0;
       system.setStrategy(new NoPromotion());
       System.out.println("Precio sin promocion: " + system.calculatePrice(originalPrice));
       system.setStrategy(new PercentageDiscount(20));
       System.out.println("Precio con 20% de descuento: " + system.calculatePrice(originalPrice));
       system.setStrategy(new FixedDiscount(30));
       System.out.println("Precio con descuento fijo de 30: " + system.calculatePrice(originalPrice));
   }
}
