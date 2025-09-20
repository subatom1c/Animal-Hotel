package hva.app.exceptions;

import pt.tecnico.uilib.menus.CommandException;

import java.io.Serial;

public class UnavailableFileException extends CommandException {
    @Serial
    private static final long serialVersionUID = 202407081733L;

    String _filename;

    public UnavailableFileException(String filename) {
        super("Erro a processar ficheiro " + filename);
        _filename = filename;
    }

    public String getFilename() {
        return _filename;
    }
}
