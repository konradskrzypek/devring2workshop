package org.devring.workshop.dogs;

public class NonuniqueDogNameException extends RuntimeException {
    
    public NonuniqueDogNameException(String name) {
        super(String.format("Dog named %s already in the repository", name));
    }
    
}
