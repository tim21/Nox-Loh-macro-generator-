package lohgen.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import lohgen.Consts;
import lohgen.gui.listeners.GenerateListener;

public class RightBottomPanel extends JPanel {

    public RightBottomPanel() {
        super();
        setLayout(new GridLayout(0, 1));
        Box b = Box.createHorizontalBox();
        JLabel delayLabel = new JLabel("Delay : ");
        delayLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        b.add(delayLabel);
        NumericTextField delayField = new NumericTextField(Integer.toString(Consts.INIT_DELAY), 4);
        delayField.setHorizontalAlignment(SwingConstants.RIGHT);
        GenerateListener.setDelayText(delayField);
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.X_AXIS));
        textPanel.setMaximumSize(new Dimension(30, 20));
        textPanel.add(delayField);
        b.add(textPanel);
        b.add(Box.createGlue());
        JButton installButton = new JButton("Auto install");
        installButton.setEnabled(false);
        installButton.setActionCommand("install");
        installButton.addActionListener(new GenerateListener());
        b.add(installButton);
        JButton zipButton = new JButton("Generate import");
        zipButton.setEnabled(false);
        zipButton.setActionCommand("import");
        zipButton.addActionListener(new GenerateListener());
        b.add(zipButton);
        JButton textButton = new JButton("Generate text file");
        textButton.setActionCommand("text");
        textButton.addActionListener(new GenerateListener());
        b.add(textButton);
        add(b);
        setBorder(BorderFactory.createTitledBorder(Consts.BORDER_ETCHEDLINE, "Settings"));
    }
}
