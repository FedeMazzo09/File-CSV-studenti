import java.io.*;

public class Gestore {
    private Record[] records;
    private String nomeFile;
    private int counter;
    private String intestazione;

    public Gestore(String nomeFile, int max) {
        this.nomeFile = nomeFile;
        records = new Record[max];
        counter = 0;
    }

    public void leggiFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(nomeFile));
        String riga;

        intestazione = br.readLine();

        while ((riga = br.readLine()) != null && counter < records.length) {
            String[] campi = riga.split(",", -1);
            records[counter] = new Record(campi);
            counter++;
        }
        br.close();
    }


    public void aggiungiRecord(String[] campi) {
        if (counter < records.length) {
            records[counter] = new Record(campi);
            counter++;
        }
    }

    public void visualizzaCampi() {
        for (int i = 0; i < counter; i++) {
            if (!records[i].isCancellato()) {
                System.out.println(records[i]);
            }
        }
    }

    public Record ricercaPerCampoChiave(String valore, int indiceCampo) {
        for (int i = 0; i < counter; i++) {
            if (!records[i].isCancellato()) {
                if (records[i].getCampi()[indiceCampo].equals(valore)) {
                    return records[i];
                }
            }
        }
        return null;
    }

    public void scriviFile(String nomeFileOutput) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(nomeFileOutput));

        bw.write(intestazione + ",cancellato");
        bw.newLine();

        for (int i = 0; i < counter; i++) {
            Record r = records[i];

            bw.write(String.join(",", r.getCampi()));

            bw.write("," + r.isCancellato());

            bw.newLine();
        }

        bw.close();
    }
}
