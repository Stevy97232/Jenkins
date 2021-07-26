package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {

    public static String STAFF_PATH = "D:\\code\\tp-gosusec\\src\\com\\company\\staff.txt";

    public static String LIST_PATH = "D:\\code\\tp-gosusec\\src\\com\\company\\liste.txt";

    public static String USER_PATH = "D:\\code\\tp-gosusec\\src\\com\\company\\cberthier.txt";


    public static String HEADER_HTML = "<!DOCTYPE html>\n<html lang=\"fr\">\n";

    public static String FOOTER_HTML = "</html>";


    public static void main(String[] args) {

        // Va lire le fichier Staff.txt
        System.out.println("------------- GET STAFF ------------------");
        System.out.println(getStaff());
        System.out.println("------------- GET USER ------------------");
        System.out.println(getUser());
        System.out.println("------------- GET LISTE ------------------");
        System.out.println(getList());
    }

    /**
     * Fonction qui va lire le fichier staff.txt
     * @return finalHtml Résultat de l'html final après avoir lu le fichier staff.txt
     */
    public static String getStaff() {
        File file = new File(STAFF_PATH);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String finalHtml = HEADER_HTML;
            String person;

            String body = "<body>\n<ul>\n";

            while ((person = br.readLine()) != null) {
                body = body.concat("<li>").concat(person).concat("</li>\n");
            }
            body = body.concat("</ul>\n</body>\n");

            return finalHtml.concat(body).concat(FOOTER_HTML);
        }catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * Fonction qui va lire le fichier liste.txt
     * @return finalHtml Résultat de l'html final après avoir lu le fichier liste.txt
     */
    public static String getList() {
        File file = new File(LIST_PATH);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String finalHtml = HEADER_HTML;
            String person;

            String body = "<body>\n<ul>\n";

            while ((person = br.readLine()) != null) {
                System.out.println(person);
                String item = person.split("\\t")[0];
                body = body.concat("<li>").concat(item).concat("</li>\n").concat("<input type=\"checkbox\" id=\""+item+ "\" name=\""+ item + "\" checked>\n");
            }
            body = body.concat("</ul>\n</body>\n");

            return finalHtml.concat(body).concat(FOOTER_HTML);
        }catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * Fonction qui va lire le fichier cberthier.txt
     * @return finalHtml Résultat de l'html final après avoir lu le fichier cberthier.txt
     */
    public static String getUser() {
        File file = new File(USER_PATH);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String finalHtml = HEADER_HTML;
            String ligne;

            String body = "<body>\n<ul>\n";

            int counter = 0;
            while ((ligne = br.readLine()) != null) {
                switch (counter) {
                    case 0:
                        body = body.concat("<li> Nom : ").concat(ligne).concat("</li>\n");
                        break;
                    case 1:
                        body = body.concat("<li> Prénom : ").concat(ligne).concat("</li>\n");
                        break;
                    case 2:
                        body = body.concat("<li> Mission : ").concat(ligne).concat("</li>\n");
                        break;
                    case 3:
                        body = body.concat("<li> Mot de passe htpasswd : ").concat(ligne).concat("</li>\n");
                        break;
                    case 5:
                        body = body.concat("<li>").concat(ligne).concat("</li>\n");
                    default:
                        if (counter != 4) {
                            body = body.concat("<li>").concat(ligne).concat("</li>\n");
                        }
                        break;
                }
                counter++;
            }
            body = body.concat("</ul>\n</body>\n");

            return finalHtml.concat(body).concat(FOOTER_HTML);
        }catch (Exception e) {
            return e.getMessage();
        }
    }
}
