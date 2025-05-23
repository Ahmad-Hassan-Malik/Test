public class MainPatient {
    public static void main(String[] args) {
        PatientOperations p = new PatientOperations(5);

        p.showPatients();
        System.out.println();

        p.addPatient("non-critical", "P1");
        p.addPatient("non-critical", "P2");
        p.addPatient("critical", "P3");
        p.addPatient("non-critical", "P4");
        p.addPatient("critical", "P5");
        System.out.println();


        p.showPatients();
        System.out.println();

        p.treatPatient();
        System.out.println();
        p.showPatients();
        System.out.println();



//        p.addInCritical("P3");
//        p.showPatients();

        p.addPatient("critical","P6");
        System.out.println();
        p.showPatients();
        System.out.println();

//        p.showPatients();
//        System.out.println();

        p.addInEmergency2("P2");
        System.out.println();
        //p.showPatients();
        p.showPatients();



    }
}
