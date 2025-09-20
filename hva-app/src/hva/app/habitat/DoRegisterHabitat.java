package hva.app.habitat;

import hva.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import hva.exceptions.DuplicateHabitatException;
import hva.app.exceptions.DuplicateHabitatKeyException;
//FIXME import other classes if needed

class DoRegisterHabitat extends Command<Hotel> {

    DoRegisterHabitat(Hotel receiver) {
        super(Label.REGISTER_HABITAT, receiver);
            addStringField("habitatKey", Prompt.habitatKey());
            addStringField("name", Prompt.habitatName());
            addIntegerField("area", Prompt.habitatArea());       
    }

    @Override
    protected void execute() throws CommandException {
        try {
            String habitatKey = stringField("habitatKey");
            String name = stringField("name");
            int area = integerField("area");
            _receiver.registerHabitat(habitatKey, name, area);

        } catch(DuplicateHabitatException e) {
            throw new DuplicateHabitatKeyException(e.getKey());
        }
    }

}
