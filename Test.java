public class Test {
    public static void main(String[] args) {

        Gestore g = new Gestore("Studenti.csv", 200);

        try {
            g.leggiFile();

            g.visualizzaCampi();

            Record r = g.ricercaPerCampoChiave("ABB", 2);
            if (r != null) {
                System.out.println("Record trovato");
            } else {
                System.out.println("Record non trovato");
            }

            String[] nuovo = {"Brahim", "Saada", "ABB", "Trentino"};

            g.aggiungiRecord(nuovo);

            System.out.println("Operazioni completate");

            g.scriviFile("Mazzoleni_copia.csv");
            System.out.println("File Studenti_copia.csv creato con le modifiche");
        } catch (Exception e) {
            System.out.println("Errore");
        }
    }
}
