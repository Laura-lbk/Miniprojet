/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 *
 * @author user
 */
@RemoteServiceRelativePath("pourcentage")
public interface PourcentageService extends RemoteService {

    Integer RemiseMontant(Integer p_montant, Integer p_pourcent) throws IllegalArgumentException;
    
    Integer MontantAvantRemise(Integer p_montant, Integer p_pourcent) throws IllegalArgumentException;
}