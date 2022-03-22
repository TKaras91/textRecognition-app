package pl.tkaras.textRecognitionapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.tkaras.textRecognitionapp.Graphic;
import pl.tkaras.textRecognitionapp.OcrService;
import pl.tkaras.textRecognitionapp.repository.GraphicRepo;

@RestController
public class OcrApi {

    private OcrService ocrService;
    private GraphicRepo graphicRepo;

    @Autowired
    public OcrApi(OcrService ocrService, GraphicRepo graphicRepo) {
        this.ocrService = ocrService;
        this.graphicRepo = graphicRepo;
    }

    @GetMapping("/api/ocr")
    public Iterable<Graphic> getGraphic(){
        return graphicRepo.findAll();
    }

    @PostMapping("/api/ocr")
    public String doOcr(@RequestBody Graphic graphic){
        String ocr = ocrService.doOCR(graphic.getUrl());
        graphic.setContent(ocr);
        graphicRepo.save(graphic);
        return ocr;
    }
}
