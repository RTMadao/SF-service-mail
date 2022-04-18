package com.salcedoFawcett.services.mailService.domain.model;

public class ChangePasswordMessage extends Message{

    private String user;
    private String url;

    public ChangePasswordMessage(String title, String addressee, String user, String url) {
        super(title, addressee);
        this.user = user;
        this.url = url;
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
                "                                   <h1 style=\"font-size:24px;margin:0 0 20px 0;font-family:Arial,sans-serif;\" >Cambio de contraseña</h1>\n" +
                "                                   <p style=\" margin:0 0 12px 0;font-size:16px;line-height:24px;font-family:Arial,sans-serif;\" >Mediante el presente correo se atiende a la solicitud de cambio de contraseña para el usuario "+this.user+"</p>\n" +
                "                               </td>\n" +
                "                           </tr>\n" +
                "                           <tr>\n" +
                "                               <td align=\"center\" style=\"padding:0 0 36px 0;\">\n" +
                "                                   <a href=\""+this.url+"\" style=\"-webkit-appearance: button;-moz-appearance: button;appearance: button;text-decoration: none;color:#001720;background:#CEAFA3;padding: 13px;font-family:Arial,sans-serif;font-size:13px\">\n" +
                "                                       Cambiar contraseña\n" +
                "                                   </a>\n" +
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
}
