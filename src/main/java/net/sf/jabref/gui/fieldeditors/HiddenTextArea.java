package net.sf.jabref.gui.fieldeditors;

import java.awt.Color;

import javax.swing.JLabel;

public class HiddenTextArea extends TextArea {



    public HiddenTextArea(String fieldName, String content) {
        super(fieldName, content);
        System.out.println("<1>");
        label.setForeground(new Color(100, 0, 0));
    }

    @Override
    public String getFieldName(){
        return "_"+ fieldName;
    }

    @Override
    public JLabel getLabel(){
        return label;
    }

    @Override
    public void setLabelColor(Color color){
        label.setForeground(new Color(100, 0, 0));
    }


}
