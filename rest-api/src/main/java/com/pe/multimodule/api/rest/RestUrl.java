package com.pe.multimodule.api.rest;

public final class RestUrl {

    public static final String APP_VERSION = "/v1";

    // Public ones


    // Products
    public static final String PRODUCTS = APP_VERSION + "/products";
    public static final String SEARCH = PRODUCTS + "/search";


    // Secured ones
    // All endpoints under this path, requires the user to be logged in
    // All endpoints outside this path are free of use by anonymous access
    public static final String SECURED = APP_VERSION + "/secured";

    // Products
    public static final String SECURED_PRODUCTS = SECURED + "/products";

    private RestUrl() {
        // Constants
    }
}
