/*******************************************************************************
 * Copyright (c) 2014, Pharmed Solutions GmbH
 * All rights reserved.
 *******************************************************************************/

package ch.pharmed.phmprescriber;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import ch.elexis.core.data.activator.CoreHub;

public class PhMPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

	private Physician ph;
	
	private Text textboxZSRid;
	private Text textboxTitle;
	private Text textboxFirstname;
	private Text textboxLastname;
	private Text textboxStreet;
	private Text textboxPostbox;
	private Text textboxZip;
	private Text textboxCity;
	private Text textboxPhone;
	private Text textboxFax;
	private Text textboxSpecialty1;
	private Text textboxSpecialty2;
	private Text textboxGLNid;
	

	private Composite compAddress;
	private Composite compInteraction;
	private Button btngetAddress;
	private Button btnCboInteraction;

	
	/**
	 * Create the preference page.
	 */
	public PhMPreferencePage(){
		
		
	}
	
	/**
	 * Initialize the preference page.
	 */
	public void init(IWorkbench workbench){
		
		// Initialize the preference page
		
		//Create new physician
		ph = new Physician();
				
	}
	
	/**
	 * Create contents of the preference page.
	 * 
	 * @param parent
	 */
	@Override
	public Control createContents(Composite parent){
		
		Composite container = new Composite(parent, SWT.NULL);
		container.setLayout(new GridLayout(1, false));
		
		//(1) Container for ZSR
		Group zsrgroup = new Group(container, SWT.None);
		zsrgroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		zsrgroup.setLayout(new GridLayout(2, false));
		zsrgroup.setText("Einstellung für die Rezeptübermittlung via PhM Prescriber");
		
		Label lblZSR = new Label(zsrgroup, SWT.NONE);
		lblZSR.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblZSR.setText("ZSR-Nummer: ");
		
		textboxZSRid = new Text(zsrgroup, SWT.BORDER);
		textboxZSRid.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		textboxZSRid.setMessage("ZSR eingeben");
		
		//(2) Button for requesting the address
		compAddress = new Composite(container, SWT.NONE);
		compAddress.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		compAddress.setLayout(new GridLayout(3, false));
		
		SelectionListener AddressSL = new AddressSelectionButtonListener();
		
		btngetAddress = new Button(compAddress, SWT.PUSH);
		btngetAddress.setText("Personalien automatisch abrufen");
		btngetAddress.addSelectionListener(AddressSL);
		
		
		//(3) Container with all fields for the address
		Group addressgroup = new Group(container, SWT.None);
		addressgroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		addressgroup.setLayout(new GridLayout(4, false));
		addressgroup.setText("Aufzudruckende Personalien (angezeigt auf Rezept)");
		
		Label lblAnrede = new Label(addressgroup, SWT.NONE);
		lblAnrede.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblAnrede.setText("Anrede ");
		
		textboxTitle = new Text(addressgroup, SWT.BORDER);
		textboxTitle.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		textboxTitle.setMessage("Dr. med. o.ä.");
		
		Label lblFirstname = new Label(addressgroup, SWT.NONE);
		lblFirstname.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblFirstname.setText("Vorname ");
		
		textboxFirstname = new Text(addressgroup, SWT.BORDER);
		textboxFirstname.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
	
		Label lblLastname = new Label(addressgroup, SWT.NONE);
		lblLastname.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblLastname.setText("Nachname ");
		
		textboxLastname= new Text(addressgroup, SWT.BORDER);
		textboxLastname.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		
		Label lblStreet = new Label(addressgroup, SWT.NONE);
		lblStreet.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblStreet.setText("Strasse ");
		
		textboxStreet = new Text(addressgroup, SWT.BORDER);
		textboxStreet.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		
		Label lblPobo = new Label(addressgroup, SWT.NONE);
		lblPobo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPobo.setText("Hausnummer ");
		
		textboxPostbox = new Text(addressgroup, SWT.BORDER);
		textboxPostbox.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		
	
		Label lblZip = new Label(addressgroup, SWT.NONE);
		lblZip.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblZip.setText("PLZ ");
		
		textboxZip = new Text(addressgroup, SWT.BORDER);
		textboxZip.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		
		Label lblCity = new Label(addressgroup, SWT.NONE);
		lblCity.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblCity.setText("Ort ");
		
		textboxCity = new Text(addressgroup, SWT.BORDER);
		textboxCity.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));

		
		Label lblPhone = new Label(addressgroup, SWT.NONE);
		lblPhone.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPhone.setText("Telefon ");
		
		textboxPhone = new Text(addressgroup, SWT.BORDER);
		textboxPhone.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		
	
		Label lblFax = new Label(addressgroup, SWT.NONE);
		lblFax.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblFax.setText("Fax ");
		
		textboxFax = new Text(addressgroup, SWT.BORDER);
		textboxFax.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		
		Label lblGLNid = new Label(addressgroup, SWT.NONE);
		lblGLNid.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblGLNid.setText("GLN ");
		
		textboxGLNid = new Text(addressgroup, SWT.BORDER);
		textboxGLNid.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));

		Label lblSpecialty1 = new Label(addressgroup, SWT.NONE);
		lblSpecialty1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSpecialty1.setText("Fachrichtung ");
		
		textboxSpecialty1 = new Text(addressgroup, SWT.BORDER);
		textboxSpecialty1.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		
		Label lblSpecialty2 = new Label(addressgroup, SWT.NONE);
		lblSpecialty2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSpecialty2.setText("Spezialisierung ");
		
		textboxSpecialty2 = new Text(addressgroup, SWT.BORDER);
		textboxSpecialty2.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		
	
		
		//(4) Button for enabling automatic DD-interaction check
		compInteraction = new Composite(container, SWT.NONE);
		compInteraction.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		compInteraction.setLayout(new GridLayout(3, false));
		
		SelectionListener interactionSL = new InteractionSelectionButtonListener();
		
		btnCboInteraction = new Button(compInteraction, SWT.CHECK);
		btnCboInteraction.setData(Constants.CFG_INTERATCIONS);
		btnCboInteraction.setText("Rezept auf Interaktionen prüfen");
		btnCboInteraction.addSelectionListener(interactionSL);
		
		
		String interactionsEnabled =
			CoreHub.globalCfg.get(Constants.CFG_INTERATCIONS,
					Constants.CFG_INTERATCIONS);
		if (interactionsEnabled.equals("true")) {
			btnCboInteraction.setSelection(true);
		}
		
		
		bindData();
		
		return container;
	}
	
	
	/**
	 * Bind the objects properties to the particular text boxes
	 */
	protected void bindData(){
	
		textboxZSRid.setText(ph.getZsrid());
		
		textboxTitle.setText(ph.getTitle());
		
		textboxFirstname.setText(ph.getFirstname());
		textboxLastname.setText(ph.getLastname());
		
		textboxStreet.setText(ph.getStreet());
		textboxPostbox.setText(ph.getPostbox());
		textboxZip.setText(ph.getZip());
		textboxCity.setText(ph.getCity());
		
		textboxPhone.setText(ph.getPhone());
		textboxFax.setText(ph.getFax());
		
		textboxSpecialty1.setText(ph.getSpecialty1());
		textboxSpecialty2.setText(ph.getSpecialty2());
		
		textboxGLNid.setText(ph.getGlnid());
			
	}
	
	
	
	// --- HANDLERS ---
	
	private class AddressSelectionButtonListener extends SelectionAdapter {
		@Override
		public void widgetSelected(SelectionEvent e){
			
			
			String zsrid = textboxZSRid.getText();
		
			//Get the data
			ph.getAttributesFromWeb(zsrid);
			
			//Assign the data
			bindData();
						
			
		}
	}
	
	
	private class InteractionSelectionButtonListener extends SelectionAdapter {
		@Override
		public void widgetSelected(SelectionEvent e){
			
			String interactionEnabled = "true";
			
			if (!((Button) e.widget).getSelection()) 
				interactionEnabled = "false";
														
			//Store the value in the preferences
					
			CoreHub.globalCfg.set(Constants.CFG_INTERATCIONS,
			(String) interactionEnabled);
			
		}
	}
	
	
	@Override
	public boolean performOk(){
		performApply();
		return super.performOk();
	}
	
	
	@Override
	protected void performApply(){
		
		String strCfg = this.createCFGString();
		
		CoreHub.globalCfg.set(Constants.CFG_PHM_PHY, strCfg.toString());
		CoreHub.globalCfg.flush();
		
	}
	
	
	// --- Some Utils ---
	/**
	 * Create the config-string to store
	 */
	private String createCFGString(){
		
		String returnValue = "";
		
	    returnValue += textboxZSRid.getText().replace(";", "") + ";";
		returnValue += textboxGLNid.getText().replace(";", "") + ";";
		
		returnValue += textboxTitle.getText().replace(";", "") + ";";
		returnValue += textboxFirstname.getText().replace(";", "") + ";";
		returnValue += textboxLastname.getText().replace(";", "") + ";";
		
		returnValue += textboxStreet.getText().replace(";", "") + ";";
		returnValue += textboxPostbox.getText().replace(";", "") + ";";
		returnValue += textboxZip.getText().replace(";", "") + ";";
		returnValue += textboxCity.getText().replace(";", "") + ";";
		
		returnValue += textboxPhone.getText().replace(";", "") + ";";
		returnValue += textboxFax.getText().replace(";", "") + ";";
		
		returnValue += textboxSpecialty1.getText().replace(";", "") + ";";
		returnValue += textboxSpecialty2.getText().replace(";", "");
		
		return returnValue;
							
	}
	


}
