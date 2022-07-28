import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // Fazer conexão HTTP e bucas 250 filmes
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        //String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY";

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        // Exibir e manipular dados
        for (Map<String,String> conteudo : ListaDeConteudos) {
            
            String urlImagem = conteudo.get("image");
            //String urlImagem = conteudo.get("url");
            String titulo = conteudo.get("title");
            InputStream inputStream = new URL(urlImagem).openStream();

            String nomeArquivo = "saida/" + titulo + ".png";

            var geradora = new GeradorDeFigurinhas();
            geradora.criar(inputStream, nomeArquivo);

            System.out.println(conteudo.get("title"));
            System.out.println(conteudo.get("image"));
            System.out.println(conteudo.get("imDbRating"));
            System.out.println();
        }
    }
}
