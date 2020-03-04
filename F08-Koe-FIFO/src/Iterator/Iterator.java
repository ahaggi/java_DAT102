package Iterator;

public interface Iterator<T>
{
 /** Avgjør om iteratorasjonen har fullført.
     @return true hvis iterasjonen har flere elementer*/  
  public boolean hasNext();
  
  
  /** Henter neste element i samlingen hvis den fins.
  Flytter til neste element.
  @return element hvis det eksisterer
  @throws NoSuchElementsException hvis iterasjonen har
          nådd slutten, hvis hasNext() er false */    
  public T next();
    
//  public void remove();//Optionell metode  
  
}