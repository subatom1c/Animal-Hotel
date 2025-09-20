package hva.app.main;

import hva.HotelManager;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import hva.app.exceptions.UnavailableFileException;
import java.io.IOException;
//FIXME import other classes if needed

class DoNewFile extends Command<HotelManager> {
    DoNewFile(HotelManager receiver) {
        super(Label.NEW_FILE, receiver);
        addStringField("fileName", Prompt.saveAs());
    }

    @Override
    protected final void execute() throws CommandException {
        String fileName = null;
        try {
            fileName = stringField("fileName");
            _receiver.saveAs(fileName);
        } catch (hva.exceptions.MissingFileAssociationException e){ // falta aqui o filenotfound mas acho que se tem de criar 
            throw new UnavailableFileException(fileName);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
