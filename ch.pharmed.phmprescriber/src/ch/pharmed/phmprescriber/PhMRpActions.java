/*******************************************************************************
 * Copyright (c) 2014, Pharmed Solutions GmbH
 * All rights reserved.
 *******************************************************************************/

package ch.pharmed.phmprescriber;



import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.swt.events.HelpListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;

import ch.elexis.core.data.events.ElexisEventDispatcher;
import ch.elexis.core.data.interfaces.IOutputter;
import ch.elexis.data.Rezept;


public class PhMRpActions  implements IAction, IOutputter {

	
	private String opID = "ch.pharmed.id";
	private String opDescription ="Rezept an Apotheke Ihrer Wahl übermitteln";
	private String optooltiptext = "Übermitteln und drucken";
	private String opText = "Senden";
	public static final String PLUGIN_ID = "ch.pharmed.phmprescriber";
  
  

	@Override
	public String getOutputterID() {
		// TODO Auto-generated method stub
		return opID;
	}

	@Override
	public String getOutputterDescription() {
		// TODO Auto-generated method stub
		return opDescription;
	}

	@Override
	public Object getSymbol() {

	
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void addPropertyChangeListener(IPropertyChangeListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getAccelerator() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getActionDefinitionId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageDescriptor getDisabledImageDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HelpListener getHelpListener() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageDescriptor getHoverImageDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {

		return null;
	}

	@Override
	public IMenuCreator getMenuCreator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getStyle() {
		// TODO Auto-generated method stub
		return AS_PUSH_BUTTON;
	}

	@Override
	public String getText() {
		
		// TODO Auto-generated method stub
		return opText;
	}

	@Override
	public String getToolTipText() {
		// TODO Auto-generated method stub
		return optooltiptext;
	}

	@Override
	public boolean isChecked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isHandled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void removePropertyChangeListener(IPropertyChangeListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		System.out.println("Test");
		
	}

	@Override
	public void runWithEvent(Event event) {
		
		// TODO Auto-generated method stub
		Rezept rp = (Rezept) ElexisEventDispatcher.getSelected(Rezept.class);
		Physician ph = new Physician();
		Sender sender = new Sender(rp,ph);
		sender.sendnprint();
		
		
	}

	@Override
	public void setActionDefinitionId(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setChecked(boolean checked) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDescription(String text) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDisabledImageDescriptor(ImageDescriptor newImage) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEnabled(boolean enabled) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setHelpListener(HelpListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setHoverImageDescriptor(ImageDescriptor newImage) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setImageDescriptor(ImageDescriptor newImage) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMenuCreator(IMenuCreator creator) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setText(String text) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setToolTipText(String text) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAccelerator(int keycode) {
		// TODO Auto-generated method stub

	}

}
