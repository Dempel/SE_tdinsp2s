package org.hbrs.se1.ws23.uebung9;

import java.util.ArrayList;
import java.util.List;

public class ComplexDocument implements Document {
    private List<Document> documents = new ArrayList<>();

    public void addDocument(Document doc) {
        documents.add(doc);
    }
    public boolean removeDocument(Document doc) {
        return documents.remove(doc);
    }
    public int getTotalBytes() {
        int size = 0;
        for (Document doc: documents) {
            if (doc instanceof ComplexDocument) {
                size += ((ComplexDocument) doc).getTotalBytes();
            }
            else {
                size += ((CoreDocument) doc).getBytes();
            }
        }
        return size;
    }
}
