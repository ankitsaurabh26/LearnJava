package com.demo.ecommerce.exception;

/**
 * ================================================================
 * ResourceNotFoundException - Jab koi cheez database mein na mile
 *
 * RuntimeException extend karte hain taaki checked exception
 * handle na karna pade har jagah.
 *
 * Example: Product ID 99 maango jo exist hi nahi karta
 * ================================================================
 */
public class ResourceNotFoundException extends RuntimeException {

    private final String resourceName;  // Kaunsa resource nahi mila (Product/Category)
    private final String fieldName;     // Kaunsa field se dhundha (id/name)
    private final Object fieldValue;    // Kya value se dhundha (99 / "Electronics")

    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        // Message automatically banta hai
        super(String.format("%s nahi mila jiska %s = '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() { return resourceName; }
    public String getFieldName() { return fieldName; }
    public Object getFieldValue() { return fieldValue; }
}
