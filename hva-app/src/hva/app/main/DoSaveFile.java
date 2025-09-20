package hva.app.main;

import hva.HotelManager;
import hva.exceptions.MissingFileAssociationException;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import java.io.IOException;
//FIXME import other classes if needed

class DoSaveFile extends Command<HotelManager> {
    DoSaveFile(HotelManager receiver) {
        super(Label.SAVE_FILE, receiver, r -> r.getHotel() != null);
    }
    @Override
    public final void execute() throws CommandException {
    try {
      try {
        _receiver.save();
      } catch (MissingFileAssociationException e) {
        saveAs();
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  private void saveAs() throws IOException {
    try {
      _receiver.saveAs(Form.requestString(Prompt.newSaveAs()));
    } catch (MissingFileAssociationException e) {
      saveAs();
    }
  }
}
