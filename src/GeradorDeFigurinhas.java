import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.awt.Font;

import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {
    
    void criar(InputStream inputStream, String nomeArquivo) throws Exception{
        // ler img
        //BufferedImage ImagemOriginal = ImageIO.read(new File("entrada/filme.jpg"));
        BufferedImage ImagemOriginal = ImageIO.read(inputStream);

        // criar nova imagem em memoria com transparencia e novo tamanho
        int largura = ImagemOriginal.getWidth();
        int altura = ImagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copia img pra uma nova em memoria
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(ImagemOriginal, 0, 0, null);

        // config texto
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setFont(fonte);

        // frase na img
        graphics.drawString("TOPZERA", 0, novaAltura-100);

        // escrever img em arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    }

}