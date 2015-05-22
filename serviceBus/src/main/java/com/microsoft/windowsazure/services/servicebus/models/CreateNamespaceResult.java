package com.microsoft.windowsazure.services.servicebus.models;

public class CreateNamespaceResult {

    private NamespaceInfo value;

    public CreateNamespaceResult(NamespaceInfo value) {
        this.setValue(value);
    }

    public void setValue(NamespaceInfo value) {
        this.value = value;
    }

    public NamespaceInfo getValue() {
        return value;
    }

}
