public class CellPhone {
    public CellPhone() {
        // Constructor body
    }
    public void ring(Tune t) {
        t.play();
    }
}

class Tune {
    public void play() {
        System.out.println("Tune.play()");
    }
}

class ObnoxiousTune extends Tune {
    public ObnoxiousTune() {
        System.out.println("ObnoxiousTune.play()");
    }
}