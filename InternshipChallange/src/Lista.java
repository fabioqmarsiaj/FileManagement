import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Lista {

    private static final String LISTABRANCA = "whitelist.txt";

    private static final String LISTANEGRA = "blacklist.txt";

    public void addWhitelist() {

        File file = new File(LISTABRANCA);

        adicionarNumaLista(file);

    }

    public void showWhitelist() throws FileNotFoundException {

        Scanner s = new Scanner(new File("whitelist.txt"));

        mostrarLista(s);

    }

    public void addBlacklist() {

        File file = new File(LISTANEGRA);

        adicionarNumaLista(file);

    }

    public void showBlacklist() throws FileNotFoundException {

        Scanner s = new Scanner(new File("blacklist.txt"));

        mostrarLista(s);
    }

    public void verify() throws IOException {

        Scanner teclado = new Scanner(System.in);

        String lista;

        System.out.println("Digite uma lista a ser verificada: [WHITELIST/BLACKLIST] ");
        lista = teclado.nextLine().toUpperCase();

        if (lista.equals("WHITELIST")) {

            verificarUrlEmArquivo(teclado, "whitelist.txt", " está na WHITELIST.");


        } else if (lista.equals("BLACKLIST")) {

            verificarUrlEmArquivo(teclado, "blacklist.txt", " está na BLACKLIST.");

        }
    }

    private void verificarUrlEmArquivo(Scanner teclado, String s2, String s3) throws FileNotFoundException {

        String urlVerificada;
        Scanner s = new Scanner(new File(s2));
        ArrayList<String> listaDeUrl = new ArrayList<>();

        while (s.hasNext()) {
            listaDeUrl.add(s.next());
        }

        System.out.println("Digite uma URL a ser verificada: ");
        urlVerificada = teclado.next();

        int i;

        for (i = 0; i < listaDeUrl.size(); i++) {

            if (listaDeUrl.get(i).equals(urlVerificada)) {
                System.out.println("URL: " + listaDeUrl.get(i) + s3);
                break;
            }
        }
        if (i == listaDeUrl.size()) {
            System.out.println("URL não encontrada");
        }
    }

    public void removeWhiteList() throws IOException {



        File file = new File("whitelist.txt");

        File temp = File.createTempFile("whitelist", ".txt", file.getParentFile());

        removerUrl(file, temp);

    }

    public void removeBlackList() throws IOException {



        File file = new File("blacklist.txt");

        File temp = File.createTempFile("blacklist", ".txt", file.getParentFile());

        removerUrl(file, temp);


    }

    //Método auxiliar para evitar código duplicado.
    public void adicionarNumaLista(File file) {


        BufferedWriter bw = null;
        FileWriter fw = null;

        Scanner teclado = new Scanner(System.in);


        try {
            System.out.println("Adicione uma URL na lista: ");
            String data = teclado.next();

            // true = append file
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);

            bw.write(data);
            bw.newLine();

            System.out.println("Pronto.");

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }
        }
    }

    //Método auxiliar para evitar código duplicado.
    public void mostrarLista(Scanner s) {

        ArrayList<String> lista = new ArrayList<>();
        while (s.hasNext()) {
            lista.add(s.next());

        }
        for (String str : lista) {
            System.out.println("URL: " + str);
        }

        s.close();
    }

    //Método auxiliar para evitar código duplicado.
    public void removerUrl(File file, File temp) throws IOException {

        Scanner teclado = new Scanner(System.in);

        String charset = "UTF-8";

        String delete;

        System.out.println("Digite uma URL a ser deletada: ");
        delete = teclado.next();

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));

        PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(temp), charset));


        for (String line; (line = reader.readLine()) != null; ) {

            line = line.replace(delete, "");
            writer.println(line);

        }


        reader.close();
        writer.close();

        file.delete();

        temp.renameTo(file);
    }

    //Usado para testar.
    public String getInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().toUpperCase();
    }

}
