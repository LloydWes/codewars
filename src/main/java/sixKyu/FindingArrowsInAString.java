package sixKyu;

import java.util.*;
import java.util.stream.Stream;

public class FindingArrowsInAString {
    public static int searchArrows(String inputString) {
        final String[] splittedString = inputString.split("");
        int compteurTotal = 0;
        int compteurTemporaire = 0;
        final String caractereInterdit = ".";
        String corpActif = "";
        final List<String> corpsValide = Arrays.asList("-", "=");
        Map<String, String> autreCorp = new HashMap<>();
        autreCorp.put("-", "=");
        autreCorp.put("=", "-");
        final Map<String, Integer> mapPoint = new HashMap<>();
        mapPoint.put("-", 1);
        mapPoint.put("=", 2);
        mapPoint.put("<", 1);
        mapPoint.put(">", 1);
    int i = 1;
        for (final String caractesCourrant : splittedString) {

            if (compteurTemporaire == 0) {
                if (caractesCourrant.equals("<"))
                    compteurTemporaire -= 1;
                else if (caractesCourrant.equals("-")) {
                    corpActif = "-";
                    compteurTemporaire += 1;
                }
                else if (caractesCourrant.equals("=")) {
                    corpActif = "=";
                    compteurTemporaire +=2;
                } else if (caractesCourrant.equals(">"))
                    compteurTotal += 1;
            } else if (compteurTemporaire < 0) {
                // NEGATIF
                // 1
                if (caractesCourrant.equals(".")) {
                    compteurTotal += compteurTemporaire;
                    compteurTemporaire = 0;
                    corpActif = "";
                }
                // 2
                else if (caractesCourrant.equals("<")) {
                    compteurTotal += compteurTemporaire;
                    compteurTemporaire = -1;
                    corpActif = "";
                }
                // 3
                else if (caractesCourrant.equals(">")) {
                    compteurTemporaire = 0;
                    corpActif = "";
                }
                // 4
                else if (corpActif.isEmpty()) {
                    corpActif = caractesCourrant;
                    if (corpActif.equals("=")) compteurTemporaire -= 3;
                    else compteurTemporaire -= mapPoint.get(caractesCourrant);
                }
                // 5
                else if (caractesCourrant.equals(corpActif))
                    compteurTemporaire -= mapPoint.get(caractesCourrant);
                // 6
                else if (caractesCourrant.equals(autreCorp.get(corpActif))) {
                    compteurTotal += compteurTemporaire;
                    compteurTemporaire = mapPoint.get(caractesCourrant);
                    corpActif = caractesCourrant;
                }
            }
            else if (compteurTemporaire > 0) {
                // POSITIF
                //1
                if (caractesCourrant.equals(">")) {
                    compteurTemporaire += corpActif.equals("-") ? 1 : 2;
                    compteurTotal += compteurTemporaire;
                    compteurTemporaire = 0;
                    corpActif = "";
                }
                //2
                else if (caractesCourrant.equals(".")) {
                    compteurTemporaire = 0;
                    corpActif = "";
                }
                else if (caractesCourrant.equals("<")) {
                    compteurTemporaire = -1;
                    corpActif = "";
                }
                //3
                else if (caractesCourrant.equals(corpActif)) compteurTemporaire += mapPoint.get(corpActif);
                //4
                else if (caractesCourrant.equals(autreCorp.get(corpActif))) {
                    compteurTemporaire = mapPoint.get(caractesCourrant);
                    corpActif = caractesCourrant;
                }
            }
            i++;
        }
        if (compteurTemporaire < 0)
            compteurTotal += compteurTemporaire;
        return compteurTotal;
    }

}


