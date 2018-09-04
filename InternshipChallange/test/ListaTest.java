import org.junit.Assert;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ListaTest {

    @Test
    public void deveTestarOInputDoUsuario() {

        Lista listaBranca = new Lista();

        String input = "www.google.com";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assert.assertEquals("www.google.com", listaBranca.getInput());
    }

    @Test (expected = IOException.class)
    public void deveTestarIOExpectionParaShowWhitelist() throws IOException {

        Lista listaBranca = new Lista();
        listaBranca.showWhitelist();
    }

    @Test (expected = IOException.class)
    public void deveTestarIOExpectionParaShowBlacklist() throws IOException {

        Lista listaBranca = new Lista();
        listaBranca.showBlacklist();
    }

}