package PDFCreation;

import Bean.StudentBean;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import Mail.Mail;

public class RegistrationPDF {

    public static void pdf(StudentBean rg) {
        try {
            System.out.println(rg);
            String file_location = "D:\\" + rg.getName() + ".pdf";
            PDDocument document1 = new PDDocument();
            document1.save(file_location);
            PDPage my_page = new PDPage();
            document1.addPage(my_page);

            OutputStream file = new FileOutputStream(new File(file_location));
            Document document = new Document();
            PdfWriter.getInstance(document, file);

            //Inserting Table in PDF
            PdfPTable table = new PdfPTable(2);
            PdfPCell cell = new PdfPCell(new Paragraph("Student Information"));
            cell.setColspan(2);
//                                      cell.setRowspan(2);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPadding(5.0f);
            cell.setBackgroundColor(new BaseColor(255, 221, 0));

            table.addCell(cell);
            table.addCell("Name");
            table.addCell(rg.getName());
            table.addCell("Email");
            table.addCell(rg.getEmail());
            table.addCell("Sex");
            table.addCell(rg.getSex());
            table.addCell("Course");
            table.addCell(rg.getCourse());
            table.addCell("Fee");
            table.addCell(rg.getFee());
            table.addCell("Paid");
            table.addCell(rg.getPaid());
            table.addCell("Due");
            table.addCell(rg.getDue());
            table.addCell("Address");
            table.addCell(rg.getAddress());
            table.addCell("Contact");
            table.addCell(rg.getContact());

            System.out.println(rg.getName());
            table.setSpacingBefore(30.0f);       // Space Before table starts, like margin-top in CSS
            table.setSpacingAfter(10.0f);
            Chunk chunk = new Chunk("");

            document.open();//PDF document opened........	
            document.add(Chunk.NEWLINE);   //Something like in HTML :-)
            document.add(new Paragraph("Document Generated On - " + new Date().toString()));

            document.add(table);

            document.add(chunk);
            document.add(Chunk.NEWLINE);   //Something like in HTML :-)
//                                        document.add(list);            //In the new page we are going to add list

            document.close();

            file.close();

            System.out.println("Pdf created successfully..");
//            new finallyDude(rg.getName(), rg.getContact(),"D:\\"+rg.getName()+".pdf");
            Mail.send(file_location);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
