package hva.app.animal;

import hva.Hotel;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import hva.exceptions.DuplicateAnimalException;
import hva.app.exceptions.DuplicateAnimalKeyException;
import hva.exceptions.UnknownSpeciesException;
import hva.app.exceptions.UnknownSpeciesKeyException;
import hva.exceptions.UnknownHabitatException;
import hva.app.exceptions.UnknownHabitatKeyException;



class DoRegisterAnimal extends Command<Hotel> {

    DoRegisterAnimal(Hotel receiver) {
        super(Label.REGISTER_ANIMAL, receiver);
            addStringField("animalKey", Prompt.animalKey());
            addStringField("name", Prompt.animalName());
            addStringField("speciesKey", Prompt.speciesKey());
            addStringField("habitatKey", hva.app.habitat.Prompt.habitatKey());
    }

    @Override
    protected final void execute() throws CommandException {
    String animalKey = null;
    String name = null;
    String speciesKey = null;
    String habitatKey = null;
    String speciesName = null;
    try {
      animalKey = stringField("animalKey");
      name = stringField("name");
      speciesKey = stringField("speciesKey");
      habitatKey = stringField("habitatKey");
      _receiver.registerAnimal(animalKey, name, speciesKey, habitatKey);

    } catch (DuplicateAnimalException e) {
      throw new DuplicateAnimalKeyException(e.getKey());
      
    } catch (UnknownSpeciesException e) {
       speciesName = Form.requestString(Prompt.speciesName()); // nao sei se pode
      _receiver.registerSpecies(speciesKey, speciesName);
      try{
            _receiver.registerAnimal(animalKey, name, speciesKey, habitatKey);
      }
      catch (DuplicateAnimalException ex){}
      catch (UnknownHabitatException ex){}
      catch (UnknownSpeciesException ex){}

    } catch (UnknownHabitatException e) {
      throw new UnknownHabitatKeyException(e.getKey());
    }
    }


}
