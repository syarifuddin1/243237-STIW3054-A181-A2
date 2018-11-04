package com.assignment2;

public class App {

    public static void main(String args[]){
        try{

            readExcel read = new readExcel();
            read.getData();

            convertPdf convert = new convertPdf();
            convert.Convert();

            convertPdf pdf = new convertPdf();
            pdf.openPdf();

            Thread.sleep(3000);

            System.out.println("\nFinish converted.!");
        }catch (Exception l){
            l.printStackTrace();
        }
    }
}