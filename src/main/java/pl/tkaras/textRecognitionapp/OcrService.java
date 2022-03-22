package pl.tkaras.textRecognitionapp;

import java.awt.image.BufferedImage;
import java.net.URL;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.sourceforge.tess4j.*;
import net.sourceforge.tess4j.util.LoadLibs;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;

@Service
public class OcrService {

    public String doOCR(String url){

        try {

            URL urlFile = new URL(url);
            BufferedImage bufferedImage = ImageIO.read(urlFile);

            ITesseract instance = new Tesseract();

            //instance.setDatapath(LoadLibs.extractTessResources("tessdata").getParent());
            instance.setDatapath(LoadLibs.extractTessResources("/OCR/").getParent());
            instance.setLanguage("pol");


            String result = instance.doOCR(bufferedImage);
            return result;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
}