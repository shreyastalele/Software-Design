/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hateoas.appeals.stalele1.netbeans.server;

/**
 *
 * @author shreyasrameshtalele
 */
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public abstract class Representation {
    public static final String RELATIONS_URI = "http://relations.appeal.com/";
    public static final String RESTAPPEAL_NAMESPACE = "http://schemas.restappeals.com";
    public static final String DAP_NAMESPACE = RESTAPPEAL_NAMESPACE + "/dap";
    public static final String RESTAPPEAL_MEDIA_TYPE = "application/vnd-appeals+xml";
    public static final String SELF_REL_VALUE = "self";

    @XmlElement(name = "link", namespace = DAP_NAMESPACE)
    protected List<Link> links;

    protected Link getLinkByName(String uriName) {
        if (links == null) {
            return null;
        }
        for (Link l : links) {
            if (l.getRelValue().toLowerCase().equals(uriName.toLowerCase())) {
                return l;
            }
        }
        return null;
    }
}
