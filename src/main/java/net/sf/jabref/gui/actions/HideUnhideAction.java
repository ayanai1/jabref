package net.sf.jabref.gui.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.text.JTextComponent;

import net.sf.jabref.logic.l10n.Localization;


public class HideUnhideAction extends AbstractAction {
    private final JTextComponent field;


    public HideUnhideAction(JTextComponent field) {
        this.field = field;
        putValue(Action.NAME, Localization.lang("Hide/Unhide Field"));
        putValue(Action.SHORT_DESCRIPTION, Localization.lang("Hide/Unhide Field"));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

}
