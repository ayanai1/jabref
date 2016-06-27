package net.sf.jabref.gui.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import net.sf.jabref.gui.fieldeditors.FieldEditor;
import net.sf.jabref.gui.fieldeditors.HiddenTextArea;
import net.sf.jabref.gui.fieldeditors.TextArea;
import net.sf.jabref.logic.l10n.Localization;

public class HideAction extends AbstractAction {

    private FieldEditor fieldEditor;


    public HideAction(FieldEditor fieldEditor) {
        this.fieldEditor = fieldEditor;

        fieldEditor.getEditors();
        fieldEditor.getFieldName();

        putValue(Action.NAME, Localization.lang("Hide"));
        putValue(Action.SHORT_DESCRIPTION, Localization.lang("Hides the chosen Field"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String fieldName = fieldEditor.getFieldName();
        if (fieldEditor instanceof HiddenTextArea) {
            fieldEditor = new TextArea(fieldName, null);
        } else {
            fieldEditor = new HiddenTextArea(fieldName, null);
        }

    }
}
