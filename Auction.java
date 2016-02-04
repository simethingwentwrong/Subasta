import java.util.ArrayList;

/**
 * A simple model of an auction.
 * The auction maintains a list of lots of arbitrary length.
 *
 * @author David J. Barnes and Michael Kölling.
 * @version 2011.07.31
 */
public class Auction
{
    // The list of Lots in this auction.
    private ArrayList<Lot> lots;
   
    // The number that will be given to the next lot entered
    // into this auction.
    private int nextLotNumber;

    /**
     * Create a new auction.
     */
    public Auction()
    {
        lots = new ArrayList<Lot>();
        nextLotNumber = 1;
    }

    /**
     * Enter a new lot into the auction.
     * @param description A description of the lot.
     */
    public void enterLot(String description)
    {
        lots.add(new Lot(nextLotNumber, description));
        nextLotNumber++;
    }

    /**
     * Show the full list of lots in this auction.
     */
    public void showLots()
    {
        for(Lot lot : lots) {
            System.out.println(lot.toString());
        }
    }
    
    /**
     * Make a bid for a lot.
     * A message is printed indicating whether the bid is
     * successful or not.
     * 
     * @param lotNumber The lot being bid for.
     * @param bidder The person bidding for the lot.
     * @param value  The value of the bid.
     */
    public void makeABid(int lotNumber, Person bidder, long value)
    {
        Lot selectedLot = getLot(lotNumber);
        if(selectedLot != null) {
            
            boolean successful = selectedLot.bidFor( new Bid (bidder, value));
            if(successful) {
                System.out.println("The bid for lot number " +
                                   lotNumber + " was successful.");
            }
            else {
                // Report which bid is higher.
                
                System.out.println("Lot number: " + lotNumber +
                                   " already has a bid of: " +
                                   selectedLot.getHighestBid().getValue());
            }
        }
    }

    /**
     * Return the lot with the given number. Return null
     * if a lot with this number does not exist.
     * @param lotNumber The number of the lot to return.
     */
    public Lot getLot(int lotNumber)
    {
        if((lotNumber >= 1) && (lotNumber < nextLotNumber)) {
            // The number seems to be reasonable.
            Lot selectedLot = lots.get(lotNumber - 1);
            // Include a confidence check to be sure we have the
            // right lot.
            if(selectedLot.getNumber() != lotNumber) {
                System.out.println("Internal error: Lot number " +
                                   selectedLot.getNumber() +
                                   " was returned instead of " +
                                   lotNumber);
                // Don't return an invalid lot.
                selectedLot = null;
            }
            return selectedLot;
        }
        else {
            System.out.println("Lot number: " + lotNumber +
                               " does not exist.");
            return null;
        }
    }
    
    /**
     * Muestra por pantalla los detalles de todos los items que se est�n subastando actualmente. De aquellos por los que haya habido pujas se debe indicar el nombre de la persona que ha hecho la puja m�s alta y el valor de dicha puja; del resto debe indicar que no ha habido pujas.
     */
     public void close()
     {
         for (Lot elemento : lots)
         {
             System.out.println(elemento.toString());
             Bid pujaMasAlta = elemento.getHighestBid();
             if(elemento.getHighestBid() == null)
             {
                System.out.println("No hay pujas para el elemento buscado");
             }
             else
             {
                System.out.println(" El nombre de la persona que ha pujado mas alto es: " + elemento.getHighestBid().getBidder().getName());
                System.out.println("El precio de cuanto pujo sobre el objeto fue de: " + elemento.getHighestBid().getValue());
             }
            }
    }
    
    /**
    * devuelva una colecci�n de todos los items por los que no habido ninguna puja en este momento
    */
    public ArrayList<Lot> getUnsold()
    {
        items = new  ArrayList<item>();
        for (Lot elemento : lots)
        {
         if (elemento.getHighestBid() == null)
         {
           items.add(getHighestBid());      
         }
    
        
       }
    }
}
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         

