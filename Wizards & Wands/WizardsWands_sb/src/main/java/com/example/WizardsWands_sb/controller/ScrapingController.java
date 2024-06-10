package com.example.WizardsWands_sb.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/harrypotter")
public class ScrapingController {
    
    // Endpoint para obtener la información de wikipedia
    @GetMapping
    public String getHarryPotterInfo() {
        String url = "https://es.wikipedia.org/wiki/Harry_Potter";
        StringBuilder result = new StringBuilder();
        
        try {
            Document doc = Jsoup.connect(url).get();
            // Extraer el primer párrafo de la página
            Element firstParagraph = doc.select("p").first();
            if (firstParagraph != null) {
                result.append(firstParagraph.text());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al realizar el scraping de la página.";
        }
        
        return result.toString();
    }
}
