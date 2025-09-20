package hva.app.main;

import hva.HotelManager;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import hva.app.exceptions.FileOpenFailedException;
import hva.exceptions.UnavailableFileException;


class DoOpenFile extends Command<HotelManager> {
    DoOpenFile(HotelManager receiver) {
        super(Label.OPEN_FILE, receiver);
        addStringField("fileName", Prompt.openFile());
    }

    @Override
    protected final void execute() throws CommandException {
        try {
            _receiver.load(stringField("fileName"));
        } catch (UnavailableFileException e) {
            throw new FileOpenFailedException(e);
        }
    }
}
