package org.skypro.skyshop.model.error;

public class ShopError {
    private final String code;
    private final String message;

    public ShopError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "ShopError{" + "code='" + code + ", message='" + message + " }";
    }
}
