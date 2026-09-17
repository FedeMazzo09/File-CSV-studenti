public class Record {
    private String[] campi;
    private boolean cancellato;

    public Record(String[] campi) {
        this.campi = campi;
        cancellato = false;
    }

    public String[] getCampi() {
        return campi;
    }

    public boolean isCancellato() {
        return cancellato;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < campi.length; i++) {
            s += campi[i] + " ";
        }
        return s;
    }
}