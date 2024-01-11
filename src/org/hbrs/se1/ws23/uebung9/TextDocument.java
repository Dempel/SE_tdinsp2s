package org.hbrs.se1.ws23.uebung9;

import java.io.UnsupportedEncodingException;

public class TextDocument extends CoreDocument{
    private String inhalt;
    public Encoding encoding;

    public TextDocument (String inhalt, Encoding encoding) {
        this.inhalt = inhalt;
        this.encoding = encoding;
    }

    @Override
    public int getBytes() {
        try {
            final byte[] utf8Bytes = inhalt.getBytes(encoding.getEncoding());
            return utf8Bytes.length;
        } catch (UnsupportedEncodingException e) {
            return 0;
        }
    }
}
