
public class ListPatient {

    static void listDiagnoze(Patient[] listPatient, String diagnoze){
        for (int i = 0; i<listPatient.length;i++){
            if (listPatient[i].getDiagnoze()==diagnoze){
                System.out.println(listPatient[i].getName());
            }
        }
    }

    static void listIdCard(Patient[] listPatient,int beginIdCard,int endIdCard){
        for (int i = 0; i<listPatient.length;i++){
            if (listPatient[i].getIdCard()>=beginIdCard && listPatient[i].getIdCard()<=endIdCard){
                System.out.println(listPatient[i].getName());
            }
        }
    }

    public static void main(String[] args){
        Patient[] list = new Patient[5];
        list[0] = new Patient(1,1,"sali","dart","cold");
        list[1] = new Patient(2,2,"yamamoto","genrusay","headache");
        list[2] = new Patient(3,36,"naruto","uzumaki","broken leg");
        list[3] = new Patient(4,4,"saske","uchiha","broken leg");
        list[4] = new Patient(5,12,"ichigo","kurosaki","cold");
        listDiagnoze(list,"cold");
        System.out.println("dd");
        listIdCard(list,1,13);
    }



}
