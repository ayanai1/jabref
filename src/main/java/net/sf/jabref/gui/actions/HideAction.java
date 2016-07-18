package net.sf.jabref.gui.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import net.sf.jabref.gui.entryeditor.EntryEditorTab;
import net.sf.jabref.gui.fieldeditors.FieldEditor;
import net.sf.jabref.gui.fieldeditors.HiddenTextArea;
import net.sf.jabref.gui.fieldeditors.TextArea;
import net.sf.jabref.logic.l10n.Localization;

public class HideAction extends AbstractAction {

    private FieldEditor fieldEditor;
    private final EntryEditorTab entryTab;

    private static boolean hidden = false;

    public HideAction(FieldEditor fieldEditor) {
        this.fieldEditor = fieldEditor;
        this.entryTab = fieldEditor.getEntryEditorTab();


        fieldEditor.getEditors();
        fieldEditor.getFieldName();
        if (hidden == false) {
            putValue(Action.NAME, Localization.lang("Hide"));
            putValue(Action.SHORT_DESCRIPTION, Localization.lang("Hides the chosen Field"));
        } else {
            putValue(Action.NAME, Localization.lang("Show"));
            putValue(Action.SHORT_DESCRIPTION, Localization.lang("Show the chosen Field"));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String fieldName = fieldEditor.getFieldName();
        if (fieldEditor == null) {
            System.out.println("fieldEditor null");
        }
        if (fieldEditor instanceof HiddenTextArea) {
            fieldEditor = new TextArea(fieldName, null, entryTab);
            fieldEditor.getEntryEditorTab().getBibEntry().toggleFieldConcealment(fieldEditor.getFieldName());
            hidden = true;
        } else {

            fieldEditor = new HiddenTextArea(fieldName, null, entryTab);
            if (fieldEditor.getEntryEditorTab() == null) {
                System.out.println("fieldEditor.getEntryEditorTab null");
            }
            fieldEditor.getEntryEditorTab().getBibEntry().toggleFieldConcealment(fieldEditor.getFieldName());
            hidden = false;
        }

    }

    public void setFieldEditor(FieldEditor fieldEditor) {
        this.fieldEditor = fieldEditor;

    }
}
