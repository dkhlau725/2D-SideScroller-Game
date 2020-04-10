package hunter2d.View;

/**
 * Views should take in a model and use its render method to
 * render the model. 
 */
abstract public class View {    

    /**
     * Examples of concrete implementations of this method 
     * would be to print the properties of a model in the console or
     * to draw them onto the screen.
     */
    abstract public void render();
}