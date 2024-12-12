package LP;
public interface Subject {
   void registerObserver(Observer o);
   void removeObserver(Observer o);
   void notifyObservers(String message);
}
