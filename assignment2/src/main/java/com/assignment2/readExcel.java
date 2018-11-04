package com.assignment2;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Font;

import java.io.*;
import java.util.ArrayList;

public class readExcel {

    public static class combine{
        public static final String PATH = "chessResultsList.xls";

        public static ArrayList<Table> detail = new ArrayList<Table>();
        public static ArrayList<String> reference = new ArrayList<String>();

    }

    public void getData() {

        String no, name, id, fed, rtg, club;

        try {
            System.out.println("\nScanning data from " + "chessResultsList.xls");
            System.out.println();
            FileInputStream inputStream = new FileInputStream("chessResultsList.xls");

            System.out.println("KEJOHANAN TERTUTUP KUANTAN 2018 LELAKI");
            System.out.println("Starting rank");

            HSSFWorkbook book = new HSSFWorkbook(inputStream);
            HSSFSheet sheet = book.getSheetAt(0);

            DataFormatter data = new DataFormatter();
            //create font
            Font font = book.createFont();
            font.setBold(true);
            font.setFontName(HSSFFont.FONT_ARIAL);
            font.setFontHeightInPoints((short) 12);

            CellStyle style = book.createCellStyle();
            style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
            style.setFont(font);
            style.setVerticalAlignment(VerticalAlignment.CENTER);


        for (Row createRow : sheet) {
            no = data.formatCellValue(createRow.getCell(0));
            name = createRow.getCell(2).toString();
            id = createRow.getCell(3).toString();
            fed = createRow.getCell(4).toString();
            rtg = data.formatCellValue(createRow.getCell(5));
            club = createRow.getCell(6).toString();

            combine.detail.add(new Table(no, name, id, fed, rtg, club));
            System.out.printf("%-5s", no);
            System.out.printf("%-50s ", name);
            System.out.printf("%-10s ", id);
            System.out.printf("%-10s ", fed);
            System.out.printf("%-10s ", rtg);
            System.out.printf("%-10s ", club);
            System.out.println();
        }

        }catch (Exception e){
                e.getStackTrace();
            }
    }
}