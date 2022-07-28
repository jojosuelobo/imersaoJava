import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa {

    public List<Conteudo> = extraiConteudos(String json) {
        // Extrair dados (titulos, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> ListaDeAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        //popular lista
        for (Map<String, String> atributos : ListaDeAtributos) {
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("url");
            var conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);
        }

        return conteudos;
    }
}
