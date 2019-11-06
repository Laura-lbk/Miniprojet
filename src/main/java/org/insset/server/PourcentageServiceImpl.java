/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.insset.client.service.PourcentageService;

/**
 *
 * @author user
 */
@SuppressWarnings("serial")
public class PourcentageServiceImpl extends RemoteServiceServlet implements
        PourcentageService {
    
    @Override
    public Integer RemiseMontant(Integer p_montant, Integer p_pourcent) throws IllegalArgumentException {
        
        int remise = p_montant * (p_pourcent/100);
                
        return remise;
    }
}