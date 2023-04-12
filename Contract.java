/**
 * This interface represents a contract that defines the methods required for interacting with a game character or object.
 */
public interface Contract {

    /**
     * Picks up the specified item.
     *
     * @param item the item to grab
     */
    void grab(String item);
  
    /**
     * Drops the specified item.
     *
     * @param item the item to drop
     * @return a message indicating whether the item was successfully dropped
     */
    String drop(String item);
  
    /**
     * Examines the specified item.
     *
     * @param item the item to examine
     */
    void examine(String item);
  
    /**
     * Uses the specified item.
     *
     * @param item the item to use
     */
    void use(String item);
  
    /**
     * Attempts to move the character in the specified direction.
     *
     * @param direction the direction to move in
     * @return true if the character was able to move in the specified direction, false otherwise
     */
    boolean walk(String direction);
  
    /**
     * Attempts to fly the character to the specified location. Must take off before flying.
     *
     * @param x the x-coordinate of the destination
     * @param y the y-coordinate of the destination
     * @return true if the character was able to fly to the specified location, false otherwise
     */
    boolean fly(int x, int y);
  
    /**
     * Shrinks the character.
     *
     * @return the new size of the character
     */
    Number shrink();
  
    /**
     * Grows the character.
     *
     * @return the new size of the character
     */
    Number grow();
  
    /**
     * Allows the character to rest.
     */
    void rest();
  
    /**
     * Undoes the last action performed by the character.
     */
    void undo();
  
  }