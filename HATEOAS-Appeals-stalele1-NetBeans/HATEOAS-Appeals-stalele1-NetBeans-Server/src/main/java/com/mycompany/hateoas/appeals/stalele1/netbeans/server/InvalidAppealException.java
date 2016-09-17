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
public class InvalidAppealException extends RuntimeException{
    
    public InvalidAppealException(Exception ex) {
        super(ex);
    }
    public InvalidAppealException() {}
}
