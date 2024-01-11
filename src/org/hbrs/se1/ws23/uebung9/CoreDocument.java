package org.hbrs.se1.ws23.uebung9;

public abstract class CoreDocument implements Document{
    private String id;

    public void setId(String id) {
        this.id = id;
    }
    public String getid() {
        return this.id;
    }
    public abstract int getBytes();
}
