package gui.helper;

/**
 * Help for keeping the same code style on every custom UI Class.
 *
 * Keeping every method mandatory allows for easier expansion of the class later on.
 */
public interface ViewInit {
    
    default void init() {
        initializeSelf();
        initializeControls();
        layoutControls();
        setupEventHandlers();
        setupValueChangedListeners();
        setupBindings();
    }
    
    void initializeSelf();
    
    void initializeControls();
    
    void layoutControls();
    
    void setupEventHandlers();
    
    void setupValueChangedListeners();
    
    void setupBindings();
    
}