/**
 * split la chaine
 * compteur_total init à 0
 * compteur_temporaire init à 0
 * caractères interdit = .
 * caractère corp actif
 *
 *
 *
 *  * boucler sur les charactères
 *  * le "contexte" est déterminé en fonction de la valeur du compteur temporaire
 *  * debut boucle
 *  *      si contexte neutre,
 *  *          si debut fleche negative compteur -= 1
 *  *          sinon si deb
 *  *      sinon si contexte négatif
 *              1 si est .
 *                  fin comptage -> vidage
 *              2 sinon si est <
 *                  fin comptage -> vidage
 *                  debut comtage autre
 *              3 sinon si est >
 *                  annulation du comptage
 *              4 sinon si pas de corpActif
 *                  corpActif = caractereCourrant
 *                  compteurTemp += x
 *              5 sinon si est corpActif
 *                  compteur temp += x
 *              6 sinon si est autreCorps
 *                  fin comptage -> vidage
 *                  debut comptage positif
 *          sinon si contexte positif
 *              1 si est >
 *                  fin comptage -> vidage
 *              2 sinon si est . ou <
 *                  reset compteur
 *              3 sinon si est corpActif
 *                  compteur temp += x
 *              4 sinon si est autreCorp
 *                  on commence à compter dans l'autre sens
 *                  compteur temp = x
 *                  corpActif = caractereEncours
 *          fin si
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * boucler sur les charactères
 * le "contexte" est déterminé en fonction de la valeur du compteur temporaire
 * debut boucle
 *      si contexte neutre,
 *          si debut fleche negative compteur -= 1
 *          sinon si deb
 *      si contexte négatif,
 *          si caractere valide
 *          1 si pas de caractere corp actif
 *                  on l'assigne -> si caractere corp actif = "=" alors + 1 compteur temporaire (pour la tête)
 *           2 sinon si est caractere invalide ou n'est pas caractere corp actif
 *                    2.1si caractere actuel est caractere fermeture fleche positive
 *                           compteur temporaire = 0 (ça s'annule donc on reset)
 *                   2.2 sinon si est caractere autre corps (pas celui actif, on commence potentiellement à compter en positif) !!!!!!!!!!!!!!!!!!!!!!
 *
 *                   fin si
 *               ajouter au compteur total et compteur temporaire = 0
 *               si compteur temporaire = 0 et est corp simple
 *                   compteur temporaire += 1
 *                sinon si compteur temporaire = 0 et est corp double
 *                      compteur temporaire +=2
 *          fin si
 *      sinon si contexte positif
 *          si caractere fin fleche
 *              ajouter au compteur total et compteur temporaire = 0
 *          sinon si est caractere invalide
 *              compteur temporaire = 0
 *          sinon si est autre corp
 *              compteur temporaire = 1 ou 2 (on commence potentiellement à compter en positif)!!!!!!!!!!!!!!!!!!!!!!!
 *          fin si
 *      fin si
 *
 * fin boucle
 * retour compteur total
 *
 */

/**
 * Kata's Url https://www.codewars.com/kata/63744cbed39ec3376c84ff4a
 * Given a string, your task is to count the number and length of arrow symbols in that string and return an int using the following rules:
 *
 * The string will only contain the characters ., -, =, <, >.
 * An arrow must start with either < or >.
 * Arrows are scored based on their length and direction, for example:
 * (Left-facing arrows are scored as negative, while Right-facing arrows are positive)
 * > is scored as 1
 * -> is scored as 2
 * < is scored as -1
 * <- is scored as -2
 * An arrow's tail (if it has one) must be entirely made up of either - or =. You cannot mix.
 * So, --> would be a valid arrow of length 3, but =-> would only count -> as a part of the arrow.
 * Additionally, arrows with a tail of = are scored twice as high as arrows with a tail of -, for example:
 * --> is scored as 3
 * ==> is scored as 6
 * <= is scored as -4
 * Double-sided arrows, like <-> or <===> are counted as 0.
 * . is an empty character and cannot be the tail of an arrow.
 * Examples
 *     arrow_search('>.') # 1
 *     arrow_search('<--..') # -3
 *     arrow_search('><=><--') # -2
 *     arrow_search('>===>->') # 11
 */