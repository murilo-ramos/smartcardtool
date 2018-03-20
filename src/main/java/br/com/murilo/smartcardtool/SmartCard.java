package br.com.murilo.smartcardtool;

import javax.smartcardio.Card;
import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.CommandAPDU;
import javax.smartcardio.ResponseAPDU;


public class SmartCard {
    
    private final CardTerminal terminal;
    private Card card;
    
    public SmartCard(CardTerminal terminal) {
        this.terminal = terminal;
    }
    
    public boolean connect() {
        try {
            this.card = this.terminal.connect("*");
            return true;
        } catch (CardException ex) {
            return false;
        }
    }
    
    public void disconnect() {
        try {
            this.card.disconnect(true);
        } catch (CardException ex) {
        }
    }
    
    public ResponseAPDU sendCommand(CommandAPDU apdu) throws CardException {
        ResponseAPDU res = this.card.getBasicChannel().transmit(apdu);
        return res;
    }
}
