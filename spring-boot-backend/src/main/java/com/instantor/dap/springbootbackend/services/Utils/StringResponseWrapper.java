package com.instantor.dap.springbootbackend.services.Utils;

public class StringResponseWrapper {

    private String response;

    public StringResponseWrapper(String response) {
        this.response = response;
    }

    public String getResponse(Long hunterId) {
        return response;
    }
}
