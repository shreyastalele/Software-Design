/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hateoas.appeals.stalele1.netbeans.client;

/**
 *
 * @author shreyasrameshtalele
 */

import java.net.URI;
import java.net.URISyntaxException;

public class RestAppealUri {
    private URI uri;
    
    public RestAppealUri(String uri) {
        try {
            this.uri = new URI(uri);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
    
    public RestAppealUri(URI uri) {
        this(uri.toString());
    }

    public RestAppealUri(URI uri, Identifier identifier) {
        this(uri.toString() + "/" + identifier.toString());
    }

    public Identifier getId() {
        String path = uri.getPath();
        return new Identifier(path.substring(path.lastIndexOf("/") + 1, path.length()));
    }
    
    public static String getURIWithoutId(URI uri1) {
        String path = uri1.toString();
        return new String(path.substring(0, path.lastIndexOf("/")));
    }

    public URI getFullUri() {
        return uri;
    }
    
    @Override
    public String toString() {
        return uri.toString();
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof RestAppealUri) {
            return ((RestAppealUri)obj).uri.equals(uri);
        }
        return false;
    }

    public String getBaseUri() {
        String uriString = uri.toString();
        String baseURI   = uriString.substring(0, uriString.lastIndexOf("appealresource/")+"appealresource".length());
        return baseURI;
    }
}
