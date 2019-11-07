/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.client.message.dialogbox;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 *
 * @author user
 */
public class DialogBoxInssetPresenter extends DialogBox {

    public DialogBoxInssetPresenter(String titre, String demande, String reponse) {
        super();
        this.setText(titre);
        formateBox(demande, reponse);
    }

    private void formateBox(String demande, String reponse) {

//         Create the popup dialog box
        setAnimationEnabled(true);
        final Button closeButton = new Button("Close");
        // We can set the id of a widget by accessing its Element
        closeButton.getElement().setId("closeButton");

        //Add a handler to close the DialogBox
        closeButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                hide();
            }
        });

        final Label textToServerLabel = new Label(demande);
        final HTML serverResponseLabel = new HTML(reponse);
        VerticalPanel dialogVPanel = new VerticalPanel();
        dialogVPanel.addStyleName("dialogVPanel");
        dialogVPanel.add(new HTML("<b>Demande envoyé au server :</b>"));
        dialogVPanel.add(textToServerLabel);
        dialogVPanel.add(new HTML("<br><b>Reponse :</b>"));
        dialogVPanel.add(serverResponseLabel);
        dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
        dialogVPanel.add(closeButton);
        setWidget(dialogVPanel);
        center();
        closeButton.setFocus(true);
    }
    
    public DialogBoxInssetPresenter(String titre, String demande1, String demande2, String reponse, String demande3) {
        super();
        this.setText(titre);
        formateBoxPourcentage(demande1, demande2, reponse, demande3);
    }

    private void formateBoxPourcentage(String demande1, String demande2, String reponse, String demande3) {

//         Create the popup dialog box
        setAnimationEnabled(true);
        final Button closeButton = new Button("Close");
        // We can set the id of a widget by accessing its Element
        closeButton.getElement().setId("closeButton");

        //Add a handler to close the DialogBox
        closeButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                hide();
            }
        });

        final Label textToServerLabel = new Label(demande1);
        final Label textToServerLabel2 = new Label(demande2);
        final HTML serverResponseLabel = new HTML(reponse);
        final Label textToServerLabel3 = new Label(demande3);
        VerticalPanel dialogVPanel = new VerticalPanel();
        dialogVPanel.addStyleName("dialogVPanel");
        dialogVPanel.add(new HTML("<b>Votre montant :</b>"));
        dialogVPanel.add(textToServerLabel);
        dialogVPanel.add(new HTML("<b>Votre pourcentage :</b>"));
        dialogVPanel.add(textToServerLabel2);
        dialogVPanel.add(new HTML("<b>Remise :</b>"));
        dialogVPanel.add(serverResponseLabel);
        dialogVPanel.add(new HTML("<b>Montant après remise :</b>"));
        dialogVPanel.add(textToServerLabel3);
        dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
        dialogVPanel.add(closeButton);
        setWidget(dialogVPanel);
        center();
        closeButton.setFocus(true);
    }
    
    public DialogBoxInssetPresenter(String titre, String demande1, String demande2, String demande3) {
        super();
        this.setText(titre);
        formateBoxPourcentage2(demande1, demande2, demande3);
    }

    private void formateBoxPourcentage2(String demande1, String demande2, String demande3) {

//         Create the popup dialog box
        setAnimationEnabled(true);
        final Button closeButton = new Button("Close");
        // We can set the id of a widget by accessing its Element
        closeButton.getElement().setId("closeButton");

        //Add a handler to close the DialogBox
        closeButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                hide();
            }
        });

        final Label textToServerLabel = new Label(demande1);
        final Label textToServerLabel2 = new Label(demande2);
        final Label textToServerLabel3 = new Label(demande3);
        VerticalPanel dialogVPanel = new VerticalPanel();
        dialogVPanel.addStyleName("dialogVPanel");
        dialogVPanel.add(new HTML("<b>Votre montant :</b>"));
        dialogVPanel.add(textToServerLabel);
        dialogVPanel.add(new HTML("<b>Votre pourcentage :</b>"));
        dialogVPanel.add(textToServerLabel2);
        dialogVPanel.add(new HTML("<b>Montant avant remise :</b>"));
        dialogVPanel.add(textToServerLabel3);
        dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
        dialogVPanel.add(closeButton);
        setWidget(dialogVPanel);
        center();
        closeButton.setFocus(true);
    }

}
