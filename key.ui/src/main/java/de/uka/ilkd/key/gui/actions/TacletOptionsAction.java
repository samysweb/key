package de.uka.ilkd.key.gui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import de.uka.ilkd.key.gui.fonticons.IconFactory;
import de.uka.ilkd.key.gui.MainWindow;
import de.uka.ilkd.key.gui.configuration.ChoiceSelector;
import de.uka.ilkd.key.gui.notification.events.GeneralInformationEvent;
import de.uka.ilkd.key.settings.ProofSettings;

public class TacletOptionsAction extends MainWindowAction {

    /**
     *
     */
    private static final long serialVersionUID = -6813540362001480606L;

    public TacletOptionsAction(MainWindow mainWindow) {
        super(mainWindow);
        setName("Show Taclet Options");
        setIcon(IconFactory.configure(16));
        setAcceleratorLetter(KeyEvent.VK_T);

        getMediator().enableWhenProofLoaded(this);
        lookupAcceleratorKey();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (getMediator().getSelectedProof() == null) {
            mainWindow.notify(new GeneralInformationEvent("No contracts available.",
                "If you wish to see the available options "
                    + "for a proof, you have to load one first."));
        } else {
            new ChoiceSelector(mainWindow, ProofSettings.DEFAULT_SETTINGS.getChoiceSettings());
        }
    }
}
