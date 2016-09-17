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

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@XmlRootElement(namespace = Representation.DAP_NAMESPACE)
public class Link {
    
    private static final Logger LOG = LoggerFactory.getLogger(Link.class);
    
    @XmlAttribute(name = "rel")
    private String rel;
    @XmlAttribute(name = "uri")
    private String uri;

    @XmlAttribute(name = "mediaType")
    private String mediaType;

    Link() {
        LOG.info("Link Constructor");
    }

    public Link(String name, RestAppealUri uri, String mediaType) {
        LOG.info("Creating a Link object");
        LOG.debug("name = {}", name);
        LOG.debug("uri = {}", uri);
        LOG.debug("mediaType = {}", mediaType);
        
        this.rel = name;
        this.uri = uri.getFullUri().toString();
        this.mediaType = mediaType;

        LOG.debug("Created Link Object {}", this);
    }

    public Link(String name, RestAppealUri uri) {
        this(name, uri, Representation.RESTAPPEAL_MEDIA_TYPE);
    }

    public String getRelValue() {
        LOG.debug("Retrieving the rel attribute value {}", rel);
        return rel;
    }

    public URI getUri() {
        try {
            URI local_uri = new URI(uri);
            LOG.debug("Retrieving the uri attribute value {}", local_uri);
            return local_uri;
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public String getMediaType() {
        LOG.debug("Retrieving the media type attribute value {}", mediaType);
        return mediaType;
    }
}
