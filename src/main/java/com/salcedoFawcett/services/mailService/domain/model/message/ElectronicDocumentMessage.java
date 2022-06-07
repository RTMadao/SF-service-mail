package com.salcedoFawcett.services.mailService.domain.model.message;

import com.salcedoFawcett.services.mailService.domain.model.ElectronicDocumentEmailInfo;

import java.io.InputStream;

public class ElectronicDocumentMessage extends Message {

    private ElectronicDocumentEmailInfo info;

    public ElectronicDocumentMessage() {
        super();
    }

    public ElectronicDocumentMessage(String title, String addressee, ElectronicDocumentEmailInfo info) {
        super(title, addressee);
        this.attachment = true;
        this.info = info;
        this.attachmentPath = info.getFilePath();
        this.setHtmlTemplate();
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }
    @Override
    public void setHtmlTemplate() {
        this.htmlTemplate = " <table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;background:#ffffff;\">\n" +
                "   <tr>\n" +
                "       <td align=\"center\" style=\"padding:0;\">\n" +
                "           <table role=\"presentation\" style=\"width:602px;border-collapse:collapse;border:1px solid #cccccc;border-spacing:0;text-align:left;\">\n" +
                "               <tr>\n" +
                "                   <td align=\"center\" style=\"padding:30px 0 30px 0;background:#01295F;\">\n" +
                "                       <h1 style=\"color:#CEAFA3;font-family:Arial,sans-serif;margin:10px\">\n" +
                "                           Salcedo & Fawcett S.A.S.\n" +
                "                       </h1>\n" +
                "                   </td>\n" +
                "               </tr>\n" +
                "               \n" +
                "               <tr>\n" +
                "                   <td style=\"padding:36px 30px 42px 30px;\">\n" +
                "                       <table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;\">\n" +
                "                           <tr>\n" +
                "                               <td style=\"padding:0 0 36px 0;color:#153643;\" >\n" +
                "                                   <h1 style=\"font-size:24px;margin:0 0 20px 0;font-family:Arial,sans-serif;\" >"+this.info.getDocumentType()+"</h1>\n" +
                "                                   <p style=\" margin:0 0 12px 0;font-size:16px;line-height:24px;font-family:Arial,sans-serif;\" >Mediante el presente correo se notifica al cliente <strong>"+this.info.getCustomer()+"</strong> la generacion del documento electronico. Para cualquier inquietud sobre este docuemnto, por favor comunicarse a el siguiente correo electronico <strong>"+this.info.getEmailContact()+"</strong></p>\n" +
                "                               </td>\n" +
                "                           </tr>\n" +
                "                       </table>\n" +
                "                   </td>\n" +
                "               </tr>\n" +
                "           </table>\n" +
                "       </td>\n" +
                "   </tr>\n" +
                "</table>\n";
    }
    @Override
    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }
    @Override
    public boolean isAttachment() {
        return this.attachment;
    }
    @Override
    public String getAttachmentPath() {
        return this.attachmentPath;
    }
    @Override
    public String getFileName() {
        return this.info.getFileName();
    }
}
