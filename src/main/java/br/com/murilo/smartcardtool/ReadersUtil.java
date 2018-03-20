package br.com.murilo.smartcardtool;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.TerminalFactory;

public class ReadersUtil {
	
	public static List<String> listReadersNames() throws CardException {
		return listReaders().stream().map(r -> r.toString()).collect(Collectors.toList());
	}
	
	public static List<CardTerminal> listReaders() throws CardException {
		List<CardTerminal> readers = new ArrayList<>();
		
		TerminalFactory factory = TerminalFactory.getDefault();		
		factory.terminals().list().forEach(readers::add);
		
		return readers;
	}
}
