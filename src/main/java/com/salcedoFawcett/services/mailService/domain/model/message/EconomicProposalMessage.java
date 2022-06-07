package com.salcedoFawcett.services.mailService.domain.model.message;

import com.salcedoFawcett.services.mailService.domain.model.*;

public class EconomicProposalMessage extends Message {

    private EconomicProposal proposal;
    private Customer customer;
    private Contact customerContact;

    public EconomicProposalMessage(String title, String addressee, EconomicProposal proposal, Customer customer, Contact customerContact) {
        super(title, addressee);
        this.proposal = proposal;
        this.customer = customer;
        this.customerContact = customerContact;
        this.setHtmlTemplate();
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setHtmlTemplate() {
        String servicesList = "";
        for (ServiceCatalogue service: this.proposal.getServices()) {
            servicesList += "<li>" + service.getServiceName() + "</li>\n";
        }
        this.htmlTemplate = "<table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;background:#ffffff;\">\n" +
                "    <tr>\n" +
                "       <td align=\"center\" style=\"padding:0;\">\n" +
                "            <table role=\"presentation\" style=\"width:602px;border-collapse:collapse;border:1px solid #cccccc;border-spacing:0;text-align:left;\">\n" +
                "                <tr>\n" +
                "                    <td align=\"center\" style=\"padding:30px 0 30px 0;background:#01295F;\">\n" +
                "                        <h1 style=\"color:#CEAFA3;font-family:Arial,sans-serif;margin:10px\">\n" +
                "                            Salcedo & Fawcett S.A.S.\n" +
                "                        </h1>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <th style=\"font-size:22px; font-family:Arial,sans-serif; padding:30px 30px 10px 30px; text-align: center; vertical-align: middle\">\n" +
                "                        Propuesta Económica\n" +
                "                    </th>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td style=\"padding:10px 30px 22px 30px;\">\n" +
                "                        <table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;\">\n" +
                "                            <tr>\n" +
                "                                <th style=\"font-size:18px; font-family:Arial,sans-serif; text-align: right; vertical-align: text-top; width:60%;\">\n" +
                "                                    Cliente: \n" +
                "                                </th>\n" +
                "                                <td style=\"font-size:18px; font-family:Arial,sans-serif;\">\n" +
                "                                    " + this.customer.getRegistrationName() + " <br>\n" +
                "                                    " + this.customer.getPartyIdentification().getDocumentTypeName() + ". " + ((this.customer.getPartyIdentification().getPartyIdentificationSchemeName() == 31)?  this.customer.getPartyIdentification().getPartyIdentificationId() +"-"+ this.customer.getPartyIdentification().getPartyIdentificationSchemeId() : this.customer.getPartyIdentification().getPartyIdentificationId()) + "\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <th style=\"font-size:16px; font-family:Arial,sans-serif; text-align: right; vertical-align: text-top; width:60%;\">\n" +
                "                                    Solicitó:\n" +
                "                                </th>\n" +
                "                                <td style=\"font-size:16px; font-family:Arial,sans-serif;\">\n" +
                "                                    " + this.customerContact.getName() + "\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                        </table>\n" +
                "                        <table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;\">\n" +
                "                            <tr>\n" +
                "                                <th style=\"font-size:16px; font-family:Arial,sans-serif; padding-top: 2em; text-align: right; vertical-align: text-top; width: 20%;\">\n" +
                "                                    Descripción:\n" +
                "                                </th>\n" +
                "                                <td style=\"font-size:16px; font-family:Arial,sans-serif; padding-top: 2em;\">\n" +
                "                                    " + this.proposal.getDescription() + "\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td style=\"padding:10px 30px 42px 30px;\">\n" +
                "                        <table role=\"presentation\" style=\"border: 1px  solid gray;border-collapse:collapse;border-spacing:0; width:100%\">\n" +
                "                            <tr>\n" +
                "                                <th style=\"border: 1px  solid gray;border-collapse:collapse;border-spacing:0; font-size:16px; font-family:Arial,sans-serif; text-align: center; vertical-align: middle; width: 40%;\">\n" +
                "                                    Alcance del Servicio\n" +
                "                                </th>\n" +
                "                                <td style=\"border: 1px  solid gray;border-collapse:collapse;border-spacing:0; font-size:16px; font-family:Arial,sans-serif; padding:10px; text-align: justify; vertical-align: middle;\">\n" +
                "                                    <ol type=\"a\" style=\"margin: 4px; padding-inline-start: 20px;\">\n" +
                                                        servicesList +
                "                                    </ol>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <th style=\"border: 1px  solid gray;border-collapse:collapse;border-spacing:0; font-size:16px; font-family:Arial,sans-serif; text-align: center; vertical-align: middle;\">\n" +
                "                                    Forma de Entrega\n" +
                "                                </th>\n" +
                "                                <td style=\"border: 1px  solid gray;border-collapse:collapse;border-spacing:0; font-size:16px; font-family:Arial,sans-serif; padding:10px; text-align: justify; vertical-align: middle; \">\n" +
                "                                    " + this.proposal.getDeliverables() + "\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <th style=\"border: 1px  solid gray;border-collapse:collapse;border-spacing:0; font-size:16px; font-family:Arial,sans-serif; text-align: center; vertical-align: middle;\">\n" +
                "                                    Valor\n" +
                "                                </th>\n" +
                "                                <td style=\"border: 1px  solid gray;border-collapse:collapse;border-spacing:0;font-size:16px; font-family:Arial,sans-serif; padding:10px; text-align: justify; vertical-align: middle; \">\n" +
                "                                    " + this.proposal.getPriceValue() + "\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <th style=\"border: 1px  solid gray;border-collapse:collapse;border-spacing:0; font-size:16px; font-family:Arial,sans-serif; text-align: center; vertical-align: middle;\">\n" +
                "                                    Forma de Pago\n" +
                "                                </th>\n" +
                "                                <td style=\"border: 1px  solid gray;border-collapse:collapse;border-spacing:0; font-size:16px; font-family:Arial,sans-serif; padding:10px; text-align: justify; vertical-align: middle;\">\n" +
                "                                    " + this.proposal.getPaymentMethod() + "\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <th style=\"border: 1px  solid gray;border-collapse:collapse;border-spacing:0; font-size:16px; font-family:Arial,sans-serif; text-align: center; vertical-align: middle;\">\n" +
                "                                    Tiempo de Ejecución\n" +
                "                                </th>\n" +
                "                                <td style=\"border: 1px  solid gray;border-collapse:collapse;border-spacing:0; font-size:16px; font-family:Arial,sans-serif; padding:10px; text-align: justify; vertical-align: middle; \">\n" +
                "                                   " + this.proposal.getTerms() + "\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <th style=\"border: 1px  solid gray;border-collapse:collapse;border-spacing:0; font-size:16px; font-family:Arial,sans-serif; text-align: center; vertical-align: middle;\">\n" +
                "                                    Personal de Trabajo\n" +
                "                                </th>\n" +
                "                                <td style=\"border: 1px  solid gray;border-collapse:collapse;border-spacing:0; font-size:16px; font-family:Arial,sans-serif; padding:10px; text-align: justify; vertical-align: middle; \">\n" +
                "                                   " + this.proposal.getWorkforce() + "\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td style=\"padding:10px 30px 22px 30px;\">\n" +
                "                        <p style=\"font-size:16px; font-family:Arial,sans-serif; text-align: justify\">\n" +
                "                           " + this.proposal.getNote() + "\n" +
                "                        </p>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "            </table>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "</table>\n";
    }

    @Override
    public void setAddressee(String addressee) {this.addressee = addressee;}
    @Override
    public boolean isAttachment() {return false;}
    @Override
    public String getAttachmentPath() {
        return this.attachmentPath;
    }
    @Override
    public String getFileName() {
        return null;
    }
}
