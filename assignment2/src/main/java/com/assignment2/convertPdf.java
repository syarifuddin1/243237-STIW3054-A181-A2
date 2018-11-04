package com.assignment2;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class convertPdf{

    public void Convert() {


        try {
            System.out.println("\nExecuting the data to chessResults.pdf");
            System.out.println("");

            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream("chessResults.pdf"));
            doc.open();

            PdfPTable data = new PdfPTable(6);
            data.setWidths(new float[]{5, 30, 7, 6, 5, 15});
            data.setWidthPercentage(100);
            data.getDefaultCell().setUseAscender(true);

            for (Table table : readExcel.combine.detail) {
                data.addCell(table.getNo());
                data.addCell(table.getName());
                data.addCell(table.getId());
                data.addCell(table.getFed());
                data.addCell(table.getRtg());
                data.addCell(table.getClub());

            }
            doc.add(data);
            doc.add(Chunk.NEWLINE);

            Paragraph bot = new Paragraph();
            for (String word : readExcel.combine.reference) {
                bot.add(word);
                bot.add("\n");
            }
            doc.add(bot);
            doc.add(Chunk.NEWLINE);
            doc.close();

        } catch (IOException l) {
            l.printStackTrace();
        } catch (DocumentException l) {
            System.out.println("Something wrong in table.");
        }
        System.out.println("chessResultsList.pdf is successfully created.");
    }

        public void openPdf(){
            System.out.print("\nOpen PDF...");
            try {
                Desktop.getDesktop().open(new File("chessResults.pdf"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


