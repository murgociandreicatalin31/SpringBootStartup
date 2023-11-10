package ro.ctrln.entities;

public class Starhawk {

    // define getBattleshipName() using these specs:
    // if number of decks divides by 4 then return Starhawk 4
    // if number of decks divides by 7 then return Starhawk 7
    // if number of decks divides by 28 then return Starhawk 28
    // if number of decks doesn't divide by neither of them then return Starhawk 'number of decks'

    private int numberOfDecks;

    public int getNumberOfDecks() {
        return numberOfDecks;
    }

    public void setNumberOfDecks(int numberOfDecks) {
        this.numberOfDecks = numberOfDecks;
    }

    public String getBattleshipName() {
        if(divideBy4() && divideBy7()) {
            return "Starhawk 28";
        }
        if(divideBy4()) {
            return "Starhawk 4";
        }
        if(divideBy7()) {
            return "Starhawk 7";
        }
        return "Starhawk " + getNumberOfDecks();
    }

    private boolean divideBy7() {
        return getNumberOfDecks() % 7 == 0;
    }

    private boolean divideBy4() {
        return getNumberOfDecks() % 4 == 0;
    }

//    public String getBattleshipName() {
//        if(getNumberOfDecks() % 4 == 0 && getNumberOfDecks() % 7 == 0) {
//            return "Starhawk 28";
//        }
//        if(getNumberOfDecks() % 4 == 0) {
//            return "Starhawk 4";
//        }
//        if(getNumberOfDecks() % 7 == 0) {
//            return "Starhawk 7";
//        }
//        return "Starhawk " + getNumberOfDecks();
//    }
}
