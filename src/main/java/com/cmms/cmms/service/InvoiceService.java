package com.cmms.cmms.service;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service
public class InvoiceService {

    public void generateInvoice(String customerName, double amount) {

        try {
            String filePath = "invoice_" + customerName + ".pdf";

            PdfWriter writer = new PdfWriter(filePath);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            document.add(new Paragraph("INVOICE"));
            document.add(new Paragraph("Customer: " + customerName));
            document.add(new Paragraph("Amount: ₹" + amount));
            document.add(new Paragraph("Thank you for your purchase!"));

            document.close();

            System.out.println("Invoice Generated: " + filePath);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

