import java.util.ArrayList;

/**
 * A class representing a flying castle that implements the Contract interface.
 * The castle can move in the air and allows the player to interact with items.
 * The player can grab and drop items, examine and use items, as well as grow or shrink the castle.
 * The player can also undo the previous action, take off, or land the castle.
 */
public class FlyingCastle implements Contract {

  /** The list of items in the castle */
  private ArrayList < String > items = new ArrayList < > ();
  /** The location of the castle on the x-axis */
  private int xloc = 0;
  /** The location of the castle on the y-axis */
  private int yloc = 0;
  /** A boolean indicating whether the castle is flying */
  private boolean isFlying = false;
  /** A log of history recording every actions of the castle */
  private ArrayList < String > history = new ArrayList < > ();
  /** The original size of the house */
  Number size = 280;

  /**
   * Adds an action to the history list.
   * @param action The action to add to the history list.
   */
  private void addToHistory(String action) {
    history.add(action);
  }

  /**
   * Allows the user to grab an item.
   * Adds the item to the user's possession and adds the action to the history.
   * @param item The item to grab.
   */
  public void grab(String item) {
    items.add(item);
    String action = "You grabbed this " + item + ". Careful!";
    addToHistory(action);
    System.out.println(action);
  }

  /**
   * Allows the user to drop an item.
   * Removes the item from the user's possession and logs the action to the history.
   * @param item The item to drop.
   * @return The item that was dropped.
   * @throws RuntimeException If the item is not in the user's possession.
   */
  @Override
  public String drop(String item) {
    if (items.contains(item)) {
      items.remove(item);
      String action = "You dropped this " + item + ".";
      addToHistory(action);
      System.out.println(action);
      return item;
    } else {
      throw new RuntimeException("This item is not in your possession.");
    }
  }

  /**
   * Allows the user to examine an item.
   * Logs the action to the history list.
   * @param item The item to examine.
   * @throws RuntimeException If the item is not in the user's possession.
   */
  @Override
  public void examine(String item) {
    if (items.contains(item)) {
      String action = "You examined the " + item + ".";
      addToHistory(action);
      System.out.println(action);
    } else {
      throw new RuntimeException("This item is not in your possession.");
    }
  }

  /**
   * Allows the user to use an item.
   * Logs the action to the history list.
   * @param item The item to use.
   * @throws RuntimeException If the item is not in the user's possession.
   */
  @Override
  public void use(String item) {
    if (items.contains(item)) {
      String action = "You used the " + item + ".";
      addToHistory(action);
      System.out.println(action);
    } else {
      throw new RuntimeException("This item is not in your possession.");
    }
  }

  /**
   * Returns false because the castle can't walk in the air.
   * Logs the action to the history list.
   * @param direction The direction to walk.
   * @return false.
   */
  public boolean walk(String direction) {
    String action = "You can't walk in the air.";
    addToHistory(action);
    System.out.println(action);
    return false;
  }

  /**
   * Returns a boolean indicating whether the castle can fly or not.
   * Logs the action to the history list.
   * @param x location on the x-axis
   * @param y location on the y-axis
   * @return false.
   */
  public boolean fly(int x, int y) {
    if (!isFlying) {
      throw new RuntimeException("You can't fly while the castle is on the ground. Must take off before flying.");
    } else {
      this.xloc = x;
      this.yloc = y;
      String action = "You flew the castle to (" + xloc + ", " + yloc + "). Hurrayyyyy!";
      addToHistory(action);
      System.out.println(action);
      return true;
    }
  }

  /**
   * Allows the user to shrink the castle if the size is above 0. The default shrink rate is 10 units everytime you use this spell.
   * @return 0;
   */
  public Number shrink() {
    if (this.size.intValue() <= 0){
        throw new RuntimeException("The castle cannot shrink right now.");
    } else {
        this.size = this.size.intValue() - 10;
        String action = "You shrink the castle. Hiding from somebody?";
        addToHistory(action);
        System.out.println(action);
        return 0;
    }
  }

  /**
   * Allows the user to grow the castle. The default growth rate is 10 units everytime you use this spell.
   * @return 0;
   */
  public Number grow() {
    this.size = this.size.intValue() + 10;
    String action = "You grew the castle. Ooohhhhhh....";
    addToHistory(action);
    System.out.println(action);
    return this.size;
  }

  /**
   * Allows the user to rest inside the castle.
   */
  public void rest() {
    String action = "You rest inside the castle. What a long day!";
    addToHistory(action);
    System.out.println(action);
  }

  /**
   * Allows the user to undo the last action in the history log.
   */
  public void undo() {
    if (history.size() > 0) {
      String lastAction = history.remove(history.size() - 1);
      System.out.println("Undo: " + lastAction);
    } else {
      System.out.println("Nothing to undo.");
    }
  }

  /**
   * Allows the user to take off into the air.
   */
  public void takeOff() {
    isFlying = true;
    String action = "You took off into the air. Breezy today, eh?";
    addToHistory(action);
    System.out.println(action);
  }

  /**
   * Allows the user to land the castle.
   */
  public void land() {
    isFlying = false;
    String action = "You landed the castle. Phew!";
    addToHistory(action);
    System.out.println(action);
  }

  /**
   * Main method to create and test FlyingCastle objects.
   */
  public static void main(String[] args) {
    FlyingCastle HowlsFlyingCastle = new FlyingCastle();
    HowlsFlyingCastle.grow();
    HowlsFlyingCastle.undo();
    HowlsFlyingCastle.undo();
    HowlsFlyingCastle.grab("pencil");
    HowlsFlyingCastle.grab("apple");
    HowlsFlyingCastle.drop("pencil");
    HowlsFlyingCastle.shrink();
  }

}