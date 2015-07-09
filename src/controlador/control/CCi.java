/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.control;

/**
 *
 * @author asus
 */
public class CCi {

    static public boolean check(String ci) {

 if (ci.length() != 11) {

    return false;

    }

   if (!usar(ci)) {

       return false;

}

   int year = Integer.parseInt(ci.substring(0, 2));

    int mes = Integer.parseInt(ci.substring(2, 4));

     int dias = Integer.parseInt(ci.substring(4, 6));

 switch (mes) {

   case 1: 

 if (dias <= 31) {

                 return true;

          } else {


   return false;

             }

          case 2: 

        if (dias <= 28) {

                 return true;

         } else {

           if (dias == 29 && year % 4 == 0) {

                   return true;


      } else {

                    return false;

                 }

          }
            case 3:

              if (dias <= 31) {

                 return true;

          } else {

                  return false;


             }
            case 4:


            if (dias <= 30) {


                return true;


             } else {

              return false;


            }
            case 5:


               if (dias <= 31) {


                   return true;


              } else {


                 return false;


                }
            case 6:


             if (dias <= 30) {


                return true;


           } else {


               return false;


            }
            case 7:


             if (dias <= 31) {


                  return true;


              } else {


              return false;


            }
            case 8:


          if (dias <= 31) {


             return true;


             } else {


                 return false;


             }
            case 9:


              if (dias <= 30) {


               return true;


             } else {


          return false;


             }
            case 10:


            if (dias <= 31) {


               return true;


               } else {


                return false;




            }
            case 11:


               if (dias <= 30) {


                 return true;


           } else {


 return false;


              }
            case 12:


               if (dias <= 31) {


                 return true;


              } else {


               return false;



              }
            default:
                return false;


       }

 }


 public static boolean usar(String ci) {

   try {


   long num = Long.parseLong(ci);


       if (num > 0) {

          return true;

       } else {

    return false;

         }
        } catch (Exception e) {


        return false;

  }

   }

}
