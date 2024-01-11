package org.hbrs.se1.ws23.uebung9;

public class GraficDocument extends CoreDocument{
    private String url;

    public GraficDocument(String url) {
        this.url = url;
    }

    @Override
    public int getBytes() {
        return 1200;
    }
}
