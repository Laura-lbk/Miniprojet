/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.client.pourcentage;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ResetButton;
import com.google.gwt.user.client.ui.SubmitButton;
import com.google.gwt.user.client.ui.TextBox;
import org.insset.client.message.dialogbox.DialogBoxInssetPresenter;
import org.insset.shared.FieldVerifier;
import org.insset.client.service.PourcentageService;
import org.insset.client.service.PourcentageServiceAsynch;


/**
 *
 * @author talend
 */
public class PourcentagePresenter extends Composite {
    
    @UiField
    public ResetButton boutonClear;
    @UiField
    public SubmitButton boutonEnregistrer;
    @UiField
    public TextBox TBmontant;
    @UiField
    public TextBox TBpourcent;
    @UiField
    public Label montantErrorLabel;
    @UiField
    public Label pourcentErrorLabel;
    
    /**
     * The message displayed to the user when the server cannot be reached or
     * returns an error.
     */
    private static final String SERVER_ERROR = "An error occurred while "
            + "attempting to contact the server. Please check your network "
            + "connection and try again.";
    
    interface AddUiBinder extends UiBinder<HTMLPanel, PourcentagePresenter> {
    }
    /**
     * Create UiBinder for the view
     */
    private static AddUiBinder ourUiBinder = GWT.create(AddUiBinder.class);
    
    
    private final PourcentageServiceAsynch service = GWT.create(PourcentageService.class);
      
    
    /**
     * Constructeur
     */
    public PourcentagePresenter() {
        //bind de la page
        initWidget(ourUiBinder.createAndBindUi(this));
        initHandler();
    }
    
    /**
     * Methode qui innitialise les handler pour les cliques sur les boutons
     */
    private void initHandler() {
        boutonClear.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                TBmontant.setText("");
                montantErrorLabel.setText("");
                TBpourcent.setText("");
                pourcentErrorLabel.setText("");
            }
        });
        boutonEnregistrer.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                RemiseMontant();
            }

        });
    }
    
    private void RemiseMontant() {
        Integer value = null;
        Integer value2 = null;
        try {
            value = Integer.parseInt(TBmontant.getText());
        } catch (NumberFormatException e) {
            montantErrorLabel.addStyleName("serverResponseLabelError");
            montantErrorLabel.setText("Format incorect");
            return;
        }
        if (!FieldVerifier.isValidDecimal(value)) {
            montantErrorLabel.addStyleName("serverResponseLabelError");
            montantErrorLabel.setText("Aucun montant entré !");
            return;
        }

        try {
            value2 = Integer.parseInt(TBpourcent.getText());
        } catch (NumberFormatException e) {
            pourcentErrorLabel.addStyleName("serverResponseLabelError");
            pourcentErrorLabel.setText("Format incorect");
            return;
        }
        if (!FieldVerifier.isValidDecimal(value2)) {
            pourcentErrorLabel.addStyleName("serverResponseLabelError");
            pourcentErrorLabel.setText("Aucun pourcentage entré !");
            return;
        }
        
        service.RemiseMontant(Integer.parseInt(TBmontant.getText()), Integer.parseInt(TBpourcent.getText()), new AsyncCallback<Integer>() {
            public void onFailure(Throwable caught) {
                // Show the RPC error message to the user
                Window.alert(SERVER_ERROR);
            }

            public void onSuccess(Integer result) {
                montantErrorLabel.setText(" ");
                new DialogBoxInssetPresenter("Votre montant : ", TBmontant.getText(), String.valueOf(result));
            }
        });
    }
}
